package controlador.dao;

import controlador.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * La clase contiene metodos para poder realizar la gestion y el almacenamiento
 * de los objetos en sus respectivas tablas en la base de datos
 *
 * @author Franz Flores
 * @version 16/08/2018
 * @param <T> Acepta objetos de cualquier tipo
 */
public class AdaptadorDao<T> implements InterfazDao {

    //Atributo privado de la clase
    private final Class clazz;

    /**
     * Constructor de la clase ADaptadorDao. inicializa el atributo privado de
     * la clase
     *
     * @param clazz objetos que sirve para asignar al atributo de la clase
     */
    public AdaptadorDao(Class clazz) {

        this.clazz = clazz;
    }//Cierre del constructor 

    /**
     * Metodo que sirve como conexion entre JPA y la base de datos.
     *
     * @return Devuelve el objeto creado de la clase EntityManager
     */
    public EntityManager getManager() {
        return Conexion.getManager();
    }//Cierre del metodo 

    /**
     * Metodo que sirve para listar los objetos de una determinada clase
     * almacenada en un tabla de la base de datos.
     *
     * @return Devuelve la lista de objetos que se guardaron en la base de
     * datos.
     */
    @Override
    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        try {
            Query query = getManager().createQuery("SELECT a FROM " + clazz.getSimpleName() + " a");
            lista = query.getResultList();

        } catch (Exception e) {
            System.out.println("Error al listar datos " + e);
        }
        return lista;
    } //Cierre del metodo

    /**
     * Metodo que sirve para obtener un objeto de una tabla de la base de datos
     * mediante el id
     *
     * @return Devuelve un objeto de una tabla de la base de datos por el id
     */
    @Override
    public T obtener(Long id) {
        T obj = null;
        try {
            obj = (T) getManager().find(clazz, id);
        } catch (Exception e) {
            System.out.println("No se encuentar el identificador id " + e);
        }
        return obj;
    } //Cierre del metodo

    /**
     * Metodo encargado de guardar un objeto de una determinada clase en una
     * tabla de la base de datos
     *
     */
    @Override
    public void guardar(Object obj) throws Exception {
        getManager().persist(obj);
    } //Cierre del metodo

    /**
     * Metodo encargado de modificar un objeto de una determinada clase en una
     * tabla de la base de datos
     *
     */
    @Override
    public void modificar(Object obj) throws Exception {
        getManager().merge(obj);
    } //Cierre del metodo

} //Cierre de la clase
