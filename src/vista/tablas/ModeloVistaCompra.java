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
import modelo.Lote;

/**
 *
 * @author franzandresflores
 */
public class ModeloVistaCompra extends AbstractTableModel {

    @Getter
    @Setter

    List<Lote> lista = new ArrayList<>();

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lote l = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return l.getProducto().getCodigo();
            case 1: return l.getProducto().getNombre();
            case 2: return l.getCantidad();
            case 3: return l.getPrecioUnitario();
            case 4: return l.getPrecioTotal();
            case 5: return l.getPersona().getNombre();
            case 6: return l.getFechaFabricacion();
            case 7: return l.getFechaVencimiento();
            default: return null; 
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Producto";
            case 2:
                return "Cantidad";
            case 3:
                return "P.Unitario";
            case 4:
                return "P.Total";
            case 5:
                return "Proveedor";
            case 6:
                return "Fecha Fab";
            case 7:
                return "Fecha Ven";
            default:
                return null;
        }
    }

}
