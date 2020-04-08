package backend.ricardoAntunes;

import java.util.ArrayList;

public class ListaEquipamento {
    
    private ArrayList<Equipamento> itens;
    
    
    
    public ListaEquipamento() {
        itens = new ArrayList<Equipamento>();
    }

        public void Adicionar(Equipamento equipamento) {
        
        itens.add(equipamento);
       
        }
        
        public void Remover(Equipamento equipamento) {
        
        itens.remove(equipamento);
       
       
    }

         public Equipamento procurarEquipamnento(int codigo) {
            for(Equipamento equip : itens) {
               // if(itens.getcodigo() == codigo) {
                    return equip;
                }
            
           // }
        return null;
        
        }
    
}
