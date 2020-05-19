package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Enfermaria implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private Integer tipo;
    private Boolean[] camas;
    private TreeMap<String, Equipamento> equipamentos;
    private TreeMap<String, Paciente> pacientes;
    private TreeMap<String, ProfissionalSaude> profissionalSaude;

    public Enfermaria() {
    }

    public Enfermaria(String codigo, int tipo, Boolean[] camas, TreeMap<String, Equipamento> equipamentos, TreeMap<String, Paciente> pacientes) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.camas = camas;
        this.equipamentos = equipamentos;
        this.pacientes = pacientes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Boolean[] getCamas() {
        return camas;
    }

    public void setCamas(Boolean[] camas) {
        this.camas = camas;
    }

    public TreeMap<String, Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(TreeMap<String, Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public TreeMap<String, Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(TreeMap<String, Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public TreeMap<String, ProfissionalSaude> getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(TreeMap<String, ProfissionalSaude> profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }
    
    @Override
    public String toString() {
        return "Enfermaria{" + "codigo=" + codigo + ", tipo=" + tipo + ", camas=" + camas + ", equipamentos=" + equipamentos + ", pacientes=" + pacientes + '}';
    }

    
}
