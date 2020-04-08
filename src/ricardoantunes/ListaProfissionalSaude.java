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
public class ListaProfissionalSaude {
    
    private ArrayList<ProfissionalSaude> profissionaisSaude;
    
    
    
    public ListaProfissionalSaude() {
        profissionaisSaude = new ArrayList<ProfissionalSaude>();
    }

        public void Adicionar(ProfissionalSaude profissionalSaude) {
        
        profissionaisSaude.add(profissionalSaude);
       
        }
        
        public void Remover(ProfissionalSaude profissionalSaude) {
        
        profissionaisSaude.remove(profissionalSaude);
       
       
    }
           
        public ProfissionalSaude procurarEnfermeiro(int codigo) {
            for(ProfissionalSaude profs : profissionaisSaude) {
                if(profs.getCodigo() == codigo) {
                    return profs;
                }
            
            }
        return null;
        
        }
}
