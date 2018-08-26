/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.servicio.CuentaServicio;
import controlador.servicio.PersonaServicio;
import controlador.servicio.RolServicio;
import controlador.utilidades.Utilidades;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import modelo.Cuenta;
import modelo.Persona;

import vista.tablas.ModeloVistaPersona;
import vista.tablas.ModeloVistaUsuario;
import vista.utilidades.UtilidadesComponente;

/**
 *
 * @author Rodrigo
 */
public class FrmListadoUsuarios extends javax.swing.JFrame {

    ModeloVistaUsuario modelo = new ModeloVistaUsuario();
    PersonaServicio ps = new PersonaServicio();
    CuentaServicio cs = new CuentaServicio();

    public FrmListadoUsuarios() {
        initComponents();
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rb_cedula);
        grupo.add(rb_nombre);
        limpiar();

    }

    private void cargarTabla() {
        modelo.setLista(ps.listaUsuario());
        tbl_tabla.setModel(modelo);
        tbl_tabla.updateUI();
    }

    private void buscar() {
        if (rb_cedula.isSelected()) {
            if (txt_buscar.getText().trim().length() >= 3) {
                modelo.setLista(ps.buscarUsuarioCedula(txt_buscar.getText()));
                tbl_tabla.setModel(modelo);
                tbl_tabla.updateUI();
            } else {
                cargarTabla();
            }
        } else if (rb_nombre.isSelected()) {
            if (txt_buscar.getText().trim().length() >= 3) {
                modelo.setLista(ps.buscarUsuarioNombre(txt_buscar.getText()));
                tbl_tabla.setModel(modelo);
                tbl_tabla.updateUI();
            } else {
                cargarTabla();
            }
        }
    }

    private void limpiar() {
        cargarTabla();
        txt_usuario.setText("");
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_cedula.setText("");
        txt_clave.setText("");
    }
    

    private void cargarObjeto() {
        ps.getPersona().setCedula(txt_cedula.getText());
        ps.getPersona().setNombre(txt_nombre.getText());
        ps.getPersona().setDireccion(txt_direccion.getText());
        ps.getPersona().setTelefono(txt_telefono.getText());
        ps.getPersona().setRol(new RolServicio().buscarRolNombre("Usuario"));
        ps.getPersona().setCuenta(cs.crearCuenta(txt_usuario.getText(),new String(txt_clave.getPassword()), ps));
    }

    private void guardar() {
        String mensaje = "Campo requerido";
        if (!UtilidadesComponente.mostrarError(txt_usuario, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_nombre, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_direccion, mensaje, 'r')
                && !UtilidadesComponente.mostrarError(txt_cedula, mensaje, 'r')) {
            cargarObjeto();
            if (ps.getPersona().getId() != null) { //Modificar
                if (ps.guardar()) {
                    UtilidadesComponente.mensajeOk("Ok", "Se ha modificado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("ERROR", "No se pudo modificar");
                }
            } else {
                if (Utilidades.validadorDeCedula(txt_cedula.getText())) {
                    if (ps.getPersonaCedula(txt_cedula.getText()) != null) {
                        UtilidadesComponente.mensajeError("Error de Cedula", "Cedula ya registrada");
                    } else {
                        //guardar
                        if (ps.guardar()) {
                            UtilidadesComponente.mensajeOk("Ok", "Se ha guardado correctamente");
                            limpiar();
                        } else {
                            UtilidadesComponente.mensajeError("ERROR", "No se pudo guardar");
                        }
                    }
                } else {
                    UtilidadesComponente.mensajeError("Error de Cedula", "Cedula no valida");
                }
            }
        }
    }

    private void cargarVista() {
        int fila = tbl_tabla.getSelectedRow();
        if (fila >= 0) {
            ps.fijarPersona(modelo.getLista().get(fila));
            txt_cedula.setText(ps.getPersona().getCedula());
            txt_cedula.setEditable(false);
            txt_nombre.setText(ps.getPersona().getNombre());
            txt_direccion.setText(ps.getPersona().getDireccion());
            txt_usuario.setText(ps.getPersona().getCuenta().getUsuario());
            txt_telefono.setText(ps.getPersona().getTelefono());
            txt_clave.setText(ps.getPersona().getCuenta().getClave());
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
        jLabel1 = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        rb_cedula = new javax.swing.JRadioButton();
        rb_nombre = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 109, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE USUARIOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 40);

        btn_aceptar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(0, 109, 240));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);
        btn_aceptar.setBounds(500, 600, 123, 39);

        btn_salir.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 109, 240));
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir);
        btn_salir.setBounds(630, 600, 99, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 109, 240));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 90, 56, 24);

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nombre);
        txt_nombre.setBounds(90, 90, 273, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 109, 240));
        jLabel3.setText("Cédula");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 90, 56, 24);

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cedula);
        txt_cedula.setBounds(540, 90, 200, 30);

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
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 900, 340);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 109, 240));
        jLabel5.setText("Buscar");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 190, 56, 24);

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });
        jPanel1.add(txt_buscar);
        txt_buscar.setBounds(90, 190, 273, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 109, 240));
        jLabel6.setText("Télefono");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 140, 56, 24);

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_telefono);
        txt_telefono.setBounds(90, 140, 273, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 109, 240));
        jLabel8.setText("Dirección");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 140, 56, 24);

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jPanel1.add(txt_direccion);
        txt_direccion.setBounds(540, 140, 200, 30);

        btn_agregar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 109, 240));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);
        btn_agregar.setBounds(100, 600, 123, 39);

        rb_cedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_cedula.setForeground(new java.awt.Color(0, 109, 240));
        rb_cedula.setSelected(true);
        rb_cedula.setText("Cédula");
        rb_cedula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb_cedulaItemStateChanged(evt);
            }
        });
        rb_cedula.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_cedulaStateChanged(evt);
            }
        });
        jPanel1.add(rb_cedula);
        rb_cedula.setBounds(380, 190, 120, 30);

        rb_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_nombre.setForeground(new java.awt.Color(0, 109, 240));
        rb_nombre.setText("Nombre");
        rb_nombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb_nombreStateChanged(evt);
            }
        });
        jPanel1.add(rb_nombre);
        rb_nombre.setBounds(520, 190, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 109, 240));
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 56, 28);
        jPanel1.add(txt_usuario);
        txt_usuario.setBounds(90, 50, 270, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 109, 240));
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(460, 50, 69, 24);
        jPanel1.add(txt_clave);
        txt_clave.setBounds(540, 50, 200, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 660);

        setSize(new java.awt.Dimension(942, 679));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            cargarVista();
        }
    }//GEN-LAST:event_tbl_tablaMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_txt_buscarKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_SPACE)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != KeyEvent.VK_BACK_SPACE && c!= KeyEvent.VK_SPACE)) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void rb_cedulaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb_cedulaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_cedulaItemStateChanged

    private void rb_cedulaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_cedulaStateChanged
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_rb_cedulaStateChanged

    private void rb_nombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb_nombreStateChanged
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_rb_nombreStateChanged

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
            java.util.logging.Logger.getLogger(FrmListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListadoUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_cedula;
    private javax.swing.JRadioButton rb_nombre;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
