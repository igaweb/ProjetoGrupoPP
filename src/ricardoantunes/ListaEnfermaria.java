/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ricardoAntunes;

import java.util.ArrayList;

/**
 *
 * @author SERALIVE
 */

public class ListaEnfermaria {

    private ArrayList<Enfermaria> enfermeiros;
    
    
    
    public ListaEnfermaria() {
        enfermeiros = new ArrayList<Enfermaria>();
    }

        public void Adicionar(Enfermaria enfermaria) {
        
        enfermeiros.add(enfermaria);
       
        }
        
        public void Remover(Enfermaria enfermaria) {
        
        enfermeiros.remove(enfermaria);
       
       
    }
           
        public Enfermaria procurarEnfermeiro(int codigo) {
            for(Enfermaria enfer : enfermeiros) {
                if(enfer.getCodigo() == codigo) {
                    return enfer;
                }
            
            }
        return null;
        
        }
}       
        
        
        
        

   