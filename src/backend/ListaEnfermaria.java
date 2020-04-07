package backend;

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

    public void adicionar(Enfermaria enfermaria) {
        // validar se os campos vêm todos bem preenchidos
        // validarCampos(enfermaria) <- se estiver bem preenchido,
        // avança para a adição -> this.lista.add(enfermaria);
        // senão, retorna erro -> new EnfermariaException("Erro a adicionar enfermaria");
    }

    public void remover(ArrayList<Enfermaria> enfermarias) {
        this.lista.removeAll(enfermarias);
    }

    public void editar(Enfermaria enfermaria) {
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
