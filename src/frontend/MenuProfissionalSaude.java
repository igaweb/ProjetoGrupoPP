package frontend;

import backend.entidades.ProfissionalSaude;
import backend.managers.ManagerProfissionalSaude;
import static frontend.MenuBase.MENU_PRINCIPAL;


public class MenuProfissionalSaude extends MenuBase {

    private ManagerProfissionalSaude manager;

    public MenuProfissionalSaude(Menus menus) {
        super(menus);   
        
        this.manager = menus.getAplicacao().getManagerProfissionalSaude();
    }

    public void start() {
        String pergunta = "Escolha uma opcao:";
        Integer opcaoEscolhida = getOpcaoMenu(pergunta, MENU_PRINCIPAL);

        switch (opcaoEscolhida) {
            case 0:// LISTAR
                listar();
                break;
                 
            case 2: // SAIR
                sair();
                break;
        }
        start();
    }
    
    public void listar() {
        System.out.println("Profissional Saude: ");
        System.out.println("| Codigo | Nome |");
        for (int i = 0; i < manager.getLista().size(); i++) {
            ProfissionalSaude profissionalSaude = (ProfissionalSaude) manager.getLista().get(i);

           System.out.print(" | " + profissionalSaude.getCodigo());

            try {
                System.out.print(" | " + profissionalSaude.getNome());
            } catch (Exception e) {
                System.out.print(" | 0");
            }
             System.out.println(" |");
    }
}
}
