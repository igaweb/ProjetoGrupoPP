package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.bases.EntidadeBase;
import backend.entidades.Medico;
import java.util.Map;
import java.util.TreeMap;

public class ManagerProfissionalSaude extends ManagerBase implements IManager {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "PR-";

    public ManagerProfissionalSaude() {
    }

    public ManagerProfissionalSaude(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }

    /**
     * Retorna todos os medicos de uma enfermaria
     * @return 
     */
    public TreeMap<String, Medico> getMedicos() {
        TreeMap<String, Medico> medicos = new TreeMap<>();
                
        for (Map.Entry<String, EntidadeBase> entry : lista.entrySet()) {
            String key = entry.getKey();
            EntidadeBase value = entry.getValue();
            
            if(value instanceof Medico) {
                medicos.put(key, (Medico)value);
            }
        }
        return medicos;
    }
    
    /**
     * Método para validar se os campos da classe estão bem preenchidos
     * @param profissionalSaude
     * @return
     * @throws backend.bases.ManagerBase.ValidacaoEntidadeException 
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
