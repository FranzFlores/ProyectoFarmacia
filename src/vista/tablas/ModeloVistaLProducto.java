/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.Setter;
import modelo.Producto;

/**
 *
 * @author franzandresflores
 */
public class ModeloVistaLProducto extends AbstractTableModel{
@Getter
@Setter
    
    List<Producto>lista = new ArrayList<>();

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.getCodigo();
            case 1: return p.getNombre();
            default: return null; 
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código";
            case 1: return "Producto";
            default: return null;
        }
    }
    
}
