package backend.interfaces;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;
import backend.bases.ManagerBase;

public interface IManager {
    
     /**
      * interface para os managers das entidades
      * @param entidade
      * @throws Exception 
      */
    
    public void adicionar(EntidadeBase entidade)throws Exception;
    public void editar(EntidadeBase entidade)throws Exception;
    public void remover(EntidadeBase entidade)throws Exception;
    
    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    public boolean validarCampos(EntidadeBase entidade) throws ManagerBase.ValidacaoEntidadeException;
}
