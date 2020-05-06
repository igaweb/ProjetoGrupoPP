
package frontend;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Equipamento;
import backend.entidades.Hospital;
import backend.managers.ManagerEquipamento;
import static frontend.MenuBase.MENU_PRINCIPAL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MenuEquipamento extends MenuBase {
 
     private static final String[] MENU_EDITAR = new String[]{"TIPO","MENU PACIENTES"};
    private static final String[] MENU_TIPO_EQUIPAMENTOS = Conteudos.getTiposEquipamentos();

    private ManagerEquipamento manager;

    public MenuEquipamento(Menus menus) {
        super(menus);
        
        this.manager = menus.getAplicacao().getManagerEquipamento();
    }

    public void start(){
        
        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, MENU_PRINCIPAL);

        switch (opcaoEscolhida) {
            case 0:// LISTAR
                listar();
                break;
            case 1: // ADICIONAR
                adicionar();
                break;
            case 2: // EDITAR
                editar();
                break;

            case 3: // REMOVER
                remover();
                break;
            
            case 4: // SAIR
                sair();
                break;
        }

        start();
    }

    private void listar() {
        System.out.println("Equipamentos: ");
        System.out.println("| Codigo | Nome | Livre | Paciente");
        for (Map.Entry<String, Equipamento> entry : getListaEquipamento().entrySet()) {
            Equipamento equipamento = (Equipamento) entry.getValue();

            System.out.print(" | " + equipamento.getCodigo());
            System.out.print(" | " + equipamento.getTipo());

            System.out.println(" |");
        }
    }

    

    private void adicionar() {
        Equipamento equipamento = new Equipamento();
               
        equipamento.setLivre(true);
        
        String pergunta = "Selecione o nome do equipamento a adicionar: ";
        Integer tipo = getOpcaoMenu(pergunta, MENU_TIPO_EQUIPAMENTOS);        
        if(tipo == -1) {
            return;
        }
        equipamento.setTipo(tipo);
        
        // Como saber qual o paciente a adicionar. Peciso de ver a lista de pacientes?
        // Estou a adicionar sem paciente
        // equipamento.setPaciente(paciente);        
        try {
            manager.adicionar(equipamento);
        } catch (Exception ex) {
            Logger.getLogger(MenuPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editar() {
        // e preciso editar? preciso da lista para selecionar o equipamento a editar?
    }

    private void remover() {
        
    }
}
