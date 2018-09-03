package vista.utilidades;

import controlador.servicio.LaboratorioServicio;
import controlador.servicio.LoteServicio;
import controlador.servicio.PresentacionServicio;
import controlador.utilidades.Utilidades;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import modelo.Detalle;
import modelo.Lote;

/**
 * Clase con metodos que crean ventanas emergentes, llenar objetos de tipo
 * ComboBox.
 *
 * @author Franz Flores
 * @version 16/08/2018
 */
public class UtilidadesComponente {

    /**
     * Metodo que colorea de Rojo un JComponent en caso de no estar lleno.
     *
     * @param componente Objeto que se desea comprobar si esta vacio
     * @param mensaje Objeto de tipo String. Muestra el texto que brinda
     * informacion sobre el error
     * @param tipo Tipo de componente que se aplicara
     * @return Devuelve un booleano que controla si se ejecuta el metodo
     */
    public static boolean mostrarError(JComponent componente, String mensaje, char tipo) {
        boolean band = true;
        switch (tipo) {
            case 'r':
                if (componente instanceof JTextComponent) {
                    JTextComponent txt = (JTextComponent) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        componente.setBackground(Color.red);
                        componente.setToolTipText(mensaje);
                    } else {
                        componente.setBackground(Color.white);
                        componente.setToolTipText(null);
                        band = false;
                    }
                }
                ;
        }
        return band;
    } //Cierre del metodo

    /**
     * Metodo que muestra una ventana emergente en caso de existir un error
     *
     * @param titulo Titulo de la ventana
     * @param mensaje Objeto de tipo String. Muestra el texto que brinda
     * informacion sobre el error
     */
    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    } //Cierre del metodo

    /**
     * Metodo que muestra una ventana emergente en caso realizar una operacion
     * con exito
     *
     * @param titulo Titulo de la ventana
     * @param mensaje Objeto de tipo String. Muestra el texto que brinda
     * informacion sobre la operacion
     */
    public static void mensajeOk(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    } //Cierre del metodo

    /**
     * Metodo que llena el comboBox por objetos de tipo Presentacion
     *
     * @param ps objeto de la clase PresentacionServicio. Ayudara a dar los
     * valores al combo
     * @param cbx ComboBox donde se mostrata la lista de opciones
     */
    public static void llenarComboPresentacion(PresentacionServicio ps, JComboBox cbx) {
        cbx.removeAllItems();
        ps.todos().forEach((p) -> {
            cbx.addItem(p.getNombre());
        });
    } //Cierre del metodo

    /**
     * Metodo que llena el comboBox por objetos de tipo Laboratorio
     *
     * @param ls objeto de la clase LaboratorioServicio. Ayudara a dar los
     * valores al combo
     * @param cbx ComboBox donde se mostrata la lista de opciones
     */
    public static void llenarComboLaboratorio(LaboratorioServicio ls, JComboBox cbx) {
        cbx.removeAllItems();
        ls.todos().forEach((l) -> {
            cbx.addItem(l.getNombre());
        });
    } //Cierre del metodo

        /**
     * Metodo que elimina un detalle en la tabla de la vista Factura
     * @param lista Lista de Detalle donde se quiere eliminar el objeto
     * @param pos Posicion del objeto en la tabla que se quiere eliminar
     * @return Devuelve una lista con el objeto eliminado
     */  
    public static List<Detalle> eliminarDetalle(List<Detalle> lista, int pos) {
        Detalle d = lista.get(pos);
        if (d.getCantidad() >= 1) {
            lista.remove(pos);
        } else {
            d.setCantidad(d.getCantidad() - 1);
        }
        return lista;
    } //Cierre del metodo
    
    public static void fechaLimite(){
        LoteServicio lote = new LoteServicio();
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date someDate = new Date();
        Date newDate = new Date(someDate.getTime() + TimeUnit.DAYS.toMillis( 1 ));
        
        for (Lote fechaVenciminento : lote.fechaVenciminento()) {
            if (fechaVenciminento.getFechaVencimiento().compareTo(new Date())<=0) {
                System.out.println("Entre en el if");
            JOptionPane.showMessageDialog(null,"Existen Productos que caducan hoy\n"
            + fechaVenciminento.getProducto().getNombre(),"ALERTA", JOptionPane.INFORMATION_MESSAGE);
            }else{
                System.out.println("No entre en el if");
            }
        }
    }

} //Cierre de la clase
