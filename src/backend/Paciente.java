package backend;

public class Paciente {

    private String codigo;
    private String nome;
    private String localidade;
    private int cama;
    private int estado;
    private int dataEntrada;
    private int dataSaida;

    public Paciente() {
    }

    public Paciente(String codigo, String nome, String localidade, int cama, int estado, int dataEntrada, int dataSaida) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade = localidade;
        this.cama = cama;
        this.estado = estado;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
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

    public int getCama() {
        return cama;
    }

    public void setCama(int cama) {
        this.cama = cama;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(int dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(int dataSaida) {
        this.dataSaida = dataSaida;
    }

}
