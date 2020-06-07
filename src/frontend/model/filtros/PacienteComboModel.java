package frontend.model.filtros;

import backend.Aplicacao;
import backend.entidades.Paciente;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class PacienteComboModel implements ComboBoxModel<String> {

    private Aplicacao app;
    private TreeMap<String, Paciente> lista;
    private String[] pacienteList;
    private String[] pacienteCodigoList;
    private String selectedItem;


    public PacienteComboModel(Aplicacao app, String codigoHospital, String codigoEnfermaria) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException {
        this.lista = app.getManagerPaciente(codigoHospital,codigoEnfermaria).getLista();
        
        inicializar();
    }
    
    
    private void inicializar() {

        if (lista != null) {
            int i = 0;
            pacienteList = new String[lista.size()];
            pacienteCodigoList = new String[lista.size()];
            for (Map.Entry<String, Paciente> entry : lista.entrySet()) {
                Paciente paciente = (Paciente) entry.getValue();
            
                pacienteList[i] = paciente.getNome();
                pacienteCodigoList[i] = paciente.getCodigo();
                
                i++;
            }
        } else {
            pacienteList = new String[] {""};

        }
        
        try {
            selectedItem = pacienteList[0];
        } catch (Exception e) {
            selectedItem = "";
        }
    }

    /**
     * Get the value of lista
     *
     * @return the value of lista
     */
    public TreeMap<String, Paciente> getLista() {
        return lista;
    }

    /**
     * Set the value of lista
     *
     * @param lista new value of lista
     */
    public void setLista(TreeMap<String, Paciente> lista) {
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
        return pacienteList == null? 0 : pacienteList.length;
    }

    @Override
    public String getElementAt(int index) {
       return pacienteList == null ? null : pacienteList[index];
  
    }
    
    

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }

    public Paciente getPacienteSelecionado() {
        Paciente paciente;
        try {
            String codigoPaciente = (String) getSelectedItem();
            paciente = lista.get(codigoPaciente);
        } catch (Exception e) {
            paciente = null;
        }
        
        return paciente;
    }
}
