/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import controlador.servicio.DetalleServicio;
import controlador.servicio.FacturaServicio;
import controlador.servicio.LoteServicio;
import controlador.utilidades.Utilidades;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Detalle;
import modelo.Factura;
import modelo.Lote;
import modelo.Persona;
import modelo.Producto;
import static oracle.jrockit.jfr.events.Bits.longValue;
import vista.tablas.ModeloVistaDetalle;
import vista.utilidades.UtilidadesComponente;

/**
 *
 * @author franzandresflores
 */
public class FrmFactura extends javax.swing.JFrame {

    private final DlgListaCliente cliente = new DlgListaCliente(this, true);
    private final DlgListaProductos producto = new DlgListaProductos(this, true);

    private ModeloVistaDetalle modelo = new ModeloVistaDetalle();
    private LoteServicio ls = new LoteServicio();
    private FacturaServicio fs = new FacturaServicio();
    private DetalleServicio ds = new DetalleServicio();

    public FrmFactura() {
        initComponents();
        presionadoPersona();
        presionadoProducto();
    }

    //=============================Detalle=======================================
    private void presionadoProducto() {
        btn_lista.addActionListener((ActionEvent arg0) -> {
            if (arg0.getSource().equals(btn_lista)) {
                cargarProducto();
            }
        });
    }

    private Producto cargarProducto() {
        if (producto.escogerItem() != null) {
            txt_detalle.setText(producto.escogerItem().getNombre());
            txt_codigo.setText(producto.escogerItem().getCodigo());
            return producto.escogerItem();
        }
        return null;
    }

    private Long codigoDetalle() {
        String tipo = "";
        for (int i = 0; i < 3; i++) {
            tipo += "0";
        }
        tipo += (ds.todos().size() + 1);
        return Long.parseLong(tipo);
    }

    private Long codigoFactura() {
        String tipo = "";
        for (int i = 0; i < 3; i++) {
            tipo += "0";
        }
        tipo += (ds.todos().size() + 1);
        return Long.parseLong(tipo);
    }    
    
    public Detalle detalle() {
        String mensaje = "Campo Requerido";
        if (!UtilidadesComponente.mostrarError(txt_cedula, mensaje, 'r')
            && !UtilidadesComponente.mostrarError(txt_codigo, mensaje, 'r') 
            && !UtilidadesComponente.mostrarError(txt_cantidad, mensaje, 'r')) {
            return ds.fijarDetalle(codigoDetalle(),codigoFactura(),cantidad(), lote(), fs, cargarPersona());
        }else{
            return null;
        }
    }

    public List<Detalle> listaDetalle(Detalle d){
        List<Detalle> aux = new ArrayList<>();
        if (d.getId()!=null) {
            if (d.getCantidad()>=1) {
                aux.remove(d);
            }else{
                aux.add(d);
            }
        }else{
            UtilidadesComponente.mensajeError("Error","No ha ingresado ningun Producto");
        }
        return aux;
    }
    
    private void cargarTabla() {
        modelo.setLista(listaDetalle(detalle()));
        tbl_tabla.setModel(modelo);
        tbl_tabla.updateUI();
    }
    
    //==============================Detalle=======================================
//    private void cargarObjetoDetalle() {
//        ds.fijarDetalle(cantidad(), lote(), fs, cargarPersona());
//    }

    private void eliminar() {
        int f = tbl_tabla.getSelectedRow();
        if (f >= 0) {

        }
    }

    private Integer cantidad() {
        return Integer.parseInt(txt_cantidad.getText());
    }

    private Lote lote() {
        return ls.restarStock(producto.escogerItem().getCodigo(), cantidad());
    }

    private void guardar1() {
        String mensaje = "Campo requerido";
        if (!UtilidadesComponente.mostrarError(txt_codigo, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_cedula, mensaje, 'r')) {
//            cargarObjetoDetalle();
            if (ds.getDetalle().getId() == null) {
                if (ds.guardar()) {
                    UtilidadesComponente.mensajeOk("OK", "Se ha registrado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo guardar");
                }
            }
        }
    }

    //==============================Factura====================================
    private void presionadoPersona() {
        btn_cliente.addActionListener((ActionEvent arg0) -> {
            if (arg0.getSource().equals(btn_cliente)) {
                cargarPersona();
            }
        });
    }

    private Persona cargarPersona() {
        if (cliente.escogerItem() != null) {
            txt_cedula.setText(cliente.escogerItem().getCedula());
            txt_cliente.setText(cliente.escogerItem().getNombre());
            txt_direccion.setText(cliente.escogerItem().getDireccion());
            txt_telefono.setText(cliente.escogerItem().getTelefono());
            return cliente.escogerItem();
        } else {
            return null;
        }
    }

    public Factura getFactura() {
        fs.getFactura().setPersona(cargarPersona());
        fs.guardar();
        return fs.getFactura();
    }

    private void asignarFactura() {
        if (ds.getDetalle().getId() != null) {
            fs.fijarFactura(ds.getDetalle().getFactura());
        }
    }

    private Double subtotal() {
        Double precio = 0.0;
        for (Detalle det : ds.getDetalle().getFactura().getListaDetalle()) {
            precio += det.getLote().getPrecioUnitario();
        }
        return Utilidades.redondearDecimales(precio, 2);
    }

