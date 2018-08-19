/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.utilidades.UtilidadesComponente;
import controlador.servicio.LaboratorioServicio;
import controlador.servicio.PresentacionServicio;
/**
 *
 * @author franzandresflores
 */
public class FrmCompras extends javax.swing.JFrame {

    PresentacionServicio ps = new PresentacionServicio();
    LaboratorioServicio ls = new LaboratorioServicio ();
    
    public FrmCompras() {
        initComponents();
        cargarCombos();
    }

    private void cargarCombos() {
        UtilidadesComponente.llenarComboPresentacion(ps,cbx_presentacion);
        cbx_presentacion.updateUI();
        UtilidadesComponente.llenarComboLaboratorio(ls,cbx_laboratorio);
        cbx_laboratorio.updateUI();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_listado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        cbx_laboratorio = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbx_presentacion = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_laboratorio = new javax.swing.JButton();
        btn_presentacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compras");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("COMPRAS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 920, 40);

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
        jPanel1.add(jTextField1);
        jTextField1.setBounds(100, 100, 360, 30);

        jLabel5.setForeground(new java.awt.Color(0, 109, 240));
        jLabel5.setText("Dirección ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 140, 64, 20);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(100, 140, 360, 30);

        jLabel6.setForeground(new java.awt.Color(0, 109, 240));
        jLabel6.setText("Teléfono");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 180, 55, 20);

        btn_agregar.setBackground(new java.awt.Color(255, 255, 255));
        btn_agregar.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/usuario.png"))); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);
        btn_agregar.setBounds(340, 50, 50, 40);

        btn_listado.setBackground(new java.awt.Color(255, 255, 255));
        btn_listado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/usuarios.png"))); // NOI18N
        btn_listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listadoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_listado);
        btn_listado.setBounds(400, 50, 50, 40);

        jLabel7.setForeground(new java.awt.Color(0, 109, 240));
        jLabel7.setText("Laboratorio");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(490, 100, 120, 20);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(610, 140, 190, 30);
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(610, 180, 190, 30);

        jLabel9.setForeground(new java.awt.Color(0, 109, 240));
        jLabel9.setText("Fecha Fabricación");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(490, 140, 140, 20);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(100, 180, 360, 30);

        cbx_laboratorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbx_laboratorio);
        cbx_laboratorio.setBounds(610, 100, 180, 30);

        jLabel10.setForeground(new java.awt.Color(0, 109, 240));
        jLabel10.setText("Presentación");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(490, 60, 120, 20);

        cbx_presentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbx_presentacion);
        cbx_presentacion.setBounds(610, 60, 180, 30);

        jPanel2.setBackground(new java.awt.Color(56, 146, 255));
        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Código");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 10, 50, 20);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(10, 30, 60, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Detalle");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(80, 10, 50, 20);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(80, 30, 340, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cant");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(430, 10, 50, 20);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(430, 30, 60, 30);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Costo");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(500, 10, 50, 20);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(500, 30, 60, 30);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("%Dscto");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(570, 10, 50, 20);
        jPanel2.add(jTextField8);
        jTextField8.setBounds(570, 30, 60, 30);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("P.V.P");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(640, 10, 50, 20);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(640, 30, 60, 30);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 109, 240));
        jButton2.setText("Ingresar");
        jPanel2.add(jButton2);
        jButton2.setBounds(740, 20, 90, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 870, 260);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 220, 890, 340);

        jLabel11.setForeground(new java.awt.Color(0, 109, 240));
        jLabel11.setText("Fecha Vencimiento");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(490, 180, 140, 20);

        btn_cancelar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 109, 240));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(580, 570, 110, 40);

        jButton5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 109, 240));
        jButton5.setText("ACEPTAR");
        jPanel1.add(jButton5);
        jButton5.setBounds(300, 570, 110, 40);

        btn_laboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Copia de mas.png"))); // NOI18N
        btn_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laboratorioActionPerformed(evt);
            }
        });
        jPanel1.add(btn_laboratorio);
        btn_laboratorio.setBounds(790, 90, 50, 40);

        btn_presentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Copia de mas.png"))); // NOI18N
        btn_presentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_presentacionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_presentacion);
        btn_presentacion.setBounds(790, 50, 50, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 920, 620);

        setSize(new java.awt.Dimension(916, 643));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listadoActionPerformed
        // TODO add your handling code here:
        new DlgListaCliente().setVisible(true);
    }//GEN-LAST:event_btn_listadoActionPerformed

    private void btn_presentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_presentacionActionPerformed
        // TODO add your handling code here:
        new DlgPresentacion(this,true).setVisible(true);
    }//GEN-LAST:event_btn_presentacionActionPerformed

    private void btn_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laboratorioActionPerformed
        // TODO add your handling code here:
        new DlgLaboratorio(this,true).setVisible(true);
    }//GEN-LAST:event_btn_laboratorioActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_laboratorio;
    private javax.swing.JButton btn_listado;
    private javax.swing.JButton btn_presentacion;
    private javax.swing.JComboBox<String> cbx_laboratorio;
    private javax.swing.JComboBox<String> cbx_presentacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txt_cedula;
    // End of variables declaration//GEN-END:variables
}
