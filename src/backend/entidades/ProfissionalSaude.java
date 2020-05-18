package backend.entidades;

import java.io.Serializable;

public abstract class ProfissionalSaude implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String nome;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(String codigo, String nome) {
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

    @Override
    public String toString() {
        return "ProfissionalSaude{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    
    
    
}
