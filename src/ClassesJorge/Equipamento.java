package ClassesJorge;

public class Equipamento {
    private String codigo;
    private int tipo;
    private boolean livre;

    public Equipamento() {
    }

    public Equipamento(String codigo, int tipo, boolean livre) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.livre = livre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }
    
    
    
}
