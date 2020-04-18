package backend;

import backend.managers.ManagerHospital;
import backend.entidades.Hospital;

public class Aplicacao {

    public Aplicacao() {

    }

    public static void main(String[] args) {
        ManagerHospital lista = new ManagerHospital();

        Hospital hospital1 = new Hospital();
        hospital1.setNome("Hospital de Guimarães");
        hospital1.setLocalidade("Guimarães");
        hospital1.setCodigo("h1");
        try {
            lista.adicionar(hospital1);

            System.out.println("Hospital1 adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("lista: " + lista);

        Hospital hospital2 = new Hospital();
        hospital2.setNome("Hospital de Braga");
        hospital2.setLocalidade("Braga");
        hospital2.setCodigo("h2");
        try {
            lista.adicionar(hospital2);

            System.err.println("Hospital2 adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("lista: " + lista);

        Hospital hospital3 = new Hospital();
        hospital3.setNome("Hospital do Porto");
        hospital3.setLocalidade("Porto");
        hospital3.setCodigo("h3");
        try {
            lista.adicionar(hospital3);

            System.err.println("Hospital3 adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("lista: " + lista);

        hospital2.setNome("HB");
        try {
            lista.editar(hospital2);
            System.out.println("Hospital editado com sucesso!");
        } catch (Exception ex) {
            //Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);

            System.err.println("Hein?2");
        }

        hospital1.setLocalidade("Cidade de Guimarães");
        try {
            lista.editar(hospital1);
            System.out.println("Hospital editado com sucesso!");
        } catch (Exception ex) {
            //Logger.getLogger(Aplicacao.class.getName()).log(Level.SEVERE, null, ex);

            System.out.println("Hein?1...1");
        }
        System.out.println("lista: " + lista);

        try {
            lista.remover(hospital3);
        } catch (Exception ex) {
            System.out.println("rem?3...3");
        }
        System.out.println("lista: " + lista);
    }

}
