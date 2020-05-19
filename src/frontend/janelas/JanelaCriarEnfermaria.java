/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.janelas;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerEnfermaria;
import frontend.model.filtros.HospitalComboModel;
import frontend.model.filtros.TipoEnfermariaComboModel;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author iga
 */
public class JanelaCriarEnfermaria extends javax.swing.JDialog {

    private Aplicacao app;
    private Serializacao serializacao;
    private String operacao;

    /**
     * Creates new form NewJDialog
     */
    public JanelaCriarEnfermaria(Aplicacao app,  Serializacao serializacao, String operacao) {
        this.app = app;
        this.serializacao = serializacao;
        this.operacao = operacao;
        
        initComponents();

        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);                                
        
        if(operacao.equals(ManagerEnfermaria.OPERACAO_ADICIONAR)) {
            setTitle("Adicionar Enfermaria");
        } else {
            setTitle("Editar Enfermaria");
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
        hospitalPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoHospital = new javax.swing.JComboBox<>();
        tipoEnfermariaPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoEnfermariaTipo = new javax.swing.JComboBox<>();
        nCamasPane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoNCamas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Hospital: ");

        campoHospital.setModel(new HospitalComboModel(app));
        campoHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHospitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hospitalPaneLayout = new javax.swing.GroupLayout(hospitalPane);
        hospitalPane.setLayout(hospitalPaneLayout);
        hospitalPaneLayout.setHorizontalGroup(
            hospitalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hospitalPaneLayout.setVerticalGroup(
            hospitalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hospitalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        jLabel4.setText("Tipo");

        campoEnfermariaTipo.setModel(new TipoEnfermariaComboModel());
        campoEnfermariaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEnfermariaTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tipoEnfermariaPaneLayout = new javax.swing.GroupLayout(tipoEnfermariaPane);
        tipoEnfermariaPane.setLayout(tipoEnfermariaPaneLayout);
        tipoEnfermariaPaneLayout.setHorizontalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoEnfermariaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tipoEnfermariaPaneLayout.setVerticalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEnfermariaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jLabel5.setText("Número de camas:");

        campoNCamas.setText("0");

        javax.swing.GroupLayout nCamasPaneLayout = new javax.swing.GroupLayout(nCamasPane);
        nCamasPane.setLayout(nCamasPaneLayout);
        nCamasPaneLayout.setHorizontalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nCamasPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        nCamasPaneLayout.setVerticalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nCamasPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoNCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jLabel1.setText(getTitle());

        javax.swing.GroupLayout filtrosLayout = new javax.swing.GroupLayout(filtros);
        filtros.setLayout(filtrosLayout);
        filtrosLayout.setHorizontalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hospitalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nCamasPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(hospitalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCamasPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Guardar");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHospitalActionPerformed
        
        try {
            int tipo = campoEnfermariaTipo.getSelectedIndex();
            Integer nCamas = new Integer(campoNCamas.getText());
            Boolean[] camas = new Boolean[nCamas];
            String codigoHospital = campoHospital.getModel().getElementAt(campoHospital.getSelectedIndex());
            Hospital hospital = (Hospital) app.getManagerHospital().getListaTreeMap().get(codigoHospital);
            TreeMap<String, Enfermaria> listaEnfermarias = (TreeMap<String, Enfermaria>) hospital.getEnfermarias();
            
            ManagerEnfermaria managerEnfermaria = new ManagerEnfermaria(listaEnfermarias);
            
            managerEnfermaria.adicionar(tipo, camas);
            
            serializacao.guardar(app);
            dispose();
            
        } catch (Exception ex) {
            mostrarAviso("Ocorreu um erro ao tentar guardar os dados");
        }
        
    }//GEN-LAST:event_campoHospitalActionPerformed

    private void campoEnfermariaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEnfermariaTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEnfermariaTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostrarAviso(String aviso) {
        JOptionPane.showMessageDialog(rootPane, aviso);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> campoEnfermariaTipo;
    private javax.swing.JComboBox<String> campoHospital;
    private javax.swing.JTextField campoNCamas;
    private javax.swing.JPanel filtros;
    private javax.swing.JPanel hospitalPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel nCamasPane;
    private javax.swing.JPanel tipoEnfermariaPane;
    // End of variables declaration//GEN-END:variables
}
