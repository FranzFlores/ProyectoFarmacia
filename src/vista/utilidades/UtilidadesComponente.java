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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import modelo.Laboratorio;
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

    
}
