package backend.managers;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import java.io.Serializable;
import java.util.TreeMap;

public class ManagerEnfermaria extends ManagerBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";

    public ManagerEnfermaria(TreeMap<String, Enfermaria> listaTreeMap) {
        this.lista = listaTreeMap;
    }

    public void adicionar(int tipo, Boolean[] camas) throws Exception {
        Enfermaria enfermaria = new Enfermaria(null, tipo, camas, new TreeMap<String, Equipamento>(), new TreeMap<String, Paciente>());
        
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

            
            lista.put(novoCodigo, enfermaria);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Enfermaria enfermaria) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_REMOVER);

        lista.remove(enfermaria.getCodigo());
    }

    public void editar(String codigo, int tipo, Boolean[] camas) throws Exception {
        
        Enfermaria enfermaria = (Enfermaria) lista.get(codigo);
        enfermaria.setTipo(tipo);
        enfermaria.setCamas(camas);
        
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(enfermaria);

        // se estiver bem preenchido,
        // avança para a edição
        if (isValido) {
            lista.put(enfermaria.getCodigo(), enfermaria);
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
