/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.servicio.LaboratorioServicio;
import controlador.servicio.PresentacionServicio;
import controlador.utilidades.Utilidades;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import modelo.Detalle;
import modelo.Factura;
import modelo.Laboratorio;
import modelo.Lote;
import modelo.Presentacion;

/**
 *
 * @author franzandresflores
 */
public class UtilidadesComponente {
    
   public static boolean mostrarError(JComponent componente, String mensaje, char tipo) {
        boolean band = true;
        switch (tipo) {
            case 'r':
                if (componente instanceof JTextComponent) {
                    JTextComponent txt = (JTextComponent) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        componente.setBackground(Color.red);
                        componente.setToolTipText(mensaje);
                    } else {
                        componente.setBackground(Color.white);
                        componente.setToolTipText(null);
                        band = false;
                    }
                }
                ;
        }

        return band;
    }
  
    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeOk(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void llenarComboPresentacion(PresentacionServicio ps,JComboBox cbx){
        cbx.removeAllItems();
        for (Presentacion p : ps.todos()) {
            cbx.addItem(p.getNombre());
        }
    }
    
    public static void llenarComboLaboratorio(LaboratorioServicio ls,JComboBox cbx){
        cbx.removeAllItems();
        for (Laboratorio l : ls.todos()) {
            cbx.addItem(l.getNombre());
        }
    }

    public static List<Detalle> eliminarDetalle(List<Detalle> lista,int pos){
        Detalle d = lista.get(pos);
        if (d.getCantidad()>=1) {
            lista.remove(pos);
        }else{
            d.setCantidad(d.getCantidad()-1);
        }
        return lista;
    }
    
    public static List<Detalle> fijarDetalle(List<Detalle>lista,Lote l,Factura f){
        boolean band = false;
        int pos=0;
        for (Detalle d:lista) {
            if (d.getLote().getProducto().getId().intValue() == l.getProducto().getId().intValue()) {
                band = true;
                break;
            }
            pos++;
        }
        if (band==true) {
            Detalle aux = lista.get(pos);
            if (aux.getLote().getProducto().getStock()>0) {
                aux.setPrecioUnitario(l.getPrecioUnitario());
                aux.setCantidad(aux.getCantidad()+1);
                aux.setPrecioTotal(aux.getPrecioUnitario()*aux.getCantidad());
                aux.getLote().getProducto().setStock(aux.getLote().getProducto().getStock()-1);
                aux.setFactura(f);
                lista.remove(pos);
                lista.add(pos,aux);
            }else{
                mensajeError("Error","No existen productos en Stock para este producto");
            }
        }
        else{
            if (l.getProducto().getStock()>0) {
                Detalle detalle = new Detalle();
                detalle.setCantidad(1);
            }
        }
        
        return lista;
    }
    
}
