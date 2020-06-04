package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;
import java.io.Serializable;
import java.util.Date;

public class Paciente extends EntidadeBase implements IEntidade {

    private String localidade;
    private int cama;
    private Integer estado;
    private Date dataEntrada;
    private Date dataSaida;

    public Paciente() {
    }

    public Paciente(String codigo, String nome, String localidade, int cama, Integer estado, Date dataEntrada, Date dataSaida) {
        super(codigo, nome);
        this.localidade = localidade;
        this.cama = cama;
        this.estado = estado;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getCama() {
        return cama;
    }

    public void setCama(int cama) {
        this.cama = cama;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nome=" + nome + ", localidade=" + localidade + ", cama=" + cama + ", estado=" + estado + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + '}';
    }

}
