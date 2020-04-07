package backend;

public class Medico extends ProfissionalSaude {

    private String especialidade;
    private Paciente[] pacientes;

    public Medico() {
    }

    public Medico(String especialidade, Paciente[] pacientes) {
        this.especialidade = especialidade;
        this.pacientes = pacientes;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    public void addPaciente(Paciente paciente) {

    }

    public void removePaciente(Paciente paciente) {

    }

    @Override
    public String toString() {
        return "Medico{" + "especialidade=" + especialidade + ", pacientes=" + pacientes + '}';
    }
    
}
