package backend.entidades;

import java.io.Serializable;

public class Utilizador implements Serializable{

    private static final long serialVersionUID = 1L;
    
    protected String nome;
    protected String password;

    public Utilizador() {
    }

    public Utilizador(String nome, String password) {
        this.nome = nome;
        this.password = password;
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

    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", password=" + password + '}';
    }

}
