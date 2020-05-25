package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Equipamento implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private Integer tipo;
    private boolean livre;
    private Paciente paciente;

    public Equipamento() {
    }

    public Equipamento(String codigo, Integer tipo, boolean livre, Paciente paciente) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.livre = livre;
        this.paciente = paciente;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "codigo=" + codigo + ", tipo=" + tipo + ", livre=" + livre + ", paciente=" + paciente + '}';
    }

    
   
   
    
}
