
package controlador.servicio;

import controlador.dao.LaboratorioDao;
import java.util.List;
import modelo.Laboratorio;

/**
 * La clase podra ser usado en la vista.Provee los metodos de la clase
 * LaboratorioDao
 *
 * @author luis villalta
 * @version:18/08/2018
 * @see LaboratorioDao
 */
public class LaboratorioServicio {

    // Campos de la clase
    private LaboratorioDao obj = new LaboratorioDao();

    /**
     * Metodo que obtiene el objeto de tipo Laboratorio.
     *
     * @return Se encarga de obtener el objeto de tipo Laboratorio.
     */
    public Laboratorio getLaboratorio() {
        return obj.getLaboratorio();
    }//Cierre del metodo

    /**
     * Metodo que guarda o modica un objeto de tipo Laboratorio
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */

    public boolean guardar() {
        return obj.guardar();
    }//Cierre del metodo

    /**
     * Metodo que devuelve una lista con objetos de tipo Laboratorio
     *
     * @return Devuelve un objeto de tipo List con todos los objetos de tipo
     * Laboratorio
     */
    public List<Laboratorio> todos() {
        return obj.listar();
    }// Cierre del metodo

    /**
     * Metodo que devuelve un objeto de tipo Laboratorio
     *
     * @param id Se encarga de dar el valor de Id para obtener el objeto
     * @return Devuelve un objeto de tipo Laboratorio mediante el id.
     */
    public Laboratorio obtener(Long id) {
        return (Laboratorio) obj.obtener(id);
    }//Cierre el metodo

    /**
     * Metodo que sirve para fijar un objeto de tipo Laboratorio en la clase
     * Laboratorio del modelo
     *
     * @param laboratorio se encarga de dar el valor de Laboratorio para obtener
     * el Laboratorio
     */

    public void fijarLaboratorio(Laboratorio laboratorio) {
        obj.setLaboratorio(laboratorio);
    }//Cierre del metodo

    /**
     * Metodo que obtiene el objeto de tipo Laboratorio
     *
     * @param nombre atributo requerido. necesarion para obtencion el
     * Laboratorio
     * @return Se encarga de obtener el objeto de tipo Laboratorio
     */
    public Laboratorio getLaboratorioNombre(String nombre) {
        return obj.getLaboratorioNombre(nombre);

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
    public List<Laboratorio> buscar(String nombre){
        return obj.buscar(nombre);
    }//Cierre del metodo

}//Cierre de la clase