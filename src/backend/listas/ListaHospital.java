package backend.listas;

import backend.entidades.Hospital;
import java.util.ArrayList;

public class ListaHospital extends ListaBase {

    public ListaHospital() {
    }
       
    public ListaHospital(ArrayList<Hospital> lista) {
        this.lista = lista;
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
    private boolean validarCampos(Hospital hospital) {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(hospital);

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaHospital{" + "lista=" + lista + '}';
    }
    
    
}
