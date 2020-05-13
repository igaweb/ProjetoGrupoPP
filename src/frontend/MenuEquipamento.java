package frontend;

import backend.Conteudos;
import backend.entidades.Equipamento;
import backend.managers.ManagerEquipamento;
import static frontend.MenuBase.MENU_PRINCIPAL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuEquipamento extends MenuBase {

    private static final String[] MENU_EDITAR = new String[]{"TIPO", "MENU PACIENTES"};
    private static final String[] MENU_TIPO_EQUIPAMENTOS = Conteudos.getTiposEquipamentos();

    private ManagerEquipamento manager;

    public MenuEquipamento(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerEquipamento();
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
        System.out.println("Equipamentos: ");
        System.out.println("| Codigo | Tipo | Livre | Paciente");
        for (Map.Entry<String, Equipamento> entry : getListaEquipamento().entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();

            System.out.print(" | " + equipamento.getCodigo());
            System.out.print(" | " + Conteudos.getTiposEquipamentos()[equipamento.getTipo()]);
            
                                           
            try {
                System.out.print(" | " + equipamento.getTipo());
            } catch  (Exception e) {   
                System.out.print(" | 0");
            }
            
             try {
                System.out.print(" | " + equipamento.isLivre());
            } catch  (Exception e) {   
                System.out.print(" | 0");
            }
            
             try {
                System.out.print(" | " + equipamento.getPaciente());
            } catch (Exception e) {
                System.out.print(" | 0");
            }
            
            System.out.println(" |");
        }
    }

    private void adicionar() {
        Equipamento equipamento = new Equipamento();

        equipamento.setLivre(true);

        //String perguntaTipo = "Selecione o tipo do equipamento a adicionar: ";
       // String perguntaEnfermaria = "Selecione a enfermaria: ";
        String perguntaPaciente = "Selecione o paciente";
        
        System.out.print(perguntaPaciente);
        //paciente.setCodigo(scanner.nextLine());
        
        //System.out.print(perguntaEnfermaria);
        
        String pergunta = "Selecione o tipo do equipamento a adicionar: ";
        Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);
        if (tipo == -1) {
            return;
        }
        equipamento.setTipo(tipo);

        // Como saber qual o paciente a adicionar. Peciso de ver a lista de pacientes?
        // Estou a adicionar sem paciente
        // equipamento.setPaciente(paciente);        
        try {
            manager.adicionar(equipamento);
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editar() {
        // e preciso editar? preciso da lista para selecionar o equipamento a editar?
        String pergunta = "Escolher o equipamento a alterar: ";
        listar();

        /* TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento();

        String equipamentoEditar = getOpcaoMenu(pergunta, menuEscolherEquipamento);
        Equipamento equipamentoEditar = (Equipamento) getListaEquipamento().get(equipamentoEditar);
        if (equipamentoEditar == null) {
            return;
        }*/
        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_EDITAR);

        switch (opcaoEscolhida) {
            case 0: // tipo
                pergunta = "Alterar o nome do equipamento ";
                Integer tipo = getOpcaoMenu(pergunta, MENU_EDITAR);
                if (tipo == -1) {
                    return;
                }

                // equipamentoEditar.setTipo(tipo);
                break;

        }

        /*try {
              manager.editar(equipamentoEditar);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }

    private void remover() {

        String pergunta = "Escolher o equipamento a remover: ";
        listar();

       /* TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento();
        String equipamentoCodigo = getOpcaoMenu(pergunta, menuEscolherEquipamento);

        Equipamento equipamento = (Equipamento) getListaEquipamento().get(equipamentoCodigo);

        try {
            manager.remover(equipamento);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
