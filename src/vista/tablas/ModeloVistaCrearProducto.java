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
public class ModeloVistaCrearProducto extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 6;
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
            case 1: return "Laboratorio";
            case 2: return "Presentación";
            case 3: return "Precio compra";
            case 4: return "Precio venta";
            case 5: return "Nombre";
            default: return null;
        }
    }
}
