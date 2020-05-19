package frontend.model;

import backend.Aplicacao;
import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.entidades.Hospital;
import backend.managers.ManagerEnfermaria;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EnfermariaTableModel extends DefaultTableModel implements TableModel {
    
    // numero de colunas
    private final int COLUMN_COUNT = 4;
    
    // indices das colunas
    public static final int COLUNA_CODIGO = 0;
    public static final int COLUNA_TIPO = 1;
    public static final int COLUNA_EQUIPAMENTOS = 2;
    public static final int COLUNA_CAMAS = 3;
    
    private Aplicacao app;
    private ManagerEnfermaria manager;
    // dados da tabela
    private TreeMap<String, Enfermaria> lista;

    public EnfermariaTableModel(Aplicacao app, String codigoHospital) {
        this.app = app;
        // inicializar manager da enfermaria que está no respetivo hospital
        Object[][] data;
        if(codigoHospital != null && !codigoHospital.isEmpty()) {
           Hospital hospital = (Hospital) app.getManagerHospital().getListaTreeMap().get(codigoHospital);
            this.manager = new ManagerEnfermaria(hospital.getEnfermarias());
            
            this.lista = manager.getListaTreeMap();

            data = new Object[lista.size()][COLUMN_COUNT];
            int i = 0;
            for (Map.Entry<String, Enfermaria> entry : lista.entrySet()) {
                Enfermaria enf = (Enfermaria) entry.getValue();

                data[i] = new Object[] {
                    enf.getCodigo(),
                    Conteudos.getTiposEnfermarias()[enf.getTipo()],
                    enf.getEquipamentos().size(),
                    enf.getCamas().length
                };

                i++;
            } 
        } else {
            data = new Object[0][COLUMN_COUNT];
        }

        setDataVector(data, new String[] {"Código", "Tipo", "Equipamentos", "Camas"});
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case COLUNA_CODIGO:
            case COLUNA_TIPO:
            case COLUNA_EQUIPAMENTOS:
            case COLUNA_CAMAS:
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case COLUNA_CODIGO:
                return false;
            case COLUNA_TIPO:
                return true;
            case COLUNA_EQUIPAMENTOS:
                return false;
            case COLUNA_CAMAS:
                return false;
            default:
                return false;
        }
    }
}