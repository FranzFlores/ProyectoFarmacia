/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Laboratorio;
import modelo.Laboratorio;

/**
 *
 * @author franzandresflores
 */
public class LaboratorioDao extends AdaptadorDao{
    
    private Laboratorio laboratorio;
    
    public LaboratorioDao() {
        super(Laboratorio.class);
    }
    
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Laboratorio getLaboratorio() {
        if (laboratorio == null) 
            laboratorio = new Laboratorio();        
        return laboratorio;
    }
    
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (laboratorio.getId() != null) {
                modificar(laboratorio);
            } else {
                guardar(laboratorio);
            }
            guardar(laboratorio);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }

    public Laboratorio getLaboratorioNombre(String nombre) {
        Laboratorio r = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Laboratorio p where p.nombre = :nombre");
            q.setParameter("nombre", nombre);
            r = (Laboratorio) q.getSingleResult();
        } catch (Exception e) {
        }
        return r;
    }
    
        public List<Laboratorio> buscar(String nombre){
        List<Laboratorio> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Persona p where"
                    + " (lower(p.nombre) LIKE CONCAT(:nombre,'%'))");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;        
    }
    
    
}
