package frontend.janelas;

import frontend.Aplicacao;

public class JanelaEnfermaria extends JanelaBase {

    public JanelaEnfermaria(Aplicacao app) {
        super(app);
        
        setFiltrosVisible(true, true);
        setOperacoes(true, true, true);
    }
}
