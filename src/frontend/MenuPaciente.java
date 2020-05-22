package frontend;

import backend.Conteudos;
import backend.entidades.Paciente;
import backend.managers.ManagerPaciente;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPaciente extends MenuBase {

    private static final String[] menuEditar = new String[]{"Nome", "Localidade", "Cama", "Estado", "Data de Entrada", "Data de Saida"};
    private static final String[] menuEstadoPaciente = Conteudos.getEstadosPaciente();

    public MenuPaciente(Menus menus) {
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
        String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);

        String pergunta2 = "Selecione a Enfermaria:";
        MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
        enfermariaMenu.listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);

        String enfermariaSelecionada = getOpcaoMenu(pergunta1, menuEscolherEnfermaria);

        System.out.println("Pacientes: ");
        System.out.println("| Codigo | Nome | Localidade | Cama | Estado | Data Entrada | Data Saida |");
        if (hospitalSelecionado != null && !hospitalSelecionado.isEmpty() && getListaPaciente(hospitalSelecionado, enfermariaSelecionada) != null) {
            for (Map.Entry<String, Paciente> entry : getListaPaciente(hospitalSelecionado, enfermariaSelecionada).entrySet()) {
                Paciente paciente = (Paciente) entry.getValue();

                System.out.print(" | " + paciente.getCodigo());

                try {
                    System.out.print(" | " + paciente.getNome());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }

                try {
                    System.out.print(" | " + paciente.getLocalidade());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }

                try {
                    System.out.print(" | " + paciente.getCama());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }
                System.out.print(" | " + Conteudos.getEstadosPaciente()[paciente.getEstado()]);
                try {
                    System.out.print(" | " + paciente.getDataEntrada());
                } catch (Exception e) {
                    System.out.print(" | 0");
                }
                try {
                    System.out.print(" | " + paciente.getDataSaida());
                } catch (Exception e) {
                    System.out.print(" | - ");
                }
                System.out.println(" |");
            }
        }
    }

    public void adicionar() {String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);

        String pergunta2 = "Selecione a Enfermaria:";
        MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
        enfermariaMenu.listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);

        String enfermariaSelecionada = getOpcaoMenu(pergunta1, menuEscolherEnfermaria);

        Paciente paciente = new Paciente();

        String perguntaNome = "Introduza o nome do paciente: ";
        String perguntaLocalidade = "Introduza a Localidade: ";
        String perguntaCama = "Introduza o numero de Cama: ";
        String perguntaDataEntrada = "Introduza a Data de Entrada: ";
        String perguntaDataSaida = "Introduza a Data de Saida: ";

        System.out.print(perguntaNome);
        paciente.setNome(scanner.nextLine());

        System.out.print(perguntaLocalidade);
        paciente.setLocalidade(scanner.nextLine());

        System.out.print(perguntaCama);
        paciente.setCama(scanner.nextInt());

        String pergunta = "Selecione o estado do paciente: ";
        Integer estado = getOpcaoMenu(pergunta, menuEstadoPaciente);

        if (estado == -1) {
            return;
        }

        paciente.setEstado(estado);

        System.out.print(perguntaDataEntrada);
        paciente.setDataEntrada(scanner.nextInt());

        System.out.print(perguntaDataSaida);
        paciente.setDataSaida(scanner.nextInt());

        try {
            ManagerPaciente manager = new ManagerPaciente(getListaPaciente(hospitalSelecionado, enfermariaSelecionada));
            manager.adicionar(paciente.getNome(), paciente.getLocalidade(), paciente.getCama(), paciente.getEstado(), paciente.getDataEntrada());

            guardar();
            System.out.println("Paciente guardado com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editar() {

        String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);

        String pergunta2 = "Escolher a enfermaria: ";
        MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
        enfermariaMenu.listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);

        String enfermariaSelecionada = getOpcaoMenu(pergunta2, menuEscolherEnfermaria);

        String editar;
        String pergunta = "Escolher o paciente a alterar: ";
        listar();

        TreeMap<String, String> menuEscolherPaciente = getMenuEscolherPaciente(hospitalSelecionado, enfermariaSelecionada);

        String pacienteSelecionado = getOpcaoMenu(pergunta, menuEscolherPaciente);

        Paciente pacienteAEditar = (Paciente) getListaPaciente(hospitalSelecionado, enfermariaSelecionada).get(pacienteSelecionado);
        //sub-menu de selecao de dado a editar
        String pergunta3 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta3, menuEditar);

        switch (opcaoEscolhida) {
            case 0:// Nome
                System.out.print("Novo Nome: ");
                pacienteAEditar.setNome(scanner.nextLine());
                break;
            case 1: // Localidade
                System.out.print("Nova Localidade: ");
                pacienteAEditar.setLocalidade(scanner.nextLine());
                break;
            case 2: // Cama
                System.out.print("Nova Cama: ");
                pacienteAEditar.setCama(scanner.nextInt());
                break;

            case 3: // Estado
                pergunta = "Alterar o estado do paciente ";
                Integer estado = getOpcaoMenu(pergunta, menuEstadoPaciente);
                if (estado == -1) {
                    return;
                }

                pacienteAEditar.setEstado(estado);
                break;

            case 4: // Data de Entrada
                System.out.print("Nova Data de Entrada: ");
                pacienteAEditar.setDataEntrada(scanner.nextInt());
                scanner.nextLine();
                break;

            case 5: // Data de saida
                System.out.print("Nova Data de Saida: ");
                pacienteAEditar.setDataSaida(scanner.nextInt());
                break;
        }

        ManagerPaciente manager = new ManagerPaciente(getListaPaciente(hospitalSelecionado, enfermariaSelecionada));
        try {
            manager.editar(pacienteAEditar);

            guardar();
            System.out.println("Paciente guardado com sucesso!");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Quer Continuar a editar(Y/N)?: ");

        editar = scanner.nextLine();
        if (editar.toUpperCase().contains("Y")) {
            editar();
        }

    }

    public void remover() {

        String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);

        String pergunta2 = "Escolher a enfermaria: ";
        MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
        enfermariaMenu.listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);

        String enfermariaSelecionada = getOpcaoMenu(pergunta2, menuEscolherEnfermaria);

        String editar;
        String pergunta = "Escolher o paciente a alterar: ";
        listar();

        TreeMap<String, String> menuEscolherPaciente = getMenuEscolherPaciente(hospitalSelecionado, enfermariaSelecionada);

        if (menuEscolherPaciente.size() > 0) {
            String pacienteSelecionado = getOpcaoMenu(pergunta, menuEscolherPaciente);

            Paciente pacienteAEditar = (Paciente) getListaPaciente(hospitalSelecionado, enfermariaSelecionada).get(pacienteSelecionado);

            try {
                ManagerPaciente manager = new ManagerPaciente(getListaPaciente(hospitalSelecionado, enfermariaSelecionada));
                manager.remover(pacienteAEditar);

                guardar();
                System.out.println("Paciente eliminado com sucesso!");
            } catch (Exception ex) {
                System.out.println("ex " + ex);
                Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nao existem pacientes");
            start();
        }

    }
}
