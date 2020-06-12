package backend.entidades;

import backend.bases.EntidadeBase;
import backend.interfaces.IEntidade;
import java.util.TreeMap;

public class Enfermaria extends EntidadeBase implements IEntidade{
     
    /**
     * 
     */
    
    private Integer tipo;
    private Boolean[] camas;
    private TreeMap<String, EntidadeBase> equipamentos;
    private TreeMap<String, EntidadeBase> pacientes;
    private TreeMap<String, EntidadeBase> profissionalSaude;

    public Enfermaria() {
    }

    public Enfermaria(String codigo, String nome, int tipo, Boolean[] camas, TreeMap<String, EntidadeBase> equipamentos, TreeMap<String, EntidadeBase> pacientes, TreeMap<String, EntidadeBase> profissionalSaude) {
        super(codigo, nome);
        this.tipo = tipo;
        this.camas = camas;
        this.equipamentos = equipamentos;
        this.pacientes = pacientes;
        this.profissionalSaude = profissionalSaude;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Boolean[] getCamas() {
        return camas;
    }

    public void setCamas(Boolean[] camas) {
        this.camas = camas;
    }

    public TreeMap<String, EntidadeBase> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(TreeMap<String, EntidadeBase> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public TreeMap<String, EntidadeBase> getPacientes() {
        return pacientes;
    }

    public void setPacientes(TreeMap<String, EntidadeBase> pacientes) {
        this.pacientes = pacientes;
    }
    
    public TreeMap<String, EntidadeBase> getProfissionalSaude() {
        return profissionalSaude;
    }

    public void setProfissionalSaude(TreeMap<String, EntidadeBase> profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }
    
    @Override
    public String toString() {
        return "Enfermaria{" + "codigo=" + codigo + ", tipo=" + tipo + ", camas=" + camas + ", equipamentos=" + equipamentos + ", pacientes=" + pacientes + '}';
    }
}
