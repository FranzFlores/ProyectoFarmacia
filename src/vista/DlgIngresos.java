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
public class DlgIngresos extends javax.swing.JDialog {

    /**
     * Creates new form Egresos
     */
    public DlgIngresos(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBenefIng = new javax.swing.JTextField();
        txtCantProdIng = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCdgProdIng = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombProdIng = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservIng = new javax.swing.JTextArea();
        btnEliminarIng = new javax.swing.JButton();
        btnGuardarIng = new javax.swing.JButton();
        btnImprimirIng = new javax.swing.JButton();
        txt_TotalIng = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSalirIng = new javax.swing.JButton();
        btnIngresarIng = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 40, 70, 30);
        getContentPane().add(txtBenefIng);
        txtBenefIng.setBounds(130, 40, 220, 30);
        getContentPane().add(txtCantProdIng);
        txtCantProdIng.setBounds(130, 90, 220, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText(" Cantidad Producto:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 90, 130, 30);
        getContentPane().add(txtCdgProdIng);
        txtCdgProdIng.setBounds(130, 140, 220, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText(" Código Producto:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 140, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText(" Nombre Producto:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 190, 130, 30);
        getContentPane().add(txtNombProdIng);
        txtNombProdIng.setBounds(130, 190, 220, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText(" Beneficiario:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 40, 80, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Cant", "P.Unit", "P.Total", "P.V.P", "Dsct", "P.V.P - Dsct"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 230, 620, 110);
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(430, 40, 190, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Observaciones:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(440, 80, 110, 30);

        txtObservIng.setColumns(20);
        txtObservIng.setRows(5);
        jScrollPane2.setViewportView(txtObservIng);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 110, 240, 60);

        btnEliminarIng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminarIng.setText("Eliminar");
        getContentPane().add(btnEliminarIng);
        btnEliminarIng.setBounds(500, 190, 100, 30);

        btnGuardarIng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarIng.setText("Guardar");
        getContentPane().add(btnGuardarIng);
        btnGuardarIng.setBounds(20, 360, 95, 30);

        btnImprimirIng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnImprimirIng.setText("Imprimir");
        getContentPane().add(btnImprimirIng);
        btnImprimirIng.setBounds(130, 360, 100, 30);
        getContentPane().add(txt_TotalIng);
        txt_TotalIng.setBounds(470, 360, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Total $:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(410, 360, 60, 30);

        btnSalirIng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalirIng.setText("Salir");
        getContentPane().add(btnSalirIng);
        btnSalirIng.setBounds(240, 360, 70, 30);

        btnIngresarIng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIngresarIng.setText("Ingresar");
        getContentPane().add(btnIngresarIng);
        btnIngresarIng.setBounds(380, 190, 100, 30);

        setSize(new java.awt.Dimension(642, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DlgIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgIngresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgIngresos dialog = new DlgIngresos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEliminarIng;
    private javax.swing.JButton btnGuardarIng;
    private javax.swing.JButton btnImprimirIng;
    private javax.swing.JButton btnIngresarIng;
    private javax.swing.JButton btnSalirIng;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBenefIng;
    private javax.swing.JTextField txtCantProdIng;
    private javax.swing.JTextField txtCdgProdIng;
    private javax.swing.JTextField txtNombProdIng;
    private javax.swing.JTextArea txtObservIng;
    private javax.swing.JTextField txt_TotalIng;
    // End of variables declaration//GEN-END:variables
}