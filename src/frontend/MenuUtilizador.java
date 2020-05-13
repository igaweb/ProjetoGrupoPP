package frontend;

import backend.Conteudos;
import backend.entidades.Utilizador;
import backend.managers.ManagerUtilizador;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuUtilizador extends MenuBase {

    private static final String[] menuPrincipal = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    private static final String[] menuEditar = new String[]{"Nome", "Password"};

    private static Scanner scanner;
    private static ManagerUtilizador manager;

    public MenuUtilizador(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerUtilizador();
    }

    private void start() {
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

    private void listar() {
        System.out.println("Utilizador: ");
        System.out.println("| Nome |");
        for (Map.Entry<String, Utilizador> entry : getListaUtilizador().entrySet()) {
            Utilizador utilizador = (Utilizador) entry.getValue();

            try {
                System.out.print(" | " + utilizador.getNome());
            } catch (Exception e) {
                System.out.print(" | -");
            }

            System.out.println(" |");
        }
    }

    private void adicionar() {
        Scanner input = new Scanner(System.in);
        Utilizador utilizador = new Utilizador();

        String perguntaNome = "Introduza o nome do Utilizador:";
        String perguntaPassword = "Introduza a Password:";

        System.out.println(perguntaNome);
        utilizador.setNome(input.nextLine());

        System.out.println(perguntaPassword);
        utilizador.setPassword(input.nextLine());

        try {
            manager.adicionar(utilizador);
        } catch (Exception ex) {
        }
    }

    private void editar() {
        Scanner input = new Scanner(System.in);
        String editar;
        String pergunta = "Escolher o utilizador a alterar: ";
        listar();

        String[] menuEscolherUtilizador = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Utilizador utilizador = (Utilizador) manager.getLista().get(i);
            menuEscolherUtilizador[i] = utilizador.getNome();
        }

        Integer utilizadorAEditarIndex = getOpcaoMenu(pergunta, menuEscolherUtilizador);
        if (utilizadorAEditarIndex == -1) {
            return;
        }

        Utilizador utilizadorAEditar = (Utilizador) manager.getLista().get(utilizadorAEditarIndex);

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, menuEditar);

        switch (opcaoEscolhida) {
            case 0:// Nome
                System.out.print("Novo Nome: ");
                utilizadorAEditar.setNome(input.nextLine());
                try {
                    manager.editar(utilizadorAEditar);
                } catch (Exception ex) {
                    System.out.println("ex " + ex);
                }
                System.out.println("Quer Continuar a editar(Y/N)?: ");

                editar = input.nextLine();
                if (editar.contains("Y") || editar.contains("y")) {
                    editar();
                }
                break;
            case 1: // Password
                System.out.print("Nova Password: ");
                utilizadorAEditar.setPassword(input.nextLine());
                try {
                    manager.editar(utilizadorAEditar);
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

    private void remover() {
        if (manager.getLista().size() > 0) {
            String pergunta = "Escolher o utilizador a remover: ";
            listar();

            String[] menuEscolherUtilizador = new String[manager.getLista().size()];
            for (int i = 0; i < manager.getLista().size(); i++) {
                Utilizador utilizador = (Utilizador) manager.getLista().get(i);
                menuEscolherUtilizador[i] = utilizador.getNome();
            }

            Integer utilizadorIndex = getOpcaoMenu(pergunta, menuEscolherUtilizador);
            if (utilizadorIndex == -1) {
                return;
            }

            Utilizador utilizador = (Utilizador) manager.getLista().get(utilizadorIndex);

            try {
                manager.remover(utilizador);
            } catch (Exception ex) {
                System.out.println("ex " + ex);
            }
        } else {
            System.out.println("Nao existem utilizadores");
            start();
        }
    }
}
