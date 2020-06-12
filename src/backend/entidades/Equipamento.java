package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;

public class Equipamento extends EntidadeBase implements IEntidade {

     /**
      * 
      */
    
    private Integer tipo;
    private Paciente paciente;
    

    public Equipamento() {
    }

    public Equipamento(String codigo, String nome, Integer tipo, Paciente paciente) {
        super(codigo, nome);
        this.tipo = tipo;
        this.paciente = paciente;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "codigo=" + codigo + ", tipo=" + tipo + ", paciente=" + paciente + '}';
    }
}
