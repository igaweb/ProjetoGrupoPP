package backend.entidades;

import backend.bases.EntidadeBase;
import java.util.TreeMap;

public class Medico extends ProfissionalSaude {

     /**
      * 
      */
    
    private String especialidade;
    private TreeMap<String, EntidadeBase> pacientes = new TreeMap();

    public Medico() {
    }

    public Medico(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public TreeMap<String, EntidadeBase> getPacientes() {
        return pacientes;
    }

    public void setPacientes(TreeMap<String, EntidadeBase> pacientes) {
        this.pacientes = pacientes;
    }

    public void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getCodigo(), paciente);
    }

    public void removePaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    @Override
    public String toString() {
        return "Medico{" + "especialidade=" + especialidade + ", pacientes=" + pacientes + '}';
    }
    
}
