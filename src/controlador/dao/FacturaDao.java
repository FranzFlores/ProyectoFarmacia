package controlador.dao;

import javax.persistence.Query;
import modelo.Factura;

/**
 * La clase es encargada de gestionar la creación y modificación de la tabla
 * Factura dentro de la base de datos
 *
 * @author Franz Flores
 * @version 16/08/2018
 * @see AdaptadorDao
 */
public class FacturaDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Factura factura;

    /**
     * Constructor para la clase FacturaDao por defecto.Hereda de la clase
     * AdaptadorDao.
     */
    public FacturaDao() {
        super(Factura.class);
    }//Cierre del Constructor

    /**
     * Método que establece la factura al objeto de tipo Factura.
     *
     * @param factura El parametro factura se encargara de dar un factura al
     * objeto de tipo Factura.
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }//Cierre del Constructor.

    /**
     * Método que obtiene el factura al objeto de tipo Factura.
     *
     * @return Se encarga de obtener el objeto de tipo Factura.
     */
    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }//Cierre del Método

    /**
     * Método que comprueba si el un objeto de tipo Factura se ha guardado con
     * exito, lanza una Excepcion.
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            guardar(factura);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del Método

}
