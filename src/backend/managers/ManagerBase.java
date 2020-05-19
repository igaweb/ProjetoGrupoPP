package backend.managers;

import java.io.Serializable;
import java.util.TreeMap;

public abstract class ManagerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String OPERACAO_ADICIONAR = "A";
    public static final String OPERACAO_EDITAR = "E";
    public static final String OPERACAO_REMOVER = "R";

    protected static final String ERRO_GENERICO = "ERRO_GENERICO";
    protected static final String ERRO_OBJ_NULO = "ERRO_OBJ_NULO";
    protected static final String ERRO_REMOVER = "ERRO_REMOVER";
    protected static final String ERRO_EDITAR = "ERRO_EDITAR";
    protected static final String ERRO_ADICIONAR = "ERRO_ADICIONAR";

    protected TreeMap listaTreeMap = new TreeMap();
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
        return "COD" + listaTreeMap.size();
    }
    
    protected String gerarCodigoTreeMap() {
        return "COD" + listaTreeMap.size();
    }

    public TreeMap getListaTreeMap() {
        return listaTreeMap;
    }

    public void setListaTreeMap(TreeMap listaTreeMap) {
        this.listaTreeMap = listaTreeMap;
    }

}
