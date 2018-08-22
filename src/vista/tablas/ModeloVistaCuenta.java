/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rodrigo
 */
public class ModeloVistaCuenta extends AbstractTableModel {

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Cédula";
            case 1: return "Nombre";
            case 2: return "Apellido";
            case 3: return "Direccion";
            case 4: return "Telefono";
            default: return null;
        }
    }
}
