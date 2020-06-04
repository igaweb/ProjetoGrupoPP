package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.bases.EntidadeBase;
import java.util.TreeMap;

public class ManagerProfissionalSaude extends ManagerBase implements IManager {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "PR-";

    public ManagerProfissionalSaude() {
    }

    public ManagerProfissionalSaude(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    @Override
    public boolean validarCampos(EntidadeBase profissionalSaude) throws ValidacaoEntidadeException {
        boolean isValid = super.validarCampos(profissionalSaude);

        return isValid;
    }

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
