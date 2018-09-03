
package vista;

import controlador.servicio.CuentaServicio;
import controlador.utilidades.Sesion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.utilidades.UtilidadesComponente;

/**
 *
 * @author franzandresflores
 */
public class DlgLogin extends javax.swing.JDialog {

    private final FrmPrincipal principal = new FrmPrincipal();
    
    public DlgLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void inicioSesion() {
        if (!UtilidadesComponente.mostrarError(txt_usuario, "Falta este campo", 'r')
            && !UtilidadesComponente.mostrarError(txt_clave, "Falta este Campo", 'r')) {
            
            Sesion.setCuenta(new CuentaServicio().inicioSesion(txt_usuario.getText(), new String(txt_clave.getPassword())));
            if (Sesion.getCuenta() != null) {
                principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                principal.setVisible(true); 
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "¡Usuario y/o contraseña incorrectos!",
                "Error de inicio", JOptionPane.ERROR_MESSAGE);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso al Sistema");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 109, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al Sistema");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 440, 40);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 120, 90, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 109, 240));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 70, 70, 30);

        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txt_usuario);
        txt_usuario.setBounds(270, 70, 140, 30);

        btn_cancelar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 109, 240));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(250, 200, 110, 40);

        btn_aceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(0, 109, 240));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(80, 200, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/hospital.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 40, 150, 140);

        txt_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveActionPerformed(evt);
            }
        });
        jPanel1.add(txt_clave);
        txt_clave.setBounds(270, 120, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 430, 260);

        setSize(new java.awt.Dimension(432, 286));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
        inicioSesion();
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void txt_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claveActionPerformed
        // TODO add your handling code here:
        inicioSesion();
    }//GEN-LAST:event_txt_claveActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        inicioSesion();
    }//GEN-LAST:event_btn_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgLogin dialog = new DlgLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
