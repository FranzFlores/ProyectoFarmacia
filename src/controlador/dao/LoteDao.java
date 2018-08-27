
package controlador.dao;

import javax.persistence.Query;
import modelo.Lote;

/**
 * La clase es encargada de gestionar la creación y modificación de la tabla
 * Lote dentro de la base de datos
 *
 * @author Franz Flores
 * @version 16/08/2018
 * @see AdaptadorDao
 */
public class LoteDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Lote lote;

    /**
     * Constructor para la clase LoteDao por defecto.Hereda de la clase
     * AdaptadorDao.
     */
    public LoteDao() {
        super(Lote.class);
    }//Cierre del Constructor.

    /**
     * Método que brinda el lote al objeto de tipo Lote.
     *
     * @param lote El parametro lote se encargara de dar un lote al objeto de
     * tipo Lote.
     */
    public void setLote(Lote lote) {
        this.lote = lote;
    }//Cierre del Método

    /**
     * Método que obtiene el lote al objeto de tipo Lote.
     *
     * @return Se encarga de obtener el objeto de tipo Lote.
     */
    public Lote getLote() {
        if (lote == null) {
            lote = new Lote();
        }
        return lote;
    }//Cierre del Método

    /**
     * Método que comprueba si el un objeto de tipo Lote se ha guardado con
     * exito, lanza una Excepcion.
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (lote.getId() != null) {
                modificar(lote);
            } else {
                guardar(lote);
            }
            guardar(lote);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del Método

    public Lote buscarCodigo(String codigo) {
        Lote p = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Lote p WHERE "
                    + "p.producto.codigo = :codigo");
            q.setParameter("codigo", codigo);
            p = (Lote) q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Lote restarStock(String codigo, Integer cant) {
        Lote p = buscarCodigo(codigo);
        Integer aux = p.getCantidad() - cant;
        p.setCantidad(aux);
        return p;
    }

} //Cierre de la Clase
