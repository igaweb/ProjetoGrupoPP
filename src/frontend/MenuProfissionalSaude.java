package frontend;

import backend.entidades.ProfissionalSaude;
import static frontend.MenuBase.MENU_PROFISSIONALSAUDE;
import java.util.Map;
import java.util.TreeMap;


public class MenuProfissionalSaude extends MenuBase {

    public MenuProfissionalSaude(Menus menus) {
        super(menus);   
    }

    public void start() {
        System.out.println(" Menu Profissional Saude ");
        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, MENU_PROFISSIONALSAUDE);

        switch (opcaoEscolhida) {
            case 0:// LISTAR
                listar();
                break;
                 
            case 1: // SAIR
                sair();
                break;
        }
        start();
    }
    
    public void listar() {
        String pergunta1 = "Selecione o Hospital:";
        MenuHospital hospitalMenu = menus.getMenuHospital();
        hospitalMenu.listar();

        TreeMap<String, String> menuEscolherHospital = getMenuEscolherHospital();

        String hospitalSelecionado = getOpcaoMenu(pergunta1, menuEscolherHospital);

        String pergunta2 = "Selecione a Enfermaria:";
        MenuEnfermaria enfermariaMenu = menus.getMenuEnfermaria();
        enfermariaMenu.listar();

        TreeMap<String, String> menuEscolherEnfermaria = getMenuEscolherEnfermaria(hospitalSelecionado);

        String enfermariaSelecionada = getOpcaoMenu(pergunta2, menuEscolherEnfermaria);

        System.out.println("Profissional Saude: ");
        System.out.println("| Codigo | Nome |");
        if(hospitalSelecionado != null && !hospitalSelecionado.isEmpty() && getListaProfissionalSaude(hospitalSelecionado, enfermariaSelecionada) != null) {
            for (Map.Entry<String, ProfissionalSaude> entry : getListaProfissionalSaude(hospitalSelecionado, enfermariaSelecionada).entrySet()) {
                ProfissionalSaude profissionalSaude = (ProfissionalSaude) entry.getValue();
                
                System.out.print(" | " + profissionalSaude.getCodigo());

                try {
                    System.out.print(" | " + profissionalSaude.getNome());
                } catch (Exception e) {
                    System.out.print(" | ");
                }
                System.out.println(" |");
            }
        }
    }
}
