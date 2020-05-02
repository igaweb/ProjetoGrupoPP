package frontend;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerEnfermaria;
import java.util.ArrayList;
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

    private void listar() {
        System.out.println("Enfermarias: ");
        System.out.println("| Codigo | Nome | Qtd Equipamentos | Qtd Camas | Qtd Pacientes |");
        for (int i = 0; i < getListaEnfermaria().size(); i++) {
            Enfermaria enfermaria = (Enfermaria) getListaEnfermaria().get(i);

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
        HospitalTeste hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        ArrayList<Hospital> listaHospital = getListaHospital();
        if(listaHospital.isEmpty()) {
            System.out.println("Nao existem hospitais criados. Deseja criar? (Y/N)");
            String criarHospital = menus.getScanner().nextLine();
            if (criarHospital.toUpperCase().contains("Y")){
                hospitalMenu.adicionar();
            } else {
                System.out.println("Operação cancelada");
                return;
            }
        }
        
        String[] menuEscolherHospital = getMenuEscolherHospital();

        Integer hospitalAInserirEnfermariaIndex = getOpcaoMenu(pergunta1, menuEscolherHospital);
        if(hospitalAInserirEnfermariaIndex == -1) {
            return;
        }
        
        String pergunta2 = "Selecione o tipo de enfermaria:";
        Integer tipo = getOpcaoMenu(pergunta2, MENU_TIPO_ENFERMARIA);

        if(tipo == -1) {
            return;
        }
        
        String pergunta3 = "Numero de camas: ";
        System.out.println(pergunta3);
        Integer nCamas = scanner.nextInt();
        
        if(nCamas == null || !(nCamas instanceof Integer) || nCamas < 0) {
            return;
        }
        
        Enfermaria enfermaria = new Enfermaria();
        enfermaria.setTipo(tipo);
        enfermaria.setCamas(new Boolean[nCamas]);
        try {
            Hospital hospitalAInserirEnfermaria = getListaHospital().get(hospitalAInserirEnfermariaIndex);
            manager.adicionar(enfermaria);
            hospitalAInserirEnfermaria.getEnfermarias().add(enfermaria);
            
            guardar();
            System.out.println("Enfermaria guardada com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void editar() {
        String pergunta = "Escolher a enfermaria a alterar: ";
        listar();
        
        String[] menuEscolherEnfermaria = getMenuEscolherEnfermaria();

        Integer enfermariaAEditarIndex = getOpcaoMenu(pergunta, menuEscolherEnfermaria);
        if(enfermariaAEditarIndex == -1) {
            return;
        }
        
        Enfermaria enfermariaAEditar = (Enfermaria) getListaEnfermaria().get(enfermariaAEditarIndex);

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_ESCOLHER_CAMPO_EDITAR);

        switch (opcaoEscolhida) {
            case 0: // tipo
                pergunta = "Alterar o tipo de enfermaria ";
                Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_ENFERMARIA);
                if(tipo == -1) {
                    return;
                }

                enfermariaAEditar.setTipo(tipo);
                break;
            
            case 1: // n camas
                pergunta = "Redefinir numero de camas ";
                Integer nCamas = scanner.nextInt();
                
                if(nCamas == null || nCamas instanceof Integer || nCamas >= 0) {
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
        
        String[] menuEscolherEnfermaria = getMenuEscolherEnfermaria();
        Integer enfermariaIndex = getOpcaoMenu(pergunta, menuEscolherEnfermaria);
        if(enfermariaIndex == -1) {
            return;
        }
        
        Enfermaria enfermaria = (Enfermaria) getListaEnfermaria().get(enfermariaIndex);

        try {
            manager.remover(enfermaria);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEnfermaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
