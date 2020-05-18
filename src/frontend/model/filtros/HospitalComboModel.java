package frontend.model.filtros;

import backend.Aplicacao;
import backend.entidades.Hospital;
import frontend.Menus;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class HospitalComboModel implements ComboBoxModel<String> {

    private TreeMap<String, Hospital> lista;
    private String[] hospitalList;
    private String selectedItem;

    public HospitalComboModel(Aplicacao app) {
        this.lista = app.getManagerHospital().getListaTreeMap();
        
        inicializar();
    }
    
    
    private void inicializar() {

        if (lista != null) {
            for (Map.Entry<String, Hospital> entry : lista.entrySet()) {
                Hospital hospital = (Hospital) entry.getValue();
            
                hospitalList = new String[lista.size()];
                for (int i = 0; i < lista.size(); i++) {
                    hospitalList[i] = hospital.getNome();
                }
            }
        } else {
            hospitalList = new String[] {""};
        }
        
        try {
            selectedItem = hospitalList[0];
        } catch (Exception e) {
            selectedItem = "";
        }
    }

    /**
     * Get the value of lista
     *
     * @return the value of lista
     */
    public TreeMap<String, Hospital> getLista() {
        return lista;
    }

    /**
     * Set the value of lista
     *
     * @param lista new value of lista
     */
    public void setLista(TreeMap<String, Hospital> lista) {
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
        return hospitalList == null? 0 : hospitalList.length;
    }

    @Override
    public String getElementAt(int index) {
        return hospitalList == null ? null : hospitalList[index];

    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

}
