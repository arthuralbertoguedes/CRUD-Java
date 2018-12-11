//Modelo de tabela abstrata
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModel extends AbstractTableModel {
    
    private List<Cliente> linhas = new ArrayList<>();
    private String[] colunas = {"Nome","Telefone","Email","Estado Civil"};
    
    
    @Override
    public int getRowCount() {
       return linhas.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        
        switch(c){
            
            case 0: return linhas.get(l).getNome();
            case 1: return linhas.get(l).getTelefone();
            case 2: return linhas.get(l).getEmail();
            case 3: return linhas.get(l).getEstadoCivil();
            default: return null;
        }
        
    }
    
    public void addLinha(Cliente c){
        this.linhas.add(c);
        this.fireTableDataChanged();
    }
    
    public String getColumnName(int i){
        return colunas[i];
    }
    
    public void removeLinha(int i){
        this.linhas.remove(i);
        //this.fireTableDataChanged();
        this.fireTableRowsDeleted(i, i);
    }
    public void removeAll(){
     this.linhas.removeAll(linhas);
     this.fireTableDataChanged();
    }
    
    
}
