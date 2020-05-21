package backend;

import backend.entidades.Administrador;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Hospital;
import backend.entidades.Paciente;
import backend.entidades.ProfissionalSaude;
import backend.entidades.Utilizador;
import backend.managers.ManagerEnfermaria;
import backend.managers.ManagerUtilizador;
import backend.managers.ManagerEquipamento;
import backend.managers.ManagerHospital;
import backend.managers.ManagerPaciente;
import backend.managers.ManagerProfissionalSaude;
import java.io.Serializable;
import java.util.TreeMap;

public class Aplicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Utilizador utilizadorAutenticado;
    
    private ManagerUtilizador managerUtilizador;
    private ManagerHospital managerHospital;

    public Aplicacao() {
        
        inicializarManagers();
    }
    
    private void inicializarManagers() {
        managerUtilizador = new ManagerUtilizador(new TreeMap<String, Utilizador>());
        managerHospital = new ManagerHospital(new TreeMap<String, Hospital>());
    }
    
    public ManagerUtilizador getManagerUtilizador() {
        return managerUtilizador;
    }

    public ManagerEnfermaria getManagerEnfermaria(String codigoHospital) {
        ManagerEnfermaria managerEnfermaria = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getLista().get(codigoHospital);
            
            managerEnfermaria = new ManagerEnfermaria(hospital.getEnfermarias());
        }
        
        return managerEnfermaria;
    }

    public ManagerEquipamento getManagerEquipamento(String codigoHospital, String codigoEnfermaria) {
        ManagerEquipamento managerEquipamento = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getLista().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerEquipamento = new ManagerEquipamento(enfermaria.getEquipamentos());
        }
        
        return managerEquipamento;
    }

    public ManagerHospital getManagerHospital() {
        return managerHospital;
    }

    public ManagerPaciente getManagerPaciente(String codigoHospital, String codigoEnfermaria) {
        ManagerPaciente managerPaciente = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getLista().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerPaciente = new ManagerPaciente(enfermaria.getPacientes());
        }
        
        return managerPaciente;
    }

    public ManagerProfissionalSaude getManagerProfissionalSaude(String codigoHospital, String codigoEnfermaria) {
        ManagerProfissionalSaude managerProfissionalSaude = null;
        
        if(codigoHospital != null && !codigoHospital.isEmpty() && codigoEnfermaria != null && !codigoEnfermaria.isEmpty()) {
            Hospital hospital = (Hospital) getManagerHospital().getLista().get(codigoHospital);
            Enfermaria enfermaria = hospital.getEnfermarias().get(codigoEnfermaria);
            
            managerProfissionalSaude = new ManagerProfissionalSaude(enfermaria.getProfissionalSaude());
        }
        return managerProfissionalSaude;
    }

    public Utilizador getUtilizadorAutenticado() {
        return utilizadorAutenticado;
    }

    public void setUtilizadorAutenticado(Utilizador utilizadorAutenticado) {
        this.utilizadorAutenticado = utilizadorAutenticado;
    }
    
    public boolean isAutenticado(Utilizador user){
        return user.equals(utilizadorAutenticado);
    }
    
    public boolean isAdministrador(Utilizador user){
        return user instanceof Administrador;
    }
    
    public Hospital getHospital(String codigoHospital) throws HospitalNaoExistenteException {
        Hospital hospital = (Hospital) getManagerHospital().getLista().get(codigoHospital);
        if(hospital == null) {
            throw new HospitalNaoExistenteException();
        }
        return hospital;
    }
    
    public Enfermaria getEnfermaria(String codigoHospital, String codigoEnfermaria) throws HospitalNaoExistenteException, EnfermariaNaoExistenteException {
        Enfermaria enfermaria = getHospital(codigoHospital).getEnfermarias().get(codigoEnfermaria);
        if(enfermaria == null) {
            throw new EnfermariaNaoExistenteException();
        }
        return enfermaria;
    }
    
    public Equipamento getEquipamento(String codigoHospital, String codigoEnfermaria, String codigoEquipamento) throws HospitalNaoExistenteException, EnfermariaNaoExistenteException, EquipamentoNaoExistenteException {
        Equipamento equipamento = (Equipamento) getEnfermaria(codigoHospital, codigoEnfermaria).getEquipamentos().get(codigoEquipamento);
        if(equipamento == null) {
            throw new EquipamentoNaoExistenteException();
        }
        return equipamento;
    }
    
    public Paciente getPaciente(String codigoHospital, String codigoEnfermaria, String codigoPaciente) throws HospitalNaoExistenteException, PacienteNaoExistenteException, EnfermariaNaoExistenteException {
        Paciente paciente = (Paciente) getEnfermaria(codigoHospital, codigoEnfermaria).getPacientes().get(codigoPaciente);
        if(paciente == null) {
            throw new PacienteNaoExistenteException();
        }
        return paciente;
    }
    
    public ProfissionalSaude getProfissionalSaude(String codigoHospital, String codigoEnfermaria, String codigoProfissionalSaude) throws HospitalNaoExistenteException, EnfermariaNaoExistenteException, ProfissionalSaudeNaoExistenteException {
        ProfissionalSaude profissionalSaude =  (ProfissionalSaude) getEnfermaria(codigoHospital, codigoEnfermaria).getProfissionalSaude().get(codigoProfissionalSaude);
        if(profissionalSaude == null) {
            throw new ProfissionalSaudeNaoExistenteException();
        }
        return profissionalSaude;
    }
    
    
    public static class HospitalNaoExistenteException extends Exception {

        public HospitalNaoExistenteException() {
            super("Hospital nao existente");
        }
    }
    
    public static class EnfermariaNaoExistenteException extends Exception {

        public EnfermariaNaoExistenteException() {
            super("Enfermaria nao existente");
        }
    }
    
    public static class EquipamentoNaoExistenteException extends Exception {

        public EquipamentoNaoExistenteException() {
            super("Equipamento nao existente");
        }
    }
    
    public static class PacienteNaoExistenteException extends Exception {

        public PacienteNaoExistenteException() {
            super("Paciente nao existente");
        }
    }
    
    public static class ProfissionalSaudeNaoExistenteException extends Exception {

        public ProfissionalSaudeNaoExistenteException() {
            super("ProfissionalSaude nao existente");
        }
    }
}