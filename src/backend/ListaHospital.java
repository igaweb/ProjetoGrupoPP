package backend;

import java.util.ArrayList;

public class ListaHospital {

    private ArrayList<Hospital> lista;

    public ListaHospital(ArrayList<Hospital> lista) {
        this.lista = lista;
    }

    public ArrayList<Hospital> getLista() {
        return lista;
    }

    public ArrayList<Hospital> setLista() {
        return lista;
    }

    public void adicionar(Hospital hospital) {
        // validar se os campos vêm todos bem preenchidos
        // validarCampos(enfermaria) <- se estiver bem preenchido,
        // avança para a adição -> this.lista.add(enfermaria);
        // senão, retorna erro -> new EnfermariaException("Erro a adicionar enfermaria");
    }

    public void remover(ArrayList<Hospital> enfermarias) {
        this.lista.remove(enfermarias);
    }

    public void editar(Hospital hospital) {
        // procurar a enfermaria na lista pelo codigo
        // validar se os campos estao bem preenchidos:
        // validarCampos(enfermaria) <- se estiver bem preenchido,
        // avança para a edição -> substitui a enfermaria na lista pela nova
        // senão, retorna erro -> new EnfermariaException("Erro a editar enfermaria");
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Enfermaria enfermaria) {

        boolean isValid = true;

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }
}
