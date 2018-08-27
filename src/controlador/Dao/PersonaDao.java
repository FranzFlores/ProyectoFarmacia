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
public class PersonaDao extends AdaptadorDao {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (persona.getId() != null) {
                modificar(persona);
            } else {
                guardar(persona);
            }
            guardar(persona);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    public Persona getPersonaCedula(String cedula) {
        Persona p = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where p.cedula = :ced");
            q.setParameter("ced", cedula);
            p = (Persona) q.getSingleResult();
        } catch (Exception e) {
        }
        return p;
    }
    
    //=======================================Cliente=======================================
    List<Persona> lista = new ArrayList<>();
    public List<Persona> listaCliente() {
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :nombre");
            q.setParameter("nombre", "Cliente");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Persona> buscarClienteCedula(String cedula){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :nombre"
                    + " and p.cedula = :cedula");
            q.setParameter("nombre", "Cliente");
            q.setParameter("cedula", cedula);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Persona> buscarClienteNombre(String nombre){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //=======================================Proveedor=======================================
       
    public List<Persona> listaProveedor() {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre = :nombre");
            q.setParameter("nombre", "Proveedor");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    public List<Persona> buscarProveedorCedula(String cedula) {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :nombre"
                    + " and p.cedula = :cedula");
            q.setParameter("nombre", "Proveedor");
            q.setParameter("cedula", cedula);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Persona> buscarProveedorNombre(String nombre){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :rol"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("rol", "Proveedor");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    //=======================================Usuario=======================================
    
    
    public List<Persona> listaUsuario() {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre = :nombre "
                    + " or p.rol.nombre = :nombre2");
            q.setParameter("nombre", "Usuario");
            q.setParameter("nombre2", "Administrador");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    public List<Persona> buscarUsuarioCedula(String cedula) {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :nombre"
                    + " and p.cedula = :cedula");
            q.setParameter("nombre", "Usuario");
            q.setParameter("cedula", cedula);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<Persona> buscarUsuarioNombre(String nombre){
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :rol"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("rol", "Usuario");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
