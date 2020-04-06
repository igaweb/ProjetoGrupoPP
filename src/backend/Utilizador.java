package backend;

public class Utilizador {

    private String nome;
    private String password;
    private boolean autenticado;

    public Utilizador() {
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

}
