package ClassesJorge;

public class Medico extends ProfissionaisSaude {
    private String especialidade;

    public Medico() {
    }

    public Medico(String especialidade) {
        this.especialidade = especialidade;
    }

    public Medico(String especialidade, String codigo, String nome) {
        super(codigo, nome);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
}
