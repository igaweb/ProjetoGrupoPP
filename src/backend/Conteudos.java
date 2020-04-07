package backend;

public class Conteudos {

    private static final String estadosPaciente[] = new String[]{"Moderado", "Grave", "Muito grave"};
    private static final String tiposEnfermaria[] = new String[]{"Normal", "UCI"};
    private static final String tiposEquipamento[] = new String[]{"Ventilador", "Desfibrilhador"};

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
