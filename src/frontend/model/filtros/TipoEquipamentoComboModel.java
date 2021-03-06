package frontend.model.filtros;

import backend.Conteudos;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class TipoEquipamentoComboModel implements ComboBoxModel<String> {

     /**
      * 
      */
    
    private String[] comboList;
    private String selectedItem;

    public TipoEquipamentoComboModel() {
        inicializar();
    }
    
    
    private void inicializar() {

        comboList = Conteudos.getTiposEquipamentos();
        
        selectedItem = comboList[0];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return comboList.length;
    }

    @Override
    public String getElementAt(int index) {
        return comboList[index];

    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

}
