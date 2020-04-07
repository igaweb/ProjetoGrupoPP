package backend.entidades;

import backend.listas.ListaEnfermaria;

public class Hospital {

    private String codigo;
    private String nome;
    private String localidade;
    private ListaEnfermaria enfermarias;

    public Hospital() {
    }

    public Hospital(String codigo, String nome, String localidade, ListaEnfermaria enfermarias) {
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

    public ListaEnfermaria getEnfermarias() {
        return enfermarias;
    }

    public void setEnfermarias(ListaEnfermaria enfermarias) {
        this.enfermarias = enfermarias;
    }

    @Override
    public String toString() {
        return "Hospital{" + "codigo=" + codigo + ", nome=" + nome + ", localidade=" + localidade + ", enfermarias=" + enfermarias + '}';
    }

}
