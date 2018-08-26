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
import modelo.Detalle;
import modelo.Lote;
import modelo.Producto;

/**
 *
 * @author franzandresflores
 */
@Getter
@Setter

public class ModeloVistaDetalle extends AbstractTableModel{

    private List<Detalle> lista = new ArrayList<>();
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Detalle d = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return d.getLote().getProducto().getCodigo();
            case 1: return d.getLote().getProducto().getNombre();
            case 2: return d.getCantidad();
            case 3: return d.getLote().getPrecioUnitario();
            case 4: return d.getLote().getPrecioTotal();
            default: return null; 
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código";
            case 1: return "Detalle";
            case 2: return "Cant";
            case 3: return "P.Unitario";
            case 4: return "P.Total";
            default: return null;
        }
    }
}
