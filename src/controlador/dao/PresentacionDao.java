/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Presentacion;

/**
 *
 * @author franzandresflores
 */
public class PresentacionDao extends AdaptadorDao {

    private Presentacion presentacion;

    public PresentacionDao() {
        super(Presentacion.class);
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Presentacion getPresentacion() {
        if (presentacion == null) {
            presentacion = new Presentacion();
        }
        return presentacion;
    }

    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (presentacion.getId() != null) {
                modificar(presentacion);
            } else {
                guardar(presentacion);
            }
            guardar(presentacion);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }

    public Presentacion getPresentacionNombre(String nombre) {
        Presentacion r = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where p.nombre = :nombre");
            q.setParameter("nombre", nombre);
            r = (Presentacion) q.getSingleResult();
        } catch (Exception e) {
        }
        return r;
    }
    
    public List<Presentacion> buscar(String nombre){
        List<Presentacion> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;        
    }
    
    
    public Presentacion buscarNombre(String nombre){
        Presentacion r = null;
        try {
            Query q = getManager().createQuery("SELECT r FROM Presentacion r where r.nombre = :data");
            q.setParameter("data", nombre);
            r = (Presentacion) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encontrar la presentacion" + e);
        }
        return r;
    }

}
