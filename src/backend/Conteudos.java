package backend;


import java.util.ArrayList;
import java.util.Arrays;

public class Conteudos {

    private static final String estadosPaciente[] = new String[]{"Moderado", "Grave", "Muito grave"};
    private static final String tiposEnfermaria[] = new String[]{"Normal", "UCI"};
    private static final String tiposEquipamento[] = new String[]{"Ventilador", "Desfibrilhador", "Raio-X"};
    //private static ArrayList<String> tiposEquipamentoARRAYLIST = new ArrayList<>(Arrays.asList("Ventilador", "Desfibrilhador", "Raio-X"));

    public Conteudos() {
    }

    public static String[] getEstadosPaciente() {
        return estadosPaciente;
    }

    public static String[] getTiposEnfermarias() {
        return tiposEnfermaria;
    }

    public static String[] getTiposEquipamentos() {
        return tiposEquipamento;
    }

}
