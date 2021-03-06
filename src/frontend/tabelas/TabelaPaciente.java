package frontend.tabelas;

import frontend.bases.TabelaBase;
import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.entidades.Medico;
import backend.entidades.Paciente;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

public class TabelaPaciente extends TabelaBase {

     /**
      * 
      */
    
    private Hospital hospitalSelecionadoObj;
    private Enfermaria enfermariaSelecionadaObj;
    
    private Medico medicoAssociado;
    
    /**
     * Cria a tabela com a listagem de pacientes de uma enfermaria
     * @param app
     * @param serializacao
     * @param hospitalSelecionado
     * @param enfermariaSelecionada
     * @throws backend.Aplicacao.HospitalNaoExistenteException
     * @throws backend.Aplicacao.EnfermariaNaoExistenteException
     * @throws backend.Aplicacao.ProfissionalSaudeNaoExistenteException 
     */
    public TabelaPaciente(Aplicacao app, Serializacao serializacao, String hospitalSelecionado, String enfermariaSelecionada) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException, Aplicacao.ProfissionalSaudeNaoExistenteException  {
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
        String[] nomeColunas = {"Código", "Nome", "Localidade", "Cama", "Estado","Medico", "Data Entrada", "Data Saida"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                try {
                    //Retorna o número de linhas que a tabela deverá ter
                    return app.getManagerPaciente(hospitalSelecionado, enfermariaSelecionada).getLista().size();
                } catch (Exception ex) {
                    return 0;
                }
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
//                Date dataEntrada;
//                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                Paciente paciente = null;
                try {
                    paciente = (Paciente) app.getManagerPaciente(hospitalSelecionado, enfermariaSelecionada).getListaArray().get(rowIndex);
                } catch (Exception ex) {
                    return "";
                }
                switch (columnIndex) {
                    case 0:
                        return paciente.getCodigo();
                    case 1:
                        return paciente.getNome();
                    case 2:
                        return paciente.getLocalidade();
                    case 3:
                        return paciente.getCama();
                    case 4:
                        return Conteudos.getEstadosPaciente()[paciente.getEstado()];
                    case 5:                      
                         try {
                        return getMedico(paciente).getNome();
                    } catch (Exception ex) {
                        return "";
                    }                                    
                    case 6:
                        return paciente.getDataEntrada();                                     
                    case 7:
                        try {
                        return paciente.getDataSaida();
                    } catch (Exception ex) {
                        return "";
                    }
                    default:
                        return "";
                    }
            }
        };
    }
    
    private Medico getMedico(Paciente paciente) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException {
        // buscar o médico que está associado a este paciente
        TreeMap<String, Medico> medicos = app.getManagerProfissionalSaude(hospitalSelecionado,enfermariaSelecionada).getMedicos();
        for (Map.Entry<String, Medico> entry : medicos.entrySet()) {
            Medico medico = (Medico) entry.getValue();
            if(medico.getPacientes().containsKey(paciente.getCodigo())) {
                return medico;
            }
        }
        return null;
    }
}