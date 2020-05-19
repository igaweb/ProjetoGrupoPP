package backend;

import backend.entidades.Utilizador;
import java.util.Map;
import java.util.TreeMap;

public class Login {
    
    private Aplicacao aplicacao;
    private Utilizador utilizador;
    
    public Login(Aplicacao aplicacao, String user, String password) {
        this.aplicacao = aplicacao;
        this.utilizador = new Utilizador();
        
        try {
            validarLogin(user, password);
            
            // se nao foi lançada nenhuma exceçao, entao autentica o user
            if(utilizador != null) {
                utilizador.setAutenticado(true);
            }
        } catch (Exception ex) {
            System.out.println("Login sem sucesso: " + ex.getMessage());
        }
    }

    private Utilizador validarLogin(String user, String password) throws Exception {
        
        if(user == null || user.trim().isEmpty()) {
            throw new UtilizadorVazioException();
        }
        
        if(password == null || password.trim().isEmpty()) {
            throw new PasswordVaziaException();
        }
        
        TreeMap<String, Utilizador> lista = aplicacao.getManagerUtilizador().getLista();
        boolean loginExists = false;
        boolean userExists = false;
        Utilizador utilizadorValidado = null;
        for (Map.Entry<String, Utilizador> entry : lista.entrySet()) {
            Utilizador utilizador = (Utilizador) entry.getValue();

            // verifica se o user é o que procuramos
            if(utilizador.getNome().toUpperCase().equals(user.trim().toUpperCase())) {
                userExists = true;
                if(utilizador.getPassword().equals(password)) {
                    loginExists = true;
                    utilizadorValidado = utilizador;
                    break;
                }
            }
        }
        
        if(!userExists) {
            throw new UtilizadorNaoExisteException();
        }
        
        if(!loginExists) {
            throw new LoginErradoException();
        }
        
        return utilizadorValidado;
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
    
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
