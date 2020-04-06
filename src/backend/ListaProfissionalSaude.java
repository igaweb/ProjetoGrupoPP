package backend;

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

    public void adicionar(ProfissionalSaude profissionalSaude) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    public void remove(ArrayList<ProfissionalSaude> profissionaisSaude) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    public void edit(ArrayList<ProfissionalSaude> profissionaisSaude) {
        // ver ListaEnfermaria ( procedimento igual)
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(ProfissionalSaude profissional) {

        boolean isValid = true;

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        // se for medico, tem de ter especialidade: profissional instanceOf Medico
        return isValid;
    }
}
