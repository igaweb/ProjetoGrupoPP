package frontend.janelas;

import backend.Aplicacao;
import backend.entidades.Paciente;
import backend.interfaces.ICallerJanelaCriarInterface;
import backend.managers.ManagerPaciente;
import frontend.model.filtros.HospitalComboModel;
import frontend.model.filtros.EstadoPacienteComboModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class JanelaCriarPaciente extends javax.swing.JDialog {
    private ICallerJanelaCriarInterface janela;
    private Aplicacao app;
    private String operacao;
    private ManagerPaciente managerPaciente;
    private Paciente paciente;
    
    /**
     * Creates new form NewJDialog
     */
    public JanelaCriarPaciente(ICallerJanelaCriarInterface janela, Aplicacao app, String codigoHospital, String codigoEnfermaria, String codigoPaciente) throws Exception {
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
        
        managerPaciente = app.getManagerPaciente(codigoHospital, codigoEnfermaria);
        
        if(codigoPaciente == null) {
            operacao = ManagerPaciente.OPERACAO_ADICIONAR;
            setTitle("Adicionar Paciente");
            
            // se estamos a adicionar, nao pedimos a data de saída
            campoDataSaida.setVisible(false);
            labelDataSaida.setVisible(false);
        } else {
            operacao = ManagerPaciente.OPERACAO_EDITAR;
            setTitle("Editar Paciente");
            paciente = (Paciente)app.getPaciente(codigoHospital, codigoEnfermaria, codigoPaciente);
            campoPacienteEstado.setSelectedIndex(paciente.getEstado());
            int nCamas = paciente.getCama();
            campoPacienteCama.setText(nCamas + "");
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
        jLabel4 = new javax.swing.JLabel();
        campoPacienteEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hospitalPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoEnfermaria = new javax.swing.JComboBox<>();
        nCamasPane = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoPacienteCama = new javax.swing.JTextField();
        campoLocalidadePaciente = new javax.swing.JTextField();
        campoNomePaciente = new javax.swing.JTextField();
        labelDataEntrada = new javax.swing.JLabel();
        labelDataSaida = new javax.swing.JLabel();
        campoDataEntrada = new javax.swing.JFormattedTextField();
        campoDataSaida = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Estado:");

        campoPacienteEstado.setModel(new EstadoPacienteComboModel());
        campoPacienteEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tipoEnfermariaPaneLayout = new javax.swing.GroupLayout(tipoEnfermariaPane);
        tipoEnfermariaPane.setLayout(tipoEnfermariaPaneLayout);
        tipoEnfermariaPaneLayout.setHorizontalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPacienteEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tipoEnfermariaPaneLayout.setVerticalGroup(
            tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipoEnfermariaPaneLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(tipoEnfermariaPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPacienteEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jLabel1.setText(getTitle());

        jLabel6.setText("Nome Paciente:");

        jLabel7.setText("Localidade:");

        jLabel2.setText("Enfermaria:");

        campoEnfermaria.setModel(new HospitalComboModel(app));
        campoEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEnfermariaActionPerformed(evt);
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
                .addComponent(campoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hospitalPaneLayout.setVerticalGroup(
            hospitalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hospitalPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hospitalPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEnfermaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        jLabel5.setText("Número de cama:");

        campoPacienteCama.setText("0");

        javax.swing.GroupLayout nCamasPaneLayout = new javax.swing.GroupLayout(nCamasPane);
        nCamasPane.setLayout(nCamasPaneLayout);
        nCamasPaneLayout.setHorizontalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nCamasPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPacienteCama, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        nCamasPaneLayout.setVerticalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nCamasPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoPacienteCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        campoLocalidadePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLocalidadePacienteActionPerformed(evt);
            }
        });

        labelDataEntrada.setText("Data de Entrada (YYYYMMdd):");

        labelDataSaida.setText("Data de Saída (YYYYMMdd):");

        try {
            campoDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataEntradaActionPerformed(evt);
            }
        });

        campoDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("YYYY-MM-dd"))));

        javax.swing.GroupLayout filtrosLayout = new javax.swing.GroupLayout(filtros);
        filtros.setLayout(filtrosLayout);
        filtrosLayout.setHorizontalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtrosLayout.createSequentialGroup()
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addComponent(nCamasPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoLocalidadePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(hospitalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, filtrosLayout.createSequentialGroup()
                                .addComponent(labelDataEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, filtrosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(labelDataSaida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoLocalidadePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoEnfermariaPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(hospitalPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCamasPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataEntrada)
                    .addComponent(campoDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataSaida)
                    .addComponent(campoDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void campoLocalidadePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLocalidadePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLocalidadePacienteActionPerformed

    private void campoEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEnfermariaActionPerformed

    }//GEN-LAST:event_campoEnfermariaActionPerformed

    private void campoPacienteEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteEstadoActionPerformed

    private void campoDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataEntradaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoDataEntrada;
    private javax.swing.JFormattedTextField campoDataSaida;
    private javax.swing.JComboBox<String> campoEnfermaria;
    private javax.swing.JTextField campoLocalidadePaciente;
    private javax.swing.JTextField campoNomePaciente;
    private javax.swing.JTextField campoPacienteCama;
    private javax.swing.JComboBox<String> campoPacienteEstado;
    private javax.swing.JPanel filtros;
    private javax.swing.JPanel hospitalPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelDataEntrada;
    private javax.swing.JLabel labelDataSaida;
    private javax.swing.JPanel nCamasPane;
    private javax.swing.JPanel tipoEnfermariaPane;
    // End of variables declaration//GEN-END:variables

    private void adicionarOuEditar() {
        try {
            String nome = campoNomePaciente.getText();
            String localidade = campoLocalidadePaciente.getText();                             
            int cama;
            try {
                cama = Integer.parseInt(campoPacienteCama.getText());
            } catch (Exception e) {
                mostrarAviso("Tem de inserir um número");
                return;
            }
            int estado = campoPacienteEstado.getSelectedIndex();
            
            // buscar o valor inserido na data de entrada
            Date dataEntrada;
            String dDataEntrada = campoDataEntrada.getText(); 
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            try {
                dataEntrada = df.parse(dDataEntrada);
            } catch (Exception e) {
                mostrarAviso("Tem de inserir em formato de data de entrada");
                return;
            }
            
            if(operacao.equals(ManagerPaciente.OPERACAO_ADICIONAR)){
                managerPaciente.adicionar(nome, localidade, cama, estado, dataEntrada);
            } else if(operacao.equals(ManagerPaciente.OPERACAO_EDITAR)){
                // buscar o valor inserido na data de saída
                Date dataSaida;
                String dDataSaida = campoDataSaida.getText(); 
                try {
                    dataSaida = df.parse(dDataSaida);
                } catch (Exception e) {
                    mostrarAviso("Tem de inserir em formato de data de saída");
                    return;
                }
                
                paciente.setEstado(estado);
                paciente.setCama(cama);
                paciente.setDataEntrada(dataEntrada);
                paciente.setDataSaida(dataSaida);
                managerPaciente.editar(paciente);
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

