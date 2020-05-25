package backend.managers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.UUID;

public abstract class ManagerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "-";

    private static long counter = 0;
    
    public static final String OPERACAO_ADICIONAR = "A";
    public static final String OPERACAO_EDITAR = "E";
    public static final String OPERACAO_REMOVER = "R";

    protected static final String ERRO_GENERICO = "ERRO_GENERICO";
    protected static final String ERRO_OBJ_NULO = "ERRO_OBJ_NULO";
    protected static final String ERRO_REMOVER = "ERRO_REMOVER";
    protected static final String ERRO_EDITAR = "ERRO_EDITAR";
    protected static final String ERRO_ADICIONAR = "ERRO_ADICIONAR";

    protected TreeMap lista = new TreeMap();
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
    protected boolean validarCampos(Object object) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(ERRO_OBJ_NULO);
        }

        return true;
    }

    protected String gerarCodigo() {
        return PREFIXO_CODIGO + (UUID.randomUUID());
    }
    
    public TreeMap getLista() {
        if(lista == null){
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
}
