
package controlador.servicio;

import controlador.dao.PresentacionDao;
import java.util.List;
import modelo.Presentacion;

/**
 * La clase podra ser usado en la vista.Provee los metodos de la clase
 * PresentacionDao
 *
 * @author luis villalta
 * @version:18/08/2018
 * @see PresentacionDao
 */
public class PresentacionServicio {

    //Campos de la clase
    private PresentacionDao obj = new PresentacionDao();

    /**
     * Metodo que obtiene el objeto de tipo Presentacion.
     *
     * @return Se encarga de obtener el objeto de tipo Presentacion.
     */
    public Presentacion getPresentacion() {
        return obj.getPresentacion();
    }//Cierre del metodo

    /**
     * Metodo que guarda o modica un objeto de tipo Presentacion
     *
     * @return Devuelve true si la operacion de guardar se ha realizado con
     * exito.
     */

    public boolean guardar() {
        return obj.guardar();
    }//Cierre del metodo

    /**
     * Metodo que devuelve una lista con objetos de tipo Presentacion
     *
     * @return Devuelve un objeto de tipo List con todos los objetos de tipo
     * Presentacion
     */

    public List<Presentacion> todos() {
        return obj.listar();
    }//Cierre del metodo

    /**
     * Metodo que devuelve un objeto de tipo Presentacion
     *
     * @param id Se encarga de dar el valor de Id para obtener el objeto
     * @return Devuelve un objeto de tipo Presentacion mediante el id.
     */
    public Presentacion obtener(Long id) {
        return (Presentacion) obj.obtener(id);
    }//Cierre del metodo

    /**
     * Metodo que sirve para fijar un objeto de tipo Presentacion en la clase
     * Presentacion del modelo
     *
     * @param presentacion se encarga de dar el valor de presentacion para
     * obtener la Presentacion
     */

    public void fijarPresentacion(Presentacion presentacion) {
        obj.setPresentacion(presentacion);
    }//Cierre del metodo

    /**
     * Metodo que obtiene el objeto de tipo Presentacion.
     *
     * @param nombre atributo requerido. necesarion para obtencion el
     * Presentacion
     * @return Se encarga de obtener el objeto de tipo Presentacion.
     */

    public Presentacion getPresentacionNombre(String nombre) {
        return obj.getPresentacionNombre(nombre);

    }//Cierre del metodo

//    public void crearPresentacion(String presentacion){
//        getPresentacion().setNombre(presentacion);
//        guardar();
//        fijarPresentacion(null);
//    }


    
    
     public List<Presentacion> buscar(String nombre){
         return obj.buscar(nombre);
     }
    
     public Presentacion buscarNombre(String nombre){
         return obj.buscarNombre(nombre);
     }

}//Cierre de la clase 


