package frontend;

import backend.Conteudos;
import backend.entidades.Equipamento;
import backend.managers.ManagerEquipamento;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuEquipamento extends MenuBase {

    private static final String[] MENU_EDITAR = new String[]{"TIPO"};
    private static final String[] MENU_TIPO_EQUIPAMENTOS = Conteudos.getTiposEquipamentos();

    public MenuEquipamento(Menus menus) {
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
            case 2: // REMOVER
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
        
        selecionarEnfermaria();
        
        System.out.println("Equipamentos: ");
        System.out.println("| Codigo | Tipo | Livre | Paciente");
        for (Map.Entry<String, Equipamento> entry : getListaEquipamento(hospitalSelecionado, enfermariaSelecionada).entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();

            System.out.print("|  " + equipamento.getCodigo());

            try {
                System.out.print("  |  " + equipamento.getTipo());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                System.out.print("  |  " + equipamento.isLivre());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                if (equipamento.getPaciente() == null) {
                    System.out.println("  | Não tem |");
                } else {
                    System.out.print("  |  " + equipamento.getPaciente() + "  |");
                }
            } catch (Exception e) {
                System.out.print(" | 0");
            }
        }
    }

    public void adicionar() {
        selecionarHospital();
        
        selecionarEnfermaria();
        
        String pergunta = "Selecione o tipo do equipamento a adicionar: ";
        Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);
        if (tipo == -1) {
            return;
        }

        Equipamento equipamento = new Equipamento();
        equipamento.setLivre(true);
        equipamento.setTipo(tipo);

        try {
            ManagerEquipamento manager = new ManagerEquipamento(getListaEquipamento(hospitalSelecionado, enfermariaSelecionada));
            manager.adicionar(equipamento);

            guardar();
            System.out.println("Equipamento guardado com sucesso!");
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        selecionarHospital();
        
        selecionarEnfermaria();
        
        String pergunta = "Escolher o equipamento a editar: ";
        listar();

        TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento(hospitalSelecionado, enfermariaSelecionada);

        String equipamentoAEditarCode = getOpcaoMenu(pergunta, menuEscolherEquipamento);
        Equipamento equipamentoAEditar = (Equipamento) getListaEquipamento(hospitalSelecionado, enfermariaSelecionada).get(equipamentoAEditarCode);
        if (equipamentoAEditar == null) {
            return;
        }

        String pergunta3 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta3, MENU_EDITAR);

        switch (opcaoEscolhida) {
            case 0: // tipo
                pergunta = "Alterar o tipo de equipamento ";
                Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);
                if (tipo == -1) {
                    return;
                }
                equipamentoAEditar.setTipo(tipo);

                System.out.println("Quer Continuar a editar(Y/N)?: ");

                String editar = scanner.nextLine();
                if (editar.contains("Y") || editar.contains("y")) {
                    editar();
                }

                break;

            case 1: // Paciente
                pergunta = "Alterar se está livre ou não o equipamento  ";
                System.out.println(pergunta);
                System.out.print("Estado: " + equipamentoAEditar.isLivre());
                equipamentoAEditar.setLivre(scanner.nextBoolean());
                
                System.out.println("Quer Continuar a editar(Y/N)?: ");

                break;
        }
        try {
            ManagerEquipamento manager = new ManagerEquipamento(getListaEquipamento(hospitalSelecionado, enfermariaSelecionada));
            manager.editar(equipamentoAEditar);

            guardar();
            System.out.println("Equipamento guardado com sucesso!");
        } catch (Exception ex) {
            System.out.print("ex " + ex);
        }
    }

    public void remover() {
        selecionarHospital();
        
        selecionarEnfermaria();
        
        String pergunta = "Escolher o equipamento a remover: ";
        listar();

        TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento(hospitalSelecionado, enfermariaSelecionada);

        String equipamentoAEditarCode = getOpcaoMenu(pergunta, menuEscolherEquipamento);
        Equipamento equipamentoARemover = (Equipamento) getListaEquipamento(hospitalSelecionado, enfermariaSelecionada).get(equipamentoAEditarCode);

        try {
            ManagerEquipamento manager = new ManagerEquipamento(getListaEquipamento(hospitalSelecionado, enfermariaSelecionada));
            manager.remover(equipamentoARemover);
            
            guardar();
            System.out.println("Equipamento eliminado com sucesso!");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
