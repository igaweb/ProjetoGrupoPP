package frontend.janelas;

import backend.Aplicacao;
import backend.entidades.Medico;
import backend.entidades.Paciente;
import backend.interfaces.ICallerJanelaCriarInterface;
import backend.managers.ManagerPaciente;
import frontend.model.filtros.MedicoComboModel;
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
    private String codigoHospital, codigoEnfermaria;
    /**
     * Creates new form NewJDialog
     */
    public JanelaCriarPaciente(ICallerJanelaCriarInterface janela, Aplicacao app, String codigoHospital, String codigoEnfermaria, String codigoPaciente) throws Exception {
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
        
        campoMedicoAtribuido.setModel(new MedicoComboModel(app,codigoHospital, codigoEnfermaria));
        
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
            campoPacienteNome.setText(paciente.getNome());
            campoPacienteLocalidade.setText(paciente.getLocalidade());
            campoPacienteEstado.setSelectedIndex(paciente.getEstado());
            int nCamas = paciente.getCama();
            campoPacienteCama.setText(nCamas + "");
//            campoDataEntrada.setDate(paciente.getDataEntrada());
//            campoDataSaida.setDate(paciente.getDataSaida());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nCamasPane = new javax.swing.JPanel();
        labelDataSaida = new javax.swing.JLabel();
        campoPacienteLocalidade = new javax.swing.JTextField();
        campoPacienteNome = new javax.swing.JTextField();
        labelDataEntrada = new javax.swing.JLabel();
        campoDataEntrada = new javax.swing.JFormattedTextField();
        campoDataSaida = new javax.swing.JFormattedTextField();
        campoPacienteEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoMedicoAtribuido = new javax.swing.JComboBox<>();
        campoPacienteCama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 250));

        filtros.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setText(getTitle());

        jLabel6.setText("Nome:");
        jLabel6.setPreferredSize(new java.awt.Dimension(75, 15));

        jLabel7.setText("Localidade:");
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 15));

        labelDataSaida.setText("Data de Saída (YYYYMMdd):");

        javax.swing.GroupLayout nCamasPaneLayout = new javax.swing.GroupLayout(nCamasPane);
        nCamasPane.setLayout(nCamasPaneLayout);
        nCamasPaneLayout.setHorizontalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nCamasPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        nCamasPaneLayout.setVerticalGroup(
            nCamasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nCamasPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        campoPacienteLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteLocalidadeActionPerformed(evt);
            }
        });

        labelDataEntrada.setText("Data de Entrada (YYYYMMdd):");
        labelDataEntrada.setPreferredSize(new java.awt.Dimension(150, 15));

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

        try {
            campoDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        campoPacienteEstado.setModel(new EstadoPacienteComboModel());
        campoPacienteEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteEstadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Medico:");
        jLabel2.setMaximumSize(new java.awt.Dimension(60, 15));
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 15));

        jLabel4.setText("Estado:");
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 15));

        campoMedicoAtribuido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMedicoAtribuidoActionPerformed(evt);
            }
        });

        campoPacienteCama.setText("0");

        jLabel5.setText("Número de cama:");
        jLabel5.setPreferredSize(new java.awt.Dimension(85, 15));

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
                        .addContainerGap()
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(filtrosLayout.createSequentialGroup()
                                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(120, 120, 120)
                                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoPacienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoPacienteLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))
                            .addGroup(filtrosLayout.createSequentialGroup()
                                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoPacienteEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(campoMedicoAtribuido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoPacienteCama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoDataEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoDataSaida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(203, 203, 203)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtrosLayout.setVerticalGroup(
            filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPacienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPacienteLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addComponent(campoPacienteEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMedicoAtribuido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPacienteCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(nCamasPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filtrosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 253, Short.MAX_VALUE)
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

    private void campoMedicoAtribuidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMedicoAtribuidoActionPerformed

    }//GEN-LAST:event_campoMedicoAtribuidoActionPerformed

    private void campoPacienteEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteEstadoActionPerformed

    private void campoDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataEntradaActionPerformed

    private void campoPacienteLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteLocalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteLocalidadeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoDataEntrada;
    private javax.swing.JFormattedTextField campoDataSaida;
    private javax.swing.JComboBox<String> campoMedicoAtribuido;
    private javax.swing.JTextField campoPacienteCama;
    private javax.swing.JComboBox<String> campoPacienteEstado;
    private javax.swing.JTextField campoPacienteLocalidade;
    private javax.swing.JTextField campoPacienteNome;
    private javax.swing.JPanel filtros;
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
    // End of variables declaration//GEN-END:variables

    private void adicionarOuEditar() {
        try {
            String nome = campoPacienteNome.getText();
            String localidade = campoPacienteLocalidade.getText();                             
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
                
                paciente.setNome(nome);
                paciente.setLocalidade(localidade);
                paciente.setEstado(estado);               
                paciente.setCama(cama);
                paciente.setDataEntrada(dataEntrada);
                paciente.setDataSaida(dataSaida);
                managerPaciente.editar(paciente);
                
                
            }
            
            // buscar o medico selecionado
            Medico medico = ((MedicoComboModel)campoMedicoAtribuido.getModel()).getMedicoSelecionado();
            ((Medico)app.getProfissionalSaude(codigoHospital, codigoEnfermaria, medico.getCodigo())).getPacientes().put(paciente.getCodigo(), paciente);

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

