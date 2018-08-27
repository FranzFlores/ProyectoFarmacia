/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Rol;

/**
 * Esta clase define el objeto de 'RolDao' y sus metodos
 *
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see AdaptadorDao
 */
public class RolDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Rol rol;

    /**
     * Constructor por defecto
     *
     * @see AdaptadorDao
     */
    public RolDao() {
        super(Rol.class);
    }

    
    /**
     * Metodo para obtener rol en el caso de que no exista
     *
     * @return rol
     */
    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();

        }
        return rol;
    }

    
    /**
     * Constructor para agregar la cuenta
     *
     * @param rol El paramatero rol define al rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
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
            if (rol.getId() != null) {
                modificar(rol);
            } else {
                guardar(rol);
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }

    /**
     * Metodo para buscar rol por nombre
     *
     * @param nombre el parametro nombre verifica el nombre
     * @return nombre del rol
     */
    public Rol buscarRolNombre(String nombre) {
        Rol r = null;
        try {
            Query q = getManager().createQuery("SELECT r FROM Rol r where r.nombre = :data");
            q.setParameter("data", nombre);
            r = (Rol) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el rol por nombre " + e);
        }
        return r;
    }

}
