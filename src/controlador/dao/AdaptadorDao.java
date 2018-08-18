/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author franzandresflores
 */
public class AdaptadorDao<T> implements InterfazDao{
    
    private Class clazz;    

    public AdaptadorDao(Class clazz) {
    
        this.clazz = clazz;        
    }
    
    public EntityManager getManager() {
        return Conexion.getManager();
    }

    @Override
    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        try {
            Query query = getManager().createQuery("SELECT a FROM " + clazz.getSimpleName() + " a");
            lista = query.getResultList();
            
        } catch (Exception e) {            
            System.out.println("Error al listar datos " + e);
        }
        return lista;
    }

    @Override
    public T obtener(Long id) {
        T obj = null;
        try {
            obj = (T)getManager().find(clazz, id);
        } catch (Exception e) {
            System.out.println("No se encuentar el identificador id " + e);
        }
        return obj;
    }

    @Override
    public void guardar(Object obj) throws Exception {
      getManager().persist(obj);
    }

    @Override
    public void modificar(Object obj) throws Exception {
       getManager().merge(obj);
    }

   
}
