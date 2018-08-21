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
    
    public List<Persona> listaSinAdministrador(){
        return obj.listaSinAdministrador();
    }
    
    public Persona getPersonaCedula(String cedula){
        return obj.getPersonaCedula(cedula);
    }
    
    public List<Persona> listaSinAdministradorTipo(String tipo){
        return obj.listaSinAdministradorTipo(tipo);
    }
    
    public List<Persona> listaSinAdministradorLike(String texto){
        return obj.listaSinAdministradorLike(texto);
    }
    
    public List<Persona> listaSinAdministradorTipoLike(String tipo,String texto){ 
        return obj.listaSinAdministradorTipoLike(tipo, texto);
    }
    
    
    
}
