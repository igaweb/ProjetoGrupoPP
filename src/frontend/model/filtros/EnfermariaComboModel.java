package frontend.model.filtros;

import backend.Aplicacao;
import backend.entidades.Enfermaria;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class EnfermariaComboModel implements ComboBoxModel<String> {

    private Aplicacao app;
    private TreeMap<String, Enfermaria> lista;
    private String[] enfermariaList;
    private String[] enfermariaCodigosList;
    private String selectedItem;

    public EnfermariaComboModel(Aplicacao app, String codigoHospital) {
        this.lista = app.getManagerEnfermaria(codigoHospital).getLista();
        
        inicializar();
    }
    
    
    private void inicializar() {

        if (lista != null) {
            int i = 0;
            enfermariaList = new String[lista.size()];
            enfermariaCodigosList = new String[lista.size()];
            for (Map.Entry<String, Enfermaria> entry : lista.entrySet()) {
                Enfermaria enfermaria = (Enfermaria) entry.getValue();
            
                enfermariaList[i] = enfermaria.getNome();
                enfermariaCodigosList[i] = enfermaria.getCodigo();
                
                i++;
            }
        } else {
            enfermariaList = new String[] {""};
            enfermariaCodigosList = new String[] {""};
        }
        
        try {
            selectedItem = enfermariaCodigosList[0];
        } catch (Exception e) {
            selectedItem = "";
        }
    }

    /**
     * Get the value of lista
     *
     * @return the value of lista
     */
    public TreeMap<String, Enfermaria> getLista() {
        return lista;
    }

    /**
     * Set the value of lista
     *
     * @param lista new value of lista
     */
    public void setLista(TreeMap<String, Enfermaria> lista) {
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
        return enfermariaList == null? 0 : enfermariaList.length;
    }

    @Override
    public String getElementAt(int index) {
        return enfermariaCodigosList == null ? null : enfermariaCodigosList[index];

    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

    public Enfermaria getEnfermairaSelecionado() {
        Enfermaria enfermaria;
        try {
            String codigoEnfermaria = (String) getSelectedItem();
            enfermaria = lista.get(codigoEnfermaria);
        } catch (Exception e) {
            enfermaria = null;
        }
        
        return enfermaria;
    }
}
