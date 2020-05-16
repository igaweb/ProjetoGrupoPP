package frontend;

import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.entidades.Equipamento;
import backend.entidades.Utilizador;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class MenuBase {

    protected final Scanner scanner;
    protected final Serializacao serializacao;
    protected final Aplicacao aplicacao;

    protected Menus menus;

    protected static final String[] MENU_PRINCIPAL = new String[]{"LISTAR", "ADICIONAR", "EDITAR", "REMOVER", "SAIR"};
    protected static final String[] MENU_PROFISSIONALSAUDE = new String[]{"LISTAR","SAIR"};
    
    public MenuBase(Menus menus) {
        this.menus = menus;

        if (menus == null) {
            System.out.println("O menu nao foi inicializado!");
        }

        this.scanner = menus.getScanner();
        if (scanner == null) {
            System.out.println("O scanner nao foi inicializado!");
        }

        this.serializacao = menus.getSerializacao();
        if (serializacao == null) {
            System.out.println("A serializacao nao foi inicializada!");
        }

        this.aplicacao = menus.getAplicacao();
        if (aplicacao == null) {
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

    protected String getOpcaoMenu(String pergunta, TreeMap<String, String> menu) {
        boolean isOpcaoEscolhida = false;
        String opcaoEscolhida;
        do {
            System.out.println(pergunta);
            for (Map.Entry<String, String> entry : menu.entrySet()) {
                String menuItemStr = entry.getValue();
                System.out.print(menuItemStr + " (" + entry.getKey() + "); ");
            }

            try {
                opcaoEscolhida = scanner.nextLine();
            } catch (Exception e) {
                opcaoEscolhida = null;
            }

            isOpcaoEscolhida = opcaoEscolhida != null && menu.get(opcaoEscolhida.toUpperCase()) != null;

            pergunta = "Opcao invalida, escolha uma das opcoes:";
        } while (!isOpcaoEscolhida);

        return opcaoEscolhida.toUpperCase();
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

    protected TreeMap<String, Hospital> getListaHospital() {
        return menus.getAplicacao().getManagerHospital().getListaTreeMap();
    }

    protected TreeMap<String, Utilizador> getListaUtilizador() {
        return menus.getAplicacao().getManagerUtilizador().getListaTreeMap();
    }

    protected TreeMap<String, Enfermaria> getListaEnfermaria() {
        return menus.getAplicacao().getManagerEnfermaria().getListaTreeMap();
    }

    protected TreeMap<String, Equipamento> getListaEquipamento() {
        return menus.getAplicacao().getManagerEquipamento().getListaTreeMap();
    }

    protected TreeMap<String, String> getMenuEscolherHospital() {
        TreeMap<String, Hospital> listaHospital = menus.getAplicacao().getManagerHospital().getListaTreeMap();
        TreeMap<String, String> menuEscolherHospital = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Hospital> entry : listaHospital.entrySet()) {
            Hospital hospital = (Hospital) entry.getValue();
            menuEscolherHospital.put(hospital.getCodigo(), hospital.getCodigo());

            i++;
        }

        return menuEscolherHospital;
    }

    protected TreeMap<String, String> getMenuEscolherEnfermaria() {
        TreeMap<String, Enfermaria> listaEnfermaria = menus.getAplicacao().getManagerEnfermaria().getListaTreeMap();
        TreeMap<String, String> menuEscolherEnfermaria = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Enfermaria> entry : listaEnfermaria.entrySet()) {
            Enfermaria enfermaria = (Enfermaria) entry.getValue();
            menuEscolherEnfermaria.put(enfermaria.getCodigo(), enfermaria.getCodigo() + " (" + Conteudos.getTiposEnfermarias()[enfermaria.getTipo()] + ")");

            i++;
        }

        return menuEscolherEnfermaria;
    }

    protected TreeMap<String, String> getMenuEscolherUtilizador() {
        TreeMap<String, Utilizador> listaUtilizador = menus.getAplicacao().getManagerUtilizador().getListaTreeMap();
        TreeMap<String, String> menuEscolherUtilizador = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Utilizador> entry : listaUtilizador.entrySet()) {
            Utilizador utilizador = (Utilizador) entry.getValue();
            menuEscolherUtilizador.put(utilizador.getNome(), utilizador.getNome());

            i++;
        }

        return menuEscolherUtilizador;
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
