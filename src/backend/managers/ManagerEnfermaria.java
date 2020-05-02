package backend.managers;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import java.io.Serializable;
import java.util.ArrayList;

public class ManagerEnfermaria extends ManagerBase implements Serializable {

    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";

    public ManagerEnfermaria() {
    }

    public ManagerEnfermaria(ArrayList<Enfermaria> lista) {
        this.lista = lista;
    }

    public void adicionar(String codigo, int tipo, Boolean[] camas, ArrayList<Equipamento> equipamentos, ArrayList<Paciente> pacientes) throws Exception {
        Enfermaria enfermaria = new Enfermaria(codigo, tipo, camas, equipamentos, pacientes);
        
        adicionar(enfermaria);
    }
    public void adicionar(Enfermaria enfermaria) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_ADICIONAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(enfermaria);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            // gerar o codigo para a nova enfermaria
            String novoCodigo = gerarCodigo();
            enfermaria.setCodigo(novoCodigo);

            lista.add(enfermaria);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Enfermaria enfermaria) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_REMOVER);

        lista.remove(enfermaria);
    }

    public void editar(Enfermaria enfermaria) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(enfermaria);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            int index = lista.indexOf(enfermaria);

            if (index >= 0) {
                lista.set(index, enfermaria);
            }
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_EDITAR);
        }
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Enfermaria enfermaria) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(enfermaria);

        // se nao for a operacao adicionar, tem de existir um codigo
        if (!operacao.equals(OPERACAO_ADICIONAR) && enfermaria.getCodigo() == null) {
            throw new Exception(ERRO_FALTA_CODIGO);
        }

        // tem de ter um tipo definido (int nao permite nulls)
        // neste caso, o tipo indica o indice do array definido em Conteudos.getTiposEnfermaria(), por isso, terá de ser maior de 0 e menor que o comprimento do array
        if (enfermaria.getTipo() < 0 || enfermaria.getTipo() >= Conteudos.getTiposEnfermarias().length) {
            throw new Exception(ERRO_TIPO_INVALIDO);
        }

        return isValid;
    }

    @Override
    public String toString() {
        return "ListaEnfermaria{" + "lista=" + lista + '}';
    }
}
