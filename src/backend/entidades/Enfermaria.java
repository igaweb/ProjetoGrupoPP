package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Enfermaria implements Serializable{

    private String codigo;
    private Integer tipo;
    private Boolean[] camas;
    private ArrayList<Equipamento> equipamentos;
    private ArrayList<Paciente> pacientes;

    public Enfermaria() {
    }

    public Enfermaria(String codigo, int tipo, Boolean[] camas, ArrayList<Equipamento> equipamentos, ArrayList<Paciente> pacientes) {
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

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Enfermaria{" + "codigo=" + codigo + ", tipo=" + tipo + ", camas=" + camas + ", equipamentos=" + equipamentos + ", pacientes=" + pacientes + '}';
    }

    
}
