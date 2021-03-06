/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.*;
import modelo.Laboratorio;

/**
 *
 * @author franzandresflores
 */
public class ModeloVistaLaboratorio extends AbstractTableModel {
@Getter
@Setter
    
    List<Laboratorio>lista = new ArrayList<>();

@Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Laboratorio p = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.getNombre();
            default: return null; 
        }
    }
    
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nombre";
            default: return null;
        }
    }



}
