/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.PersonaDao;
import java.util.List;
import modelo.Persona;

/**
 * Metodos de las clases de PersonaDao
 *
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see PersonaDao
 */
public class PersonaServicio {

    //Objeto privado de PersonaDao
    private PersonaDao obj = new PersonaDao();

    /**
     * Metodo que obtiene persona
     *
     * @return objeto de tipo persona
     */
    public Persona getPersona() {
        return obj.getPersona();
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
    public List<Persona> todos() {
        return obj.listar();
    }//cierre de metodo

    /**
     * Metodo que obtiene cuenta
     *
     * @param id El parametro es de tipo cuenta
     * @return el objeto de tipo obtener con Casting de cuenta
     */
    public Persona obtener(Long id) {
        return (Persona) obj.obtener(id);
    }//cierre de metodo

    /**
     * Metodo para fijar persona
     *
     * @param persona El parametro es de tipo persona
     */
    public void fijarPersona(Persona persona) {
        obj.setPersona(persona);
    }//cierre de metodo

    /**
     * Metodo para listar clientes
     *
     * @return objeto de tipo listar cliente
     */
    public List<Persona> listaCliente() {
        return obj.listaCliente();
    }//cierre de metodo

    /**
     * Metodo para buscar Cliente por cedula
     *
     * @param cedula
     * @return objeto de tipo Cedula
     */
    public List<Persona> buscarClienteCedula(String cedula) {
        return obj.buscarClienteCedula(cedula);
    }//cierre de metodo

    /**
     * Metodo para buscar Cliente por nombre
     *
     * @param nombre
     * @return objeto de tipo Nombre
     */
    public List<Persona> buscarClienteNombre(String nombre) {
        return obj.buscarClienteNombre(nombre);
    }//cierre de metodo

    /**
     * Metodo para listar proveedores
     *
     * @return objeto de tipo listar proveedores
     */
    public List<Persona> listaProveedor() {
        return obj.listaProveedor();
    }//cierre de metodo

    /**
     * Metodo para buscar proveedor por cedula
     *
     * @param cedula
     * @return objeto de tipo Cedula
     */
    public List<Persona> buscarProveedorCedula(String cedula) {
        return obj.buscarProveedorCedula(cedula);
    }//cierre de metodo

    /**
     * Metodo para buscar proveedor por nombre
     *
     * @param nombre
     * @return objeto de tipo Nombre
     */
    public List<Persona> buscarProveedorNombre(String nombre) {
        return obj.buscarProveedorNombre(nombre);
    }//cierre de metodo

    /**
     * Metodo para listar usuario
     *
     * @return objeto de tipo Usuario
     */
    public List<Persona> listaUsuario() {
        return obj.listaUsuario();
    }//cierre de metodo

    /**
     * Metodo para buscar usuario por cedula
     *
     * @param cedula
     * @return objeto de tipo Cedula
     */
    public List<Persona> buscarUsuarioCedula(String cedula) {
        return obj.buscarClienteCedula(cedula);
    }//cierre de metodo

    /**
     * Metodo para buscar usuario por nombre
     *
     * @param nombre
     * @return objeto de tipo Nombre
     */
    public List<Persona> buscarUsuarioNombre(String nombre) {
        return obj.buscarClienteNombre(nombre);
    }//cierre de metodo

    /**
     * Metodo para obtener cedula de la persona
     *
     * @param cedula
     * @return objeto de tipo Cedula
     */
    public Persona getPersonaCedula(String cedula) {
        return obj.getPersonaCedula(cedula);
    }//cierre de metodo

}//cierre de clase
