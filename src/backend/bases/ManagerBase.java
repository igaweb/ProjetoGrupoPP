package backend.bases;

import backend.interfaces.IManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.UUID;

public abstract class ManagerBase implements Serializable, IManager {

     /**
      * 
      */
    
    private static final long serialVersionUID = 1L;

    private static final String PREFIXO_CODIGO = "-";

    private static long counter = 0;

    public static final String OPERACAO_ADICIONAR = "A";
    public static final String OPERACAO_EDITAR = "E";
    public static final String OPERACAO_REMOVER = "R";

    protected static final String ERRO_GENERICO = "Erro genérico";
    protected static final String ERRO_OBJ_NULO = "Erro de sistema (objeto nulo)";
    protected static final String ERRO_FALTA_NOME = "O campo nome é obrigatório";
    protected static final String ERRO_FALTA_CODIGO = "Falta codigo";

    protected TreeMap<String, EntidadeBase> lista = new TreeMap();
    protected String operacao = null;

    public ManagerBase() {
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    
    @Override
    public boolean validarCampos(EntidadeBase entidade) throws ValidacaoEntidadeException {
        if (entidade == null) {
            throw new ValidacaoEntidadeException(ERRO_OBJ_NULO);
        }

        // se nao for a operacao adicionar, tem de existir um codigo
        if (!operacao.equals(OPERACAO_ADICIONAR) && (entidade.getCodigo() == null || entidade.getCodigo().trim().isEmpty())) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_CODIGO);
        }

        if (entidade.getNome() == null || (entidade.getNome() == null || entidade.getNome().trim().isEmpty())) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_NOME);
        }

        return true;
    }

    protected String gerarCodigo() {
        return PREFIXO_CODIGO + (UUID.randomUUID());
    }

    public TreeMap getLista() {
        if (lista == null) {
            lista = new TreeMap();
        }
        return lista;
    }

    public void setLista(TreeMap listaTreeMap) {
        this.lista = listaTreeMap;
    }

    public ArrayList getListaArray() {
        return new ArrayList<>(lista.values());
    }

    @Override
    public void adicionar(EntidadeBase entidade) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_ADICIONAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(entidade);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            // gerar o codigo para a nova enfermaria
            String novoCodigo = gerarCodigo();
            entidade.setCodigo(novoCodigo);

            lista.put(novoCodigo, entidade);
        } else {
            // senão, retorna erro
            throw new AdicionarEntidadeException();
        }
    }

    @Override
    public void editar(EntidadeBase entidade) throws EditarEntidadeException, ValidacaoEntidadeException, Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);
        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(entidade);

        // se estiver bem preenchido,
        // avança para a edição
        if (isValido) {

            lista.put(entidade.getCodigo(), entidade);
        } else {
            // senão, retorna erro
            throw new EditarEntidadeException();
        }
    }

    @Override
    public void remover(EntidadeBase entidade) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_REMOVER);

        try {
            boolean isValido = validarCampos(entidade);
            if (isValido) {
                lista.remove(entidade.getCodigo());
            } else {
                // senão, retorna erro
                throw new RemoverEntidadeException();
            }
        } catch (Exception e) {
            throw new RemoverEntidadeException();
        }
    }

    public static class ValidacaoEntidadeException extends Exception {

        public ValidacaoEntidadeException(String msg) {
            super("Erro de validação: " + msg);
        }
    }

    public static class AdicionarEntidadeException extends Exception {

        public AdicionarEntidadeException() {
            super("Ocorreu um erro ao adicionar");
        }
    }

    public static class EditarEntidadeException extends Exception {

        public EditarEntidadeException() {
            super("Ocorreu um erro ao editar");
        }
    }

    public static class RemoverEntidadeException extends Exception {

        public RemoverEntidadeException() {
            super("Ocorreu um erro ao remover");
        }
    }

}
