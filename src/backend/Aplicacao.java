package backend;

import backend.managers.ManagerUtilizador;
import backend.managers.ManagerEnfermaria;
import backend.managers.ManagerEquipamento;
import backend.managers.ManagerHospital;
import backend.managers.ManagerPaciente;
import backend.managers.ManagerProfissionalSaude;
import java.io.Serializable;

public class Aplicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ManagerUtilizador managerUtilizador;
    private ManagerEnfermaria managerEnfermaria;
    private ManagerEquipamento managerEquipamento;
    private ManagerHospital managerHospital;
    private ManagerPaciente managerPaciente;
    private ManagerProfissionalSaude managerProfissionalSaude;

    public Aplicacao() {
        
        inicializarManagers();
    }
    
    private void inicializarManagers() {
        managerUtilizador = new ManagerUtilizador();
        managerHospital = new ManagerHospital();
        managerEnfermaria = new ManagerEnfermaria();
        managerEquipamento = new ManagerEquipamento();
        managerPaciente = new ManagerPaciente();
        managerProfissionalSaude = new ManagerProfissionalSaude();
    }
    
    public ManagerUtilizador getManagerUtilizador() {
        return managerUtilizador;
    }

    public void setManagerUtilizador(ManagerUtilizador managerUtilizador) {
        this.managerUtilizador = managerUtilizador;
    }

    public ManagerEnfermaria getManagerEnfermaria() {
        return managerEnfermaria;
    }

    public void setManagerEnfermaria(ManagerEnfermaria managerEnfermaria) {
        this.managerEnfermaria = managerEnfermaria;
    }

    public ManagerEquipamento getManagerEquipamento() {
        return managerEquipamento;
    }

    public void setManagerEquipamento(ManagerEquipamento managerEquipamento) {
        this.managerEquipamento = managerEquipamento;
    }

    public ManagerHospital getManagerHospital() {
        return managerHospital;
    }

    public void setManagerHospital(ManagerHospital managerHospital) {
        this.managerHospital = managerHospital;
    }

    public ManagerPaciente getManagerPaciente() {
        return managerPaciente;
    }

    public void setManagerPaciente(ManagerPaciente managerPaciente) {
        this.managerPaciente = managerPaciente;
    }

    public ManagerProfissionalSaude getManagerProfissionalSaude() {
        return managerProfissionalSaude;
    }

    public void setManagerProfissionalSaude(ManagerProfissionalSaude managerProfissionalSaude) {
        this.managerProfissionalSaude = managerProfissionalSaude;
    }
}