package frontend;

import backend.Conteudos;
import backend.entidades.Hospital;
import backend.managers.ManagerHospital;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class HospitalTeste {

    private static final String[] menuPrincipal = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};

    private static Scanner scanner;
    private static ManagerHospital manager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        manager = new ManagerHospital();

        start();
    }

    private static void start() {
        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, menuPrincipal);

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

    private static Integer getOpcaoMenu(String pergunta, String[] menu) {
        boolean isOpcaoEscolhida = false;
        Integer opcaoEscolhida;
        do {
            System.out.println(pergunta);
            System.out.println("Menu: ");
            for (int i = 0; i < menu.length; i++) {
                String menuItemStr = menu[i];
                System.out.print(menuItemStr + " (" + i + "); ");
            }

            opcaoEscolhida = scanner.nextInt();

            isOpcaoEscolhida = (opcaoEscolhida != null && opcaoEscolhida >= 0 && opcaoEscolhida < menu.length)
                    || opcaoEscolhida == -1;

            pergunta = "Opcao invalida, escolha uma das opcoes:";
        } while (!isOpcaoEscolhida);

        return opcaoEscolhida;
    }

    private static void listar() {
        System.out.println("Hospitais: ");
        System.out.println("| Codigo | Nome | Localidade | Qtd Enfermairas |");
        for (int i = 0; i < manager.getLista().size(); i++) {
            Hospital hospital = (Hospital) manager.getLista().get(i);

            System.out.print(" | " + hospital.getCodigo());

            try {
                System.out.print(" | " + hospital.getNome());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                System.out.print(" | " + hospital.getLocalidade());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                System.out.print(" | " + hospital.getEnfermarias().size());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            System.out.println(" |");
        }
    }

    private static void adicionar() {
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

    private static void editar() {
        Scanner input = new Scanner(System.in);
        String pergunta = "Escolher o hospital a alterar: ";
        listar();

        String[] menuEscolherHospital = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Hospital hospital = (Hospital) manager.getLista().get(i);
            menuEscolherHospital[i] = hospital.getCodigo();
        }

        Integer hospitalAEditarIndex = getOpcaoMenu(pergunta, menuEscolherHospital);
        if (hospitalAEditarIndex == -1) {
            return;
        }

        Hospital hospitalAEditar = (Hospital) manager.getLista().get(hospitalAEditarIndex);

        String perguntaNovoNome = "Introduza o novo nome do hospital:";
        String perguntaNovaLocalidade = "Introduza a nova localidade do hospital:";

        System.out.println(perguntaNovoNome);
        hospitalAEditar.setNome(input.nextLine());

        System.out.println(perguntaNovaLocalidade);
        hospitalAEditar.setLocalidade(input.nextLine());

        try {
            manager.editar(hospitalAEditar);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    private static void remover() {
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
    }

    private static void sair() {
        System.exit(0);
    }
}
