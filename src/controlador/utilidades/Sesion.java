/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utilidades;

import modelo.Cuenta;

/**
 * Esta clase define la sesión 
 * @author Alberto Ortega
 * @version
 */
public class Sesion {

    private static Cuenta cuenta;

    public static Cuenta getCuenta() {
        return cuenta;
    }

    /**
     *@param cuenta. el parámetro cuenta sirve para dar el valor a sesión
     */
    public static void setCuenta(Cuenta cuenta) {
        Sesion.cuenta = cuenta;
    }
}//Cierre de clase
