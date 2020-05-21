package frontend.janelas;

import backend.Aplicacao;
import backend.Conteudos;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Paciente;
import backend.managers.ManagerPaciente;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JanelaConsultaPaciente extends javax.swing.JDialog {

    private final Aplicacao app;
    private final Serializacao serializacao;
    private AbstractTableModel modeloTabela;
    
    // hospital selecionado onde buscar a lista de enfermarias
    private String hospitalSelecionado;
    private String enfermariaSelecionada;
    
    /**
     * Creates new form JanelaConsultaEnfermaria
     * @param app
     * @param serializacao
     */
    public JanelaConsultaPaciente(Aplicacao app, Serializacao serializacao) {
        this.app = app;
        this.serializacao = serializacao;
        
        initComponents();
        
        this.modeloTabela = criarModeloTabela();
        tabela.setModel(modeloTabela);
        
//        // inicializar filtros
//        boolean hospitalFiltroVisible = true;
//        boolean tipoEnfermariaVisible = true;
//        setFiltrosVisible(hospitalFiltroVisible, tipoEnfermariaVisible);
        
//        // inicializar botoes de operaçoes
//        boolean criar = true;
//        boolean editar = true;
//        boolean remover = true;
//        setOperacoes(criar, editar, remover);
        
        // TEMPORARIO PARA TESTAR:
        hospitalSelecionado = "COD0";
        enfermariaSelecionada = "COD0";
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Código", "Nome", "Localidade", "Cama", "Estado", "Data Entrada", "Data Saida", "Hospital","Enfermaria"};
        
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
                Paciente paciente = (Paciente)app.getManagerPaciente(hospitalSelecionado,enfermariaSelecionada).getListaArray().get(rowIndex);
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
                        return paciente.getDataEntrada();
                    case 6: 
                        return paciente.getDataSaida();
                    case 7:
                        return hospitalSelecionado;
                    case 8: 
                        return enfermariaSelecionada;
                    default:
                        return "";
                }                              
            }            
        };
    }

    private void adicionar() {
        JanelaCriarPaciente janela = new JanelaCriarPaciente(app, serializacao, ManagerPaciente.OPERACAO_ADICIONAR);
        janela.setVisible(true);
    }
    
    private void editar() {
        int rowIndex = tabela.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) return;
        
        int colunaCodigo = 0;
        String codigo = (String) modeloTabela.getValueAt(rowIndex, colunaCodigo);
        
        try {
            Paciente paciente = (Paciente) app.getPaciente(hospitalSelecionado, enfermariaSelecionada, codigo);
            JanelaCriarPaciente janela = new JanelaCriarPaciente(app, serializacao, ManagerPaciente.OPERACAO_EDITAR);
            janela.setVisible(true);
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
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
        if(tabela.getSelectedRows() != null && tabela.getSelectedRows().length > 0) {
            int option = JOptionPane.showConfirmDialog(null, "Tem a certeza que quer eliminar a linha selecionada?");

            if(option == JOptionPane.OK_OPTION) {
                ManagerPaciente managerPaciente = app.getManagerPaciente(hospitalSelecionado, enfermariaSelecionada);
                for (int i = 0; i < tabela.getSelectedRows().length; i++) {
                    try {
                        int index = tabela.getSelectedRows()[i];
                        Enfermaria enfermaria = (Enfermaria) app.getEnfermaria(hospitalSelecionado, enfermariaSelecionada);
                        Paciente paciente = (Paciente) enfermaria.getPacientes().get(tabela.getModel().getValueAt(index, 0));
                        managerPaciente.remover(paciente);
                    } catch (Exception ex) {
                        mostrarAviso("Ocorreu um erro ao tentar remover o(s) paciente(s) selecionado(s).");
                    }
                }
            }
        }
    }//GEN-LAST:event_botaoRemoverMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
    }//GEN-LAST:event_tabelaMouseClicked
    
    protected void setOperacoes(boolean criar, boolean editar, boolean remover) {
        botaoCriar.setVisible(criar);
        botaoEditar.setVisible(editar);
        botaoRemover.setVisible(remover);
    }

    private void mostrarAviso(String aviso) {
        JOptionPane.showMessageDialog(rootPane, aviso);
    }
    
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
}
