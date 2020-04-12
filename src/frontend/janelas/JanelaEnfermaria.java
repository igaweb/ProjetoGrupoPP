package frontend.janelas;

import frontend.Aplicacao;

public class JanelaEnfermaria extends JanelaBase {

    public JanelaEnfermaria(Aplicacao app) {
        super(app);
    }
    
    private boolean canCreate() {
        return true;
    }
    
}
