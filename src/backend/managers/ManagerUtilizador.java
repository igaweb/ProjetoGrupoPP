package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.bases.EntidadeBase;
import backend.entidades.Utilizador;
import backend.Aplicacao;
import java.util.TreeMap;

public class ManagerUtilizador extends ManagerBase implements IManager {

    private static final long serialVersionUID = 1L;

    private static final String PREFIXO_CODIGO = "UT-";

    private static final String ERRO_FALTA_PASSWORD = "ERRO_FALTA_PASSWORD";

    private static final String ERRO_REMOVER_UTILIZADOR = "Operação inválida, utilizador não pode ser eliminado";

    private static final String ERRO_EDITAR_UTILIZADOR = "ERRO_EDITAR_UTILIZADOR";
    
    private static Aplicacao app;

    public ManagerUtilizador() {
    }

    public ManagerUtilizador(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }

    /**
     * Adiciona utilizador com codigo com o nome do utilizador
     *
     * @param utilizador
     * @throws Exception
     */
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
            throw new AdicionarEntidadeException();
        }
    }

    /**
     * Adicionar nova entidade à lista
     *
     * @param nome
     * @param password
     * @throws Exception
     */
    public void adicionar(String nome, String password) throws Exception {
        Utilizador utilizador = new Utilizador(nome, password);

        adicionar(utilizador);
    }

    /**
     * Método para validar se os campos da classe estão bem preenchidos
     *
     * @param utilizador
     * @return
     * @throws backend.bases.ManagerBase.ValidacaoEntidadeException
     */
    @Override
    public boolean validarCampos(EntidadeBase entidade) throws ValidacaoEntidadeException {
        Utilizador utilizador = (Utilizador) entidade;
        
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(utilizador);
        if (!operacao.equals(OPERACAO_ADICIONAR) && utilizador.getPassword() == null || utilizador.getPassword().isEmpty()) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_PASSWORD);
        }
        if (operacao.equals(OPERACAO_REMOVER) && utilizador.equals(app.getUtilizadorAutenticado())) {
            throw new ValidacaoEntidadeException(ERRO_REMOVER_UTILIZADOR);
        }

        return isValid;
    }
    
    

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
