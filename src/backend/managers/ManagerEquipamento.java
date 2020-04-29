package backend.managers;

import backend.entidades.Equipamento;
import backend.entidades.Paciente;
import java.util.ArrayList;
import backend.Conteudos;

public class ManagerEquipamento extends ManagerBase {

    private static final String ERRO_FALTA_CODIGO = "ERRO_FALTA_CODIGO";
    private static final String ERRO_TIPO_INVALIDO = "ERRO_TIPO_INVALIDO";
    
            
    public ManagerEquipamento() {
        
    }
    
     public ManagerEquipamento(ArrayList<Equipamento> lista) {
        this.lista = lista;
    }

     
     
    public void adicionar(String codigo, Integer tipo, boolean livre, ArrayList<Paciente> pacientes)throws Exception {
        
        Equipamento equipamentos = new Equipamento(codigo, tipo, livre, pacientes);
        adicionar(equipamentos);
        
    }
    
    
    public void adicionar(Equipamento equipamentos) throws Exception {
        
        // set da operacao que estamos a fazer)
        setOperacao(OPERACAO_ADICIONAR);
        
        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(equipamentos);
        
         // avança para a adição
        if (isValido) {
            // gerar o codigo para o novo equipamento
            String novoCodigo = gerarCodigo();
            equipamentos.setCodigo(novoCodigo);

            lista.add(equipamentos);
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_ADICIONAR);
        }
    }

    public void remover(Equipamento equipamentos) throws Exception {
        
        // set da operacao que estamos a fazer)
        setOperacao(OPERACAO_REMOVER);
        lista.remove(equipamentos);
    }

    public void editar(Equipamento equipamentos) throws Exception {
        
        // set da operacao que estamos a fazer
        setOperacao(OPERACAO_EDITAR);

        // validar se os campos vêm todos bem preenchidos
        boolean isValido = validarCampos(equipamentos);

        // se estiver bem preenchido,
        // avança para a adição
        if (isValido) {
            int index = lista.indexOf(equipamentos);

            if (index >= 0) {
                lista.set(index, equipamentos);
            }
        } else {
            // senão, retorna erro
            throw new Exception(ERRO_EDITAR);
        }  
    }

    /*
     * Método para validar se os campos da classe estão bem preenchidos
     */
    private boolean validarCampos(Equipamento equipamentos) throws Exception {
        // validações para todas as operaçoes na base
        boolean isValid = super.validarCampos(equipamentos);
        
          if (equipamentos.getCodigo() == null || equipamentos.getCodigo().isEmpty()) {
            throw new Exception(ERRO_FALTA_CODIGO);
        }
          
         // Se a opção que o utilizador escolher for menor que 0 || "OU" || se o número que o utilizador escolher for maior que as que existem
         if (equipamentos.getTipo() < 0 || equipamentos.getTipo() >= Conteudos.getTiposEquipamentos().length) {
            throw new Exception(ERRO_TIPO_INVALIDO); 
         }
       
        
        // validações....... (campos obrigatorios, tipos de dados, etc...)
        return isValid;
   
    }  

    @Override
    public String toString() {
        return "ListaEquipamentos{" + "lista=" + lista + '}';
    }
}