package frontend.model.filtros;

import backend.Aplicacao;
import backend.entidades.Paciente;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class PacienteComboModel implements ComboBoxModel<String> {

    private Aplicacao app;
    private TreeMap<String, Paciente> lista;
    private String[] pacienteList;
    private String[] pacienteCodigoList;
    private String selectedItem;

    public PacienteComboModel(Aplicacao app, String codigoHospital, String codigoEnfermaria, boolean pacientesAtivos) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException {
        this.lista = getLista(app.getManagerPaciente(codigoHospital, codigoEnfermaria).getLista(), pacientesAtivos);

        inicializar();
    }

    private void inicializar() {

        if (lista != null) {
            int i = 1;
            pacienteList = new String[(lista.size() + 1)];
            pacienteCodigoList = new String[(lista.size() + 1)];
            pacienteList[0] = "<Nenhum>";
            pacienteCodigoList[0] = null;
            for (Map.Entry<String, Paciente> entry : lista.entrySet()) {
                Paciente paciente = (Paciente) entry.getValue();

                pacienteList[i] = paciente.getNome();
                pacienteCodigoList[i] = paciente.getCodigo();

                i++;
            }
        } else {
            pacienteList = new String[]{""};
            pacienteCodigoList = new String[]{""};
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
        return pacienteList == null ? 0 : pacienteList.length;
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

    public Paciente getPacienteSelecionado(int index) {
        Paciente paciente;
        try {
            paciente = lista.get(pacienteCodigoList[index]);
        } catch (Exception e) {
            paciente = null;
        }

        return paciente;
    }

    public void setPacienteSelecionado(Paciente paciente) {
        selectedItem = paciente == null ? null : paciente.getNome();
    }

    private TreeMap<String, Paciente> getLista(TreeMap<String, Paciente> listaInicial, boolean pacientesAtivos) {
        if(pacientesAtivos) {
            TreeMap<String, Paciente> novaLista = new TreeMap<String, Paciente>();
            TreeMap<String, Paciente> listaTemporaria = listaInicial;
            
            for (Map.Entry<String, Paciente> entry : listaInicial.entrySet()) {
                Paciente paciente = (Paciente) entry.getValue();

                // se este paciente já tiver alta, não aparece na combo
                if(paciente.getDataSaida() != null){
                    continue;
                }
                
                novaLista.put(paciente.getCodigo(), paciente);
            }
            
            return novaLista;
        } else {
            return listaInicial;
        }
    }
}
