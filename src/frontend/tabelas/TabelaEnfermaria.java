package frontend.tabelas;

import frontend.bases.TabelaBase;
import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import javax.swing.table.AbstractTableModel;

public class TabelaEnfermaria extends TabelaBase {

    private Hospital hospitalSelecionadoObj;
    
    /**
     * Creates new form JanelaConsultaEnfermaria
     * @param app
     * @param serializacao
     * @param hospitalSelecionado
     */
    public TabelaEnfermaria(Aplicacao app, Serializacao serializacao, String hospitalSelecionado) throws Aplicacao.HospitalNaoExistenteException {
        super(app, serializacao);
        
        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);
        
    }
    
    /*
     * Cria o modelo com os dados necessários para configurar a tabela, tanto na estrutura como o seu conteudo
    */
    @Override
    public AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Código", "Nome", "Tipo", "Equipamentos", "Camas"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return app.getManagerEnfermaria(hospitalSelecionado).getLista().size();
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
                Enfermaria enfermaria = (Enfermaria)app.getManagerEnfermaria(hospitalSelecionado).getListaArray().get(rowIndex);
                switch (columnIndex) {
                    case 0: 
                        return enfermaria.getCodigo();
                    case 1:
                        return enfermaria.getNome();
                    case 2:
                        return Conteudos.getTiposEnfermarias()[enfermaria.getTipo()];
                    case 3:
                        return enfermaria.getEquipamentos().size();
                    case 4:
                        return enfermaria.getCamas().length;
                    default:
                        return "";
                }                              
            }            
        };
    }

}