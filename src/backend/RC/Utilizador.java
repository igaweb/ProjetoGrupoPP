
package backend.RC;

/**
 *
 * @author rcoelho
 */
public class Utilizador {
    private String nome;
    private String password;
    private Boolean autenticado;

    public Utilizador() {
    }

    public Utilizador(String nome, String password, Boolean autenticado) {
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

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }
    
    
}
