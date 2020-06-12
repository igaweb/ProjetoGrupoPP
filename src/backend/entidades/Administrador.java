package backend.entidades;

public class Administrador extends Utilizador {

     /**
      * perfil de utilizador de administracao
      * @param nome
      * @param password 
      */
    
    public Administrador(String nome, String password) {
        super(nome, password);
    }

    @Override
    public String toString() {
        return "Administrador{" + "nome=" + nome + ", password=" + password + '}';
    }
    
}
