package backend.entidades;

public class Enfermaria {

    private String codigo;
    private int tipo;
    private boolean[] camas;
    private Equipamento[] equipamentos;
    private Paciente[] pacientes;

    public Enfermaria() {
    }

    public Enfermaria(String codigo, int tipo, boolean[] camas, Equipamento[] equipamentos, Paciente[] pacientes) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.camas = camas;
        this.equipamentos = equipamentos;
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

    public boolean[] getCamas() {
        return camas;
    }

    public void setCamas(boolean[] camas) {
        this.camas = camas;
    }

    public Equipamento[] getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(Equipamento[] equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Enfermaria{" + "codigo=" + codigo + ", tipo=" + tipo + ", camas=" + camas + ", equipamentos=" + equipamentos + ", pacientes=" + pacientes + '}';
    }

    
}
