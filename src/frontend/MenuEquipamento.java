package frontend;

import backend.Conteudos;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import backend.managers.ManagerEquipamento;
import static frontend.MenuBase.MENU_PRINCIPAL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuEquipamento extends MenuBase {

    private static final String[] MENU_EDITAR = new String[]{"TIPO"};
    private static final String[] MENU_TIPO_EQUIPAMENTOS = Conteudos.getTiposEquipamentos();
    private String[] MENU_EDITAR_EQUIPAMENTOS = new String[]{"LISTAR", "ADICIONAR EQUIPAMENTO", "REMOVER EQUIPAMENTO","EDITAR", "ADICIONAR TIPO EQUIPAMENTO", "REMOVER TIPO EQUIPAMENTO", "SAIR"};
    private ManagerEquipamento manager;

    public MenuEquipamento(Menus menus) {
        super(menus);

        this.manager = menus.getAplicacao().getManagerEquipamento();
    }

    public void start() {

        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, MENU_EDITAR_EQUIPAMENTOS);

        switch (opcaoEscolhida) {
            case 0:// LISTAR
                listar();
                break;
            case 1: // ADICIONAR
                adicionar();
                break;
            case 2: // REMOVER
                remover();
                break;
            case 3: // REMOVER
                editar();
                break;    
            case 4: // ADICIONAR TIPO EQUIPAMENTO
                adicionarTipoEquipamento();
                break;                
             case 5: // REMOVER TIPO EQUIPAMENTO
                removerTipoEquipamento();
                break; 
            case 6: // SAIR
                sair();
                break;
        }

        start();
    }

    public void listar() {
        System.out.println("Equipamentos: ");
        System.out.println("| Codigo | Tipo | Livre | Paciente");
        for (Map.Entry<String, Equipamento> entry : getListaEquipamento().entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();

            System.out.print("|  " + equipamento.getCodigo());
                       
                                           
            try {
                System.out.print("  |  " + equipamento.getTipo());
            } catch  (Exception e) {   
                System.out.print(" | 0");
            }
            
             try {
                System.out.print("  |  " + equipamento.isLivre());
            } catch  (Exception e) {   
                System.out.print(" | 0");
            }
            
             try {
                if (equipamento.getPaciente() == null) {
                   System.out.println("  | Não tem |");
                } else 
                System.out.print("  |  " + equipamento.getPaciente() + "  |");
            } catch (Exception e) {
                System.out.print(" | 0");
            } 
        }
    }

    public void adicionar() {
        Equipamento equipamento = new Equipamento();

        equipamento.setLivre(true);
      
        String pergunta = "Selecione o tipo do equipamento a adicionar: ";
        Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);
        if (tipo == -1) {
            return;
        }
        equipamento.setTipo(tipo);
                
        try {
            manager.adicionar(equipamento);
            guardar();
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        Scanner input = new Scanner(System.in);
        String pergunta = "Escolher o equipamento a editar: ";
        listar();

         TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento();

        String equipamentoAEditarCode = getOpcaoMenu(pergunta, menuEscolherEquipamento);
        Equipamento equipamentoAEditar = (Equipamento) getListaEquipamento().get(equipamentoAEditarCode);        
        if (equipamentoAEditar == null) {
            return;
        }
        
        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, MENU_EDITAR);

        switch (opcaoEscolhida) {
            case 0: // tipo
                 pergunta = "Alterar o tipo de equipamento ";
                Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);
                    if(tipo == -1) {
                        return;
                    }        
                    equipamentoAEditar.setTipo(tipo);
                    
                 System.out.println("Quer Continuar a editar(Y/N)?: ");

               String editar = input.nextLine();
                if (editar.contains("Y") || editar.contains("y")) {
                    editar();
                }  
                    
                break;

        
            case 1: // Paciente
                pergunta = "Alterar se está livre ou não o equipamento  ";
                System.out.println(pergunta);
                System.out.print("Estado: " + equipamentoAEditar.isLivre());
                equipamentoAEditar.setLivre(input.nextBoolean());
                try {
                    manager.editar(equipamentoAEditar);
                } catch (Exception ex) {
                    System.out.print("ex " + ex);
                }
                System.out.println("Quer Continuar a editar(Y/N)?: ");
                
               
                break;  
        }                 
    }

    public void remover() {

        String pergunta = "Escolher o equipamento a remover: ";
        listar();

        TreeMap<String, String> menuEscolherEquipamento = getMenuEscolherEquipamento();
        String equipamentoCodigo = getOpcaoMenu(pergunta, menuEscolherEquipamento);

        Equipamento equipamento = (Equipamento) getListaEquipamento().get(equipamentoCodigo);

        try {
            manager.remover(equipamento);
            guardar();
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(MenuEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void adicionarTipoEquipamento(){
//        System.out.println("Diga o nome do novo tipo de equipamento:");
//        Scanner input = new Scanner(System.in);
//        String nome = input.nextLine();
//        MENU_TIPO_EQUIPAMENTOS.add(nome);        
    }
    
        public void removerTipoEquipamento() {
            
        }
    
}
