
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Presentacion;

/**
 * La clase se encarga de gestionar la creacion y modificacion de la tabla
 * presentacion dentro de la base de datos
 *
 * @author luis villalta
 * @version:18/08/2018
 * @see AdaptadorDao
 */
public class PresentacionDao extends AdaptadorDao {
// Campos de la clase

    private Presentacion presentacion;

    /**
     * Constructor para la clase ProductoDao por defecto heredada de la clase
     * AdaptadorDao
     */
    public PresentacionDao() {
        super(Presentacion.class);
    }// Cierre del constructor

    /**
     * Metodo que brinda el producto al objeto de tipo producto
     *
     * @param presentacion el parametro se encarga de dar producto al objeto de tipo
     * producto
     */
    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }// Cierre del metodo

    /**
     * Método metodo para obtener presentacion en el caso de que no este creada
     *
     * @return presentacion
     */
    public Presentacion getPresentacion() {
        if (presentacion == null) {
            presentacion = new Presentacion();
        }
        return presentacion;
    }// Cierre del metodo

    /**
     * Metodo que guarda y lanza una excepcion
     *
     * @return un valor booleano si se realizo el metodo
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (presentacion.getId() != null) {
                modificar(presentacion);
            } else {
                guardar(presentacion);
            }
            guardar(presentacion);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del metodo

    /**
     * Metodo que devuel un objeto de tipo presentacion mediante el nombre
     * dentro sentencia de SQL y lanza una excepcion
     *
     * @param nombre atributo requerido. necesarion para obtencion de la
     * presentacion
     * @return devuelve objeto de tipo presentacion buscado por el nombre en el
     * parametro
     */
    public Presentacion getPresentacionNombre(String nombre) {
        Presentacion r = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Presentacion p where p.nombre = :nombre");
            q.setParameter("nombre", nombre);
            r = (Presentacion) q.getSingleResult();
        } catch (Exception e) {
        }
        return r;

    }//Cierre del metodo 

    
    
    public List<Presentacion> buscar(String nombre){
        List<Presentacion> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Presentacion p where"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;        
    }
    
    
    public Presentacion buscarNombre(String nombre){
        Presentacion r = null;
        try {
            Query q = getManager().createQuery("SELECT r FROM Presentacion r where r.nombre = :data");
            q.setParameter("data", nombre);
            r = (Presentacion) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encontrar la presentacion" + e);
        }
        return r;
    }

}//Cierre de la clase 

