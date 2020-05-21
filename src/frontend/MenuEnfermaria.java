package frontend;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerEnfermaria;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuEnfermaria extends MenuBase {

    private static final String[] MENU_ESCOLHER_CAMPO_EDITAR = new String[]{"TIPO", "N. CAMAS", "MENU EQUIPAMENTOS", "MENU PACIENTES"};
    private static final String[] MENU_TIPO_ENFERMARIA = Conteudos.getTiposEnfermarias();

    public MenuEnfermaria(Menus menus) {
        super(menus);

    }

    public void start() {

        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, MENU_PRINCIPAL);

        switch (opcaoEscolhida) {
            case 0:// LISTAR
                listar();
                break;
            case 1: // ADICIONAR
                adicionar();
                break;
            case 2: // EDITAR
                editar();
                break;

            case 3: // REMOVER
                remover();
                break;

            case 4: // SAIR
                sair();
                break;
        }

        start();
    }

    public void listar() {
        selecionarHospital();
        
        System.out.println("Enfermarias: ");
        System.out.println("| Codigo | Nome | Qtd Equipamentos | Qtd Camas | Qtd Pacientes |");
        if(hospitalSelecionado != null && !hospitalSelecionado.isEmpty() && getListaEnfermaria(hospitalSelecionado) != null) {
            for (Map.Entry<String, Enfermaria> entry : getListaEnfermaria(hospitalSelecionado).entrySet()) {
                Enfermaria enfermaria = (Enfermaria) entry.getValue();

                System.out.print(" | " + enfermaria.getCodigo());
                System.out.print(" | " + Conteudos.getTiposEnfermarias()[enfermaria.getTipo()]);

                try {
                    System.out.print(" | " + enfermaria.getEquipamentos().size());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }

                try {
                    System.out.print(" | " + enfermaria.getCamas().length);
                } catch (Exception e) {
                    System.out.print(" | 0");
                }

                try {
                    System.out.print(" | " + enfermaria.getPacientes().size());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }
                System.out.println(" |");
            }
        }
    }

    public void adicionar() {
        selecionarHospital();

        String pergunta2 = "Selecione o tipo de enfermaria:";
        Integer tipo = getOpcaoMenu(pergunta2, MENU_TIPO_ENFERMARIA);

        if (tipo == -1) {
            return;
        }

        String pergunta3 = "Numero de camas: ";
        System.out.println(pergunta3);
        Integer nCamas = scanner.nextInt();

        if (nCamas == null || !(nCamas instanceof Integer) || nCamas < 0) {
            return;
        }

        try {
            Hospital hospitalAInserirEnfermaria = getListaHospital().get(hospitalSelecionado);
            ManagerEnfermaria manager = new ManagerEnfermaria(hospitalAInserirEnfermaria.getEnfermarias());
            manager.adicionar(tipo, new Boolean[nCamas]);

            guardar();
            System.out.println("Enfermaria guardada com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editar() {
        selecionarHospital();
        
        selecionarEnfermaria();
        
        Enfermaria enfermariaAEditar = (Enfermaria) getListaEnfermaria(hospitalSelecionado).get(enfermariaSelecionada);

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_ESCOLHER_CAMPO_EDITAR);

        String pergunta = "";
        switch (opcaoEscolhida) {
            case 0: // tipo
                pergunta = "Alterar o tipo de enfermaria ";
                Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_ENFERMARIA);
                if (tipo == -1) {
                    return;
                }

                enfermariaAEditar.setTipo(tipo);
                break;

            case 1: // n camas
                System.out.println("Redefinir numero de camas:");
                Integer nCamas = scanner.nextInt();

                if (nCamas == null || !(nCamas instanceof Integer) || nCamas < 0) {
                    return;
                }

                enfermariaAEditar.setCamas(new Boolean[nCamas]);
                break;

            case 2: // menu equipamentos
                 menus.getMenuEquipamento().start();
                break;

            case 3: // menu pacientes
                menus.getMenuPaciente().start();
        }

        try {
            ManagerEnfermaria manager = new ManagerEnfermaria(getListaEnfermaria(hospitalSelecionado));
            manager.editar(enfermariaAEditar);
            
            guardar();
            System.out.println("Enfermaria guardada com sucesso!");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover() {
        selecionarHospital();
        
        selecionarEnfermaria();
        
        Enfermaria enfermaria = (Enfermaria) getListaEnfermaria(hospitalSelecionado).get(enfermariaSelecionada);

        guardar();
        System.out.println("Enfermaria eliminada com sucesso!");
        try {
            ManagerEnfermaria manager = new ManagerEnfermaria(getListaEnfermaria(hospitalSelecionado));
            manager.remover(enfermaria);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
