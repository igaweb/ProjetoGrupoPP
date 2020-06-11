package frontend.bases;

import backend.interfaces.ITable;
import backend.interfaces.ICallerJanelaCriarInterface;
import backend.Aplicacao;
import backend.Serializacao;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public abstract class TabelaBase extends javax.swing.JPanel implements ICallerJanelaCriarInterface, ITable {

    protected final Aplicacao app;
    protected final Serializacao serializacao;
    
    protected AbstractTableModel modeloTabela;
    
    /**
     * Seleçoes
     */
    protected String hospitalSelecionado;
    protected String enfermariaSelecionada;
    
    /**
     * 
     * @param app
     * @param serializacao 
     */
    
    public TabelaBase(Aplicacao app, Serializacao serializacao) {
        this.app = app;
        this.serializacao = serializacao;
        
        initComponents();
        
        this.modeloTabela = criarModeloTabela();
        tabela.setModel(modeloTabela);        
    }
    
    protected void setOrdenacao() {
        tabela.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
    }//GEN-LAST:event_tabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizar() {
        // guarda os dados alterados
        guardar();
        
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }

    @Override
    public void guardar() {
        serializacao.guardar(app);
    }

    @Override
    public JTable getTabela() {        
        return tabela;
    }
    
    @Override
    public int getColunaCodigo() {
        return 0;
    }
    
    @Override
    public int getLinhaSelecionada() {
        return tabela.getRowSorter().convertRowIndexToModel(tabela.getSelectedRow());
    }
}
