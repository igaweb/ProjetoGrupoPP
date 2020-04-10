package backend.listas;

import backend.entidades.ProfissionalSaude;
import java.util.ArrayList;

public class ManagerProfissionalSaude extends ManagerBase {

    public ManagerProfissionalSaude(ArrayList<ProfissionalSaude> lista) {
        this.lista = lista;
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
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(profissional);

        // validações....... (campos obrigatorios, tipos de dados, etc...)
        // se for medico, tem de ter especialidade: profissional instanceOf Medico
        return isValid;
    }
}
