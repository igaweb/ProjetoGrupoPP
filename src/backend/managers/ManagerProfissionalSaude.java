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
        this.lista = lista;
    }

    public void adicionar(ProfissionalSaude profissionalSaude) throws Exception {
        setOperacao(OPERACAO_ADICIONAR);
        boolean isValido = validarCampos(profissionalSaude);
      
        if (isValido) {
            // gerar o codigo para a nova enfermaria
            String novoCodigo = gerarCodigo();
            profissionalSaude.setCodigo(novoCodigo);

            lista.put(profissionalSaude.getCodigo(), profissionalSaude);
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
            lista.put(profissionalSaude.getCodigo(), profissionalSaude);
        } else {

            throw new Exception(ERRO_EDITAR);
        }
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(ProfissionalSaude profissionalSaude) throws Exception {
        boolean isValid = super.validarCampos(profissionalSaude);
        if (!operacao.equals(OPERACAO_ADICIONAR) && profissionalSaude.getNome() == null) {
            throw new Exception(ERRO_FALTA_NOME);
        }

        return isValid;
    }

    @Override
    public String toString() {
        return "ListaUtilizador{" + "lista=" + lista + '}';
    }

}
