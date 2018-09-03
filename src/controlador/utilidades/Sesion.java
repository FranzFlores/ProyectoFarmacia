
package controlador.utilidades;

import modelo.Cuenta;

/**
 * Clase encargada de la gestion de la cuentas de los  usuarios y el administrador
 * @author Alberto Ortega
 * @version 16/08/2018
 */
public class Sesion {

    //Atributo privado de la clase
    private static Cuenta cuenta;
    
    /**
     * Metodo que devuele un objeto de tipo Cuenta
     *
     * @return Devuele un objeto de tipo Cuenta
     */
    public static Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Metodo que fija un objeto de tipo Cuenta
     *@param cuenta parámetro cuenta sirve para dar el valor a sesión
     */
    public static void setCuenta(Cuenta cuenta) {
        Sesion.cuenta = cuenta;
    }
}//Cierre de clase
