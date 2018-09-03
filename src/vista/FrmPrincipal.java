
package vista;

import controlador.servicio.LoteServicio;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Lote;

/**
 *
 * @author franzandresflores
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
        private LoteServicio los = new LoteServicio();
    
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mn_cliente = new javax.swing.JMenuItem();
        mn_proveedor = new javax.swing.JMenuItem();
        mn_usuarios = new javax.swing.JMenuItem();
        mn_salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mn_listadoP = new javax.swing.JMenuItem();
        mn_presentacion = new javax.swing.JMenuItem();
        mn_laboratorio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mn_factura = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mn_compras = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Facturacion");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 23, 1200, 900));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/principal.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(280, 0, 1010, 760);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1380, 830);

        jMenuBar1.setBackground(new java.awt.Color(0, 109, 240));

        jMenu1.setText("General");

        mn_cliente.setText("Clientes");
        mn_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_clienteActionPerformed(evt);
            }
        });
        jMenu1.add(mn_cliente);

        mn_proveedor.setText("Proveedores");
        mn_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_proveedorActionPerformed(evt);
            }
        });
        jMenu1.add(mn_proveedor);

        mn_usuarios.setText("Usuarios");
        mn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_usuariosActionPerformed(evt);
            }
        });
        jMenu1.add(mn_usuarios);

        mn_salir.setText("Salir");
        mn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_salirActionPerformed(evt);
            }
        });
        jMenu1.add(mn_salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Inventarios");

        mn_listadoP.setText("Productos");
        mn_listadoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_listadoPActionPerformed(evt);
            }
        });
        jMenu2.add(mn_listadoP);

        mn_presentacion.setText("Presentación");
        mn_presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_presentacionActionPerformed(evt);
            }
        });
        jMenu2.add(mn_presentacion);

        mn_laboratorio.setText("Laboratorio");
        mn_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_laboratorioActionPerformed(evt);
            }
        });
        jMenu2.add(mn_laboratorio);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ventas");

        mn_factura.setText("Crear Factura");
        mn_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_facturaActionPerformed(evt);
            }
        });
        jMenu3.add(mn_factura);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Compras");

        mn_compras.setText("Compras");
        mn_compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_comprasActionPerformed(evt);
            }
        });
        jMenu4.add(mn_compras);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1349, 832));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mn_salirActionPerformed

    private void mn_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_facturaActionPerformed
        // TODO add your handling code here:
        new FrmFactura().setVisible(true);
        
    }//GEN-LAST:event_mn_facturaActionPerformed

    private void mn_comprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_comprasActionPerformed
        // TODO add your handling code here:
        new FrmCompras().setVisible(true);
    }//GEN-LAST:event_mn_comprasActionPerformed

    private void mn_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_proveedorActionPerformed
        // TODO add your handling code here:
        new FrmListadoProveedores().setVisible(true);
    }//GEN-LAST:event_mn_proveedorActionPerformed

    private void mn_listadoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_listadoPActionPerformed
        // TODO add your handling code here:
        new FrmProducto().setVisible(true);
    }//GEN-LAST:event_mn_listadoPActionPerformed

    private void mn_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_clienteActionPerformed
        // TODO add your handling code here:
        new FrmListadoClientes().setVisible(true);
    }//GEN-LAST:event_mn_clienteActionPerformed

    private void mn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_usuariosActionPerformed
        // TODO add your handling code here:
        new FrmListadoUsuarios().setVisible(true);
    }//GEN-LAST:event_mn_usuariosActionPerformed

    private void mn_presentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_presentacionActionPerformed
        // TODO add your handling code here:
         new DlgPresentacion(this, true).setVisible(true);
    }//GEN-LAST:event_mn_presentacionActionPerformed

    private void mn_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_laboratorioActionPerformed
        // TODO add your handling code here:
        new DlgLaboratorio(this, true).setVisible(true);
    }//GEN-LAST:event_mn_laboratorioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         Date fechaActual = new Date();
      
        for (Lote todo : los.todos()) {
            Date fechaVP = todo.getFechaVencimiento();
            if (fechaVP.compareTo(fechaActual)<=0) {
               JOptionPane.showMessageDialog(null,"Existen Productos que caducan hoy\n"
                + todo.getProducto().getNombre(),"ALERTA", JOptionPane.INFORMATION_MESSAGE); 
                System.out.println("Si es igual");
            }
        }
    }//GEN-LAST:event_formWindowOpened

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
                if ("McWin".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem mn_cliente;
    private javax.swing.JMenuItem mn_compras;
    private javax.swing.JMenuItem mn_factura;
    private javax.swing.JMenuItem mn_laboratorio;
    private javax.swing.JMenuItem mn_listadoP;
    private javax.swing.JMenuItem mn_presentacion;
    private javax.swing.JMenuItem mn_proveedor;
    private javax.swing.JMenuItem mn_salir;
    private javax.swing.JMenuItem mn_usuarios;
    // End of variables declaration//GEN-END:variables
}
