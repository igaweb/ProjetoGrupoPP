/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.janelas;

import backend.interfaces.ICallerJanelaCriarInterface;
import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Utilizador;
import backend.managers.ManagerUtilizador;
import javax.swing.JOptionPane;

/**
 *
 * @author iga
 */
public class JanelaCriarUtilizador extends javax.swing.JDialog {

    private ICallerJanelaCriarInterface janela;
    private Aplicacao app;
    private Serializacao serializacao;
    private String operacao;
    private ManagerUtilizador managerUtilizador;
    private Utilizador utilizador;

    /**
     * Creates new form NewJDialog
     */
    public JanelaCriarUtilizador(ICallerJanelaCriarInterface janela, Aplicacao app, Serializacao serializacao, String nomeUtilizador) {
        this.janela = janela;
        this.app = app;
        this.serializacao = serializacao;

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

        managerUtilizador = app.getManagerUtilizador();

        if (nomeUtilizador == null) {
            operacao = ManagerUtilizador.OPERACAO_ADICIONAR;
            setTitle("Adicionar Utilizador");
            campoUtilizadorNome.setEditable(true);
        } else {
            operacao = ManagerUtilizador.OPERACAO_EDITAR;
            setTitle("Editar Utilizador");
            utilizador = (Utilizador) app.getManagerUtilizador().getLista().get(nomeUtilizador);
            campoUtilizadorNome.setText(utilizador.getNome());
            campoUtilizadorPassword.setText(utilizador.getPassword());
            campoUtilizadorNome.setEditable(false);
            campoUtilizadorPassword.setEditable(false);
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
        jLabel1 = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        campoUtilizadorNome = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Password1 = new javax.swing.JLabel();
        Password2 = new javax.swing.JLabel();
        campoUtilizadorPassword = new javax.swing.JTextField();
        campoUtilizadorNovaPassword = new javax.swing.JPasswordField();
        campoUtilizadorValidarPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText(getTitle());

        Nome.setText("Nome:");

        campoUtilizadorNome.setEditable(false);

        Password.setText("Password:");

        Password1.setText("Nova Password:");

        Password2.setText("Validar Password:");

        javax.swing.GroupLayout filtrosLayout = new javax.swing.GroupLayout(filtros);
        filtros.setLayout(filtrosLayout);
        filtrosLayout.setHorizontalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoUtilizadorNovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(filtrosLayout.createSequentialGroup()
                            .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Password)
                                .addComponent(Password1)
                                .addComponent(Password2))
                            .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(filtrosLayout.createSequentialGroup()
                                    .addGap(69, 69, 69)
                                    .addComponent(campoUtilizadorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoUtilizadorValidarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(filtrosLayout.createSequentialGroup()
                            .addComponent(Nome)
                            .addGap(123, 123, 123)
                            .addComponent(campoUtilizadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(campoUtilizadorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password)
                    .addComponent(campoUtilizadorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoUtilizadorNovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password1))
                .addGap(28, 28, 28)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password2)
                    .addComponent(campoUtilizadorValidarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Password1;
    private javax.swing.JLabel Password2;
    private javax.swing.JTextField campoUtilizadorNome;
    private javax.swing.JPasswordField campoUtilizadorNovaPassword;
    private javax.swing.JTextField campoUtilizadorPassword;
    private javax.swing.JPasswordField campoUtilizadorValidarPassword;
    private javax.swing.JPanel filtros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void adicionarOuEditar() {
        try {
            String nome = campoUtilizadorNome.getText();
            String password = campoUtilizadorPassword.getText();
            String novaPassword = campoUtilizadorNovaPassword.getText();
            String validarPassword = campoUtilizadorValidarPassword.getText();
            
            if (operacao.equals(ManagerUtilizador.OPERACAO_ADICIONAR)) {
                managerUtilizador.adicionar(nome, password);
            } else if (operacao.equals(ManagerUtilizador.OPERACAO_EDITAR)) {
                if (novaPassword.equals(validarPassword)) {
                utilizador.setPassword(novaPassword);
                managerUtilizador.editar(utilizador);
                }

            }

            fechar();
            this.getOwner().firePropertyChange("tabela", 0, 0);
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
        
        if(janela != null) {
            janela.atualizar();
        }
        serializacao.guardar(app);
        
    }
    /*
     * FIM Métodos auxiliares genéricos
     */
}
