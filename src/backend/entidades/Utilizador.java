package backend.entidades;

import java.io.Serializable;

public class Utilizador implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String password;
    private boolean autenticado;

    public Utilizador() {
    }

    public Utilizador(String nome, String password) {
        this.nome = nome;
        this.password = password;
        this.autenticado = false;
    }

    public Utilizador(String nome, String password, boolean autenticado) {
        this.nome = nome;
        this.password = password;
        this.autenticado = autenticado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", password=" + password + ", autenticado=" + autenticado + '}';
    }

}
