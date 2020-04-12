package frontend.model;

import backend.Conteudos;
import backend.entidades.Enfermaria;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class EnfermariaTableModel implements TableModel {

    // dados da tabela
    private ArrayList<Enfermaria> lista;
    
    // numero de colunas
    private final int COLUMN_COUNT = 4;
    
    // indices das colunas
    private final int COLUNA_CODIGO = 0;
    private final int COLUNA_TIPO = 1;
    private final int COLUNA_EQUIPAMENTOS = 2;
    private final int COLUNA_CAMAS = 3;

    public EnfermariaTableModel(ArrayList<Enfermaria>lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
       return lista.size();
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Enfermaria obj = lista.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_CODIGO:
                return obj.getCodigo();
            case COLUNA_TIPO:
                return Conteudos.getTiposEnfermarias()[obj.getTipo()];
            case COLUNA_EQUIPAMENTOS:
                return obj.getEquipamentos().size();
            case COLUNA_CAMAS:
                return obj.getCamas().size();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case COLUNA_CODIGO:
                // TODO: aviso
                break;
            case COLUNA_TIPO:
                lista.get(rowIndex).setTipo((int) aValue);
                break;
            case COLUNA_EQUIPAMENTOS:
                // TODO: aviso
                break;
            case COLUNA_CAMAS:
                // TODO: 
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        System.out.println("addTableModelListener");
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        System.out.println("removeTableModelListener");
    }

}
