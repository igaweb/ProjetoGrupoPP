package backend.managers;

import backend.bases.ManagerBase;
import backend.interfaces.IManager;
import backend.Conteudos;
import backend.bases.EntidadeBase;
import backend.entidades.Paciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class ManagerPaciente extends ManagerBase implements IManager {
  
    private static final long serialVersionUID = 1L;
    
    private static final String PREFIXO_CODIGO = "PA-";

    private static final String ERRO_FALTA_LOCALIDADE = "ERRO_FALTA_LOCALIDADE";
    private static final String ERRO_FALTA_CAMA = "ERRO_FALTA_CAMA";
    private static final String ERRO_FALTA_ESTADO = "ERRO_FALTA_ESTADO";
    private static final String ERRO_FALTA_DATAENTRADA = "ERRO_FALTA_DATAENTRADA";
    private static final String ERRO_FALTA_DATASAIDA = "ERRO_FALTA_DATASAIDA";

    public ManagerPaciente() {
    }

    public ManagerPaciente(TreeMap<String,EntidadeBase>lista) {
        this.lista = lista;
    }

    public void adicionar(String nome, String localidade, int cama, Integer estado, Date dataEntrada) throws Exception {
        Paciente paciente = new Paciente(null, nome, localidade, cama, estado, dataEntrada, null);
        
        adicionar(paciente);
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    @Override
    public boolean validarCampos(EntidadeBase paciente) throws ValidacaoEntidadeException {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(paciente);

        if (((Paciente)paciente).getLocalidade() == null || ((Paciente)paciente).getLocalidade().isEmpty()) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_LOCALIDADE);
        }
        if (((Paciente)paciente).getCama() < 0 ) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_CAMA);
        }
          if (((Paciente)paciente).getEstado() < 0 || ((Paciente)paciente).getEstado() >= Conteudos.getEstadosPaciente().length) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_ESTADO);
        }
        if (((Paciente)paciente).getDataEntrada() == null ) {
            throw new ValidacaoEntidadeException(ERRO_FALTA_DATAENTRADA);
        }

        return isValid;
    }
   

    @Override
    public String toString() {
        return "ListaPaciente{" + "lista=" + lista + '}';
    } 
}
