package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;
import java.util.TreeMap;

public class Hospital extends EntidadeBase implements IEntidade {

     /**
      * 
      */
    
    private String nome;
    private String localidade;
    private TreeMap<String, EntidadeBase> enfermarias = new TreeMap();

    public Hospital() {
    }

    public Hospital(String codigo, String nome, String localidade, TreeMap<String, EntidadeBase> enfermarias) {
        super(codigo, nome);
        this.localidade = localidade;
        this.enfermarias = enfermarias;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public TreeMap<String, EntidadeBase> getEnfermarias() {
        return enfermarias;
    }

    public void setEnfermarias(TreeMap<String, EntidadeBase> enfermarias) {
        this.enfermarias = enfermarias;
    }

    @Override
    public String toString() {
        return "Hospital{" + "codigo=" + codigo + ", nome=" + nome + ", localidade=" + localidade + ", enfermarias=" + enfermarias + '}';
    }
}
