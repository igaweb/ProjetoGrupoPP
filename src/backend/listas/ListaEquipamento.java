package backend.listas;

import backend.entidades.Equipamento;
import java.util.ArrayList;

public class ListaEquipamento extends ListaBase {

    public ListaEquipamento(ArrayList<Equipamento> lista) {
        this.lista = lista;
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
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(equipamento);

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }
}
