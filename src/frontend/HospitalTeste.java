package frontend;

import backend.entidades.Hospital;
import backend.managers.ManagerHospital;
import java.util.Scanner;

public class HospitalTeste extends MenuBase {

    private static final String[] menuPrincipal = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    private static final String[] menuEditar = new String[]{"Nome", "Localidade"};

    private static ManagerHospital manager;

    public HospitalTeste(Menus menus) {
        super(menus);
        
        this.manager = menus.getAplicacao().getManagerHospital();
    }

    public void listar() {
        System.out.println("Hospitais: ");
        System.out.println("| Codigo | Nome | Localidade | Qtd Enfermairas |");
        for (int i = 0; i < manager.getLista().size(); i++) {
            Hospital hospital = (Hospital) manager.getLista().get(i);

            System.out.print(" | " + hospital.getCodigo());

            try {
                System.out.print(" | " + hospital.getNome());
            } catch (Exception e) {
                System.out.print(" | -");
            }

            try {
                System.out.print(" | " + hospital.getLocalidade());
            } catch (Exception e) {
                System.out.print(" | -");
            }

            try {
                System.out.print(" | " + hospital.getEnfermarias().size());
            } catch (Exception e) {
                System.out.print(" | -");
            }

            System.out.println(" |");
        }
    }

    public void adicionar() {
        Scanner input = new Scanner(System.in);
        Hospital hospital = new Hospital();

        String perguntaNome = "Introduza o nome do hospital:";
        String perguntaLocalidade = "Introduza a localidade do hospital:";

        System.out.println(perguntaNome);
        hospital.setNome(input.nextLine());

        System.out.println(perguntaLocalidade);
        hospital.setLocalidade(input.nextLine());

        try {
            manager.adicionar(hospital);
        } catch (Exception ex) {
        }
    }

    public void editar() {
        Scanner input = new Scanner(System.in);
        String editar;
        String pergunta = "Escolher o paciente a alterar: ";
        listar();

        String[] menuEscolherHospital = getMenuEscolherHospital();

        Integer hospitalAEditarIndex = getOpcaoMenu(pergunta, menuEscolherHospital);
        if (hospitalAEditarIndex == -1) {
            return;
        }

        Hospital hospitalAEditar = (Hospital) manager.getLista().get(hospitalAEditarIndex);

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, menuEditar);

        switch (opcaoEscolhida) {
            case 0:// Nome
                System.out.print("Novo Nome: ");
                hospitalAEditar.setNome(input.nextLine());
                try {
                    manager.editar(hospitalAEditar);
                } catch (Exception ex) {
                    System.out.println("ex " + ex);
                }
                System.out.println("Quer Continuar a editar(Y/N)?: ");

                editar = input.nextLine();
                if (editar.contains("Y") || editar.contains("y")) {
                    editar();
                }
                break;
            case 1: // Localidade
                System.out.print("Nova Localidade: ");
                hospitalAEditar.setLocalidade(input.nextLine());
                try {
                    manager.editar(hospitalAEditar);
                } catch (Exception ex) {
                    System.out.println("ex " + ex);
                }
                System.out.println("Quer Continuar a editar(Y/N)? ");

                editar = input.nextLine();
                if (editar.contains("Y") || editar.contains("y")) {
                    editar();
                }
                break;
        }

    }

    public void remover() {
        if (manager.getLista().size() > 0) {
            String pergunta = "Escolher o hospital a remover: ";
            listar();

            String[] menuEscolherHospital = new String[manager.getLista().size()];
            for (int i = 0; i < manager.getLista().size(); i++) {
                Hospital hospital = (Hospital) manager.getLista().get(i);
                menuEscolherHospital[i] = hospital.getCodigo();
            }

            Integer hospitalIndex = getOpcaoMenu(pergunta, menuEscolherHospital);
            if (hospitalIndex == -1) {
                return;
            }

            Hospital hospital = (Hospital) manager.getLista().get(hospitalIndex);

            try {
                manager.remover(hospital);
            } catch (Exception ex) {
                System.out.println("ex " + ex);
            }
        } else {
            System.out.println("Nao existem pacientes");
            start();
        }
    }
}
