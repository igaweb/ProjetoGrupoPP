package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Administrador;
import backend.entidades.Utilizador;
import frontend.janelas.JanelaLogin;
import java.util.Scanner;
import java.util.TreeMap;

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

        // //////////////////////////dummy object:
        TreeMap<String, Utilizador> users = new TreeMap();
        users.put("user", new Utilizador("user", "1234"));
        users.put("admin", new Administrador("admin", "admin"));
        aplicacao.getManagerUtilizador().setLista(users);

        // login
        JanelaLogin janelaLogin = new JanelaLogin(aplicacao, serializacao);
        janelaLogin.setVisible(true);
        // carregar menus
//        Menus menus = new Menus(aplicacao, serializacao, scanner);
//        menus.getMenuPaciente().start();

       Homepage gui = new Homepage(aplicacao, serializacao);
       gui.setVisible(true);
    }
}
