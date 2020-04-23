package frontend;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.managers.ManagerEnfermaria;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnfermariaTeste {

    private static final String[] menuPrincipal = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    private static final String[] menuTipoEnfermaria = Conteudos.getTiposEnfermarias();

    private static Scanner scanner;

    private static ManagerEnfermaria manager;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        manager = new ManagerEnfermaria();

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
        System.out.println("Enfermarias: ");
        System.out.println("| Codigo | Nome | Qtd Equipamentos | Qtd Camas | Qtd Pacientes |");
        for (int i = 0; i < manager.getLista().size(); i++) {
            Enfermaria enfermaria = (Enfermaria) manager.getLista().get(i);

            System.out.print(" | " + enfermaria.getCodigo());
            System.out.print(" | " + Conteudos.getTiposEnfermarias()[enfermaria.getTipo()]);

            try {
                System.out.print(" | " + enfermaria.getEquipamentos().size());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                System.out.print(" | " + enfermaria.getCamas().size());
            } catch (Exception e) {
                System.out.print(" | 0");
            }

            try {
                System.out.println(" | " + enfermaria.getPacientes().size());
            } catch (Exception e) {
                System.out.print(" | 0");
            }
            System.out.println(" |");
        }
    }

    private static void adicionar() {
        String pergunta = "Selecione o tipo de enfermaria:";
        Integer tipo = getOpcaoMenu(pergunta, menuTipoEnfermaria);

        if(tipo == -1) {
            return;
        }
        
        Enfermaria enfermaria = new Enfermaria();
        enfermaria.setTipo(tipo);
        try {
            manager.adicionar(enfermaria);
        } catch (Exception ex) {
            Logger.getLogger(EnfermariaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void editar() {
        String pergunta = "Escolher a enfermaria a alterar: ";
        listar();
        
        String[] menuEscolherEnfermaria = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Enfermaria enfermaria = (Enfermaria) manager.getLista().get(i);
            menuEscolherEnfermaria[i] = enfermaria.getCodigo();
        }

        Integer enfermariaAEditarIndex = getOpcaoMenu(pergunta, menuEscolherEnfermaria);
        if(enfermariaAEditarIndex == -1) {
            return;
        }
        
        Enfermaria enfermariaAEditar = (Enfermaria) manager.getLista().get(enfermariaAEditarIndex);

        pergunta = "Alterar o tipo de enfermaria ";
        Integer tipo = getOpcaoMenu(pergunta, menuTipoEnfermaria);
        if(tipo == -1) {
            return;
        }

        enfermariaAEditar.setTipo(tipo);
        try {
            manager.editar(enfermariaAEditar);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(EnfermariaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void remover() {
        String pergunta = "Escolher a enfermaria a remover: ";
        listar();
        
        String[] menuEscolherEnfermaria = new String[manager.getLista().size()];
        for (int i = 0; i < manager.getLista().size(); i++) {
            Enfermaria enfermaria = (Enfermaria) manager.getLista().get(i);
            menuEscolherEnfermaria[i] = enfermaria.getCodigo();
        }

        Integer enfermariaIndex = getOpcaoMenu(pergunta, menuEscolherEnfermaria);
        if(enfermariaIndex == -1) {
            return;
        }
        
        Enfermaria enfermaria = (Enfermaria) manager.getLista().get(enfermariaIndex);

        try {
            manager.remover(enfermaria);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
            Logger.getLogger(EnfermariaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void sair(){
        System.exit(0);
    }
}
