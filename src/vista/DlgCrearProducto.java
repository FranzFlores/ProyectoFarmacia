/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Lili
 */
public class DlgCrearProducto extends javax.swing.JDialog {

    /**
     * Creates new form Producto
     */
    public DlgCrearProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        txt_CodBarrasProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_DescProd = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_LabProd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_NombreProd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_PrecCompProd = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_PrecVentaProd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbx_PresProd = new javax.swing.JComboBox<>();
        btn_CancProd = new javax.swing.JButton();
        btn_EditarProd = new javax.swing.JButton();
        btn_AceptarProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(txt_CodBarrasProd);
        txt_CodBarrasProd.setBounds(140, 40, 170, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Producto");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 330, 30);

        txt_DescProd.setColumns(20);
        txt_DescProd.setRows(5);
        jScrollPane1.setViewportView(txt_DescProd);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 80, 170, 60);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Descripción:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 100, 90, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Código de Barras:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 40, 110, 20);
        getContentPane().add(txt_LabProd);
        txt_LabProd.setBounds(140, 160, 170, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Laboratorio:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 160, 90, 20);
        getContentPane().add(txt_NombreProd);
        txt_NombreProd.setBounds(140, 200, 170, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nombre:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 200, 90, 20);
        getContentPane().add(txt_PrecCompProd);
        txt_PrecCompProd.setBounds(140, 240, 170, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Precio compra:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 240, 110, 20);
        getContentPane().add(txt_PrecVentaProd);
        txt_PrecVentaProd.setBounds(140, 280, 170, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Presentación:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 320, 110, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Precio venta:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(20, 280, 110, 20);

        cbx_PresProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbx_PresProd);
        cbx_PresProd.setBounds(140, 320, 170, 20);

        btn_CancProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_CancProd.setText("Cancelar");
        btn_CancProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancProdActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CancProd);
        btn_CancProd.setBounds(211, 360, 100, 31);

        btn_EditarProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_EditarProd.setText("Editar");
        btn_EditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarProdActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EditarProd);
        btn_EditarProd.setBounds(10, 360, 90, 31);

        btn_AceptarProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_AceptarProd.setText("Aceptar");
        btn_AceptarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarProdActionPerformed(evt);
            }
        });
        getContentPane().add(btn_AceptarProd);
        btn_AceptarProd.setBounds(110, 360, 91, 31);

        setSize(new java.awt.Dimension(338, 441));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CancProdActionPerformed

    private void btn_EditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EditarProdActionPerformed

    private void btn_AceptarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AceptarProdActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgCrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgCrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgCrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgCrearProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgCrearProducto dialog = new DlgCrearProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AceptarProd;
    private javax.swing.JButton btn_CancProd;
    private javax.swing.JButton btn_EditarProd;
    private javax.swing.JComboBox<String> cbx_PresProd;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_CodBarrasProd;
    private javax.swing.JTextArea txt_DescProd;
    private javax.swing.JTextField txt_LabProd;
    private javax.swing.JTextField txt_NombreProd;
    private javax.swing.JTextField txt_PrecCompProd;
    private javax.swing.JTextField txt_PrecVentaProd;
    // End of variables declaration//GEN-END:variables
}