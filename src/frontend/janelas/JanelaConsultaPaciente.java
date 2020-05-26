package frontend.janelas;

import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.entidades.Paciente;
import backend.managers.ManagerPaciente;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaConsultaPaciente extends javax.swing.JDialog {

    private final Aplicacao app;
    private final Serializacao serializacao;
    private AbstractTableModel modeloTabela;

    // hospital selecionado onde buscar a lista de enfermarias
    private String hospitalSelecionado;
    private Hospital hospitalSelecionadoObj;
    private String enfermariaSelecionada;
    private Enfermaria enfermariaSelecionadaObj;

    /**
     * Creates new form JanelaConsultaEnfermaria
     *
     * @param app
     * @param serializacao
     * @param hospitalSelecionado
     * @param enfermariaSelecionada
     */
    public JanelaConsultaPaciente(Aplicacao app, Serializacao serializacao, String hospitalSelecionado, String enfermariaSelecionada) {
        this.app = app;
        this.serializacao = serializacao;

        initComponents();

        this.modeloTabela = criarModeloTabela();
        tabela.setModel(modeloTabela);

        // aplica a seleçao do hospital onde está esta listagem
        this.hospitalSelecionado = hospitalSelecionado;
        try {
            this.hospitalSelecionadoObj = app.getHospital(hospitalSelecionado);
        } catch (Aplicacao.HospitalNaoExistenteException ex) {
            mostrarAviso(ex.getMessage());
            return;
        }

        // aplica a seleçao do hospital onde está esta listagem
        this.enfermariaSelecionada = enfermariaSelecionada;
        try {
            this.enfermariaSelecionadaObj = app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada);
        } catch (Aplicacao.EnfermariaNaoExistenteException | Aplicacao.HospitalNaoExistenteException ex) {
            mostrarAviso(ex.getMessage());
            return;
        }

        // titulo da janela
        setTitle("Listagem Pacientes (" + hospitalSelecionadoObj.getNome() + " - " + enfermariaSelecionadaObj.getNome() + ")");
    }

    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Código", "Nome", "Localidade", "Cama", "Estado", "Data Entrada", "Data Saida", "Enfermaria"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return app.getManagerPaciente(hospitalSelecionado, enfermariaSelecionada).getLista().size();
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
                Date dataEntrada;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                
                Paciente paciente = (Paciente) app.getManagerPaciente(hospitalSelecionado, enfermariaSelecionada).getListaArray().get(rowIndex);
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
                            return df.format(paciente.getDataEntrada());
                        } catch (Exception ex) {
                            return "";
                        }
                    case 6:
                        try {
                            return df.format(paciente.getDataSaida());
                        } catch (Exception ex) {
                            return "";
                        }
                    case 8:
                        try {
                            return app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada).getNome();
                        } catch (Aplicacao.HospitalNaoExistenteException | Aplicacao.EnfermariaNaoExistenteException ex) {
                            return "";
                        }

                    default:
                        return "";
                }
            }
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentor = new javax.swing.JPanel();
        botoes = new javax.swing.JPanel();
        botaoCriar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botaoCriar.setText("Criar");
        botaoCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoCriarMouseClicked(evt);
            }
        });
        botaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover linha");
        botaoRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoRemoverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout botoesLayout = new javax.swing.GroupLayout(botoes);
        botoes.setLayout(botoesLayout);
        botoesLayout.setHorizontalGroup(
            botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCriar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRemover)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        botoesLayout.setVerticalGroup(
            botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesLayout.createSequentialGroup()
                .addGroup(botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCriar)
                    .addComponent(botaoEditar)
                    .addComponent(botaoRemover))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setColumnSelectionAllowed(true);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout contentorLayout = new javax.swing.GroupLayout(contentor);
        contentor.setLayout(contentorLayout);
        contentorLayout.setHorizontalGroup(
            contentorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentorLayout.setVerticalGroup(
            contentorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(contentor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoCriarMouseClicked
        adicionar();
    }//GEN-LAST:event_botaoCriarMouseClicked

    private void botaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarActionPerformed

    }//GEN-LAST:event_botaoCriarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        editar();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoRemoverMouseClicked
        remover();
    }//GEN-LAST:event_botaoRemoverMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

    }//GEN-LAST:event_tabelaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCriar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JPanel botoes;
    private javax.swing.JPanel contentor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
private void adicionar() {
        try {
            JanelaCriarPaciente janela = new JanelaCriarPaciente(this, app, hospitalSelecionado, enfermariaSelecionada, null);
            janela.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void editar() {
        if (!validarSeExisteSelecao(false)) {
            return;
        }

        int rowIndex = tabela.getSelectedRow();
        int colunaCodigo = 0;
        String codigo = (String) modeloTabela.getValueAt(rowIndex, colunaCodigo);

        try {
            JanelaCriarPaciente janela = new JanelaCriarPaciente(this, app, hospitalSelecionado, enfermariaSelecionada, codigo);
            janela.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    private void remover() {
        if (!validarSeExisteSelecao(true)) {
            return;
        }

        int option = JOptionPane.showConfirmDialog(null, "Tem a certeza que quer eliminar a linha selecionada?");

        if (option == JOptionPane.OK_OPTION) {
            Enfermaria enfermaria = (Enfermaria) app.getManagerEnfermaria(hospitalSelecionado).getLista().get(enfermariaSelecionada);
            ManagerPaciente managerPaciente = new ManagerPaciente(enfermaria.getPacientes());
            boolean error = false;
            for (int i = 0; i < tabela.getSelectedRows().length; i++) {
                try {
                    int index = tabela.getSelectedRows()[i];

                    String key = (String) tabela.getModel().getValueAt(index, 0);
                    Paciente paciente = enfermaria.getPacientes().get(key);
                    managerPaciente.remover(paciente);
                } catch (Exception ex) {
                    mostrarAviso("Ocorreu um erro ao tentar remover o(s) paciente(s) selecionado(s).");
                    error = true;
                    break;
                }
            }
            
            if(error) {
                return;
            }
            
            atualizar();
            mostrarAviso("Paciente removido com sucesso");
        }
    }

    /*
     * Métodos auxiliares genéricos
     */
    private void mostrarAviso(String aviso) {
        JOptionPane.showMessageDialog(rootPane, aviso);
    }

    private void fechar() {
        dispose();
    }

    public void atualizar() {
        // guarda os dados alterados
        guardar();

        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }

    private boolean validarSeExisteSelecao(boolean isMultipla) {
        if (tabela.getSelectedRows() == null
                || (isMultipla && tabela.getSelectedRows().length <= 0)
                || (!isMultipla && tabela.getSelectedRows().length != 1)) {
            mostrarAviso("Tem de selecionar uma linha primeiro");
            return false;
        }
        return true;
    }

    private void guardar() {
        serializacao.guardar(app);
    }
    /*
     * FIM Métodos auxiliares genéricos
     */
}
