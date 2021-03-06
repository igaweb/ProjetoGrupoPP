package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import backend.Conteudos;
import backend.bases.EntidadeBase;
import java.util.TreeMap;

public class ManagerEquipamento extends ManagerBase implements IManager {

    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "EQ-";
    
    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    
    public ManagerEquipamento(TreeMap<String, EntidadeBase> lista) {
        this.lista = lista;
    }
     
    public void adicionar(String nome, int tipo)throws Exception {
        
        Equipamento equipamento = new Equipamento(null, nome, tipo, null);
        
        adicionar(equipamento);
    }
    
    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    @Override
    public boolean validarCampos(EntidadeBase equipamento) throws ValidacaoEntidadeException {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(equipamento);
        
         // Se a opção que o utilizador escolher for menor que 0 || "OU" || se o número que o utilizador escolher for maior que as que existem
         if (((Equipamento) equipamento).getTipo() < 0 || ((Equipamento) equipamento).getTipo() >= Conteudos.getTiposEquipamentos().length) {
            throw new ValidacaoEntidadeException(ERRO_TIPO_INVALIDO); 
         }

        return isValid;
   
    }  

    @Override
    public String toString() {
        return "ListaEquipamentos{" + "lista=" + lista + '}';
    }
}