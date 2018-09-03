/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.utilidades.UtilidadesComponente;
import controlador.servicio.LaboratorioServicio;
import controlador.servicio.LoteServicio;
import controlador.servicio.PersonaServicio;
import controlador.servicio.PresentacionServicio;
import controlador.servicio.ProductoServicio;
import controlador.utilidades.Utilidades;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import modelo.Laboratorio;
import modelo.Persona;
import modelo.Presentacion;
import modelo.Producto;
import vista.tablas.ModeloVistaCompra;

/**
 *
 * @author franzandresflores
 */
public class FrmCompras extends javax.swing.JFrame {

    private LoteServicio los = new LoteServicio();
    private ProductoServicio prs = new ProductoServicio();
    private PersonaServicio ps = new PersonaServicio();
    
    private final DlgListaProductos producto = new DlgListaProductos(this, true);

    private ModeloVistaCompra modelo = new ModeloVistaCompra();
    
    public FrmCompras() {
       initComponents();
       limpiar();
    }
    
    private void limpiar() {     
        txt_cedula.setText("");
        txt_proveedor.setText("");
        txt_cantidad.setText("");
        txt_codigo.setText("");
        txt_producto.setText("");
        txt_costo.setText("");
        txt_cantidad.setText("");
        cargarTabla();
        ps.fijarPersona(null);
        prs.fijarProducto(null);
    }
    

    
    //=============================Proveedor===============================
    
    public PersonaServicio getPersonaServicio(){
        return ps;
    }
    
    private void cargarPersona() {
        if (ps.getPersona() != null) {
            txt_cedula.setText(ps.getPersona().getCedula());
            txt_proveedor.setText(ps.getPersona().getNombre());
        } 
    }
   
    //=============================Producto===============================

    public ProductoServicio getProductoServicio(){
        return prs;
    }
    
    private void cargarProducto() {
        if (prs.getProducto() != null) {
            txt_codigo.setText(prs.getProducto().getCodigo());
            txt_producto.setText(prs.getProducto().getNombre());
        }
    }
    
    private void cargarTabla() {
        modelo.setLista(los.todos());
        tbl_tabla.setModel(modelo);
        tbl_tabla.updateUI();
    }

    private Double precioUnitario() {
        return Utilidades.redondearDecimales(Double.parseDouble(txt_costo.getText()), 2);
    }

    private Double getPrecioTotal() {
        Double precio = Utilidades.redondearDecimales(precioUnitario() * cantidad(),2);
        return precio;
    }
    
    private int cantidad(){
        return Integer.parseInt(txt_cantidad.getText());
    }

    private void cargarObjeto() {
        los.getLote().setPersona(ps.getPersona());
        los.getLote().setCantidad(Integer.parseInt(txt_cantidad.getText()));
        los.getLote().setFechaFabricacion(date_fabricacion.getDate());
        los.getLote().setFechaVencimiento(date_vencimiento.getDate());
        los.getLote().setFechaCompra(new Date());
        los.getLote().setPrecioUnitario(precioUnitario());
        los.getLote().setPrecioTotal(getPrecioTotal());
        los.getLote().setProducto(prs.getProducto());
        los.getLote().getProducto().setStock(Integer.parseInt(txt_cantidad.getText()));
        //los.getLote().getProducto().setPrecioCompra(precioUnitario());
    }

    private void guardar() {
        String mensaje = "Campo requerido";
        if (!UtilidadesComponente.mostrarError(txt_cedula, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_codigo, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_costo, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_cantidad, mensaje, 'r')) {
            if (date_fabricacion.getDate()==null || date_vencimiento.getDate()==null) {
                UtilidadesComponente.mensajeError("Error", "Falta llenar algun campo de fecha");
            }else{
               cargarObjeto();
            if (los.getLote().getId() != null) { //Modificar
                if (los.guardar()) {
                    UtilidadesComponente.mensajeOk("Ok", "Se ha modificado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo modificar");
                }
            } else {
                if (los.guardar()) {
                    UtilidadesComponente.mensajeOk("Ok", "Se ha guardado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo guardar");
                }
            }
            }
           
        }
    }

