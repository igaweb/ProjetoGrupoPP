package frontend;

import backend.managers.ManagerProfissionalSaude;


public class MenuProfissionalSaude extends MenuBase {
    //listar
    private ManagerProfissionalSaude manager;
    
    public MenuProfissionalSaude(Menus menus) {
        super(menus);
        
        this.manager = menus.getAplicacao().getManagerProfissionalSaude();
    }

}
