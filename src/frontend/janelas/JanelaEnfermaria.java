package frontend.janelas;

import backend.Aplicacao;

public class JanelaEnfermaria extends JanelaBase {

    public JanelaEnfermaria(Aplicacao app) {
        super(app);
        
        setFiltrosVisible(true, true);
        setOperacoes(true, true, true);
    }
}
