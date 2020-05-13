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

    private ManagerEnfermaria manager;

    public MenuEnfermaria(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerEnfermaria();
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

    private void listar() {
        System.out.println("Enfermarias: ");
        System.out.println("| Codigo | Nome | Qtd Equipamentos | Qtd Camas | Qtd Pacientes |");
        for (Map.Entry<String, Enfermaria> entry : getListaEnfermaria().entrySet()) {
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
                System.out.println(" | " + enfermaria.getPacientes().size());
            } catch (Exception e) {
                System.out.print(" | 0");
            }
            System.out.println(" |");
        }
    }

    private void adicionar() {
        String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, Hospital> listaHospital = getListaHospital();
        if (listaHospital.isEmpty()) {
            System.out.println("Nao existem hospitais criados. Deseja criar? (Y/N)");
            String criarHospital = menus.getScanner().nextLine();
            if (criarHospital.toUpperCase().contains("Y")) {
                hospitalMenu.adicionar();
            } else {
                System.out.println("Operação cancelada");
                return;
            }
        }

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();
        /*String[] menuEscolherHospital = getMenuEscolherHospital();*/

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria();

        String hospitalAInserirEnfermariaIndex = getOpcaoMenu(pergunta1, menuEscolherHospital);
        Hospital hospitalAEditar = (Hospital) getListaHospital().get(hospitalAInserirEnfermariaIndex);
        if (hospitalAEditar == null) {
            return;
        }

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

        Enfermaria enfermaria = new Enfermaria();
        enfermaria.setTipo(tipo);
        enfermaria.setCamas(new Boolean[nCamas]);
        try {
            manager.adicionar(enfermaria);
            Hospital hospitalAInserirEnfermaria = getListaHospital().get(hospitalAInserirEnfermariaIndex);
            hospitalAInserirEnfermaria.getEnfermarias().put(enfermaria.getCodigo(), enfermaria);

            guardar();
            System.out.println("Enfermaria guardada com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void editar() {
        String pergunta = "Escolher a enfermaria a alterar: ";
        listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria();

        String enfermariaAEditarCode = getOpcaoMenu(pergunta, menuEscolherEnfermaria);
        Enfermaria enfermariaAEditar = (Enfermaria) getListaEnfermaria().get(enfermariaAEditarCode);
        if (enfermariaAEditar == null) {
            return;
        }

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_ESCOLHER_CAMPO_EDITAR);

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
                // menus.getMenuEquipamento().start();
                break;

            case 3: // menu pacientes
                menus.getMenuPaciente().start();
        }

        try {
            manager.editar(enfermariaAEditar);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void remover() {
        String pergunta = "Escolher a enfermaria a remover: ";
        listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria();
        String enfermariaCode = getOpcaoMenu(pergunta, menuEscolherEnfermaria);

        Enfermaria enfermaria = (Enfermaria) getListaEnfermaria().get(enfermariaCode);

        try {
            manager.remover(enfermaria);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
