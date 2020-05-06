package frontend;

import backend.entidades.Hospital;
import backend.entidades.Enfermaria;
import backend.managers.ManagerHospital;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuHospital extends MenuBase {

    private static final String[] MENU_ESCOLHER_CAMPO_EDITAR = new String[]{"NOME", "LOCALIDADE"};

    private static ManagerHospital manager;

    public MenuHospital(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerHospital();
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
        System.out.println("Hospitais: ");
        System.out.println("| Codigo | Nome | Localidade | Qtd Enfermairas |");
        for (Map.Entry<String, Hospital> entry : getListaHospital().entrySet()) {
            Hospital hospital = (Hospital) entry.getValue();

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
        String pergunta = "Escolher o hospital a alterar: ";
        listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalAEditarCode = getOpcaoMenu(pergunta, menuEscolherHospital);
        Hospital hospitalAEditar = (Hospital) getListaHospital().get(hospitalAEditarCode);
        if (hospitalAEditar == null) {
            return;
        }

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_ESCOLHER_CAMPO_EDITAR);

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

               String editar = input.nextLine();
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
        String pergunta = "Escolher o hospital a remover: ";
        listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();
        String hospitalCode = getOpcaoMenu(pergunta, menuEscolherHospital);

        Hospital hospital = (Hospital) getListaHospital().get(hospitalCode);

        try {
            manager.remover(hospital);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }
}
