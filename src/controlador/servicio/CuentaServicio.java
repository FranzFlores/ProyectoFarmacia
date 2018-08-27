/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.CuentaDao;
import java.util.Date;
import java.util.List;
import modelo.Cuenta;

/**
 * Metodos de las clases de CuentaDao, la clase se usará en DlgCuenta
 *
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see CuentaDao
 */
public class CuentaServicio {

    //Objeto privado de CuentaDao
    private CuentaDao obj = new CuentaDao();

    /**
     * Metodo que obtiene cuenta
     *
     * @return objeto de tipo cuenta
     */
    public Cuenta getCuenta() {
        return obj.getCuenta();
    }//cierre de metodo

    /**
     * Metodo guardar
     *
     * @return objeto de tipo guardar
     */
    public boolean guardar() {
        return obj.guardar();
    }//cierre de metodo

    /**
     * Metodo listar para todas las cuentas
     *
     * @return objeto de tipo listar
     */
    public List<Cuenta> todos() {
        return obj.listar();
    }//cierre de metodo

    /**
     * Metodo que obtiene cuenta
     *
     * @param id El parametro es de tipo cuenta
     * @return el objeto de tipo obtener con Casting de cuenta
     */
    public Cuenta obtener(Long id) {
        return (Cuenta) obj.obtener(id);
    }//cierre de metodo

    /**
     * Metodo para fijar cuenta
     *
     * @param persona El parametro es de tipo cuenta
     */
    public void fijarCuenta(Cuenta persona) {
        obj.setCuenta(persona);
    }//cierre de metodo

    /**
     * Metodo para crear Cuenta del Administrador
     */
    public void crearCuentaAdmin() {
        if (todos().isEmpty()) {
            PersonaServicio persona = new PersonaServicio();
            persona.getPersona().setNombre("Franz Flores");
            persona.getPersona().setCedula("1104015928");
            persona.getPersona().setTelefono("2572310");
            persona.getPersona().setDireccion("Andrés Bello y Juan Jose Peña");
            persona.getPersona().setRol(new RolServicio().buscarRolNombre("Administrador"));

            Cuenta c = new Cuenta();
            c.setUsuario("franz");
            c.setClave("franz");
            c.setCreacion(new Date());
            c.setPersona(persona.getPersona());
            persona.getPersona().setCuenta(c);
            persona.guardar();
        }
    }//cierre de metodo

    /**
     * Metodo para crear cuenta
     *
     * @param usuario El parametro usuario agrega nombre al usuario
     * @param clave El parametro clave agrega una clave al usuario
     * @param ps El parametro es de tipo Persona Servicio
     * @return cuenta
     */
    public Cuenta crearCuenta(String usuario, String clave, PersonaServicio ps) {
        Cuenta c = new Cuenta();
        c.setUsuario(usuario);
        c.setClave(clave);
        c.setCreacion(new Date());
        c.setPersona(ps.getPersona());
        return c;
    }//cierre de metodo

    /**
     * Metodo para iniciar sesion
     *
     * @param usuario
     * @param clave
     * @return el objeto de tipo inicioSesion
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        return obj.inicioSesion(usuario, clave);
    }//cierre de metodo

}//cierre de clase
