package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Administrador;
import backend.entidades.Utilizador;
import frontend.janelas.JanelaLogin;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JOptionPane;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Carregar dados...");
        String ficheiro = "dados";
        Serializacao serializacao = new Serializacao(ficheiro);
        //       Scanner scanner = new Scanner(System.in);
        Aplicacao aplicacao = serializacao.carregar();

        Homepage gui;
        if(aplicacao.getManagerUtilizador().getLista() == null || aplicacao.getManagerUtilizador().getLista().size() == 0) {
            
            TreeMap<String, Utilizador> users = new TreeMap();
            users.put("admin", new Administrador("admin", "admin"));
            aplicacao.getManagerUtilizador().setLista(users);
            serializacao.guardar(aplicacao);
            
            aplicacao.setUtilizadorAutenticado(new Administrador("admin", "admin"));
            
            gui = new Homepage(aplicacao, serializacao);
            gui.mostrarAvisoInicializacao();
        } else {
            // login
            JanelaLogin janelaLogin = new JanelaLogin(aplicacao, serializacao);
            janelaLogin.setVisible(true);
            gui = new Homepage(aplicacao, serializacao);
        }

        gui.setVisible(true);
    }
}
