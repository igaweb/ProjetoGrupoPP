/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ricardoAntunes;

/**
 *
 * @author iga
 */
public class Equipamento extends ListaEquipamento {
  
    protected int codigo;
    private int tipo;
    private Paciente paciente;
   
    
 public Equipamento () {
 }   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
}
