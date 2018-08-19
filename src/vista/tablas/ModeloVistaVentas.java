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
public class ModeloVistaVentas extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Num. Doc.";
            case 1: return "Fecha";
            case 2: return "Cliente";
            case 3: return "Total";
            default: return null;
        }
    }
    
}
