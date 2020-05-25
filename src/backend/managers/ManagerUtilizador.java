package backend.managers;

import backend.entidades.Utilizador;
import java.io.Serializable;
import java.util.TreeMap;

public class ManagerUtilizador extends ManagerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "UT-";

    private static final String ERRO_FALTA_NOME = "ERRO_FALTA_NOME";
    private static final String ERRO_FALTA_PASSWORD = "ERRO_FALTA_PASSWORD";

    public ManagerUtilizador() {
    }

    public ManagerUtilizador(TreeMap<String, Utilizador> lista) {
        this.lista = lista;
    }

    public void adicionar(Utilizador utilizador) throws Exception {
        setOperacao(OPERACAO_ADICIONAR);
        boolean isValido = validarCampos(utilizador);

        if (isValido) {

            lista.put(utilizador.getNome(), utilizador);
        } else {
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Utilizador utilizador) throws Exception {
        setOperacao(OPERACAO_REMOVER);

        lista.remove(utilizador);
    }

    public void editar(Utilizador utilizador) throws Exception {
        setOperacao(OPERACAO_EDITAR);

        boolean isValido = validarCampos(utilizador);

        if (isValido) {
            lista.put(utilizador.getNome(), utilizador);
        } else {

            throw new Exception(ERRO_EDITAR);
        }
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

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
