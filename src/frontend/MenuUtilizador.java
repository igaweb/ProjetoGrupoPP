package frontend;

import backend.entidades.Enfermaria;
import backend.entidades.Utilizador;
import backend.managers.ManagerUtilizador;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuUtilizador extends MenuBase {

    private static final String[] MENU_PRINCIPAL = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    private static final String[] MENU_EDITAR = new String[]{"Nome", "Password"};

    private static ManagerUtilizador manager;

    public MenuUtilizador(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerUtilizador();
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

    public void adicionar() {
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

    public void editar() {
        if (getListaUtilizador().size() > 0) {
            String editar;
            String pergunta = "Escolher o utilizador a alterar: ";
            listar();

            TreeMap<String, String> menuEscolherUtilizador = getMenuEscolherUtilizador();

            String codigoUtilizador = getOpcaoMenu(pergunta, menuEscolherUtilizador);

            Utilizador utilizadorAEditar = (Utilizador) getListaUtilizador().get(codigoUtilizador);

            String pergunta2 = "Escolha o dado que quer editar:";
            Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_EDITAR);

            switch (opcaoEscolhida) {
                case 0:// Nome
                    System.out.print("Novo Nome: ");
                    utilizadorAEditar.setNome(scanner.nextLine());
                    try {
                        manager.editar(utilizadorAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)?: ");

                    editar = scanner.nextLine();
                    if (editar.contains("Y") || editar.contains("y")) {
                        editar();
                    }
                    break;
                case 1: // Password
                    System.out.print("Nova Password: ");
                    utilizadorAEditar.setPassword(scanner.nextLine());
                    try {
                        manager.editar(utilizadorAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");

                    editar = scanner.nextLine();
                    if (editar.contains("Y") || editar.contains("y")) {
                        editar();
                    }
                    break;
            }
        } else {
            System.out.println("Nao existem utilizadores");
            start();
        }
    }

    public void remover() {

        if (getListaUtilizador().size() > 0) {
            String pergunta = "Escolher o utilizador a remover: ";
            listar();

            TreeMap<String, String> menuEscolherUtilizador = getMenuEscolherUtilizador();

            String codigoUtilizador = getOpcaoMenu(pergunta, menuEscolherUtilizador);

            Utilizador utilizador = (Utilizador) getListaUtilizador().get(codigoUtilizador);

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
