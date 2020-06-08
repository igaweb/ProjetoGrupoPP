package frontend.janelas;

import frontend.tabelas.TabelaEnfermaria;
import frontend.bases.JanelaBase;
import backend.interfaces.ITable;
import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Hospital;
import backend.interfaces.IManager;
import javax.swing.JTable;

public class JanelaDetalheHospital extends JanelaBase {

    private Hospital hospitalSelecionadoObj;
    
    /**
     * Creates new form JanelaConsultaEnfermaria
     * @param app
     * @param serializacao
     * @param tituloJanela
     * @param hospitalSelecionado
     */
    public JanelaDetalheHospital(Aplicacao app, Serializacao serializacao, String tituloJanela, String hospitalSelecionado) throws Exception {
        super(app, serializacao, tituloJanela);
        
        getBotaoCriar().setVisible(true);
        getBotaoEditar().setVisible(true);
        getBotaoDetalhe().setVisible(true);

        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);
        
        setTextoDetalhe();
        
        getTabTabela().add(new TabelaEnfermaria(app, serializacao, hospitalSelecionado));
        getTabTabela().setTitleAt(0, "Enfermarias");
        getTabTabela().setVisible(true);
        getTabTabela().revalidate();
        getTabTabela().repaint();
    }
    
    @Override
    public void setTextoDetalhe() {
        String detalhe = "<html>";
        detalhe += "Hospital " + hospitalSelecionadoObj.getNome() + " - " + hospitalSelecionadoObj.getLocalidade();
        detalhe += "</html>";
        
        getLabelDetalhe().setText(detalhe);
    }
    
    @Override
    public void adicionar() {
        try {
            JanelaCriarEnfermaria janela = new JanelaCriarEnfermaria(this, app, hospitalSelecionado, null);
            janela.setVisible(true);
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
    }
    
    @Override
    public void editar() {
        
        try {
            JanelaCriarEnfermaria janela = new JanelaCriarEnfermaria(this, app, hospitalSelecionado, getCodigoSelecionado());
            janela.setVisible(true);
        } catch (Exception ex) { 
            mostrarAviso(ex.getMessage());
        }
        
    }
    
    @Override
    public void detalhe() {
        // buscar o codigo do hospital para enviar para a listagem de enfermarias
        int rowIndex = getTabelaSelecionada().getSelectedRow();
        
        // chama a janela da listagem das enfermarias do hospital selecionado
        String titutloConsultaEnfermaria = "Detalhe Enfermaria (" + getTabelaSelecionada().getModel().getValueAt(rowIndex, 1) + ")";
        JanelaDetalheEnfermaria janela;
        try {
            janela = new JanelaDetalheEnfermaria(app, serializacao, titutloConsultaEnfermaria, hospitalSelecionado, getCodigoSelecionado());
            janela.setVisible(true);
        } catch (Aplicacao.HospitalNaoExistenteException | Aplicacao.EnfermariaNaoExistenteException | NenhumaLinhaSelecionadaException ex) {
            mostrarAviso(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarAviso("Ocorre um erro no sistema");
        }
        
    }
    
    @Override
    public JTable getTabelaSelecionada() {
        return ((ITable) getTabTabela().getComponentAt(0)).getTabela();
    }

    @Override
    public IManager getManager() {
        return app.getManagerEnfermaria(hospitalSelecionado);
    }

}