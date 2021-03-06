package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Administrador;
import frontend.janelas.JanelaConsultaUtilizador;
import frontend.janelas.JanelaCriarUtilizador;
import javax.swing.JOptionPane;
import backend.interfaces.ICallerJanelaCriarInterface;
import frontend.janelas.JanelaListaHospital;

public class Homepage extends javax.swing.JFrame implements ICallerJanelaCriarInterface {
 
    /**
     * 
     */
    
    private static Aplicacao app;
    private static Serializacao serializacao;

    Homepage(Aplicacao app, Serializacao serializacao) {
        this.app = app;
        this.serializacao = serializacao;

        initComponents();
        //Força a maximização da janela
        this.setExtendedState(Homepage.MAXIMIZED_BOTH);    

        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Apenas mostra o menu de administração se o utilizador for um administrador
        menuAdmin.setVisible(app.getUtilizadorAutenticado() instanceof Administrador);

        //Mostra o menu Iniciar
        menuIniciar.setVisible(true);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        hospital1 = new backend.entidades.Hospital();
        hospital2 = new backend.entidades.Hospital();
        popupMenu1 = new java.awt.PopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdmin = new javax.swing.JMenu();
        menuAcessoGerirUtilizadores = new javax.swing.JMenuItem();
        menuIniciar = new javax.swing.JMenu();
        menuListarHospitais = new javax.swing.JMenuItem();
        menuEditarUtilizador = new javax.swing.JMenuItem();
        menuAcessoLogin = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        popupMenu1.setLabel("popupMenu1");

        jMenu3.setText("jMenu3");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        menuAdmin.setText("Administrador");
        menuAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdminActionPerformed(evt);
            }
        });

        menuAcessoGerirUtilizadores.setText("Gerir Utilizadores");
        menuAcessoGerirUtilizadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcessoGerirUtilizadoresActionPerformed(evt);
            }
        });
        menuAdmin.add(menuAcessoGerirUtilizadores);

        jMenuBar1.add(menuAdmin);

        menuIniciar.setText("Iniciar");

        menuListarHospitais.setText("Hospitais");
        menuListarHospitais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarHospitaisActionPerformed(evt);
            }
        });
        menuIniciar.add(menuListarHospitais);

        menuEditarUtilizador.setText("Editar Perfil");
        menuEditarUtilizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarUtilizadorActionPerformed(evt);
            }
        });
        menuIniciar.add(menuEditarUtilizador);

        menuAcessoLogin.setText("Logout");
        menuAcessoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcessoLoginActionPerformed(evt);
            }
        });
        menuIniciar.add(menuAcessoLogin);

        jMenuBar1.add(menuIniciar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAdminActionPerformed

    private void menuAcessoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcessoLoginActionPerformed
        logout();
    }//GEN-LAST:event_menuAcessoLoginActionPerformed

    private void menuAcessoGerirUtilizadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcessoGerirUtilizadoresActionPerformed
        listarUtilizadores();
    }//GEN-LAST:event_menuAcessoGerirUtilizadoresActionPerformed

    private void menuListarHospitaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarHospitaisActionPerformed
        listarHospitais();
    }//GEN-LAST:event_menuListarHospitaisActionPerformed

    private void menuEditarUtilizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarUtilizadorActionPerformed
        editarPerfil();
    }//GEN-LAST:event_menuEditarUtilizadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private backend.entidades.Hospital hospital1;
    private backend.entidades.Hospital hospital2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private javax.swing.JMenuItem menuAcessoGerirUtilizadores;
    private javax.swing.JMenuItem menuAcessoLogin;
    private javax.swing.JMenu menuAdmin;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JMenuItem menuEditarUtilizador;
    private javax.swing.JMenu menuIniciar;
    private javax.swing.JMenuItem menuListarHospitais;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

    public void mostrarAvisoInicializacao() {
        String aviso ="Bem vindo/a!\n";
        aviso += "O seu login é admin / admin.\nPode alterar a password em Iniciar > Editar Perfil.\n";
        aviso += "Crie novos utilizadores em Administrador > Gerir Utilizadores.";
        mostrarAviso(aviso);
    }
    
    private void listarHospitais() {
        // chama a janela da listagem das enfermarias do hospital selecionado
        String titutlo = "Listagem Hospitais";
        JanelaListaHospital janelaConsulta;
        try {
            janelaConsulta = new JanelaListaHospital(app, serializacao, titutlo);
            janelaConsulta.setVisible(true);
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
    }

    private void listarUtilizadores() {
        JanelaConsultaUtilizador janelaConsulta = new JanelaConsultaUtilizador(app, serializacao);
        janelaConsulta.setVisible(true);
    }

    private void editarPerfil() {
        try {
            JanelaCriarUtilizador janela = new JanelaCriarUtilizador(this, app, serializacao, app.getUtilizadorAutenticado().getNome());
            janela.setVisible(true);
        } catch (Exception ex) {
            mostrarAviso(ex.getMessage());
        }
    }

    private void logout() {
        app.setUtilizadorAutenticado(null);
        fechar();
        
        Inicio.main(new String[0]);
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
    
    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Nada a atualizar!");
    }
    
    @Override
    public void guardar() {
        serializacao.guardar(app);
    }
    /*
     * FIM Métodos auxiliares genéricos
    */

}
