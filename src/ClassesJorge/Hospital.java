package ClassesJorge;

public class Hospital {
   private String codigo;
   private String nome;
   private String localidade;
   
    public Hospital() {
    }

    public Hospital(String codigo, String nome, String localidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade = localidade;
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

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
   
   
   
   
   
   
}
