package frontend;

import backend.entidades.Hospital;
import backend.managers.ManagerHospital;
import java.util.Map;
import java.util.Scanner;

public class MenuHospital extends MenuBase {

    private static final String[] MENU_ESCOLHER_CAMPO_EDITAR = new String[]{"NOME", "LOCALIDADE"};

    private ManagerHospital manager;
    
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
        System.out.println("| Codigo | Nome | Localidade | Qtd Enfermarias |");
        if(getListaHospital() != null && getListaHospital().size() > 0) {
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

            guardar();
            System.out.println("Hospital guardado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar");
        }
    }

    public void editar() {
        selecionarHospital();
        Hospital hospitalAEditar = (Hospital) getListaHospital().get(hospitalSelecionado);
        if (hospitalAEditar == null) {
            return;
        }

        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_ESCOLHER_CAMPO_EDITAR);

        switch (opcaoEscolhida) {
            case 0:// Nome
                System.out.print("Novo Nome: ");
                hospitalAEditar.setNome(scanner.nextLine());
                break;
            case 1: // Localidade
                System.out.print("Nova Localidade: ");
                hospitalAEditar.setLocalidade(scanner.nextLine());
                break;
        }

        try {
            manager.editar(hospitalAEditar);

            guardar();
            System.out.println("Hospital guardado com sucesso!");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
        System.out.println("Quer Continuar a editar(Y/N)?: ");

        String editar = scanner.nextLine();
        if (editar.contains("Y") || editar.contains("y")) {
            editar();
        }
    }

    public void remover() {
        selecionarHospital();
        
        Hospital hospital = (Hospital) getListaHospital().get(hospitalSelecionado);

        try {
            manager.remover(hospital);

            guardar();
            System.out.println("Hospital eliminado com sucesso!");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }
}
