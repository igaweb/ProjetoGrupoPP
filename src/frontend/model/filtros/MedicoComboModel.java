package frontend.model.filtros;

import backend.Aplicacao;
import backend.entidades.Medico;
import backend.entidades.Paciente;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class MedicoComboModel implements ComboBoxModel<String> {

    private TreeMap<String, Medico> lista;
    private String[] medicoList;
    private String[] medicoCodigoList;
    private String selectedItem;


    public MedicoComboModel(Aplicacao app, String codigoHospital, String codigoEnfermaria) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException {
        this.lista = app.getManagerProfissionalSaude(codigoHospital,codigoEnfermaria).getMedicos();
        
        inicializar();
    }
    
    
    private void inicializar() {

        if (lista != null) {
            int i = 0;
            medicoList = new String[lista.size()];
            medicoCodigoList = new String[lista.size()];
            for (Map.Entry<String, Medico> entry : lista.entrySet()) {
                Medico medico = (Medico) entry.getValue();
            
                medicoList[i] = medico.getNome();
                medicoCodigoList[i] = medico.getCodigo();
                
                i++;
            }
        } else {
            medicoList = new String[0];
        }
        
        try {
            selectedItem = medicoList[0];
        } catch (Exception e) {
            selectedItem = "";
        }
    }

    /**
     * Get the value of lista
     *
     * @return the value of lista
     */
    public TreeMap<String, Medico> getLista() {
        return lista;
    }

    /**
     * Set the value of lista
     *
     * @param lista new value of lista
     */
    public void setLista(TreeMap<String, Medico> lista) {
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
        return medicoList == null? 0 : medicoList.length;
    }

    @Override
    public String getElementAt(int index) {
       return medicoList == null ? null : medicoList[index];
  
    }
    
    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
    public Medico getMedicoSelecionado(int index) {
        Medico medico;
        try {
            medico = lista.get(medicoCodigoList[index]);
        } catch (Exception e) {
            medico = null;
        }
        
        return medico;
    }
    
    public void setMedicoSelecionado(Paciente paciente) {
        
        for (Map.Entry<String, Medico> entry : lista.entrySet()) {
            Medico medico = (Medico) entry.getValue();
            if(medico.getPacientes().containsKey(paciente.getCodigo())) {
                selectedItem = medico.getNome();
                break;
            }
        }
    }

}
