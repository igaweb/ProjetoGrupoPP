package frontend.model.filtros;

import backend.entidades.Hospital;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class HospitalComboModel implements ComboBoxModel<String> {

    private ArrayList<Hospital> lista;
    private String[] hospitalList;
    private String selectedItem;

    public HospitalComboModel(ArrayList<Hospital> lista) {
        this.lista = lista;
        
        inicializar();
    }
    
    
    private void inicializar() {

        if (lista != null) {
            hospitalList = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                hospitalList[i] = lista.get(i).getNome();
            }
        } else {
            hospitalList = new String[] {""};
        }
        
        selectedItem = hospitalList[0];
    }

    /**
     * Get the value of lista
     *
     * @return the value of lista
     */
    public ArrayList<Hospital> getLista() {
        return lista;
    }

    /**
     * Set the value of lista
     *
     * @param lista new value of lista
     */
    public void setLista(ArrayList<Hospital> lista) {
        this.lista = lista;
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
        return hospitalList.length;
    }

    @Override
    public String getElementAt(int index) {
        return hospitalList[index];

    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

}
