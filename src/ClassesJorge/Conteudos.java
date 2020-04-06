package ClassesJorge;

public class Conteudos {
    private String estadosPaciente[];
    private String tiposEnfermarias[];
    private String tiposEquipamentos[];

    public Conteudos() {
    }

    public Conteudos(String[] estadosPaciente, String[] tiposEnfermarias, String[] tiposEquipamentos) {
        this.estadosPaciente = estadosPaciente;
        this.tiposEnfermarias = tiposEnfermarias;
        this.tiposEquipamentos = tiposEquipamentos;
    }

    public String[] getEstadosPaciente() {
        return estadosPaciente;
    }

    public void setEstadosPaciente(String[] estadosPaciente) {
        this.estadosPaciente = estadosPaciente;
    }

    public String[] getTiposEnfermarias() {
        return tiposEnfermarias;
    }

    public void setTiposEnfermarias(String[] tiposEnfermarias) {
        this.tiposEnfermarias = tiposEnfermarias;
    }

    public String[] getTiposEquipamentos() {
        return tiposEquipamentos;
    }

    public void setTiposEquipamentos(String[] tiposEquipamentos) {
        this.tiposEquipamentos = tiposEquipamentos;
    }
    
    
}
