package backend;

public class Equipamento {

    private String codigo;
    private int tipo;
    private boolean livre;
    private Paciente paciente;

    public Equipamento() {
    }

    public Equipamento(String codigo, int tipo, boolean livre, Paciente paciente) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.livre = livre;
        this.paciente = paciente;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "codigo=" + codigo + ", tipo=" + tipo + ", livre=" + livre + ", paciente=" + paciente + '}';
    }

}
