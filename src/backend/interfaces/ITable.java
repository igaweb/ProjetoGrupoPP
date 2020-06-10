package backend.interfaces;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public interface ITable {
    
    public AbstractTableModel criarModeloTabela();
    public JTable getTabela();
    public int getColunaCodigo();
    public int getLinhaSelecionada();
}
