/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Rodrigo
 */
public class DlgCliente extends javax.swing.JDialog {

    /**
     * Creates new form Cliente
     */
    public DlgCliente(java.awt.Frame parent, boolean modal) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        btn_CancProd1 = new javax.swing.JButton();
        btn_EditarProd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 109, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 400, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setText("Cédula");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 70, 56, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 109, 240));
        jLabel3.setText("Teléfono");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 310, 56, 24);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 109, 240));
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 130, 56, 24);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 109, 240));
        jLabel5.setText("Apellido");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 190, 56, 24);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 109, 240));
        jLabel6.setText("Celular");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 250, 56, 24);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 109, 240));
        jLabel7.setText("Dirección");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 370, 56, 24);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(90, 370, 273, 30);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(90, 70, 273, 30);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(90, 130, 273, 30);
        getContentPane().add(jTextField10);
        jTextField10.setBounds(90, 190, 273, 30);
        getContentPane().add(jTextField11);
        jTextField11.setBounds(90, 250, 273, 30);
        getContentPane().add(jTextField12);
        jTextField12.setBounds(90, 310, 273, 30);

        btn_CancProd1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_CancProd1.setForeground(new java.awt.Color(0, 109, 240));
        btn_CancProd1.setText("Aceptar");
        btn_CancProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancProd1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CancProd1);
        btn_CancProd1.setBounds(40, 451, 110, 40);

        btn_EditarProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_EditarProd.setForeground(new java.awt.Color(0, 109, 240));
        btn_EditarProd.setText("Salir");
        btn_EditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarProdActionPerformed(evt);
            }
        });
        getContentPane().add(btn_EditarProd);
        btn_EditarProd.setBounds(210, 450, 100, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 380, 520);

        setSize(new java.awt.Dimension(399, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancProd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CancProd1ActionPerformed

    private void btn_EditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarProdActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
=======
    }//GEN-LAST:event_btn_EditarProdActionPerformed
>>>>>>> 64e88fbb679c2e618ebc31215fde9aabb3183aea

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
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgCliente dialog = new DlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_CancProd1;
    private javax.swing.JButton btn_EditarProd;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
