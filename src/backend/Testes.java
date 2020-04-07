package backend;

public class Testes {

    public static void main(String[] args) {
        Enfermeiro e1 = new Enfermeiro();
        
        e1.setCodigo("80094");
        e1.setNome("Cláudia");
        
        
        System.out.println("Codigo: " + e1.getCodigo());
        System.out.println("Nome: " + e1.getNome());
    }
    
}
