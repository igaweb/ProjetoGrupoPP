package frontend.janelas;

import frontend.tabelas.TabelaHospital;
import frontend.bases.JanelaBase;
import backend.Aplicacao;
import backend.Serializacao;
import backend.bases.EntidadeBase;
import backend.interfaces.IManager;
import javax.swing.JOptionPane;

public class JanelaListaHospital extends JanelaBase {

    /**
     * Creates new form JanelaConsultaEnfermaria
     *
     * @param app
     * @param serializacao
     * @param tituloJanela
     */
    public JanelaListaHospital(Aplicacao app, Serializacao serializacao, String tituloJanela) throws Exception {
        super(app, serializacao, tituloJanela);

        getBotaoCriar().setVisible(true);
        getBotaoEditar().setVisible(true);

        getBotaoDetalhe().setVisible(true);

        getTabTabela().add(new TabelaHospital(app, serializacao));
        getTabTabela().setTitleAt(0, "Hospitais");
        getTabTabela().setVisible(true);
        getTabTabela().revalidate();
        getTabTabela().repaint();
    }

    @Override
    public void adicionar() {
        try {
            JanelaCriarHospital janela = new JanelaCriarHospital(this, app, null);
            janela.setVisible(true);
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
    }

    @Override
    public void editar() {
        try {
            JanelaCriarHospital janela = new JanelaCriarHospital(this, app, getCodigoSelecionado());
            janela.setVisible(true);
        } catch (NenhumaLinhaSelecionadaException ex) {
            mostrarAviso(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
                
    }

    @Override
    public void detalhe() {
        // buscar o codigo do hospital para enviar para a listagem de enfermarias
        int rowIndex = getTabelaSelecionada().getSelectedRow();
        
        // chama a janela da listagem das enfermarias do hospital selecionado
        String titutloConsultaEnfermaria = "Listagem Enfermarias (" + getTabelaSelecionada().getModel().getValueAt(rowIndex, 1) + ")";
        JanelaDetalheHospital janelaConsulta;
        try {
            janelaConsulta = new JanelaDetalheHospital(app, serializacao, titutloConsultaEnfermaria, getCodigoSelecionado());
            janelaConsulta.setVisible(true);
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
        
    }

    @Override
    public IManager getManager() {
        return app.getManagerEnfermaria(hospitalSelecionado);
    }
}
