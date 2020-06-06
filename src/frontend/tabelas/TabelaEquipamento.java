package frontend.tabelas;

import frontend.bases.TabelaBase;
import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Hospital;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TabelaEquipamento extends TabelaBase {

    private Hospital hospitalSelecionadoObj;
    private Enfermaria enfermariaSelecionadaObj;
    
    /**
     * Creates new form JanelaConsultaEnfermaria
     * @param app
     * @param serializacao
     * @param hospitalSelecionado
     * @param enfermariaSelecionada
     * @throws java.lang.Exception
     */
    public TabelaEquipamento(Aplicacao app, Serializacao serializacao, String hospitalSelecionado, String enfermariaSelecionada) throws Exception {
        super(app, serializacao);
        
        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);
        
        this.enfermariaSelecionada = enfermariaSelecionada;
        this.enfermariaSelecionadaObj = app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada);
    }
    
    /*
     * Cria o modelo com os dados necessários para configurar a tabela, tanto na estrutura como o seu conteudo
    */
    @Override
    public AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Código", "Nome", "Tipo", "Paciente"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                try {
                    //Retorna o número de linhas que a tabela deverá ter
                    return app.getManagerEquipamento(hospitalSelecionado, enfermariaSelecionada).getLista().size();
                } catch (Aplicacao.HospitalNaoExistenteException | Aplicacao.EnfermariaNaoExistenteException ex) {
                    Logger.getLogger(TabelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0;
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
                 */
                Equipamento equipamento;
                try {
                    equipamento = (Equipamento) app.getManagerEquipamento(hospitalSelecionado, enfermariaSelecionada).getListaArray().get(rowIndex);
                } catch (Aplicacao.HospitalNaoExistenteException | Aplicacao.EnfermariaNaoExistenteException ex) {
                    Logger.getLogger(TabelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
                    equipamento = null;
                }
                switch (columnIndex) {
                    case 0:
                        return equipamento.getCodigo();
                    case 1:
                           return  equipamento.getNome();
                    case 2:               
                        return Conteudos.getTiposEquipamentos()[equipamento.getTipo()];
                    case 3:
                        try {
                            return equipamento.getPaciente().getNome();
                        }catch (Exception e){
                           return ""; 
                        }
                                
                        
                    default:
                        return "";
                }
            }
        };
    }
}