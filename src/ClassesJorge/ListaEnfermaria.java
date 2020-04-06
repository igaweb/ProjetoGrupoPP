package ClassesJorge;

import java.util.ArrayList;

public class ListaEnfermaria {

    private final ArrayList<Enfermaria> lista;

    public ListaEnfermaria(ArrayList<Enfermaria> lista) {
        this.lista = lista;
    }

    public ArrayList<Enfermaria> getLista() {
        return lista;
    }

    public ArrayList<Enfermaria> setLista() {
        return lista;
    }
    
    public void add(ArrayList<Enfermaria> enfermarias) {
        this.lista.addAll(enfermarias);
    }

    public void remove(ArrayList<Enfermaria> enfermarias) {
        this.lista.removeAll(enfermarias);
    }

    public void edit(ArrayList<Enfermaria> enfermarias) {
        this.lista.addAll(enfermarias);
    }
}
