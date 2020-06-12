package frontend.janelas;

import frontend.tabelas.TabelaProfissionalSaude;
import frontend.tabelas.TabelaEquipamento;
import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Hospital;
import backend.entidades.Enfermaria;
import backend.bases.EntidadeBase;
import backend.entidades.Equipamento;
import backend.interfaces.ITable;
import frontend.bases.JanelaBase;
import frontend.bases.TabelaBase;
import frontend.tabelas.TabelaPaciente;
import java.util.Map;
import java.util.TreeMap;

public class JanelaDetalheEnfermaria extends JanelaBase {

    // hospital selecionado onde buscar a lista de enfermarias
    private Hospital hospitalSelecionadoObj;
    private Enfermaria enfermariaSelecionadaObj;

    /**
     * janela de destalhe enfermarias
     * @param app
     * @param serializacao
     * @param tituloJanela
     * @param hospitalSelecionado
     * @param enfermariaSelecionada
     * @throws backend.Aplicacao.HospitalNaoExistenteException
     * @throws backend.Aplicacao.EnfermariaNaoExistenteException
     * @throws Exception 
     */
     
    public JanelaDetalheEnfermaria(Aplicacao app, Serializacao serializacao, String tituloJanela, String hospitalSelecionado, String enfermariaSelecionada) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException, Exception {
        super(app, serializacao, tituloJanela);

        getMenuEquipamento().setVisible(true);
        getMenuProfissionalSaude().setVisible(true);
        getMenuPaciente().setVisible(true);

        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);

        // aplica a seleçao da enfermaria onde está esta listagem
        this.enfermariaSelecionada = enfermariaSelecionada;
        this.enfermariaSelecionadaObj = app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada);

        setTextoDetalhe();

        getTabTabela().add(new TabelaEquipamento(app, serializacao, hospitalSelecionado, enfermariaSelecionada));
        getTabTabela().setTitleAt(0, "Equipamentos");
        getTabTabela().add(new TabelaProfissionalSaude(app, serializacao, hospitalSelecionado, enfermariaSelecionada));
        getTabTabela().setTitleAt(1, "Profissionais de Saúde");
        getTabTabela().add(new TabelaPaciente(app, serializacao, hospitalSelecionado, enfermariaSelecionada));
        getTabTabela().setTitleAt(2, "Pacientes");
        getTabTabela().setVisible(true);
        redesenharTabela();
    }

    @Override
    public void setTextoDetalhe() {
        String detalhe = "<html>";
        detalhe += "<b>Hospital " + hospitalSelecionadoObj.getNome() + " - " + hospitalSelecionadoObj.getLocalidade() + "</b>";
        detalhe += "<br>";
        detalhe += "<b>Enfermaria " + enfermariaSelecionadaObj.getNome() + " (" + Conteudos.getTiposEnfermarias()[enfermariaSelecionadaObj.getTipo()] + ")</b>";
        detalhe += "<br>";
        detalhe += "- Nº de camas: " + enfermariaSelecionadaObj.getCamas().length + " (" + getCamasLivres() + " livres)";
        detalhe += "<br>";
        detalhe += "- Nº de equipamentos: " + enfermariaSelecionadaObj.getEquipamentos().size() + " (" + getEquipamentosLivres() + " livres)";
        detalhe += "</html>";

        getLabelDetalhe().setText(detalhe);
    }

    @Override
    public void adicionar() {
        try {

            EntidadeBase entidadeRef;
            ITable tabelaSelecionada = ((TabelaBase) getTabTabela().getSelectedComponent());

            if (tabelaSelecionada instanceof TabelaEquipamento) {
                JanelaCriarEquipamento janela = new JanelaCriarEquipamento(this, app, hospitalSelecionado, enfermariaSelecionada, null);
                janela.setVisible(true);
            } else if (tabelaSelecionada instanceof TabelaPaciente) {
                JanelaCriarPaciente janela = new JanelaCriarPaciente(this, app, hospitalSelecionado, enfermariaSelecionada, null);
                janela.setVisible(true);
            } else {
                entidadeRef = null;
            }
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
    }

    @Override
    public void editar() {
        try {

            ITable tabelaSelecionada = ((TabelaBase) getTabTabela().getSelectedComponent());

            if (tabelaSelecionada instanceof TabelaEquipamento) {
                editarEquipamento();
            } else if (tabelaSelecionada instanceof TabelaProfissionalSaude) {
                editarProfissionalSaude();
            } else if (tabelaSelecionada instanceof TabelaPaciente) {
                editarPaciente();
            } else {
            }
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }

    }

    private void adicionarProfissionalSaude(boolean isMedico) {
        try {
            JanelaCriarProfissionalSaude janela = new JanelaCriarProfissionalSaude(this, app, hospitalSelecionado, enfermariaSelecionada, null, isMedico);
            janela.setVisible(true);
        } catch (Aplicacao.EnfermariaNaoExistenteException | Aplicacao.HospitalNaoExistenteException ex) {
            mostrarAviso(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarAviso("Ocorreu um erro generico.");
        }
    }

    @Override
    public void detalhe() {
        // não existe detalhe
    }

    private int getCamasLivres() {
        Boolean[] camas = enfermariaSelecionadaObj.getCamas();
        int contador = 0;
        for (int i = 0; i < camas.length; i++) {
            if (camas[i] == null || camas[i]) {
                contador++;
            }
        }

        return contador;
    }

    private int getEquipamentosLivres() {
        TreeMap<String, EntidadeBase> equipamentos = enfermariaSelecionadaObj.getEquipamentos();
        int contador = 0;
        for (Map.Entry<String, EntidadeBase> entry : equipamentos.entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();

            if (equipamento.getPaciente() == null) {
                contador++;
            }
        }

        return contador;
    }
}
