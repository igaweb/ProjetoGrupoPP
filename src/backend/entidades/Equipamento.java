package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;

public class Equipamento extends EntidadeBase implements IEntidade {

    private Integer tipo;
    private boolean livre;
    private Paciente paciente;


    public Equipamento() {
    }

    public Equipamento(String nome, String codigo, Integer tipo, boolean livre, Paciente paciente) {
        super(codigo, nome);
        this.tipo = tipo;
        this.livre = livre;
        this.paciente = paciente;
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
