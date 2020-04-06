package ClassesJorge;

import java.util.ArrayList;

public class ListaEquipamento {

    private final ArrayList<Equipamento> lista;

    public ListaEquipamento(ArrayList<Equipamento> lista) {
        this.lista = lista;
    }

    public ArrayList<Equipamento> getLista() {
        return lista;
    }

    public ArrayList<Equipamento> setLista() {
        return lista;
    }

    public void add(ArrayList<Equipamento> equipamentos) {
        this.lista.addAll(equipamentos);
    }

    public void remove(ArrayList<Equipamento> equipamentos) {
        this.lista.removeAll(equipamentos);
    }

    public void edit(ArrayList<Equipamento> equipamentos) {
        this.lista.addAll(equipamentos);
    }

}
