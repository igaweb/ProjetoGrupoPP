package frontend;

import backend.Login;
import backend.Aplicacao;
import backend.Serializacao;
import backend.entidades.Utilizador;
import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Carregar dados...");
        String ficheiro = "dados";
        Serializacao serializacao = new Serializacao(ficheiro);

        Aplicacao aplicacao = serializacao.carregar();
        Scanner scanner = new Scanner(System.in);
        
        // //////////////////////////dummy object:
        ArrayList<Utilizador> users = new ArrayList();
        users.add(new Utilizador("user", "1234"));
        aplicacao.getManagerUtilizador().setLista(users);
        
        boolean userAutenticado = false;
        do {
            // login
            Login login = new Login(scanner, aplicacao);

            userAutenticado = login.getUtilizador().isAutenticado();
        } while (!userAutenticado);
        
        // carregar menus
        Menus menus = new Menus(aplicacao, serializacao, scanner);
        menus.getMenuEquipamento().start();
    }
    
}
