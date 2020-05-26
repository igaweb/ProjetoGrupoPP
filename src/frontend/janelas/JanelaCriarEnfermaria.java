
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.janelas;

import backend.Aplicacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerEnfermaria;
import frontend.model.filtros.TipoEnfermariaComboModel;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author iga
 */
public class JanelaCriarEnfermaria extends javax.swing.JDialog {

    private JanelaConsultaEnfermaria janela;
    private Aplicacao app;
    private String operacao;
    private Hospital hospital;
    private ManagerEnfermaria managerEnfermaria;
    private Enfermaria enfermaria;

    /**
     * Creates new form NewJDialog
     * @param janela
     * @param app
     * @param codigoHospital
     * @param codigoEnfermaria
     */
    public JanelaCriarEnfermaria(JanelaConsultaEnfermaria janela, Aplicacao app, String codigoHospital, String codigoEnfermaria) {
        this.janela = janela;
        this.app = app;
        
        initComponents();

        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);    
        
        this.setAlwaysOnTop(true);
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);                                
        
        try {
            hospital = (Hospital) app.getManagerHospital().getLista().get(codigoHospital);
        } catch (Exception e) {
            throw  new NullPointerException("Falta codigo do hospital.");
        }
        
        TreeMap<String, Enfermaria> listaEnfermarias = hospital.getEnfermarias();
        managerEnfermaria = app.getManagerEnfermaria(codigoHospital);
        
        if(codigoEnfermaria == null) {
            operacao = ManagerEnfermaria.OPERACAO_ADICIONAR;
            setTitle("Adicionar Enfermaria");
        } else {
            operacao = ManagerEnfermaria.OPERACAO_EDITAR;
            setTitle("Editar Enfermaria");
            enfermaria = listaEnfermarias.get(codigoEnfermaria);
            campoEnfermariaTipo.setSelectedIndex(enfermaria.getTipo());
            int nCamas = enfermaria.getCamas().length;
            campoNome.setText(enfermaria.getNome());
            campoNCamas.setText(nCamas + "");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtros = new javax.swing.JPanel();
        tipoEnfermariaPane = new javax.swing.JPanel();
        labelTipo = new javax.swing.JLabel();
        campoEnfermariaTipo = new javax.swing.JComboBox<>();
        nomePane = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        nCamasPane1 = new javax.swing.JPanel();
        labelNcamas = new javax.swing.JLabel();
        campoNCamas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelTipo.setText("Tipo");

        campoEnfermariaTipo.setModel(new TipoEnfermariaComboModel());
        campoEnfermariaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEnfermariaTipoActionPerformed(evt);
            }
        });

        labelNome.setText("Nome");

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomePaneLayout = new javax.swing.GroupLayout(nomePane);
        nomePane.setLayout(nomePaneLayout);
        nomePaneLayout.setHorizontalGroup(
            nomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomePaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        nomePaneLayout.setVerticalGroup(
            nomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nomePaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout tipoEnfermariaPaneLayout = new javax.swing.GroupLayout(tipoEnfermariaPane);
        tipoEnfermariaPane.setLayout(tipoEnfermariaPaneLayout);
        tipoEnfermariaPaneLayout.setHorizontalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoEnfermariaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addComponent(nomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tipoEnfermariaPaneLayout.setVerticalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEnfermariaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipo)))
        );

        labelTitulo.setText(getTitle());

        labelNcamas.setText("Número de camas:");

        campoNCamas.setText("0");

        javax.swing.GroupLayout nCamasPane1Layout = new javax.swing.GroupLayout(nCamasPane1);
        nCamasPane1.setLayout(nCamasPane1Layout);
        nCamasPane1Layout.setHorizontalGroup(
            nCamasPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nCamasPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelNcamas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        nCamasPane1Layout.setVerticalGroup(
            nCamasPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nCamasPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nCamasPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNcamas)
                    .addComponent(campoNCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout filtrosLayout = new javax.swing.GroupLayout(filtros);
        filtros.setLayout(filtrosLayout);
        filtrosLayout.setHorizontalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nCamasPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(labelTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nCamasPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoEnfermariaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEnfermariaTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEnfermariaTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        adicionarOuEditar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> campoEnfermariaTipo;
    private javax.swing.JTextField campoNCamas;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPanel filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelNcamas;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel nCamasPane1;
    private javax.swing.JPanel nomePane;
    private javax.swing.JPanel tipoEnfermariaPane;
    // End of variables declaration//GEN-END:variables

    private void adicionarOuEditar() {
        
        String nome = campoNome.getText();
        int tipo = campoEnfermariaTipo.getSelectedIndex();
        Integer nCamas;

        try {
            nCamas = new Integer(campoNCamas.getText());
        } catch (NumberFormatException ex) {
            mostrarAviso("Número de camas inválido");
            return;
        }
        Boolean[] camas = new Boolean[nCamas];
        
        try {
            if(operacao.equals(ManagerEnfermaria.OPERACAO_ADICIONAR)){
                managerEnfermaria.adicionar(nome, tipo, camas);
            } else if(operacao.equals(ManagerEnfermaria.OPERACAO_EDITAR)){
                enfermaria.setNome(nome);
                enfermaria.setTipo(tipo);
                enfermaria.setCamas(camas);
                managerEnfermaria.editar(enfermaria);
            }
            
            fechar();
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
        
    }
    
    /*
     * Métodos auxiliares genéricos
    */
    private void mostrarAviso(String aviso) {
        JOptionPane.showMessageDialog(rootPane, aviso);
    }
    
    private void fechar() {
        // fehca a janela atual
        dispose();
        
        // atualiza os dados alterados na listagem
        janela.atualizar();
    }
    /*
     * FIM Métodos auxiliares genéricos
    */
}
