package controlador;

import controlador.servicio.CuentaServicio;
import controlador.servicio.RolServicio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * La clase contiene metodos para conectar con la base de datos
 *
 * @author Franz Flores
 * @version 16/08/2018
 */
public class Conexion {

    //Atributos privados de la clase
    private static EntityManager manager;
    private static final String NAME_EMPU = "ProyectoFarmaciaPU";

    /**
     * Metodo encargado de crear un objeto de la clase EntityManagerFactory que
     * lo vincula con la persistencia del proyecto
     *
     * @return Devuelve el objeto de la clase  EntityManagerFactory 
     */
    public static EntityManagerFactory sesion() {
        return Persistence.createEntityManagerFactory(NAME_EMPU);
    }

    /**
     * Metodo encargado de crear un objeto de la clase EntityManager que se asocia
     * con el objeto  la clase EntityManagerFactory
     * @return Devuelve el objeto de la clase EntityManager asociado con la clase  EntityManagerFactory 
     */
    public static EntityManager getManager() {
        if (manager == null) {
            manager = sesion().createEntityManager();
        }
        return manager;
    }

    
    public static void main(String[] args) {
        new RolServicio().crearRoles();
        new CuentaServicio().crearCuentaAdmin();
    }

} //Cierre de la clase
