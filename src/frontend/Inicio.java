package frontend;

import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Utilizador;
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

        Aplicacao aplicacao = serializacao.carregar();

        // //////////////////////////dummy object:
        TreeMap<String, Utilizador> users = new TreeMap();
        users.put("user", new Utilizador("user", "1234"));
        aplicacao.getManagerUtilizador().setLista(users);

        boolean userAutenticado = false;

//        // login
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Insira o user:");
//        String user = scanner.nextLine();
//
//        System.out.println("Insira a password:");
//        String password = scanner.nextLine();
//
//        Login login = new Login(aplicacao, user, password);
//
//        userAutenticado = login.getUtilizador().isAutenticado();
//
        // carregar menus
//        Menus menus = new Menus(aplicacao, serializacao, scanner);
//        menus.getMenuHospital().start();

        Homepage gui = new Homepage(aplicacao, serializacao);
        gui.setVisible(true);
    }
}
