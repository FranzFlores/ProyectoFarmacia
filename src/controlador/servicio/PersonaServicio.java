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
 *
 * @author franzandresflores
 */
public class PersonaServicio {
    
    private PersonaDao obj = new PersonaDao();
    
    public Persona getPersona(){
        return obj.getPersona();
    }
    
    public boolean guardar(){
        return obj.guardar();
    }
    
    public List<Persona> todos(){
        return obj.listar();
    }
    
    public Persona obtener(Long id){
        return (Persona) obj.obtener(id);
    }
    
    public void fijarPersona(Persona persona){
        obj.setPersona(persona);
    }
   
    public List<Persona> listaCliente() {
        return obj.listaCliente();
    }
    
    public List<Persona> buscarClienteCedula(String cedula){
         return obj.buscarClienteCedula(cedula);
    }
    
    public List<Persona> buscarClienteNombre(String nombre){
        return obj.buscarClienteNombre(nombre);
    }
    
    public List<Persona> listaProveedor() {
        return obj.listaProveedor();
    }
    
    public List<Persona> buscarProveedorCedula(String cedula){
        return obj.buscarProveedorCedula(cedula);
    }
    
    public List<Persona> buscarProveedorNombre(String nombre){
        return obj.buscarProveedorNombre(nombre);
    }
    
    public List<Persona> listaUsuario() {
        return obj.listaUsuario();
    }
    
    public List<Persona> buscarUsuarioCedula(String cedula) {
        return obj.buscarClienteCedula(cedula);
    }
    
    public List<Persona> buscarUsuarioNombre(String nombre){
        return obj.buscarClienteNombre(nombre);
    }
    
    
    public Persona getPersonaCedula(String cedula){
        return obj.getPersonaCedula(cedula);
    }

    

    

    
    
    
    
}
