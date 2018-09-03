package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Laboratorio;
import modelo.Laboratorio;

/**
 * La clase se encarga de gestionar la creacion y modificacion de la tabla
 * LaboratorioDao dentro de la base de datos
 *
 * @author luis villalta
 * @version:18/08/2018
 * @see AdaptadorDao
 */
public class LaboratorioDao extends AdaptadorDao {

    //Campos de la clase 
    private Laboratorio laboratorio;

    /**
     * Constructor para la clase LaboratoriDao por defecto heredada de la clase
     * AdaptadorDao
     */
    public LaboratorioDao() {
        super(Laboratorio.class);
    }// Cierre del constructor

    /**
     * Metodo que brinda el laboratorio al objeto de tipo laboratorio
     *
     * @param laboratorio el parametro se encarga de dar laboratorio al objeto
     * de tipo laboratorio
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }// Cierre del metodo

    /**
     * Método metodo para obtener laboratorio en el caso de que no este creada
     *
     * @return laboratorio
     */
    public Laboratorio getLaboratorio() {
        if (laboratorio == null) {
            laboratorio = new Laboratorio();
        }
        return laboratorio;
    }//Cierre del metodo

    /**
     * Metodo que guarda y lanza una excepcion
     *
     * @return un balor booleano si se realizo el metodo
     */

    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (laboratorio.getId() != null) {
                modificar(laboratorio);
            } else {
                guardar(laboratorio);
            }
            guardar(laboratorio);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del metodo

    /**
     * Metodo que devuelve un objeto de tipo presentacion mediante el nombre
     * dentro sentencia de SQL y lanza una excepcion
     *
     * @param nombre atributo requerido. necesarion para obtencion de la
     * presentacion
     * @return devuelve objeto de tipo presentacion buscado por el nombre en el
     * parametro
     */

    public Laboratorio getLaboratorioNombre(String nombre) {
        Laboratorio r = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Laboratorio p where p.nombre = :nombre");
            q.setParameter("nombre", nombre);
            r = (Laboratorio) q.getSingleResult();
        } catch (Exception e) {
        }
        return r;
    }//Cierre del metodo 

        /**
     * Metodo que devuelve una lista de objetos de tipo laboratorio. Permite la busqueda de laboratorios por nombre
     *
     *
     * @param nombre atributo requerido. necesarion para obtencion de la
     * presentacion
     * @return devuelve una lista de tipo presentacion buscado por el nombre en el
     * parametro
     */
    public List<Laboratorio> buscar(String nombre) {
        List<Laboratorio> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Laboratorio p where"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }//Cierre del metodo

}//Cierre de la clase

