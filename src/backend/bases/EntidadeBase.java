package backend.bases;

import backend.interfaces.IEntidade;
import java.io.Serializable;

public abstract class EntidadeBase implements Serializable, IEntidade {
    
    private static final long serialVersionUID = 1L;
    
    protected String codigo;
    protected String nome;
    
    public EntidadeBase() {
    }
    
    public EntidadeBase(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
