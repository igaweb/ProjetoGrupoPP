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
    private static final String[] menuEditar = new String[]{"Nome", "Localidade", "Cama", "Estado", "Data de Entrada", "Data de Saida"};
    private static final String[] menuEstadoPaciente = Conteudos.getEstadosPaciente();

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
            System.out.println("Menu Paciente: ");
            for (int i = 0; i < menu.length; i++) {
                if(i == menu.length - 1){
                    String menuItemStr = menu[i];
                System.out.println(menuItemStr + " (" + i + "); ");
                }
                else
                {
                String menuItemStr = menu[i];
                System.out.print(menuItemStr + " (" + i + "); ");
                }
            }
            System.out.print(pergunta);

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
                System.out.print(" | - ");
            }
             System.out.println(" |");
    }
}
    private static void adicionar() {
        Scanner input = new Scanner(System.in);
        Paciente paciente = new Paciente();
        
        String perguntaNome = "Introduza o nome do paciente: ";
        String perguntaLocalidade = "Introduza a Localidade: ";
        String perguntaCama = "Introduza o numero de Cama: ";
        String perguntaDataEntrada = "Introduza a Data de Entrada: ";
        String perguntaDataSaida = "Introduza a Data de Saida: ";
        
        System.out.print(perguntaNome);
        paciente.setNome(input.nextLine());

        System.out.print(perguntaLocalidade);
        paciente.setLocalidade(input.nextLine());

        System.out.print(perguntaCama);
        paciente.setCama(input.nextInt());
        
        String pergunta = "Selecione o estado do paciente: ";
        Integer estado = getOpcaoMenu(pergunta, menuEstadoPaciente);

        if(estado == -1) {
            return;
        }
        
        
        paciente.setEstado(estado);
        
         System.out.print(perguntaDataEntrada);
         paciente.setDataEntrada(input.nextInt());
         
         System.out.print(perguntaDataSaida);
         paciente.setDataSaida(input.nextInt()); 
         
        try {
            manager.adicionar(paciente);
        } catch (Exception ex) {
            Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
    }

    private static void editar() {
        Scanner input = new Scanner(System.in);
        String editar;
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
        //sub-menu de selecao de dado a editar
        String pergunta2 = "Escolha o dado que quer editar:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta2, menuEditar);

        switch (opcaoEscolhida) {
            case 0:// Nome
                    System.out.print("Novo Nome: ");
                    pacienteAEditar.setNome(input.nextLine());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)?: ");
                    
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;
            case 1: // Localidade
                System.out.print("Nova Localidade: ");
                    pacienteAEditar.setLocalidade(input.nextLine());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;
            case 2: // Cama
                System.out.print("Nova Cama: ");
                    pacienteAEditar.setCama(input.nextInt());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;

            case 3: // Estado
                pergunta = "Alterar o estado do paciente ";
                Integer estado = getOpcaoMenu(pergunta, menuEstadoPaciente);
                    if(estado == -1) {
                        return;
                    }
        
                    pacienteAEditar.setEstado(estado);
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;
                
            case 4: // Data de Entrada
                System.out.print("Nova Data de Entrada: ");
                    pacienteAEditar.setDataEntrada(input.nextInt());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;
                
            case 5: // Data de saida
                System.out.print("Nova Data de Saida: ");
                    pacienteAEditar.setDataSaida(input.nextInt());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(PacienteTeste.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = input.nextLine();
                    if (editar.contains("Y")||editar.contains("y")){
                        editar();
                    }
                break;
        }
        

    }

    private static void remover() {
        if(manager.getLista().size() > 0){
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
        else{
            System.out.println("Nao existem pacientes");
            start();
        }
        
    }
    
    private static void sair(){
        System.exit(0);
    }
}
