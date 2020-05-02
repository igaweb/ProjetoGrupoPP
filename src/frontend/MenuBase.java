package frontend;

import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class MenuBase {

    protected final Scanner scanner;
    protected final Serializacao serializacao;
    protected final Aplicacao aplicacao;
    
    protected Menus menus;

    protected static final String[] MENU_PRINCIPAL = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};

    public MenuBase(Menus menus) {
        this.menus = menus;
        
        if(menus == null) {
            System.out.println("O menu nao foi inicializado!");
        }
        
        this.scanner = menus.getScanner();
        if(scanner == null) {
            System.out.println("O scanner nao foi inicializado!");
        }
        
        this.serializacao = menus.getSerializacao();
        if(serializacao == null) {
            System.out.println("A serializacao nao foi inicializada!");
        }
        
        this.aplicacao = menus.getAplicacao();
        if(aplicacao == null) {
            System.out.println("A aplicacao nao foi inicializada!");
        }
    }
    
    protected Integer getOpcaoMenu(String pergunta, String[] menu) {
        boolean isOpcaoEscolhida = false;
        Integer opcaoEscolhida;
        do {
            System.out.println(pergunta);
            for (int i = 0; i < menu.length; i++) {
                String menuItemStr = menu[i];
                System.out.print(menuItemStr + " (" + i + "); ");
            }

            try {
                opcaoEscolhida = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                opcaoEscolhida = null;
            }

            isOpcaoEscolhida = opcaoEscolhida != null
                    && ((opcaoEscolhida >= 0 && opcaoEscolhida < menu.length) || opcaoEscolhida == -1);

            pergunta = "Opcao invalida, escolha uma das opcoes:";
        } while (!isOpcaoEscolhida);

        return opcaoEscolhida;
    }

    protected void sair() {
        // guarda os ficheiros
        guardar();

        // termina o programa
        System.exit(0);
    }
    
    protected void guardar() {
        // guarda os ficheiros
        serializacao.guardar(aplicacao);
    }
    
    protected ArrayList<Hospital> getListaHospital() {
        return menus.getAplicacao().getManagerHospital().getLista();
    }
    
    protected ArrayList<Enfermaria> getListaEnfermaria() {
        return menus.getAplicacao().getManagerEnfermaria().getLista();
    }
    
    protected String[] getMenuEscolherHospital() {
        ArrayList<Hospital> listaHospital = menus.getAplicacao().getManagerHospital().getLista();
        String[] menuEscolherHospital = new String[listaHospital.size()];
        for (int i = 0; i < listaHospital.size(); i++) {
            Hospital hospital = (Hospital) listaHospital.get(i);
            menuEscolherHospital[i] = hospital.getCodigo() + " - " + hospital.getNome();
        }
        
        return menuEscolherHospital;
    }
    
    protected String[] getMenuEscolherEnfermaria() {
        ArrayList<Enfermaria> listaEnfermaria = menus.getAplicacao().getManagerEnfermaria().getLista();
        String[] menuEscolherEnfermaria = new String[listaEnfermaria.size()];
        for (int i = 0; i < listaEnfermaria.size(); i++) {
            Enfermaria enfermaria = (Enfermaria) listaEnfermaria.get(i);
            menuEscolherEnfermaria[i] = enfermaria.getCodigo() + " (" + Conteudos.getTiposEnfermarias()[enfermaria.getTipo()] + ")";
        }
      
        return menuEscolherEnfermaria;
    }

    private String[] getEscolherPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[] getEscolherEquipamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[] getEscolherUtilizador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[] getEscolherProfissionalSaude() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
