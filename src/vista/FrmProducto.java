/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.utilidades.UtilidadesComponente;
import controlador.servicio.LaboratorioServicio;
import controlador.servicio.PresentacionServicio;
import controlador.servicio.ProductoServicio;
import controlador.utilidades.Utilidades;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import modelo.Laboratorio;
import modelo.Presentacion;
import modelo.Producto;
import vista.tablas.ModeloVistaProducto;

/**
 *
 * @author franzandresflores
 */
public class FrmProducto extends javax.swing.JFrame {

    private ModeloVistaProducto modelo = new ModeloVistaProducto();
    private ProductoServicio prs = new ProductoServicio();

    private PresentacionServicio ps = new PresentacionServicio();
    private LaboratorioServicio ls = new LaboratorioServicio();

    public FrmProducto() {
        initComponents();
        limpiar();
    }

    private void cargarTabla() {
        modelo.setLista(prs.todos());
        tbl_tabla.setModel(modelo);
        tbl_tabla.updateUI();
    }

    private void buscar() {
        if (txt_buscar.getText().trim().length() >= 3) {
            modelo.setLista(prs.buscar(txt_buscar.getText()));
            tbl_tabla.setModel(modelo);
            tbl_tabla.updateUI();
        } else {
            cargarTabla();
        }
    }

    private void cargarCombos() {      
        UtilidadesComponente.llenarComboPresentacion(ps, cbx_presentacion);
        cbx_presentacion.updateUI();
        
        UtilidadesComponente.llenarComboLaboratorio(ls, cbx_laboratorio);
        cbx_laboratorio.updateUI();
    }

    private void limpiar() {
        cargarCombos();
        cargarTabla();
        txt_buscar.setText("");
        txt_codigo.setText(codigoProducto());
        txt_costo.setText("");
        txt_ganancia.setText("");
        txt_iva.setText("");
        txt_porG.setText("");
        txt_precioDesc.setText("");
        txt_pvp.setText("");
        txt_nombre.setText("");
        txt_descuento.setText("");
    }

    private String codigoProducto() {
        String tipo = "";
        for (int i = 0; i < 3; i++) {
            tipo += "0";
        }
        tipo += (prs.todos().size() + 1);
        txt_codigo.setText(tipo);
        return tipo;
    }

    private void cargarVista(){
        int fila = tbl_tabla.getSelectedRow();
        if (fila >= 0) {
            prs.fijarProducto(modelo.getLista().get(fila));
            txt_codigo.setText(prs.getProducto().getCodigo());
            txt_costo.setText(String.valueOf(prs.getProducto().getPrecioCompra()));
            txt_ganancia.setText(String.valueOf(prs.getProducto().getGanancia()));
            txt_iva.setText(String.valueOf(prs.getProducto().getIva()));
            cargarPorGanancia();
            txt_precioDesc.setText(String.valueOf(prs.getProducto().getPrecioDescuento()));
            txt_pvp.setText(String.valueOf(prs.getProducto().getPrecioVenta()));
            txt_nombre.setText(prs.getProducto().getNombre());
            txt_descuento.setText(String.valueOf(prs.getProducto().getDescuento()));
        } else {
            UtilidadesComponente.mensajeError("Error", "Escoja un dato de la tabla");
        }
    }

    private Double costo(){
        if (!Utilidades.isEmpty(txt_costo.getText())) {
            return Utilidades.redondearDecimales(Double.parseDouble(txt_costo.getText()),2);
        }
        return 0.0;
    }
    
    private Double calcularIva() {    
        return Utilidades.redondearDecimales(costo() * 0.12, 2);
    }
    
    private void cargarIva() {
        txt_iva.setText(String.valueOf(calcularIva()));
        txt_iva.updateUI();
    }

 
    private Double ganancia() {
        if (!Utilidades.isEmpty(txt_ganancia.getText())) {
            return Utilidades.redondearDecimales(Double.parseDouble(txt_ganancia.getText()), 2);
        }
        return 0.0;
    }

