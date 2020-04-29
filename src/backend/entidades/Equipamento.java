package backend.entidades;

import java.util.ArrayList;

public class Equipamento {

    private String codigo;
    private Integer tipo;
    private boolean livre;
    private ArrayList<Paciente> pacientes;

    public Equipamento() {
    }

    public Equipamento(String codigo, Integer tipo, boolean livre, ArrayList<Paciente> pacientes) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.livre = livre;
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

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "codigo=" + codigo + ", tipo=" + tipo + ", livre=" + livre + ", pacientes=" + pacientes + '}';
    }

   
   
    
}
