package frontend.janelas;

import frontend.tabelas.TabelaHospital;
import frontend.bases.JanelaBase;
import backend.Aplicacao;
import backend.Serializacao;
import backend.interfaces.ITable;
import javax.swing.JTable;

public class JanelaListaHospital extends JanelaBase {

    /**
     * Janela de listagem e manipulação de hospitais
     * @param app
     * @param serializacao
     * @param tituloJanela
     * @throws Exception 
     */
    public JanelaListaHospital(Aplicacao app, Serializacao serializacao, String tituloJanela) throws Exception {
        super(app, serializacao, tituloJanela);

        getBotaoCriar().setVisible(true);
        getBotaoDetalhe().setVisible(true);

        setTextoDetalhe();
        
        getTabTabela().add(new TabelaHospital(app, serializacao));
        getTabTabela().setTitleAt(0, "Hospitais");
        getTabTabela().setVisible(true);
        redesenharTabela();
    }

    @Override
    public void setTextoDetalhe() {
        String detalhe = "<html>";
        detalhe += "<b>Lista de hospitais</b>";
        detalhe += "</html>";
        
        getLabelDetalhe().setText(detalhe);
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
            JanelaCriarHospital janela = new JanelaCriarHospital(this, app, getCodigoSelecionado(((ITable) getTabTabela().getSelectedComponent())));
            janela.setVisible(true);
        } catch (NenhumaLinhaSelecionadaException ex) {
            mostrarAviso(ex.getMessage());
        } catch (Exception e) {
            mostrarAviso("");
        }
                
    }

    @Override
    public void detalhe() {
        try {
            validarSeExisteSelecao(false);
        } catch (NenhumaLinhaSelecionadaException ex) {
            mostrarAviso(ex.getMessage());
        }
        
        // buscar o codigo do hospital para enviar para a listagem de enfermarias
        int rowIndex = getLinhaSelecionada();
        
        // chama a janela da listagem das enfermarias do hospital selecionado
        String titutloConsultaEnfermaria = "Listagem Enfermarias (" + getTabelaSelecionada().getModel().getValueAt(rowIndex, 1) + ")";
        JanelaDetalheHospital janelaConsulta;
        try {
            fechar();
            janelaConsulta = new JanelaDetalheHospital(app, serializacao, titutloConsultaEnfermaria, getCodigoSelecionado(((ITable) getTabTabela().getSelectedComponent())));
            janelaConsulta.setVisible(true);
        } catch (Aplicacao.HospitalNaoExistenteException | Aplicacao.EnfermariaNaoExistenteException | NenhumaLinhaSelecionadaException ex) {
            mostrarAviso(ex.getMessage());
        } catch (Exception e) {
            mostrarAviso("");
        }
        
    }
    
    @Override
    public JTable getTabelaSelecionada() {
        return ((ITable) getTabTabela().getComponentAt(0)).getTabela();
    }
    
    public int getLinhaSelecionada() {
        return ((ITable) getTabTabela().getComponentAt(0)).getLinhaSelecionada();
    }
}
