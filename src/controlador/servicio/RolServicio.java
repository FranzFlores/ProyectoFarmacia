/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.RolDao;
import java.util.List;
import modelo.Rol;

/**
 * Metodos de las clases de RolDao
 *
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see RolDao
 */
public class RolServicio {
    
    //Objeto privado de RolDao
    private RolDao obj = new RolDao();
    
    
    /**
     * Metodo que obtiene rol
     *
     * @return objeto de tipo rol
     */
    public Rol getRol(){
        return obj.getRol();
    }//cierre de metodo
    
     /**
     * Metodo guardar
     *
     * @return objeto de tipo guardar
     */
    public boolean guardar(){
        return obj.guardar();
    }//cierre de metodo
    
    /**
     * Metodo listar todos
     *
     * @return objeto de tipo listar
     */
    public List<Rol> todos(){
        return obj.listar();
    }//cierre de metodo
    
    /**
     * Metodo para obtener id
     *@param id  Id del rol que se desea buscar
     * @return objeto de tipo obtener
     */
    public Rol obtener(Long id){
        return (Rol) obj.obtener(id);
    }//cierre de metodo
    
    /**
     * Metodo para fijar el rol
     *@param rol Objeto que se fijara en el objeto de tipo Rol
     */
    public void fijarRol(Rol rol){
        obj.setRol(rol);
    }//cierre de metodo
    
    /**
     * Metodo buscar el rol por nombre
     *@param nombre Nombre del rol que se desea buscar
     * @return objeto de tipo nombre
     */
    public Rol buscarRolNombre(String nombre){
        return obj.buscarRolNombre(nombre);
    }//cierre de metodo
    
    /**
     * Metodo para crear roles
     */
    public void crearRoles(){
        if(obj.listar().isEmpty()){
            getRol().setNombre("Administrador");
            guardar();
            fijarRol(null);
            
            getRol().setNombre("Cliente");
            guardar();
            fijarRol(null);
            
            getRol().setNombre("Usuario");
            guardar();
            fijarRol(null);
            
            getRol().setNombre("Proveedor");
            guardar();
            fijarRol(null);
        }
    }//cierre de metodo
}//cierre de clase
