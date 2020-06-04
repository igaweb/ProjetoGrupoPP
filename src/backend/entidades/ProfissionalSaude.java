package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;

public abstract class ProfissionalSaude extends EntidadeBase implements IEntidade {
    
    public ProfissionalSaude() {
    }

    public ProfissionalSaude(String codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public String toString() {
        return "ProfissionalSaude{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
}
