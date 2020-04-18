package backend.listas;

import backend.entidades.Utilizador;
import java.io.Serializable;
import java.util.ArrayList;

public class ManagerUtilizador extends ManagerBase implements Serializable {
    
    private static final String ERRO_FALTA_NOME = "ERRO_FALTA_NOME";
    private static final String ERRO_FALTA_PASSWORD = "ERRO_FALTA_PASSWORD";

    public ManagerUtilizador() {
    }   
    
    public ManagerUtilizador(ArrayList<Utilizador> lista) {
        this.lista = lista;
    }
    
        /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Utilizador utilizador) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(utilizador);
        if (!operacao.equals(OPERACAO_ADICIONAR) && utilizador.getNome() == null) {
            throw new Exception(ERRO_FALTA_NOME);
        }
        if (!operacao.equals(OPERACAO_ADICIONAR) && utilizador.getPassword() == null) {
            throw new Exception(ERRO_FALTA_PASSWORD);
        }
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

}
