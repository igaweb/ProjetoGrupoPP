/* package backend;

import backend.listas.ListaEnfermaria;
import backend.entidades.Enfermaria;


public class Aplicacao {

    public Aplicacao() {
        

    }

    public static void main(String[] args) {
        ListaEnfermaria lista = new ListaEnfermaria();

        Enfermaria enfermaria1 = new Enfermaria();
        enfermaria1.setCamas(new boolean[10]);
        enfermaria1.setTipo(1);
        try {
            lista.adicionar(enfermaria1);
            
            System.out.println("Enfermaria1 adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Enfermaria enfermaria2 = new Enfermaria();
        enfermaria2.setCamas(new boolean[10]);
        enfermaria2.setTipo(1);
        try {
            lista.adicionar(enfermaria2);
            
            System.err.println("Enfermaria2 adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Enfermaria enfermaria3 = new Enfermaria();
        enfermaria3.setTipo(5);
        try {
            lista.adicionar(enfermaria3);
            
            System.err.println("Enfermaria3 adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        enfermaria2.setTipo(0);
        try {
            lista.editar(enfermaria2);
            System.out.println("Enfermaria2 editadfa com sucesso!");
        } catch (Exception ex) {
            //Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            
            System.err.println("Hein?2");
        }
        
        
        enfermaria2.setTipo(-1);
        try {
            lista.editar(enfermaria2);
            System.out.println("Enfermaria editadfa com sucesso!");
        } catch (Exception ex) {
            //Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);
            
            System.err.println("Hein?2...2");
        }
        System.out.println("lista: " + lista);
        
        
        try {
            lista.remover(enfermaria2);
        } catch (Exception ex) {
            System.err.println("rem?2...2");
        }
        System.out.println("lista: " + lista);
    }

}
*/