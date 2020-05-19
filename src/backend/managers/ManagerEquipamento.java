package backend.managers;

import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import backend.Conteudos;
import java.util.TreeMap;

public class ManagerEquipamento extends ManagerBase {

    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";
    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    
     public ManagerEquipamento(TreeMap<String,Equipamento> lista) {
        this.listaTreeMap = lista;
    }
     
    public void adicionar(String codigo, Integer tipo, boolean livre, Paciente paciente)throws Exception {
        
        Equipamento equipamentos = new Equipamento(codigo, tipo, livre, paciente);
        adicionar(equipamentos);
    }
    
    public void adicionar(Equipamento equipamento) throws Exception {
        
        // set da operacao que estamos a fazer)
        setOperacao(OPERACAO_ADICIONAR);
        
        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(equipamento);
        
         // avança para a adição
        if (isValido) {
            // gerar o codigo para o novo equipamento
            String novoCodigo = gerarCodigoTreeMap();
            equipamento.setCodigo(novoCodigo);

            listaTreeMap.put(novoCodigo, equipamento);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Equipamento equipamento) throws Exception {
        
        // set da operacao que estamos a fazer)
        setOperacao(OPERACAO_REMOVER);
        listaTreeMap.remove(equipamento.getCodigo());
    }

    public void editar(Equipamento equipamento) throws Exception {
        
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(equipamento);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            Equipamento equipamentoAEditar = (Equipamento) listaTreeMap.get(equipamento.getCodigo());

            listaTreeMap.put(equipamentoAEditar.getCodigo(), equipamentoAEditar);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_EDITAR);
        }  
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Equipamento equipamento) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(equipamento);
        
          
         // Se a opção que o utilizador escolher for menor que 0 || "OU" || se o número que o utilizador escolher for maior que as que existem
         if (equipamento.getTipo() < 0 || equipamento.getTipo() >= Conteudos.getTiposEquipamentos().length) {
            throw new Exception(ERRO_TIPO_INVALIDO); 
         }

         // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
   
    }  

    @Override
    public String toString() {
        return "ListaEquipamentos{" + "lista=" + listaTreeMap + '}';
    }
}