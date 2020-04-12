package backend;

import backend.entidades.Enfermaria;
import backend.listas.ManagerEnfermaria;
import java.io.Serializable;
import java.util.ArrayList;

public class Dados implements Serializable {

    public Dados() {

        ManagerEnfermaria lista = new ManagerEnfermaria();

        try {
            Enfermaria enfermaria1 = new Enfermaria("COD0", 0, new ArrayList(), new ArrayList(), new ArrayList());
            lista.adicionar(enfermaria1);

            Enfermaria enfermaria2 = new Enfermaria("COD1", 0, new ArrayList(), new ArrayList(), new ArrayList());
            lista.adicionar(enfermaria2);

            Enfermaria enfermaria3 = new Enfermaria("COD2", 0, new ArrayList(), new ArrayList(), new ArrayList());
            lista.adicionar(enfermaria3);
        

            System.out.println("Enfermaria1 adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
//        OutputStream ops = null;
//        ObjectOutputStream objOps = null;
//        try {
//            ops = new FileOutputStream("./dados.txt");
//            objOps = new ObjectOutputStream(ops);
//            objOps.writeObject(enfermaria1);
//            objOps.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (objOps != null) {
//                    objOps.close();
//                }
//            } catch (Exception ex) {
//
//            }
//        }
//
//        //////////////////////////////////
//        InputStream fileIs = null;
//        ObjectInputStream objIs = null;
//        try {
//            fileIs = new FileInputStream("./dados.txt");
//            objIs = new ObjectInputStream(fileIs);
//            Enfermaria emp = (Enfermaria) objIs.readObject();
//            System.out.println(emp);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (objIs != null) {
//                    objIs.close();
//                }
//            } catch (Exception ex) {
//
//            }
//        }
        
        
        
    }
}
