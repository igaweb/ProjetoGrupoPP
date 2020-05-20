package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import java.util.Scanner;

public class Menus {

    private Scanner scanner;
    private Aplicacao aplicacao;
    private Serializacao serializacao;
    
    private MenuEnfermaria menuEnfermaria;
    private MenuHospital menuHospital;
    private MenuEquipamento menuEquipamento;
    private MenuPaciente menuPaciente;
    private MenuUtilizador menuUtilizador;
    private MenuProfissionalSaude menuProfissionalSaude;
    
    public Menus(Aplicacao aplicacao, Serializacao serializacao, Scanner scanner) {
        
        System.out.println("Inicializar aplicacao...");
        this.aplicacao = aplicacao;
        this.serializacao = serializacao;
        this.scanner = scanner;
        
        System.out.println("Inicializar menus...");
        this.menuEnfermaria = new MenuEnfermaria(this);
        this.menuEquipamento = new MenuEquipamento(this);
        this.menuHospital = new MenuHospital(this);
        this.menuPaciente = new MenuPaciente(this);
        this.menuUtilizador = new MenuUtilizador(this);
        this.menuProfissionalSaude = new MenuProfissionalSaude(this);
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

    public MenuHospital getMenuHospital() {
        return menuHospital;
    }

    public void setMenuHospital(MenuHospital menuHospital) {
        this.menuHospital = menuHospital;
    }
    
    public MenuUtilizador getMenuUtilizador() {
        return menuUtilizador;
    }

    public void setMenuUtilizador(MenuUtilizador menuUtilizador) {
        this.menuUtilizador = menuUtilizador;
    }
    
    public MenuEquipamento getMenuEquipamento() {
        return menuEquipamento;
    }

    public void setMenuEquipamento(MenuEquipamento menuEquipamento) {
        this.menuEquipamento = menuEquipamento;
    }
    
    public MenuPaciente getMenuPaciente() {
        return menuPaciente;
    }

    public void setMenuPaciente(MenuPaciente menuPaciente) {
        this.menuPaciente = menuPaciente;
    }
    
   public MenuProfissionalSaude getMenuProfissionalSaude() {
        return menuProfissionalSaude;
    }
   
    public void setMenuProfissionalSaude(MenuProfissionalSaude menuProfissionalSaude) {
        this.menuProfissionalSaude = menuProfissionalSaude;
    }
}
