package backend;

public class Administrador extends Utilizador {

    private boolean isAdministrador;

    public Administrador() {
    }

    public Administrador(boolean isAdminitrador) {
        this.isAdministrador = isAdminitrador;
    }

    public Administrador(boolean isAdminitrador, String nome, String password, boolean autenticado) {
        super(nome, password, autenticado);
        this.isAdministrador = isAdminitrador;
    }

    public boolean isIsAdminitrador() {
        return isAdministrador;
    }

    public void setIsAdminitrador(boolean isAdminitrador) {
        this.isAdministrador = isAdminitrador;
    }
}
