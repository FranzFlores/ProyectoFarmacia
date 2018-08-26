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
import modelo.Presentacion;
import modelo.Producto;

/**
 *
 * @author franzandresflores
 */
@Getter
@Setter
public class ModeloVistaProducto extends AbstractTableModel{

    List<Producto> lista = new ArrayList<>();
    
    @Override
    public int getColumnCount() {
       return 5;
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
            case 2: return p.getPrecioCompra();
            case 3: return p.getPrecioVenta();
            case 4: return p.getPrecioDescuento();
            default: return null; 
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Codigo";
            case 1: return "Nombre";
            case 2: return "Precio Compra";
            case 3: return "Precio Venta";
            case 4: return "Precio(Desc)";
            default: return null;
        }
    }
    
}