    private void cargarPorGanancia() {
        Double porcentaje = Utilidades.redondearDecimales(100 * ganancia()/costo(),2);
        txt_porG.setText(String.valueOf(porcentaje));
        txt_porG.updateUI();
    }

    private Double calcularPrecioVenta() {
        Double precioVenta = Utilidades.redondearDecimales(costo() + calcularIva() + ganancia(),2);
        return precioVenta;
    }
    
    private void cargarPrecioVenta() {
        txt_pvp.setText(String.valueOf(calcularPrecioVenta()));
        txt_pvp.updateUI();
    }

    private Double descuento() {
        if (!Utilidades.isEmpty(txt_descuento.getText())) {
            return Utilidades.redondearDecimales(Double.parseDouble(txt_descuento.getText()), 2);
        }
        return 0.0;
    }

    private Double calcularPrecioDescuento() {
        Double precio = calcularPrecioVenta() - descuento();
        return precio;
    }

    private void cargarPrecioDesc() {
        txt_precioDesc.setText(String.valueOf(calcularPrecioDescuento()));
        txt_precioDesc.updateUI();
    }
    
    private void aplicarDescuento() {
        if (chk_descuento.isSelected()) {
            txt_descuento.setEditable(true);
        } else {
            txt_descuento.setEditable(false);
        }
    }
    
    private void cargarObjeto() {
        prs.getProducto().setNombre(txt_nombre.getText());
        prs.getProducto().setCodigo(codigoProducto());
        prs.getProducto().setPresentacion(ps.buscarNombre(cbx_presentacion.getSelectedItem().toString()));
        prs.getProducto().setLaboratorio(ls.getLaboratorioNombre(cbx_laboratorio.getSelectedItem().toString()));
        prs.getProducto().setPrecioCompra(costo());
        prs.getProducto().setIva(calcularIva());
        prs.getProducto().setGanancia(ganancia());
        prs.getProducto().setPrecioVenta(calcularPrecioVenta());
        prs.getProducto().setDescuento(descuento());
        prs.getProducto().setPrecioDescuento(calcularPrecioDescuento());
    }

    private void guardar() {
        String mensaje = "Campo requerido";
        if (!UtilidadesComponente.mostrarError(txt_nombre, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_costo, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_ganancia, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_descuento, mensaje, 'r')) {
            cargarObjeto();
            if (prs.getProducto().getId() != null) {
                if (prs.guardar()) {
                    UtilidadesComponente.mensajeOk("Ok", "Se ha modificado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo modificar");
                }
            } else {
                if (prs.guardar()) {
                    UtilidadesComponente.mensajeOk("OK", "Se ha guardado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo guardar");
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbx_laboratorio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbx_presentacion = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_porG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_descuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_precioDesc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_ganancia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_pvp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_iva = new javax.swing.JTextField();
        chk_descuento = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compras");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Listado de Producto");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 970, 40);

        jLabel7.setForeground(new java.awt.Color(0, 109, 240));
        jLabel7.setText("Laboratorio");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(430, 90, 80, 20);

        cbx_laboratorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbx_laboratorio);
        cbx_laboratorio.setBounds(520, 90, 180, 30);

        jLabel10.setForeground(new java.awt.Color(0, 109, 240));
        jLabel10.setText("Presentación");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(430, 50, 80, 20);

        cbx_presentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbx_presentacion);
        cbx_presentacion.setBounds(520, 50, 180, 30);

