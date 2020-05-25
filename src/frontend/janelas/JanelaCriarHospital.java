/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.janelas;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Hospital;
import backend.managers.ManagerHospital;
import javax.swing.JOptionPane;

/**
 *
 * @author iga
 */
public class JanelaCriarHospital extends javax.swing.JDialog {

    private JanelaConsultaHospital janela;
    private Aplicacao app;
    private String operacao;
    private String codigoHospital;
    private ManagerHospital managerHospital;
    private Hospital hospital;

    /**
     * Creates new form NewJDialog
     */
    public JanelaCriarHospital(JanelaConsultaHospital janela, Aplicacao app, String codigoHospital) {
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

        managerHospital = app.getManagerHospital();

        if (codigoHospital == null) {
            operacao = ManagerHospital.OPERACAO_ADICIONAR;
            setTitle("Adicionar Hospital");
        } else {
            operacao = ManagerHospital.OPERACAO_EDITAR;
            setTitle("Editar Hospital");
            hospital = (Hospital) app.getManagerHospital().getLista().get(codigoHospital);
            campoHospitalNome.getText();
            campoHospitaLocalidade.getText();
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
        Localidade = new javax.swing.JLabel();
        campoHospitaLocalidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        campoHospitalNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Localidade.setText("Localidade:");

        javax.swing.GroupLayout tipoEnfermariaPaneLayout = new javax.swing.GroupLayout(tipoEnfermariaPane);
        tipoEnfermariaPane.setLayout(tipoEnfermariaPaneLayout);
        tipoEnfermariaPaneLayout.setHorizontalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(Localidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoHospitaLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tipoEnfermariaPaneLayout.setVerticalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tipoEnfermariaPaneLayout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Localidade)
                    .addComponent(campoHospitaLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setText(getTitle());

        Nome.setText("Nome:");

        javax.swing.GroupLayout filtrosLayout = new javax.swing.GroupLayout(filtros);
        filtros.setLayout(filtrosLayout);
        filtrosLayout.setHorizontalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(132, Short.MAX_VALUE))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addComponent(Nome)
                        .addGap(36, 36, 36)
                        .addComponent(campoHospitalNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(campoHospitalNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        adicionarOuEditar();
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Localidade;
    private javax.swing.JLabel Nome;
    private javax.swing.JTextField campoHospitaLocalidade;
    private javax.swing.JTextField campoHospitalNome;
    private javax.swing.JPanel filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel tipoEnfermariaPane;
    // End of variables declaration//GEN-END:variables

    private void adicionarOuEditar() {
        try {
            String nome = campoHospitalNome.getText();
            String localidade = campoHospitaLocalidade.getText();

            if (operacao.equals(ManagerHospital.OPERACAO_ADICIONAR)) {
                managerHospital.adicionar(nome, localidade);
            } else if (operacao.equals(ManagerHospital.OPERACAO_EDITAR)) {
                hospital.setNome(nome);
                hospital.setLocalidade(localidade);
                managerHospital.editar(hospital);
            }

            fechar();
            this.getOwner().firePropertyChange("tabela", 0, 0);
        } catch (Exception ex) {
            mostrarAviso("Ocorreu um erro ao tentar guardar os dados");
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
