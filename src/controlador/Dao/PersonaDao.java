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
 * Esta clase define el objeto de 'PersonaDao' y sus metodos
 *
 * @author Alberto Ortega
 * @version 19/08/2018
 * @see AdaptadorDao
 */
public class PersonaDao extends AdaptadorDao {

    //Atributo privado de la clase
    private Persona persona;

    /**
     * Constructor por defecto
     *
     * @see AdaptadorDao
     */
    public PersonaDao() {
        super(Persona.class);
    }

    /**
     * Metodo guardar, lanza una excepcion
     *
     * @return un boolean si se realiza la operacion con exito
     */
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

    /**
     * Metodo para obtener persona en el caso de que no exista
     *
     * @return persona
     */
    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    /**
     * Constructor para agregar la cuenta
     *
     * @param persona El parametro persona define a persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo para obtener la cedula
     *
     * @param cedula el parametro cedula verifica la cedula
     * @return cedula
     */
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
    /**
     * Metodo para verificar el nombre con la cedula
     *
     * @return lista de clientes
     */
    public List<Persona> listaCliente() {
        List<Persona> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p WHERE p.rol.nombre  = :nombre");
            q.setParameter("nombre", "Cliente");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }

    /**
     * Metodo para buscar cliente por cedula
     *
     * @param cedula el parametro cedula verifica la cedula
     * @return numero de cedula del cliente deseado
     */
    public List<Persona> buscarClienteCedula(String cedula) {
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

    /**
     * Metodo para buscar cliente por nombre
     *
     * @param nombre el parametro nombre verifica el nombre
     * @return numero el nombre del cliente
     */
    public List<Persona> buscarClienteNombre(String nombre) {
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
    /**
     * Metodo para listar Proveedores
     *
     * @return lista de proveedores
     */
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

    /**
     * Metodo para buscar al Proveedor por su cedula
     *
     * @param cedula el parametro cedula verifica la cedula
     * @return cedula del proveedor
     */
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

    /**
     * Metodo para buscar Proveedor por nombre
     *
     * @param nombre el parametro nombre verifica el nombre
     * @return nombre del proveedor
     */
    public List<Persona> buscarProveedorNombre(String nombre) {
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
    /**
     * Metodo para listar Usuario
     *
     * @return lista de usuarios
     */
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

    /**
     * Metodo para buscar usuario por cedula
     *
     * @param cedula el parametro cedula verifica la cedula
     * @return cedula del usuario
     */
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

    /**
     * Método para buscar usuario por nombre
     *
     * @param nombre el parametro nombre verifica el nombre
     * @return nombre del usuario
     */
    public List<Persona> buscarUsuarioNombre(String nombre) {
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