        btn_cancelar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 109, 240));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(690, 580, 110, 40);

        btn_agregar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 109, 240));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);
        btn_agregar.setBounds(50, 580, 110, 40);

        jLabel5.setForeground(new java.awt.Color(0, 109, 240));
        jLabel5.setText("Nombre");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 100, 70, 20);

        txt_codigo.setEditable(false);
        jPanel1.add(txt_codigo);
        txt_codigo.setBounds(110, 50, 70, 30);

        jLabel6.setForeground(new java.awt.Color(0, 109, 240));
        jLabel6.setText("Buscar");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 210, 70, 30);

        txt_costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_costo);
        txt_costo.setBounds(110, 130, 120, 30);

        jLabel8.setForeground(new java.awt.Color(0, 109, 240));
        jLabel8.setText("Ganancia");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(430, 130, 80, 30);

        txt_porG.setEditable(false);
        jPanel1.add(txt_porG);
        txt_porG.setBounds(650, 130, 70, 30);

        jLabel9.setForeground(new java.awt.Color(0, 109, 240));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("%");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(720, 130, 30, 30);

        txt_descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descuentoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_descuento);
        txt_descuento.setBounds(520, 170, 120, 30);

        jLabel11.setForeground(new java.awt.Color(0, 109, 240));
        jLabel11.setText("Descuento");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(430, 170, 70, 30);

        txt_precioDesc.setEditable(false);
        jPanel1.add(txt_precioDesc);
        txt_precioDesc.setBounds(730, 170, 120, 30);

        jLabel12.setForeground(new java.awt.Color(0, 109, 240));
        jLabel12.setText("Código");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 56, 50, 20);

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nombre);
        txt_nombre.setBounds(110, 90, 270, 30);

        jLabel13.setForeground(new java.awt.Color(0, 109, 240));
        jLabel13.setText("P.V.P-Desc.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(650, 170, 90, 30);

        txt_ganancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gananciaActionPerformed(evt);
            }
        });
        txt_ganancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_gananciaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_ganancia);
        txt_ganancia.setBounds(520, 130, 120, 30);

        jLabel14.setForeground(new java.awt.Color(0, 109, 240));
        jLabel14.setText("P.V.P");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(20, 180, 80, 20);

        txt_pvp.setEditable(false);
        txt_pvp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pvpActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pvp);
        txt_pvp.setBounds(110, 170, 120, 30);

        jLabel15.setForeground(new java.awt.Color(0, 109, 240));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("IVA (12%)");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(230, 130, 70, 30);

        txt_iva.setEditable(false);
        jPanel1.add(txt_iva);
        txt_iva.setBounds(300, 130, 80, 30);

        chk_descuento.setForeground(new java.awt.Color(0, 109, 240));
        chk_descuento.setSelected(true);
        chk_descuento.setText("Aplicar Descuento");
        chk_descuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_descuentoStateChanged(evt);
            }
        });
        jPanel1.add(chk_descuento);
        chk_descuento.setBounds(240, 170, 160, 30);

        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 250, 940, 320);

        jLabel16.setForeground(new java.awt.Color(0, 109, 240));
        jLabel16.setText("Costo");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 130, 40, 30);
        jPanel1.add(txt_buscar);
        txt_buscar.setBounds(110, 206, 280, 30);

        btn_aceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(0, 109, 240));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(190, 580, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 970, 640);

        setSize(new java.awt.Dimension(972, 653));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_gananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gananciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gananciaActionPerformed

    private void txt_pvpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pvpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pvpActionPerformed

    private void txt_costoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_PERIOD)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }else{
            cargarIva();
        }
    }//GEN-LAST:event_txt_costoKeyTyped

    private void txt_gananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_gananciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_PERIOD)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            cargarPorGanancia();
            cargarPrecioVenta();
            
        }
    }//GEN-LAST:event_txt_gananciaKeyTyped

    private void txt_descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descuentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_PERIOD)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            cargarPrecioDesc();
        }       
    }//GEN-LAST:event_txt_descuentoKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_SPACE)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void chk_descuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_descuentoStateChanged
        // TODO add your handling code here:
        aplicarDescuento();
    }//GEN-LAST:event_chk_descuentoStateChanged

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        // TODO add your handling code here:
       if (evt.getClickCount() >= 2) {
            cargarVista();
        }
    }//GEN-LAST:event_tbl_tablaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JComboBox<String> cbx_laboratorio;
    private javax.swing.JComboBox<String> cbx_presentacion;
    private javax.swing.JCheckBox chk_descuento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_ganancia;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_porG;
    private javax.swing.JTextField txt_precioDesc;
    private javax.swing.JTextField txt_pvp;
    // End of variables declaration//GEN-END:variables
}
