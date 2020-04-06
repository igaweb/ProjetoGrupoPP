
package backend.RC;

/**
 *
 * @author rcoelho
 */
public class Equipamento {
    
    private String codigo;
    private int tipo;
    private Boolean livre;
    private Paciente paciente;

    public Equipamento() {
    }

    public Equipamento(String codigo, int tipo, Boolean livre, Paciente paciente) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.livre = livre;
        this.paciente = paciente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
       
}
