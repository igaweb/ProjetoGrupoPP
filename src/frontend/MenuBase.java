package frontend;

import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import backend.entidades.ProfissionalSaude;
import backend.entidades.Utilizador;
import backend.managers.ManagerEnfermaria;
import backend.managers.ManagerPaciente;
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
    
    protected String hospitalSelecionado;
    protected String enfermariaSelecionada;

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
        return menus.getAplicacao().getManagerHospital().getLista();
    }

    protected TreeMap<String, Paciente> getListaPaciente(String codigoHospital, String codigoEnfermaria) {
        Hospital hospital = (Hospital) menus.getAplicacao().getManagerHospital().getLista().get(codigoHospital);
        Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
        return enfermaria.getPacientes();
    }
    
    protected TreeMap<String, ProfissionalSaude> getListaProfissionalSaude(String codigoHospital, String codigoEnfermaria) {
        Hospital hospital = (Hospital) menus.getAplicacao().getManagerHospital().getLista().get(codigoHospital);
        Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
        return enfermaria.getProfissionalSaude();
    }

    protected TreeMap<String, Utilizador> getListaUtilizador() {
        return menus.getAplicacao().getManagerUtilizador().getLista();
    }

    protected TreeMap<String, Enfermaria> getListaEnfermaria(String codigoHospital) {
        Hospital hospital = (Hospital) menus.getAplicacao().getManagerHospital().getLista().get(codigoHospital);
        return hospital.getEnfermarias();
    }

    protected TreeMap<String, Equipamento> getListaEquipamento(String codigoHospital, String codigoEnfermaria) {
        return menus.getAplicacao().getManagerEquipamento(codigoHospital, codigoEnfermaria).getLista();
    }

    protected TreeMap<String, String> getMenuEscolherHospital() {
        TreeMap<String, Hospital> listaHospital = menus.getAplicacao().getManagerHospital().getLista();
        TreeMap<String, String> menuEscolherHospital = new TreeMap<String, String>();
        for (Map.Entry<String, Hospital> entry : listaHospital.entrySet()) {
            Hospital hospital = (Hospital) entry.getValue();
            menuEscolherHospital.put(hospital.getCodigo(), hospital.getCodigo() + " (" + hospital.getLocalidade() + ")");
        }

        return menuEscolherHospital;
    }

    protected TreeMap<String, String> getMenuEscolherEnfermaria(String codigoHospital) {
        TreeMap<String, Enfermaria> listaEnfermaria = new ManagerEnfermaria(getListaEnfermaria(codigoHospital)).getLista();
        TreeMap<String, String> menuEscolherEnfermaria = new TreeMap<String, String>();
        for (Map.Entry<String, Enfermaria> entry : listaEnfermaria.entrySet()) {
            Enfermaria enfermaria = (Enfermaria) entry.getValue();
            menuEscolherEnfermaria.put(enfermaria.getCodigo(), enfermaria.getCodigo() + " (" + Conteudos.getTiposEnfermarias()[enfermaria.getTipo()] + ")");
        }

        return menuEscolherEnfermaria;
    }

    protected TreeMap<String, String> getMenuEscolherUtilizador() {
        TreeMap<String, Utilizador> listaUtilizador = menus.getAplicacao().getManagerUtilizador().getLista();
        TreeMap<String, String> menuEscolherUtilizador = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Utilizador> entry : listaUtilizador.entrySet()) {
            Utilizador utilizador = (Utilizador) entry.getValue();
            menuEscolherUtilizador.put(utilizador.getNome(), utilizador.getNome());

            i++;
        }

        return menuEscolherUtilizador;
    }

     protected TreeMap<String, String> getMenuEscolherEquipamento(String codigoHospital, String codigoEnfermaria) {
        TreeMap<String, Equipamento> listaEquipamento = menus.getAplicacao().getManagerEquipamento(codigoHospital, codigoEnfermaria).getLista();
        TreeMap<String, String> menuEscolherEquipamento = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Equipamento> entry : listaEquipamento.entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();
            menuEscolherEquipamento.put(equipamento.getCodigo(), equipamento.getCodigo());

            i++;
        }

        return menuEscolherEquipamento;
    }
     
    protected TreeMap<String, String> getMenuEscolherPaciente(String codigoHospital, String codigoEnfermaria) {
        TreeMap<String, Paciente> listaPaciente = new ManagerPaciente(getListaPaciente(codigoHospital, codigoEnfermaria)).getLista();
        TreeMap<String, String> menuEscolherPaciente = new TreeMap<String, String>();
        int i = 0;
        for (Map.Entry<String, Paciente> entry : listaPaciente.entrySet()) {
            Paciente paciente = (Paciente) entry.getValue();
            menuEscolherPaciente.put(paciente.getCodigo(), paciente.getNome());

            i++;
        }

        return menuEscolherPaciente;
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
    
    public String getHospitalSelecionado() {
        return hospitalSelecionado;
    }

    public void setHospitalSelecionado(String hospitalSelecionado) {
        this.hospitalSelecionado = hospitalSelecionado;
    }

    public String getEnfermariaSelecionada() {
        return enfermariaSelecionada;
    }

    public void setEnfermariaSelecionada(String enfermariaSelecionada) {
        this.enfermariaSelecionada = enfermariaSelecionada;
    }
    
    protected void selecionarHospital() {
        if(hospitalSelecionado == null) {
            String pergunta1 = "Selecione o Hospital:";
            MenuHospital hospitalMenu = menus.getMenuHospital();
            hospitalMenu.listar();
            TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();
            hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);
            
            menus.getMenuHospital().setHospitalSelecionado(hospitalSelecionado);
            menus.getMenuEnfermaria().setHospitalSelecionado(hospitalSelecionado);
            menus.getMenuEquipamento().setHospitalSelecionado(hospitalSelecionado);
            menus.getMenuPaciente().setHospitalSelecionado(hospitalSelecionado);
            menus.getMenuProfissionalSaude().setHospitalSelecionado(hospitalSelecionado);
            menus.getMenuUtilizador().setHospitalSelecionado(hospitalSelecionado);
        }
    }
    
    protected void selecionarEnfermaria() {
        if(enfermariaSelecionada == null) {
            String pergunta2 = "Selecione a Enfermaria:";
            MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
            enfermariaMenu.listar();
            TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);
            enfermariaSelecionada = getOpcaoMenu(pergunta2, menuEscolherEnfermaria);
            
            menus.getMenuHospital().setHospitalSelecionado(enfermariaSelecionada);
            menus.getMenuEnfermaria().setHospitalSelecionado(enfermariaSelecionada);
            menus.getMenuEquipamento().setHospitalSelecionado(enfermariaSelecionada);
            menus.getMenuPaciente().setHospitalSelecionado(enfermariaSelecionada);
            menus.getMenuProfissionalSaude().setHospitalSelecionado(enfermariaSelecionada);
            menus.getMenuUtilizador().setHospitalSelecionado(enfermariaSelecionada);
        }
    }
}
