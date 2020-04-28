package backend.managers;

import backend.entidades.Hospital;
import java.util.ArrayList;

public class ManagerHospital extends ManagerBase {

    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";
    private static final String ERRO_FALTA_NOME = "ERRO_FALTA_NOME";
    private static final String ERRO_FALTA_LOCALIDADE = "ERRO_FALTA_LOCALIDADE";
    
    public ManagerHospital() {
    }
       
    public ManagerHospital(ArrayList<Hospital> lista) {
        this.lista = lista;
    }

    public void adicionar(Hospital hospital) throws Exception {
        // validar se os campos vêm todos bem preenchidos
        // validarCampos(hospital) <- se estiver bem preenchido,
        // avança para a adição -> this.lista.add(hospital);
        // senão, retorna erro -> new EnfermariaException("Erro a adicionar hospital");
    // set da operacao que estamos a fazer
        setOperacao(OPERACAO_ADICIONAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(hospital);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            // gerar o codigo para o novo hospital
            String novoCodigo = gerarCodigo();
            hospital.setCodigo(novoCodigo);

            lista.add(hospital);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Hospital hospital) throws Exception {
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_REMOVER);

        lista.remove(hospital);
    }

    public void editar(Hospital hospital) throws Exception {
        // procurar o hospital na lista pelo codigo
        // validar se os campos estao bem preenchidos:
        // validarCampos(hsopital) <- se estiver bem preenchido,
        // avança para a edição -> substitui o hospital na lista pela nova
        // senão, retorna erro -> new HospitalException("Erro a editar hospital");
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(hospital);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            int index = lista.indexOf(hospital);

            if (index >= 0) {
                lista.set(index, hospital);
            }
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_EDITAR);
        }    
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Hospital hospital) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(hospital);
        // se nao for a operacao adicionar, tem de existir um codigo
        if (!operacao.equals(OPERACAO_ADICIONAR) && (hospital.getCodigo() == null || hospital.getCodigo().isEmpty())) {
            throw new Exception(ERRO_FALTA_CODIGO);
        }
        if (hospital.getNome() == null || hospital.getNome().isEmpty()) {
            throw new Exception(ERRO_FALTA_NOME);
        }
        if (hospital.getLocalidade() == null || hospital.getLocalidade().isEmpty()) {
            throw new Exception(ERRO_FALTA_LOCALIDADE);
        }
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
    }

    @Override
    public String toString() {
        return "ListaHospital{" + "lista=" + lista + '}';
    }
    
    
}
