package backend;

import backend.entidades.Utilizador;
import java.util.Map;
import java.util.TreeMap;

public class Login {
    
    private Aplicacao aplicacao;
    
    public Login(Aplicacao aplicacao, String user, String password) {
        this.aplicacao = aplicacao;
    }

    public Utilizador validarLogin(String user, String password) throws Exception {
        
        if(user == null || user.trim().isEmpty()) {
            throw new UtilizadorVazioException();
        }
        
        if(password == null || password.trim().isEmpty()) {
            throw new PasswordVaziaException();
        }
        
        TreeMap<String, Utilizador> lista = aplicacao.getManagerUtilizador().getLista();
        
        Utilizador utilizador = lista.get(user);
        
        if(utilizador == null) {
            throw new UtilizadorNaoExisteException();
        }
        
        if(!utilizador.getPassword().equals(password)) {
            throw new LoginErradoException();
        }
        
        return utilizador;
    }

    private static class UtilizadorVazioException extends Exception {
        public UtilizadorVazioException() {
            super("Utilizador vazio");
        }
    }

    private static class PasswordVaziaException extends Exception {

        public PasswordVaziaException() {
            super("Password vazia");
        }
    }

    private static class LoginErradoException extends Exception {

        public LoginErradoException() {
            super("Login inválido");
        }
    }

    private static class UtilizadorNaoExisteException extends Exception {

        public UtilizadorNaoExisteException() {
            super("User não existe");
        }
    }
}
