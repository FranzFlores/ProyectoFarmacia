/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author Rodrigo
 */
public class PersonaDao extends AdaptadorDao{
    
       private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }
    
    public boolean guardar(){
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (persona.getId() != null) 
                modificar(persona);
            else
                guardar(persona);
            guardar(persona);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }

    public Persona getPersona() {
        if (persona == null) 
            persona = new Persona();        
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public List<Persona> listaSinAdministrador(){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  != :nombre");
            q.setParameter("nombre", "Administrador");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Persona> listaSinAdministradorTipo(String tipo){ //Tipo es el rol
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  != :nombre and p.rol.nombre = :tipo");
            q.setParameter("nombre", "Administrador");
            q.setParameter("tipo", tipo);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public Persona getPersonaCedula(String cedula){
        Persona p = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where p.cedula = :ced");
            q.setParameter("ced", cedula);
            p = (Persona)q.getSingleResult();
        }catch (Exception e) {
        }
        return p;
    }
    
    
    public List<Persona> listaSinAdministradorLike(String texto){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  != :nombre "
                    + "and (lower(p.apellidos) LIKE CONCAT(:texto,'%'))");
            q.setParameter("nombre", "Administrador");
            q.setParameter("texto", texto);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
//        public List<Persona> listaSinAdministradorTipoLike(String tipo,String texto){ //Tipo es el rol
//        List<Persona> lista = new ArrayList<>();
//        try {
//            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE "
//                    + "p.rol.nombre  != :nombre "
//                    + "and p.rol.nombre = :tipo"
//                    + "and (lower(p.apellidos) LIKE CONCAT(:texto,'%'))");
//            q.setParameter("nombre", "Administrador");
//            q.setParameter("tipo", tipo);
//            q.setParameter("texto", texto);
//            lista = q.getResultList();
//        } catch (Exception e) {
//        }
//        return lista;
//    }
    

    
}
