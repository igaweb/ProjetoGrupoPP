package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;

public class Utilizador extends EntidadeBase implements IEntidade{

    private static final long serialVersionUID = 1L;
    
    protected String password;

    public Utilizador() {
    }

    public Utilizador(String nome, String password) {
        super(nome, nome);
        this.password = password;
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
