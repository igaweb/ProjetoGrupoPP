package frontend;

import backend.Conteudos;
import backend.entidades.Paciente;
import backend.managers.ManagerPaciente;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteTeste {
   
    private static final String[] menuPrincipal = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    private static final String[] menuTipoPaciente = Conteudos.getEstadosPaciente();

    private static Scanner scanner;

    private static ManagerPaciente manager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        manager = new ManagerPaciente();

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

            isOpcaoEscolhida = (opcaoEscolhida != null && opcaoEscolhida >= 0 && opcaoEscolhida < menu.length) ||
                    opcaoEscolhida == -1;

            pergunta = "Opcao invalida, escolha uma das opcoes:";
        } while (!isOpcaoEscolhida);

        return opcaoEscolhida;
    }
    
    private static void listar() {
        System.out.println("Pacientes: ");
        System.out.println("| Codigo | Nome | Localidade | Cama | Estado | Data Entrada | Data Saida |");
        for (int i = 0; i < manager.getLista().size(); i++) {
            Paciente paciente = (Paciente) manager.getLista().get(i);

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
                System.out.print(" | 0");
            }
             System.out.println(" |");
    }
}
    private static void adicionar() {
        Scanner input = new Scanner(System.in);
        Paciente paciente = new Paciente();
        
        String perguntaNome = "Introduza o nome do paciente:";
        String perguntaLocalidade = "Introduza a Localidade:";
        String perguntaCama = "Introduza o numero de Cama:";
        String perguntaDataEntrada = "Introduza a Data de Entrada:";
        String perguntaDataSaida = "Introduza a Data de Saida:";
        
        System.out.println("codigo");
        paciente.setCodigo(input.nextLine());
        
        System.out.println(perguntaNome);
        paciente.setNome(input.nextLine());

        System.out.println(perguntaLocalidade);
        paciente.setLocalidade(input.nextLine());

        System.out.println(perguntaCama);
        paciente.setCama(input.nextInt());
        
        String pergunta = "Selecione o estado do paciente:";
        Integer estado = getOpcaoMenu(pergunta, menuTipoPaciente);

        if(estado == -1) {
            return;
        }
        
        
        paciente.setEstado(estado);
        
         System.out.println(perguntaDataEntrada);
         paciente.setDataEntrada(input.nextInt());
         
         System.out.println(perguntaDataSaida);
         paciente.setDataSaida(input.nextInt()); 
         
        try {
            manager.adicionar(paciente);
        } catch (Exception ex) {
            Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
    }

    private static void editar() {
        String pergunta = "Escolher o paciente a alterar: ";
        listar();
        
        String[] menuEscolherPaciente = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Paciente paciente = (Paciente) manager.getLista().get(i);
            menuEscolherPaciente[i] = paciente.getCodigo();
        }

        Integer pacienteAEditarIndex = getOpcaoMenu(pergunta, menuEscolherPaciente);
        if(pacienteAEditarIndex == -1) {
            return;
        }
        
        Paciente pacienteAEditar = (Paciente) manager.getLista().get(pacienteAEditarIndex);

        pergunta = "Alterar o tipo de paciente ";
       /* Integer tipo = getOpcaoMenu(pergunta, menuTipoPaciente);
        if(tipo == -1) {
            return;
        }
        */
        /*pacienteAEditar.setTipo(tipo);
        try {
            manager.editar(pacienteAEditar);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    private static void remover() {
        String pergunta = "Escolher o paciente a remover: ";
        listar();
        
        String[] menuEscolherPaciente = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Paciente paciente = (Paciente) manager.getLista().get(i);
            menuEscolherPaciente[i] = paciente.getCodigo();
        }

        Integer pacienteIndex = getOpcaoMenu(pergunta, menuEscolherPaciente);
        if(pacienteIndex == -1) {
            return;
        }
        
        Paciente paciente = (Paciente) manager.getLista().get(pacienteIndex);

        try {
            manager.remover(paciente);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void sair(){
        System.exit(0);
    }
}
