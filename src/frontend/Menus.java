package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Hospital;
import backend.entidades.Paciente;
import backend.entidades.ProfissionalSaude;
import java.util.Scanner;

public class Menus {

    private Scanner scanner;
    private Aplicacao aplicacao;
    private Serializacao serializacao;
    
    private MenuEnfermaria menuEnfermaria;
    private HospitalTeste menuHospital;
    private EquipamentoTeste menuEquipamento;
    private PacienteTeste menuPaciente;
    // private MenuUtilizador menuUtilizador;
    // private MenuProfissionalSaude menuProfissionalSaude;
    
    private Hospital hospitalSelecionado;
    private Enfermaria enfermariaSelecionado;
    private Equipamento equipamentoSelecionado;
    private Paciente pacienteSelecionado;
    private ProfissionalSaude profissionalSelecionado;

    public Menus(Aplicacao aplicacao, Serializacao serializacao, Scanner scanner) {
        
        System.out.println("Inicializar aplicacao...");
        this.aplicacao = aplicacao;
        this.serializacao = serializacao;
        this.scanner = scanner;
        
        System.out.println("Inicializar menus...");
        this.menuEnfermaria = new MenuEnfermaria(this);
        this.menuHospital = new HospitalTeste(this);
        this.menuPaciente = new PacienteTeste(this);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        scanner = scanner;
    }

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Serializacao getSerializacao() {
        return serializacao;
    }

    public void setSerializacao(Serializacao serializacao) {
        this.serializacao = serializacao;
    }

    public MenuEnfermaria getMenuEnfermaria() {
        return menuEnfermaria;
    }

    public void setMenuEnfermaria(MenuEnfermaria menuEnfermaria) {
        this.menuEnfermaria = menuEnfermaria;
    }

    public HospitalTeste getMenuHospital() {
        return menuHospital;
    }

    public void setMenuHospital(HospitalTeste menuHospital) {
        this.menuHospital = menuHospital;
    }
    
    public EquipamentoTeste getMenuEquipamento() {
        return menuEquipamento;
    }

    public void setMenuEquipamento(EquipamentoTeste menuEquipamento) {
        this.menuEquipamento = menuEquipamento;
    }
    
    public PacienteTeste getMenuPaciente() {
        return menuPaciente;
    }

    public void setMenuPaciente(PacienteTeste menuPaciente) {
        this.menuPaciente = menuPaciente;
    }

}
