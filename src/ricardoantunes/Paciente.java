/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ricardoAntunes;

/**
 *
 * @author SERALIVE
 */
public class Paciente {

  private int codigo;
  private String nome;
  private String localidade;
  private int cama;
  private int estado;
  private int dataEntrada;
  private int ddataSaida;

    public Paciente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public int getDdataSaida() {
        return ddataSaida;
    }

    public void setDdataSaida(int ddataSaida) {
        this.ddataSaida = ddataSaida;
    }
  
  
  
    
    
    
    
    
    
}
