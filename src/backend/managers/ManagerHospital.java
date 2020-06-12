package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.bases.EntidadeBase;
import backend.entidades.Hospital;
import java.util.TreeMap;

public class ManagerHospital extends ManagerBase implements IManager {
    
     /**
      * 
      */
    
    private static final String PREFIXO_CODIGO = "HO-";

    private static final String ERRO_FALTA_LOCALIDADE = "ERRO_FALTA_LOCALIDADE";

    public ManagerHospital() {
    }

    public ManagerHospital(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }

    public void adicionar(String nome, String localidade) throws Exception {
        Hospital hospital = new Hospital(null, nome, localidade, new TreeMap<String, EntidadeBase>());

        adicionar(hospital);
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    @Override
    public boolean validarCampos(EntidadeBase hospital) throws ValidacaoEntidadeException {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(hospital);
        // se nao for a operacao adicionar, tem de existir um codigo
        if (!operacao.equals(OPERACAO_ADICIONAR) && (hospital.getCodigo() == null || hospital.getCodigo().isEmpty())) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_CODIGO);
        }
        if (hospital.getNome() == null || hospital.getNome().isEmpty()) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_NOME);
        }
        if (((Hospital) hospital).getLocalidade() == null || ((Hospital) hospital).getLocalidade().isEmpty()) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_LOCALIDADE);
        }
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaHospital{" + "lista=" + lista + '}';
    }

}
