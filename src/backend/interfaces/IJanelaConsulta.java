package backend.interfaces;

import backend.bases.EntidadeBase;
import backend.enums.EntidadeEnum;

public interface IJanelaConsulta {
    
    public IManager getManager();
    public void adicionar();
    public void editar();
    public void detalhe();

}
