
package backend.RC;

/**
 *
 * @author rcoelho
 */
public class Administrador extends Utilizador {
    
    private Boolean isAdministrador;

    public Administrador() {
    }

    public Administrador(Boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }

    public Boolean getIsAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(Boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }
    
    
}
