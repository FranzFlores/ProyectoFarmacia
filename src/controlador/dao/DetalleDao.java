package controlador.dao;

import controlador.servicio.FacturaServicio;
import controlador.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Detalle;
import modelo.Factura;
import modelo.Lote;
import modelo.Persona;

/**
 * La clase es encargada de gestionar la creación y modificación de la tabla
 * Detalle dentro de la base de datos
 *
 * @author Franz Flores
 * @version 16/08/2018
 * @see AdaptadorDao
 */
public class DetalleDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Detalle detalle;

    /**
     * Constructor para la clase DetalleDao por defecto.Hereda de la clase
     * AdaptadorDao.
     */
    public DetalleDao() {
        super(Detalle.class);
    }//Cierre del Constructor.

    /**
     * Método que brinda el detalle al objeto de tipo Detalle.
     *
     * @param detalle El parametro detalle se encargara de dar un detalle al
     * objeto de tipo Detalle.
     */
    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }//Cierre del Método

    /**
     * Método que obtiene el objeto de tipo Detalle.
     *
     * @return Se encarga de obtener el objeto de tipo Detalle.
     */
    public Detalle getDetalle() {
        if (detalle == null) {
            detalle = new Detalle();
        }
        return detalle;
    }//Cierre del Método

    /**
     * Método que comprueba si el un objeto de tipo Detalle se ha guardado con
     * exito, lanza una Excepcion.
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            guardar(detalle);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
        }
        return verificar;
    }//Cierre del Método

    private Factura cargarFactura(Long id, FacturaServicio fs, Persona ps) {
        fs.getFactura().setId(id);
        fs.getFactura().setPersona(ps);
        fs.guardar();
        return fs.getFactura();
    }

    /**
     * Método que sirve para crear un objeto de tipo Detalle con la factura ya
     * cargada.
     * @param f Objeto de tipo Factura
     * @param cant Objeto de tipo Integer. Asigna la cantidad de producto al
     * detalle
     * @param lote Objeto de tipo Lote.
     * @return Devuelve objeto de tipo detalle con atributos ya cargados exito.
     */
    public Detalle fijarDetalle(Factura f, Integer cant, Lote lote) {
        Detalle d = new Detalle();
        d.setFactura(f);
        d.setCantidad(cant);
        d.setLote(lote);
        d.setPrecioUnitario(Utilidades.redondearDecimales(lote.getPrecioUnitario(), 2));
        Double total = Utilidades.redondearDecimales((d.getPrecioUnitario() * d.getCantidad()), 2);
        d.setPrecioTotal(total);
        return d;
    }//Cierre del Método

} //Cierre de la clase 
