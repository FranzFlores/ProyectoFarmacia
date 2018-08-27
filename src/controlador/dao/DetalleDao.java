package controlador.dao;

import controlador.servicio.FacturaServicio;
import controlador.servicio.LoteServicio;
import controlador.servicio.PersonaServicio;
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
    private Factura f = new Factura();

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
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del Método
    
    
    private Factura cargarFactura(Long id,FacturaServicio fs,Persona ps){
        fs.getFactura().setId(id);
        fs.getFactura().setPersona(ps);
        fs.guardar();
        return fs.getFactura();
    }
    
    public Detalle fijarDetalle(Long id_d,Long id_f,Integer cant, Lote lote,FacturaServicio fs,Persona ps) {
        getDetalle().setFactura(cargarFactura(id_f,fs,ps));
        getDetalle().setCantidad(cant);
        getDetalle().setLote(lote);
        getDetalle().setId(id_d);
        getDetalle().setPrecioUnitario(lote.getPrecioUnitario());
        getDetalle().setPrecioTotal(getDetalle().getPrecioUnitario()* getDetalle().getCantidad());
        return getDetalle();
    }

    public List<Detalle> listaFactura(Long id) {
        List<Detalle> lista = new ArrayList();
        try {
            Query q = getManager().createQuery("SELECT p FROM Detalle p WHERE p.factura.id  = :id");
            q.setParameter("id", id);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;

    }
} //Cierre de la clase Entity
