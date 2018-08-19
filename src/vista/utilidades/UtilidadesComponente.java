/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.servicio.LaboratorioServicio;
import controlador.servicio.PresentacionServicio;
import controlador.utilidades.Utilidades;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Laboratorio;
import modelo.Presentacion;

/**
 *
 * @author franzandresflores
 */
public class UtilidadesComponente {
    
    public static boolean mostrarError(JComponent componente, String mensaje, char tipo) {
        boolean band = false;
        switch (tipo) {
            case 'r':
                if (componente instanceof JTextField) {
                    JTextField txt = (JTextField) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        //componente.setBackground(new java.awt.Color(255, 51, 51));
                        componente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
                        componente.setToolTipText(mensaje);
                    } else {
                        //componente.setBackground(Color.white);
                        componente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        componente.setToolTipText(null);
                        band = true;
                    }
                }
            case 'a':
                if (componente instanceof JTextArea) {
                    JTextArea txt = (JTextArea) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        //componente.setBackground(new java.awt.Color(255, 51, 51));
                        componente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
                        componente.setToolTipText(mensaje);
                    } else {
                        //componente.setBackground(Color.white);
                        componente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                        componente.setToolTipText(null);
                        band = true;
                    }
                }
        }
        return band;
    }

    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeOK(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void llenarComboPresentacion(PresentacionServicio ps,JComboBox cbx){
        cbx.removeAllItems();
        for (Presentacion p : ps.todos()) {
            cbx.addItem(p);
        }
    }
    
    public static void llenarComboLaboratorio(LaboratorioServicio ls,JComboBox cbx){
        cbx.removeAllItems();
        for (Laboratorio l : ls.todos()) {
            cbx.addItem(l);
        }
    }

    
}
