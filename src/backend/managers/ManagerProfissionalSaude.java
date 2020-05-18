package backend.managers;

import backend.entidades.ProfissionalSaude;
import static backend.managers.ManagerBase.ERRO_ADICIONAR;
import static backend.managers.ManagerBase.ERRO_EDITAR;
import static backend.managers.ManagerBase.OPERACAO_ADICIONAR;
import static backend.managers.ManagerBase.OPERACAO_EDITAR;
import static backend.managers.ManagerBase.OPERACAO_REMOVER;
import java.io.Serializable;
import java.util.TreeMap;

public class ManagerProfissionalSaude extends ManagerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final String ERRO_FALTA_NOME = "ERRO_FALTA_NOME";

    public ManagerProfissionalSaude() {
    }

    public ManagerProfissionalSaude(TreeMap<String,ProfissionalSaude> lista) {
        this.listaTreeMap = lista;
    }

    public void adicionar(ProfissionalSaude profissionalSaude) throws Exception {
        setOperacao(OPERACAO_ADICIONAR);
        boolean isValido = validarCampos(profissionalSaude);
      
        if (isValido) {

            lista.add(profissionalSaude);
        } else {
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(ProfissionalSaude profissionalSaude) throws Exception {
        setOperacao(OPERACAO_REMOVER);

        lista.remove(profissionalSaude);
    }

    public void editar(ProfissionalSaude profissionalSaude) throws Exception {
        setOperacao(OPERACAO_EDITAR);

        boolean isValido = validarCampos(profissionalSaude);

        if (isValido) {
            int index = lista.indexOf(profissionalSaude);

            if (index >= 0) {
                lista.set(index, profissionalSaude);
            }
        } else {

            throw new Exception(ERRO_EDITAR);
        }
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(ProfissionalSaude profissionalSaude) throws Exception {
  //condicao se é enfermeiro ou medico(se e medico), tem que ter especialidade, se nao, nao faz nada        
// validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(profissionalSaude);
        if (!operacao.equals(OPERACAO_ADICIONAR) && profissionalSaude.getNome() == null) {
            throw new Exception(ERRO_FALTA_NOME);
        }
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
