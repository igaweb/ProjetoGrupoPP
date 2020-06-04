package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.bases.EntidadeBase;
import backend.entidades.Utilizador;
import java.util.TreeMap;

public class ManagerUtilizador extends ManagerBase implements IManager {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "UT-";

    private static final String ERRO_FALTA_PASSWORD = "ERRO_FALTA_PASSWORD";

    public ManagerUtilizador() {
    }

    public ManagerUtilizador(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }

    @Override
    public void adicionar(EntidadeBase utilizador) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_ADICIONAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(utilizador);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            lista.put(utilizador.getNome(), utilizador);
        } else {
            throw new Exception(ERRO_ADICIONAR);
        }
    }
    
    public void adicionar(String nome, String password) throws Exception {
        Utilizador utilizador = new Utilizador(nome, password);

        adicionar(utilizador);
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Utilizador utilizador) throws ValidacaoEntidadeException {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(utilizador);
        if (!operacao.equals(OPERACAO_ADICIONAR) && utilizador.getPassword() == null) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_PASSWORD);
        }
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
