package frontend;

import backend.Conteudos;
import backend.entidades.Paciente;
import backend.managers.ManagerPaciente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPaciente extends MenuBase {
   
    private static final String[] menuEditar = new String[]{"Nome", "Localidade", "Cama", "Estado", "Data de Entrada", "Data de Saida"};
    private static final String[] menuEstadoPaciente = Conteudos.getEstadosPaciente();

    private ManagerPaciente manager;

    public MenuPaciente(Menus menus) {
        super(menus);
        
        this.manager = menus.getAplicacao().getManagerPaciente();
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
    public void adicionar() {
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

        if(estado == -1) {
            return;
        }
        
        
        paciente.setEstado(estado);
        
         System.out.print(perguntaDataEntrada);
         paciente.setDataEntrada(scanner.nextInt());
         
         System.out.print(perguntaDataSaida);
         paciente.setDataSaida(scanner.nextInt()); 
         
        try {
            manager.adicionar(paciente);
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }  
          
    }

    public void editar() {
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
                    pacienteAEditar.setNome(scanner.nextLine());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)?: ");
                    
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
                        editar();
                    }
                break;
            case 1: // Localidade
                System.out.print("Nova Localidade: ");
                    pacienteAEditar.setLocalidade(scanner.nextLine());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
                        editar();
                    }
                break;
            case 2: // Cama
                System.out.print("Nova Cama: ");
                    pacienteAEditar.setCama(scanner.nextInt());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
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
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
                        editar();
                    }
                break;
                
            case 4: // Data de Entrada
                System.out.print("Nova Data de Entrada: ");
                    pacienteAEditar.setDataEntrada(scanner.nextInt());
                    scanner.nextLine();
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
                        editar();
                    }
                break;
                
            case 5: // Data de saida
                System.out.print("Nova Data de Saida: ");
                    pacienteAEditar.setDataSaida(scanner.nextInt());
                    try {
                        manager.editar(pacienteAEditar);
                    } catch (Exception ex) {
                        System.out.println("ex " + ex);
                        Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Quer Continuar a editar(Y/N)? ");
                    
                    editar = scanner.nextLine();
                    if (editar.toUpperCase().contains("Y")){
                        editar();
                    }
                break;
        }
        

    }

    public void remover() {
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
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            System.out.println("Nao existem pacientes");
            start();
        }
        
    }
}

