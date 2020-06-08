package frontend.tabelas;

import frontend.bases.TabelaBase;
import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Hospital;
import javax.swing.table.AbstractTableModel;

public class TabelaHospital extends TabelaBase {

    /**
     * Creates new form JanelaConsultaEnfermaria
     * @param app
     * @param serializacao
     */
    public TabelaHospital(Aplicacao app, Serializacao serializacao) throws Exception {
        super(app, serializacao);
    }
    
    /*
     * Cria o modelo com os dados necessários para configurar a tabela, tanto na estrutura como o seu conteudo
    */
    @Override
    public AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Código", "Nome", "Localidade", "Enfermarias"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return app.getManagerHospital().getLista().size();
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
                Hospital hospital;
                try {
                    hospital = (Hospital) app.getManagerHospital().getListaArray().get(rowIndex);
                    switch (columnIndex) {
                        case 0:
                            return hospital.getCodigo();
                        case 1:
                            return hospital.getNome();
                        case 2:
                            return hospital.getLocalidade();
                        case 3:
                            return hospital.getEnfermarias().size();
                        default:
                            return "";
                    }
                } catch (Exception ex) {
                    return "";
                }
            }
        };
    }
}