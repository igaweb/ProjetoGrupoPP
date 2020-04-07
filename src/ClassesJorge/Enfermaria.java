package ClassesJorge;

public class Enfermaria {

    private String condigo;
    private int tipo;
    private boolean camas[];

    public Enfermaria() {
    }

    public Enfermaria(String condigo, int tipo, boolean[] camas) {
        this.condigo = condigo;
        this.tipo = tipo;
        this.camas = camas;
    }

    public String getCondigo() {
        return condigo;
    }

    public void setCondigo(String condigo) {
        this.condigo = condigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean[] getCamas() {
        return camas;
    }

    public void setCamas(boolean[] camas) {
        this.camas = camas;
    }

}
