/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ricardoAntunes;

/**
 *
 * @author SERALIVE
 */
public class Medico extends ProfissionalSaude {
  
    private String especialidade;
    private Paciente paciente;
    
    public Medico () {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public void Adicionar(Paciente paciente) {
        
       // paciente.add(paciente);
       
        }
        
        public void Remover(Paciente paciente) {
        
        
       
       }
        
        
}
