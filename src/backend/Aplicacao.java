package backend;

import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerUtilizador;
import backend.managers.ManagerEquipamento;
import backend.managers.ManagerHospital;
import backend.managers.ManagerPaciente;
import backend.managers.ManagerProfissionalSaude;
import java.io.Serializable;

public class Aplicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private ManagerUtilizador managerUtilizador;
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
        
        managerPaciente = new ManagerPaciente();
        managerProfissionalSaude = new ManagerProfissionalSaude();
    }
    
    public ManagerUtilizador getManagerUtilizador() {
        return managerUtilizador;
    }

    public void setManagerUtilizador(ManagerUtilizador managerUtilizador) {
        this.managerUtilizador = managerUtilizador;
    }

    public ManagerEquipamento getManagerEquipamento(String codigoHospital, String codigoEnfermaria) {
        managerEquipamento = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getListaTreeMap().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerEquipamento = new ManagerEquipamento(enfermaria.getEquipamentos());
        }
        
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

    public ManagerPaciente getManagerPaciente(String codigoHospital, String codigoEnfermaria) {
        managerPaciente = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getListaTreeMap().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerPaciente = new ManagerPaciente(enfermaria.getPacientes());
        }
        
        return managerPaciente;
    }

    public void setManagerPaciente(ManagerPaciente managerPaciente) {
        this.managerPaciente = managerPaciente;
    }

    public ManagerProfissionalSaude getManagerProfissionalSaude(String codigoHospital, String codigoEnfermaria) {
        managerPaciente = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getListaTreeMap().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerProfissionalSaude = new ManagerProfissionalSaude(enfermaria.getProfissionalSaude());
        }
        return managerProfissionalSaude;
    }

    public void setManagerProfissionalSaude(ManagerProfissionalSaude managerProfissionalSaude) {
        this.managerProfissionalSaude = managerProfissionalSaude;
    }
}