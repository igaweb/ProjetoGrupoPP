package ClassesJorge;

public class Teste {

    public static void main(String[] args) {

        
       Hospital h1 = new Hospital();       
       h1.setCodigo("H1-Braga");
       h1.setNome ("Hospital de Braga");
       h1.setLocalidade("Braga");
       
      // System.out.println(h1.getCodigo());
      // System.out.println(h1.getLocalidade());
         
     //   System.out.println("codigo: " + h1.getCodigo());
     //   System.out.println("localidade: " + h1.getLocalidade());
        System.out.println(h1); //imprime o endereço de memória onde a class está alojada
       
        /*for (EstadoPaciente estados : EstadoPaciente.values()) {
            System.out.println(estados);
        }
        
        EstadoPaciente estado = EstadoPaciente.MODERADO; 
        System.out.println(estado); 
    }*/
        
    }

}
