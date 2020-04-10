package backend.listas;

import backend.Conteudos;
import backend.entidades.Paciente;
import java.util.ArrayList;

public class ListaPaciente extends ListaBase {
  
    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";

    public ListaPaciente() {
    }

    public ListaPaciente(ArrayList <Paciente>lista) {
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
        if (!operacao.equals(OPERACAO_ADICIONAR) && paciente.getCodigo() == null) {
            throw new Exception(ERRO_FALTA_CODIGO);
        }

        // tem de ter um tipo definido (int nao permite nulls)
        // neste caso, o tipo indica o indice do array definido em Conteudos.getTiposPaciente(), por isso, terá de ser maior de 0 e menor que o comprimento do array
        /*if (paciente.getEstado() < 0 paciente.getEstado()) {
            throw new Exception(ERRO_TIPO_INVALIDO);
        }
*/
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaPaciente{" + "lista=" + lista + '}';
    } 
}
