package backend;

import java.util.ArrayList;

public class ListaEquipamento {

    private ArrayList<Equipamento> lista;

    public ListaEquipamento(ArrayList<Equipamento> lista) {
        this.lista = lista;
    }

    public ArrayList<Equipamento> getLista() {
        return lista;
    }

    public ArrayList<Equipamento> setLista() {
        return lista;
    }

    public void adicionar(Equipamento equipamentos) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    public void remover(ArrayList<Equipamento> equipamentos) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    public void editar(ArrayList<Equipamento> equipamentos) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Equipamento equipamento) {

        boolean isValid = true;

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }
}
