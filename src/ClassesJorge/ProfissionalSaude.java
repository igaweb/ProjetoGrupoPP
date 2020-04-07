package ClassesJorge;

public abstract class ProfissionalSaude {
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
    
    
    
    
}
