
package backend.RC;

/**
 *
 * @author rcoelho
 */
public class Conteudos {
    
    private String estadosPaciente[];
    private String tiposEnfermaria[];
    private String tiposEquipamento[];

    public Conteudos() {
    }

    public Conteudos(String[] estadosPaciente, String[] tiposEnfermaria, String[] tiposEquipamento) {
        this.estadosPaciente = estadosPaciente;
        this.tiposEnfermaria = tiposEnfermaria;
        this.tiposEquipamento = tiposEquipamento;
    }

    public String[] getEstadosPaciente() {
        return estadosPaciente;
    }

    public void setEstadosPaciente(String[] estadosPaciente) {
        this.estadosPaciente = estadosPaciente;
    }

    public String[] getTiposEnfermaria() {
        return tiposEnfermaria;
    }

    public void setTiposEnfermaria(String[] tiposEnfermaria) {
        this.tiposEnfermaria = tiposEnfermaria;
    }

    public String[] getTiposEquipamento() {
        return tiposEquipamento;
    }

    public void setTiposEquipamento(String[] tiposEquipamento) {
        this.tiposEquipamento = tiposEquipamento;
    }
    
    
    
}
