package frontend;

import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.listas.ManagerUtilizador;
import backend.listas.ManagerEnfermaria;
import backend.listas.ManagerEquipamento;
import backend.listas.ManagerHospital;
import backend.listas.ManagerPaciente;
import backend.listas.ManagerProfissionalSaude;
import java.util.ArrayList;

public class Aplicacao {

    private ManagerUtilizador managerUtilizador;
    private ManagerEnfermaria managerEnfermaria;
    private ManagerEquipamento managerEquipamento;
    private ManagerHospital managerHospital;
    private ManagerPaciente managerPaciente;
    private ManagerProfissionalSaude managerProfissionalSaude;

    public Aplicacao() {
        
        inicializarManagers();
        inicializarDados();
    }
    
    private void inicializarManagers() {
        managerUtilizador = new ManagerUtilizador();
        managerEnfermaria = new ManagerEnfermaria();
        managerEquipamento = new ManagerEquipamento();
        managerHospital = new ManagerHospital();
        managerPaciente = new ManagerPaciente();
        managerProfissionalSaude = new ManagerProfissionalSaude();
    }

    private void inicializarDados() {
        try {
            managerEnfermaria.adicionar(null, 0, new ArrayList(), new ArrayList(), new ArrayList());
            managerEnfermaria.adicionar(null, 0, new ArrayList(), new ArrayList(), new ArrayList());
            managerEnfermaria.adicionar(null, 0, new ArrayList(), new ArrayList(), new ArrayList());
        } catch (Exception e) {
            
        }
        
        ArrayList listaHospital = new ArrayList();
        listaHospital.add(new Hospital("COD0", "HSM", "Porto", new ArrayList()));
        managerHospital.setLista(listaHospital);
        
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