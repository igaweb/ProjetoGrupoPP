package frontend.model;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import backend.listas.ManagerEnfermaria;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EnfermariaTableModel extends DefaultTableModel implements TableModel {
    
    // numero de colunas
    private final int COLUMN_COUNT = 4;
    
    // indices das colunas
    private final int COLUNA_CODIGO = 0;
    private final int COLUNA_TIPO = 1;
    private final int COLUNA_EQUIPAMENTOS = 2;
    private final int COLUNA_CAMAS = 3;
    
    private final ManagerEnfermaria manager;
    // dados da tabela
    private ArrayList<Enfermaria> lista;

    public EnfermariaTableModel(ManagerEnfermaria manager) {
        this.manager = manager;
        this.lista = manager.getLista();
        
        Object[][] data = new Object[lista.size()][COLUMN_COUNT];
        for (int i = 0; i < lista.size(); i++) {
            Enfermaria enf = lista.get(i);
                data[i] = new Object[] {
                enf.getCodigo(),
                Conteudos.getTiposEnfermarias()[enf.getTipo()],
                enf.getEquipamentos().size(),
                enf.getCamas().size()
            };
        }
        
        setDataVector(data, new String[] {"Código", "Tipo", "Equipamentos", "Camas"});
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex) {
            case COLUNA_CODIGO:
                return "Código";
                
            case COLUNA_TIPO:
                return "Tipo";
                
            case COLUNA_EQUIPAMENTOS:
                return "Equipamentos";
                
            case COLUNA_CAMAS:
                return "Camas";
                
            default:
                return "";
        }
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
