/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author franzandresflores
 */
public class ModeloVistaCompra extends AbstractTableModel {
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código";
            case 1: return "Descripción";
            case 2: return "Cant";
            case 3: return "P.Costo";
            case 4: return "P.Total";
            case 5: return "P.V.P";
            case 6: return "descuento";
            default: return null;
        }
    }
    
    
    
}
