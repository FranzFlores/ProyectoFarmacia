
package controlador.dao;

import java.util.List;

/**
 * Esta Interfaz Generica define los metodos que se deben implementar dentro del
 * 'AdaptadorDao'
 *
 * @author Alberto Ortega
 * @param <T> La Interfaz es de Tipo Generica
 */
public interface InterfazDao<T> {

    /**
     * Metodo para guardar los objetos y lanzar una excepcion
     * @param obj Objeto de cualquier tipo
     * @throws java.lang.Exception Lanza una exception en caso de no encontrar al objeto que se desea guardar.
     */
    public void guardar(T obj) throws Exception;

    /**
     * Metodo para modificar los objetos y lanzar una excepcion
     * @param obj Objeto de cualquier tipo
     * @throws java.lang.Exception Lanza una exception en caso de no encontrar al objeto que se desea modificar.
     */
    public void modificar(T obj) throws Exception;

    /**
     * Metodo para listar los objetos y me devuelve una lista
     * @return  Retorna una lista de objetos de la clase usada.
     */
    public List<T> listar();

    /**
     * Metodo para obtener el id
     * @param id Asigna el id al objeto de la clase
     * @return Retorna un objeto de la clase
     */
    public T obtener(Long id);

}//Cierre de la Interfaz Generica