    private Double iva() {
        return Utilidades.redondearDecimales(subtotal() * 0.12, 2);
    }

    private Double descuento() {
        return Utilidades.redondearDecimales(Double.parseDouble(txt_descuento.getText()), 2);
    }

    private Double precioFinal() {
        return Utilidades.redondearDecimales(subtotal() + iva() - descuento(), 2);
    }

    private void cargarObjeto() {
        fs.getFactura().setPersona(cargarPersona());
        fs.getFactura().setSubTotal(subtotal());
        fs.getFactura().setFechaEmision(new Date());
        fs.getFactura().setDescuento(descuento());
        fs.getFactura().setIva(iva());
        fs.getFactura().setPrecioFinal(precioFinal());
    }

    private void guardar() {
        String mensaje = "Campo requerido";
        if (!UtilidadesComponente.mostrarError(txt_cedula, mensaje, 'r')) {
            cargarObjeto();
            if (ls.getLote().getId() == null) {
                if (ls.guardar()) {
                    UtilidadesComponente.mensajeOk("OK", "Se ha registrado correctamente");
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo guardar");
                }
            }
        }
    }

    private void limpiar() {
        txt_cantidad.setText("");
        txt_codigo.setText("");
        txt_detalle.setText("");
        cargarTabla();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        btn_cliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_descuento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_lista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        txt_codigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_detalle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 109, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURA");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 940, 40);

        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setText("Ced/RUC");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 60, 70, 20);

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cedula);
        txt_cedula.setBounds(100, 60, 250, 30);

        jLabel3.setForeground(new java.awt.Color(0, 109, 240));
        jLabel3.setText("Cliente");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 100, 60, 20);

        txt_cliente.setEditable(false);
        jPanel1.add(txt_cliente);
        txt_cliente.setBounds(100, 100, 360, 30);

        jLabel4.setForeground(new java.awt.Color(0, 109, 240));
        jLabel4.setText("Dirección ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 64, 20);

        txt_direccion.setEditable(false);
        jPanel1.add(txt_direccion);
        txt_direccion.setBounds(100, 140, 360, 30);

        jLabel5.setForeground(new java.awt.Color(0, 109, 240));
        jLabel5.setText("Teléfono");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 180, 55, 20);

        txt_telefono.setEditable(false);
        jPanel1.add(txt_telefono);
        txt_telefono.setBounds(100, 180, 360, 30);

        btn_cliente.setBackground(new java.awt.Color(255, 255, 255));
        btn_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/usuarios.png"))); // NOI18N
        btn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cliente);
        btn_cliente.setBounds(360, 50, 50, 40);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 109, 240));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Subtotal");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(670, 240, 230, 30);

        jTextField4.setEditable(false);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(700, 270, 200, 40);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 109, 240));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("IVA 12%");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(690, 310, 230, 30);

        jTextField8.setEditable(false);
        jPanel1.add(jTextField8);
        jTextField8.setBounds(700, 330, 200, 40);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 109, 240));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(" Descuento");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(700, 380, 230, 40);

        txt_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descuentoActionPerformed(evt);
            }
        });
        txt_descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descuentoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_descuento);
        txt_descuento.setBounds(700, 410, 200, 40);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 109, 240));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TOTAL");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(690, 450, 230, 40);

        jTextField12.setEditable(false);
        jPanel1.add(jTextField12);
        jTextField12.setBounds(700, 490, 200, 40);

        btn_aceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(0, 109, 240));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(200, 610, 120, 40);

        btn_cancelar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 109, 240));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(460, 610, 140, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 109, 240));
        jPanel2.setLayout(null);

        btn_lista.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_lista.setForeground(new java.awt.Color(0, 109, 240));
        btn_lista.setText("Ver Lista");
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_lista);
        btn_lista.setBounds(500, 10, 90, 40);

        tbl_tabla.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 650, 320);

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_codigo);
        txt_codigo.setBounds(30, 30, 60, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 109, 240));
        jLabel9.setText("Cant");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(430, 10, 40, 16);

        txt_detalle.setEditable(false);
        jPanel2.add(txt_detalle);
        txt_detalle.setBounds(90, 30, 320, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 109, 240));
        jLabel8.setText("Descripción");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(100, 10, 80, 16);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 109, 240));
        jLabel7.setText("Código");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(35, 10, 50, 20);

        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txt_cantidad);
        txt_cantidad.setBounds(420, 30, 70, 30);

        btn_ingresar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(0, 109, 240));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ingresar);
        btn_ingresar.setBounds(600, 10, 90, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 210, 700, 400);

        btn_eliminar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 109, 240));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar);
        btn_eliminar.setBounds(560, 170, 90, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 680);

        setSize(new java.awt.Dimension(937, 678));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteActionPerformed
        // TODO add your handling code here:
        cliente.setVisible(true);
    }//GEN-LAST:event_btn_clienteActionPerformed

    private void txt_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descuentoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descuentoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_PERIOD)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_descuentoKeyTyped

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        guardar();
        this.dispose();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        // TODO add your handling code here:
        producto.setVisible(true);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
        //guardar1();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_btn_ingresarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cliente;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_lista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_detalle;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
