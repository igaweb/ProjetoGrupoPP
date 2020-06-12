package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.bases.EntidadeBase;
import java.util.TreeMap;

public class ManagerEnfermaria extends ManagerBase implements IManager {
 
  /**
  * 
  */
    
    private static final String PREFIXO_CODIGO = "EN-";

    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    
    public ManagerEnfermaria(TreeMap<String, EntidadeBase> listaTreeMap) {
        this.lista = listaTreeMap;
    }

    public void adicionar(String nome, int tipo, Boolean[] camas) throws Exception {
        Enfermaria enfermaria = new Enfermaria(null, nome, tipo, camas, new TreeMap<String, EntidadeBase>(), new TreeMap<String, EntidadeBase>(), new TreeMap<String, EntidadeBase>());
        
        adicionar(enfermaria);
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    public boolean validarCampos(EntidadeBase enfermaria) throws ValidacaoEntidadeException {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(enfermaria);

        // tem de ter um tipo definido (int nao permite nulls)
        // neste caso, o tipo indica o indice do array definido em Conteudos.getTiposEnfermaria(), por isso, terá de ser maior de 0 e menor que o comprimento do array
        if (((Enfermaria) enfermaria).getTipo() < 0 || ((Enfermaria) enfermaria).getTipo() >= Conteudos.getTiposEnfermarias().length) {
            throw new ValidacaoEntidadeException(ERRO_TIPO_INVALIDO);
        }

        return isValid;
    }
}
