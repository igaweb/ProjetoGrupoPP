package backend.entidades;

import java.util.ArrayList;

public class Medico extends ProfissionalSaude {

    private String especialidade;
    private ArrayList<Paciente> pacientes = new ArrayList();

    public Medico() {
    }

    public Medico(String especialidade, ArrayList<Paciente> pacientes) {
        this.especialidade = especialidade;
        this.pacientes = pacientes;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
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
