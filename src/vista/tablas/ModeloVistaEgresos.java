/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lili
 */
public class ModeloVistaEgresos extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 8;
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
            case 0: return "Código";
            case 1: return "Producto";
            case 2: return "Cantidad";
            case 3: return "Precio unitario";
            case 4: return "Precio total";
            case 5: return "P.V:P";
            case 6: return "Descuento";
            case 7: return "P.V.P - Descuento";
            default: return null;
        }
    }
}
