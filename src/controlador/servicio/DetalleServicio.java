package controlador.servicio;

import controlador.dao.DetalleDao;
import java.util.List;
import modelo.Detalle;
import modelo.Factura;
import modelo.Lote;
import modelo.Persona;

/**
 * La clase podra ser usado en la vista.Provee los metodos de la clase
 * DetalleDao
 *
 * @author Franz Flores
 * @version 16/08/2018
 * @see DetalleDao
 */
public class DetalleServicio {

    //Atributo privado de la clase
    private DetalleDao obj = new DetalleDao();

    /**
     * Método que obtiene el objeto de tipo Detalle.
     *
     * @return Se encarga de obtener el objeto de tipo Detalle.
     */
    public Detalle getDetalle() {
        return obj.getDetalle();
    }//Cierre del Método

    /**
     * Método que brinda al informacion al objeto de tipo Detalle.
     *
     * @param detalle El parametro detalle se encargara de dar un detalle al
     * objeto de tipo Detalle.
     */
    public void fijarDetalle(Detalle detalle) {
        obj.setDetalle(detalle);
    }//Cierre del Método

    /**
     * Método que guarda o modica un objeto de tipo Detalle
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */
    public boolean guardar() {
        return obj.guardar();
    }//Cierre del Método

    /**
     * Método que devuelve una lista con objetos de tipo Detalle
     *
     * @return Devuelve un objeto de tipo List con todos los objetos de tipo
     * detalle
     */
    public List<Detalle> todos() {
        return obj.listar();
    }//Cierre del Método

    /**
     * Método que devuelve un objeto de tipo Detalle
     *
     * @param id Se encarga de dar el valor de Id para obtener el objeto
     * @return Devuelve un objeto de tipo detalle mediante el id.
     */
    public Detalle obtener(Long id) {
        return (Detalle) obj.obtener(id);
    }//Cierre del Método

    public Detalle fijarDetalle(Long id_d,Long id_f,Integer cant, Lote lote,FacturaServicio fs,Persona ps) {
        return obj.fijarDetalle(id_d, id_f, cant, lote, fs, ps);
    }
    
    public List<Detalle> listaFactura(Long id) {
        return obj.listaFactura(id);
    }
    

    public Detalle crearDetalle(Integer cant, Lote lote, FacturaServicio fs) {
        Detalle d = new Detalle();
        d.setCantidad(cant);
        d.setLote(lote);
        d.setFactura(fs.getFactura());
        return d;
    }
} //Cierre de la Clase
