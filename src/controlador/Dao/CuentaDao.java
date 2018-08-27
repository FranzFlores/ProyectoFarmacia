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
<<<<<<< HEAD
 * @author Luis Villalta
 */
public class CuentaDao extends AdaptadorDao {

    
=======
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see AdaptadorDao
 */
public class CuentaDao extends AdaptadorDao {

    //Atributo privado de la clase
>>>>>>> 638a5501943a696d98a323f672a998f0e4c0f3ae
    private Cuenta cuenta;

    
    /**
 * Constructor por defecto
 * @see AdaptadorDao
 */
    public CuentaDao() {
        super(Cuenta.class);
    }

    /**
     * Metodo para obtener cuenta en el caso de que no exista
     *
     * @return la cuenta
     */
    public Cuenta getCuenta() {
        if (cuenta == null) {
            cuenta = new Cuenta();

        }
        return cuenta;
    }

<<<<<<< HEAD
    /*@Param cuenta   Sirve como metodo setter de la clase cuenta */
=======
    /**
     * Metodo para agregar la cuenta
     *
     * @param cuenta El paramatero cuenta define a cuenta
     */
>>>>>>> 638a5501943a696d98a323f672a998f0e4c0f3ae
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

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
    }

    /**
     * Metodo inicioSesion, sirve para iniciar sesion(valga la redundancia)
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
    }

}
