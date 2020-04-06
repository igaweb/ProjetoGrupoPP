
package backend.RC;

/**
 *
 * @author rcoelho
 */
public class Enfermaria {
  
    private String codigo;
    private int tipo;
    private Boolean camas[];
    private Equipamentos[] equipamentos;
    private Profissional[] profissionais;
    private Paciente[] pacientes;

    public Enfermaria() {
    }

    public Enfermaria(String codigo, int tipo, Boolean[] camas, Equipamentos[] equipamentos, Profissional[] profissionais, Paciente[] pacientes) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.camas = camas;
        this.equipamentos = equipamentos;
        this.profissionais = profissionais;
        this.pacientes = pacientes;
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

    public Boolean[] getCamas() {
        return camas;
    }

    public void setCamas(Boolean[] camas) {
        this.camas = camas;
    }

    public Equipamentos[] getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamentos[] equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Profissional[] getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(Profissional[] profissionais) {
        this.profissionais = profissionais;
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }
    
}
