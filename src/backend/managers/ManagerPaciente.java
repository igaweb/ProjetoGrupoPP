package backend.managers;

import backend.Conteudos;
import backend.entidades.Paciente;
import java.util.ArrayList;

public class ManagerPaciente extends ManagerBase {
  
    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";
    private static final String ERRO_FALTA_NOME = "ERRO_FALTA_NOME";
    private static final String ERRO_FALTA_LOCALIDADE = "ERRO_FALTA_LOCALIDADE";
    private static final String ERRO_FALTA_CAMA = "ERRO_FALTA_CAMA";
    private static final String ERRO_FALTA_ESTADO = "ERRO_FALTA_ESTADO";
    private static final String ERRO_FALTA_DATAENTRADA = "ERRO_FALTA_DATAENTRADA";
    private static final String ERRO_FALTA_DATASAIDA = "ERRO_FALTA_DATASAIDA";

    public ManagerPaciente() {
    }

    public ManagerPaciente(ArrayList <Paciente>lista) {
        this.lista = lista;
    }

    public void adicionar(Paciente paciente) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_ADICIONAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(paciente);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            // gerar o codigo para a novo paciente
            String novoCodigo = gerarCodigo();
            paciente.setCodigo(novoCodigo);
            
            lista.add(paciente);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Paciente paciente) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_REMOVER);

        lista.remove(paciente);
    }

    public void editar(Paciente paciente) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(paciente);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            int index = lista.indexOf(paciente);

            if (index >= 0) {
                lista.set(index, paciente);
            }
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_EDITAR);
        }
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Paciente paciente) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(paciente);

        // se nao for a operacao adicionar, tem de existir um codigo
        if (paciente.getCodigo() == null || paciente.getCodigo().isEmpty()) {
            throw new Exception(ERRO_FALTA_CODIGO);
        }
        if (paciente.getNome() == null || paciente.getNome().isEmpty()) {
            throw new Exception(ERRO_FALTA_NOME);
        }
        if (paciente.getLocalidade() == null || paciente.getLocalidade().isEmpty()) {
            throw new Exception(ERRO_FALTA_LOCALIDADE);
        }
        if (paciente.getCama() < 0 ) {
            throw new Exception(ERRO_FALTA_CAMA);
        }
          if (paciente.getEstado() < 0 || paciente.getEstado() >= Conteudos.getEstadosPaciente().length) {
            throw new Exception(ERRO_FALTA_ESTADO);
        }
        if (paciente.getDataEntrada() < 0 ) {
            throw new Exception(ERRO_FALTA_DATAENTRADA);
        }
        if (paciente.getDataSaida() < 0) {
            throw new Exception(ERRO_FALTA_DATASAIDA);
        }

        // tem de ter um tipo definido (int nao permite nulls)
        // neste caso, o tipo indica o indice do array definido em Conteudos.getTiposPaciente(), por isso, terá de ser maior de 0 e menor que o comprimento do array
            
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaPaciente{" + "lista=" + lista + '}';
    } 
}