    private void cargarVista() {
        int fila = tbl_tabla.getSelectedRow();
        if (fila >= 0) {
            los.fijarLote(modelo.getLista().get(fila));
            txt_cedula.setText(los.getLote().getPersona().getCedula());
            txt_cedula.setEditable(false);
            txt_proveedor.setText(los.getLote().getPersona().getNombre());
            txt_cantidad.setText(String.valueOf(los.getLote().getCantidad()));
            date_fabricacion.setDate(los.getLote().getFechaFabricacion());
            date_vencimiento.setDate(los.getLote().getFechaVencimiento());
            txt_codigo.setText(los.getLote().getProducto().getCodigo());
            txt_producto.setText(los.getLote().getProducto().getNombre());
            txt_costo.setText(String.valueOf(los.getLote().getPrecioUnitario()));
            txt_cantidad.setText(String.valueOf(los.getLote().getCantidad()));
        } else {
            UtilidadesComponente.mensajeError("Error", "Escoja un dato de la tabla");
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
        jLabel3 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_proveedor = new javax.swing.JTextField();
        btn_producto = new javax.swing.JButton();
        date_fabricacion = new com.toedter.calendar.JDateChooser();
        date_vencimiento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_producto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        btn_ListaProveedor = new javax.swing.JButton();
        btn_proveedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compras");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPRAS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 880, 40);

        jLabel3.setForeground(new java.awt.Color(0, 109, 240));
        jLabel3.setText("Ced/RUC");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 60, 70, 20);
        jPanel1.add(txt_cedula);
        txt_cedula.setBounds(100, 60, 220, 30);

        jLabel4.setForeground(new java.awt.Color(0, 109, 240));
        jLabel4.setText("Proveedor");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 100, 70, 20);

        txt_proveedor.setEditable(false);
        jPanel1.add(txt_proveedor);
        txt_proveedor.setBounds(100, 100, 330, 30);

        btn_producto.setBackground(new java.awt.Color(255, 255, 255));
        btn_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/codigo-de-barras (1).png"))); // NOI18N
        btn_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_producto);
        btn_producto.setBounds(240, 140, 40, 40);
        jPanel1.add(date_fabricacion);
        date_fabricacion.setBounds(600, 60, 190, 30);
        jPanel1.add(date_vencimiento);
        date_vencimiento.setBounds(600, 100, 190, 30);

        jLabel9.setForeground(new java.awt.Color(0, 109, 240));
        jLabel9.setText("Fecha Fabricación");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(480, 60, 140, 20);

        jLabel11.setForeground(new java.awt.Color(0, 109, 240));
        jLabel11.setText("Fecha Vencimiento");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(480, 100, 140, 20);

        btn_cancelar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 109, 240));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(510, 570, 110, 40);

        btn_aceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(0, 109, 240));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(240, 570, 110, 40);

        jLabel16.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 109, 240));
        jLabel16.setText("Producto");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(300, 140, 60, 30);

        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_codigo);
        txt_codigo.setBounds(100, 140, 110, 30);

        txt_producto.setEditable(false);
        jPanel1.add(txt_producto);
        txt_producto.setBounds(370, 140, 420, 30);

        jLabel18.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 109, 240));
        jLabel18.setText("Código");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(30, 140, 60, 30);

        jLabel19.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 109, 240));
        jLabel19.setText("Costo");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(30, 176, 60, 20);

        txt_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_costo);
        txt_costo.setBounds(100, 170, 110, 30);

        jLabel20.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 109, 240));
        jLabel20.setText("Cantidad");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(300, 180, 60, 20);
        jPanel1.add(txt_cantidad);
        txt_cantidad.setBounds(370, 170, 90, 30);

        jLabel21.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 109, 240));
        jLabel21.setText("Buscar");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(470, 170, 50, 30);
        jPanel1.add(txt_buscar);
        txt_buscar.setBounds(520, 170, 270, 30);

        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 210, 860, 350);

        btn_ListaProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btn_ListaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/usuarios.png"))); // NOI18N
        btn_ListaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListaProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ListaProveedor);
        btn_ListaProveedor.setBounds(380, 50, 50, 40);

        btn_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        btn_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/usuario.png"))); // NOI18N
        btn_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_proveedor);
        btn_proveedor.setBounds(330, 50, 50, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 880, 620);

        setSize(new java.awt.Dimension(878, 643));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productoActionPerformed
        // TODO add your handling code here:
       new DlgListaProductos(this, true, this).setVisible(true);
       cargarProducto();
    }//GEN-LAST:event_btn_productoActionPerformed

    private void txt_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_codigoKeyTyped

    private void btn_ListaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListaProveedorActionPerformed
        // TODO add your handling code here:
        new DlgListaProveedores(this,true,this).setVisible(true);
        cargarPersona();
    }//GEN-LAST:event_btn_ListaProveedorActionPerformed

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            cargarVista();
        }
    }//GEN-LAST:event_tbl_tablaMouseClicked

    private void btn_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveedorActionPerformed
        // TODO add your handling code here:
        new DlgProveedor(this, true, this).setVisible(true);
    }//GEN-LAST:event_btn_proveedorActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ListaProveedor;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_producto;
    private javax.swing.JButton btn_proveedor;
    private com.toedter.calendar.JDateChooser date_fabricacion;
    private com.toedter.calendar.JDateChooser date_vencimiento;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_proveedor;
    // End of variables declaration//GEN-END:variables
}
