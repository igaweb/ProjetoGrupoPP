package backend.listas;

import backend.entidades.Utilizador;
import java.io.Serializable;
import java.util.ArrayList;

public class ManagerUtilizador extends ManagerBase implements Serializable {

    public ManagerUtilizador() {
    }
    
    public ManagerUtilizador(ArrayList<Utilizador> lista) {
        this.lista = lista;
    }

}
