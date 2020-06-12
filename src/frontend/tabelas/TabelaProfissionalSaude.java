package frontend.tabelas;

import frontend.bases.TabelaBase;
import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.entidades.Medico;
import backend.entidades.ProfissionalSaude;
import javax.swing.table.AbstractTableModel;

public class TabelaProfissionalSaude extends TabelaBase {

     /**
      * 
      */
    
    private Hospital hospitalSelecionadoObj;
    private Enfermaria enfermariaSelecionadaObj;
    
    /**
     * Cria a tabela com a listagem de profissionais de uma enfermaria
     * @param app
     * @param serializacao
     * @param hospitalSelecionado
     * @param enfermariaSelecionada
     * @throws java.lang.Exception
     */
    public TabelaProfissionalSaude(Aplicacao app, Serializacao serializacao, String hospitalSelecionado, String enfermariaSelecionada) throws Exception {
        super(app, serializacao);
        
        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);
        
        this.enfermariaSelecionada = enfermariaSelecionada;
        this.enfermariaSelecionadaObj = app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada);
        setOrdenacao();
    }
    
    /**
     * Cria o modelo com os dados necessários para configurar a tabela, tanto na estrutura como o seu conteudo
     * @return 
     */
    @Override
    public AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Código", "Nome", "Especialidade", "Nº pacientes"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return enfermariaSelecionadaObj.getProfissionalSaude().size();
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
                ProfissionalSaude profissionalSaude;
                try {
                    profissionalSaude = (ProfissionalSaude) app.getManagerProfissionalSaude(hospitalSelecionado, enfermariaSelecionada).getListaArray().get(rowIndex);
                } catch (Exception ex) {
                    return null;
                }
                switch (columnIndex) {
                    case 0:
                        return profissionalSaude.getCodigo();
                    case 1:
                        return profissionalSaude.getNome();
                    case 2:
                        String especialidade = "";
                        if (profissionalSaude instanceof Medico) {
                            especialidade = ((Medico) profissionalSaude).getEspecialidade();
                        }
                        return especialidade;
                    case 3:
                        int nPacientes = 0;
                        if (profissionalSaude instanceof Medico) {
                            nPacientes = ((Medico) profissionalSaude).getPacientes().size();
                        }
                        return nPacientes;
                    default:
                        return "";
                }
            }
        };
    }
}