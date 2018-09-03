/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Cuenta;

/**
 * Esta clase define el objeto de 'CuentaDao' y sus metodos
 *
 *  * @author Alberto Ortega
 * @version 19/08/2018
 * @see AdaptadorDao
 */
public class CuentaDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Cuenta cuenta;

    /**
     * Constructor por defecto
     *
     * @see AdaptadorDao
     */
    public CuentaDao() {
        super(Cuenta.class);
    }//Cierre del Metodo 

    /**
     * Metodo para obtener una cuenta.En caso de no existir crea una nueva
     * cuenta.
     *
     * @return objeto de tipo cuenta
     */
    public Cuenta getCuenta() {
        if (cuenta == null) {
            cuenta = new Cuenta();

        }
        return cuenta;
    }//Cierre del Metodo 


    
    /**
     * Metodo para fijar un objeto de tipo cuenta
     * 
     * @param cuenta objeto de tipo cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }//Cierre del Metodo 

    /**
     * Metodo guardar, lanza una excepcion
     *
     * @return un boolean si se realiza la operación con exito
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (cuenta.getId() != null) {
                modificar(cuenta);
            } else {
                guardar(cuenta);
            }
            guardar(cuenta);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }//Cierre del Metodo 

    /**
     * Metodo que sirve para iniciar sesion
     *
     * @param usuario El parametro usuario verifica si tiene una cuenta o no
     * @param clave El parametro clave verifica si la clave es correcta
     * @return el inicio de sesion
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        Cuenta c = null;
        try {
            Query q = getManager().createQuery("SELECT c FROM Cuenta c WHERE c.usuario = :user");
            q.setParameter("user", usuario);
            Cuenta aux = (Cuenta) q.getSingleResult();
            if (aux != null && aux.getClave().equals(clave)) {
                c = aux;
            }
        } catch (Exception e) {
        }
        return c;
    } //Cierre del Metodo 

} //Cierre de la clase 
