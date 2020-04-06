
package ClassesJorge;

import java.util.ArrayList;

public class ListaProfissionalSaude {
  
        private final ArrayList<ProfissionalSaude> lista;

    public ListaProfissionalSaude(ArrayList<ProfissionalSaude> lista) {
         this.lista = lista;
    }

    public ArrayList<ProfissionalSaude> getLista() {
        return lista;
    }

    public ArrayList<ProfissionalSaude> setLista() {
        return lista;
    }

    public void add(ArrayList<ProfissionalSaude> profissionaisSaude) {
        this.lista.addAll(profissionaisSaude);
    }

    public void remove(ArrayList<ProfissionalSaude> profissionaisSaude) {
        this.lista.removeAll(profissionaisSaude);
    }

    public void edit(ArrayList<ProfissionalSaude> profissionaisSaude) {
        this.lista.addAll(profissionaisSaude);
    }
}

