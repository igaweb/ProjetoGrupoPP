package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Hospital implements Serializable {

    private String codigo;
    private String nome;
    private String localidade;
    private TreeMap<String, Enfermaria> enfermarias;

    public Hospital() {
    }

    public Hospital(String codigo, String nome, String localidade, TreeMap<String, Enfermaria> enfermarias) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade = localidade;
        this.enfermarias = enfermarias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public TreeMap<String, Enfermaria> getEnfermarias() {
        return enfermarias;
    }

    public void setEnfermarias(TreeMap<String, Enfermaria> enfermarias) {
        this.enfermarias = enfermarias;
    }

    @Override
    public String toString() {
        return "Hospital{" + "codigo=" + codigo + ", nome=" + nome + ", localidade=" + localidade + ", enfermarias=" + enfermarias + '}';
    }

}
