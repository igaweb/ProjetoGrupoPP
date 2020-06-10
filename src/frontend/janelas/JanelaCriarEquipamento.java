/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.janelas;

import backend.interfaces.ICallerJanelaCriarInterface;
import backend.Aplicacao;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import backend.managers.ManagerEquipamento;
import frontend.model.filtros.PacienteComboModel;
import frontend.model.filtros.TipoEquipamentoComboModel;
import javax.swing.JOptionPane;

public class JanelaCriarEquipamento extends javax.swing.JDialog {

    private ICallerJanelaCriarInterface janela;
    private Aplicacao app;
    private String operacao;
    private ManagerEquipamento managerEquipamento;
    private Equipamento equipamento;
    private Enfermaria enfermaria;
    private String codigoHospital;
    private String codigoEnfermaria;
    
    
    /**
     * Creates new form JanelaCriarEquipamento
     */
    public JanelaCriarEquipamento(ICallerJanelaCriarInterface janela, Aplicacao app, String codigoHospital, String codigoEnfermaria, String codigoEquipamento) throws Aplicacao.HospitalNaoExistenteException, Aplicacao.EnfermariaNaoExistenteException, Aplicacao.EquipamentoNaoExistenteException {
        this.janela = janela;
        this.app = app;
        this.codigoHospital = codigoHospital;
        this.codigoEnfermaria = codigoEnfermaria;

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
            enfermaria = (Enfermaria) app.getManagerEnfermaria(codigoHospital).getLista().get(codigoEnfermaria);
        } catch (Exception e) {
            throw new NullPointerException("Falta codigo da Enfermaria.");
        }
        
        managerEquipamento = app.getManagerEquipamento(codigoHospital, codigoEnfermaria);
        
        if (codigoEquipamento == null) {
            operacao = ManagerEquipamento.OPERACAO_ADICIONAR;
            setTitle("Adicionar Equipamento");
            comboNomePaciente.setVisible(false);
            labelNomePaciente.setVisible(false);
        } else {
            operacao = ManagerEquipamento.OPERACAO_EDITAR;
            setTitle("Editar Equipamento");
            equipamento = (Equipamento) app.getEquipamento(codigoHospital, codigoEnfermaria, codigoEquipamento);
            campoNomeEquipamento.setText(equipamento.getNome());
            comboTipoEquipamento.setSelectedIndex(equipamento.getTipo());
            PacienteComboModel pacienteComboModel = (PacienteComboModel) comboNomePaciente.getModel();
            pacienteComboModel.setPacienteSelecionado(equipamento.getPaciente());
            
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

        botaoGuardar = new javax.swing.JButton();
        labelNomePaciente = new javax.swing.JLabel();
        comboNomePaciente = new javax.swing.JComboBox<>();
        jLabelNomeEquipamento = new javax.swing.JLabel();
        campoNomeEquipamento = new javax.swing.JTextField();
        userCode = new javax.swing.JLabel();
        labelTipoEquipamento = new javax.swing.JLabel();
        comboTipoEquipamento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botaoGuardar.setText("Guardar");
        botaoGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoGuardarMouseClicked(evt);
            }
        });
        botaoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGuardarActionPerformed(evt);
            }
        });

        labelNomePaciente.setText("Nome do Paciente :");

        try {
            comboNomePaciente.setModel(new PacienteComboModel(app, codigoHospital, codigoEnfermaria));
        } catch (Exception e) {
            System.out.println(e);
        }
        comboNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomePacienteActionPerformed(evt);
            }
        });

        jLabelNomeEquipamento.setText("Nome do Equipamento : ");

        campoNomeEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeEquipamentoActionPerformed(evt);
            }
        });

        userCode.setText("<User Code>");

        labelTipoEquipamento.setText("Tipo de equipamento:");

        comboTipoEquipamento.setModel(new TipoEquipamentoComboModel());
        comboTipoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(botaoGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(userCode)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomeEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(labelTipoEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboTipoEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addComponent(campoNomeEquipamento)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(userCode)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoEquipamento)
                    .addComponent(comboTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNomePaciente)
                    .addComponent(comboNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(botaoGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        campoNomeEquipamento.getAccessibleContext().setAccessibleName("");
        campoNomeEquipamento.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGuardarActionPerformed
        adicionarOuEditar();
    }//GEN-LAST:event_botaoGuardarActionPerformed

    private void botaoGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoGuardarMouseClicked

    private void comboNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNomePacienteActionPerformed

    private void campoNomeEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeEquipamentoActionPerformed

    private void comboTipoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoEquipamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGuardar;
    private javax.swing.JTextField campoNomeEquipamento;
    private javax.swing.JComboBox<String> comboNomePaciente;
    private javax.swing.JComboBox<String> comboTipoEquipamento;
    private javax.swing.JLabel jLabelNomeEquipamento;
    private javax.swing.JLabel labelNomePaciente;
    private javax.swing.JLabel labelTipoEquipamento;
    private javax.swing.JLabel userCode;
    // End of variables declaration//GEN-END:variables

   
    
    private void adicionarOuEditar() {
        String nome = campoNomeEquipamento.getText();
        int tipo = comboTipoEquipamento.getSelectedIndex();        
        
        try {
            if (operacao.equals(ManagerEquipamento.OPERACAO_ADICIONAR)) {
              managerEquipamento.adicionar(nome,tipo);

            } else if (operacao.equals(ManagerEquipamento.OPERACAO_EDITAR)) {
                equipamento.setNome(nome);
                equipamento.setTipo(tipo);
                if(comboNomePaciente.getSelectedIndex() == 0) {
                    equipamento.setPaciente(null);
                } else {
                    Paciente paciente = ((PacienteComboModel)comboNomePaciente.getModel()).getPacienteSelecionado(comboNomePaciente.getSelectedIndex());
                    equipamento.setPaciente(paciente);
                }
                
                managerEquipamento.editar(equipamento);
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
        dispose();
        
        janela.atualizar();
    }
    /*
     * FIM Métodos auxiliares genéricos
     */
}