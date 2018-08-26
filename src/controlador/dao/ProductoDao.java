/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Producto;

/**
 *
 * @author franzandresflores
 */
public class ProductoDao extends AdaptadorDao{
    
    private Producto producto;
    
    public ProductoDao() {
        super(Producto.class);
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        if (producto == null) 
            producto = new Producto();        
        return producto;
    }
    
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (producto.getId() != null) {
                modificar(producto);
            } else {
                guardar(producto);
            }
            guardar(producto);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }
    
    public List<Producto> buscar(String nombre) {
        List<Producto> lista = new ArrayList<>();
        try {
            Query q = getManager().createQuery("SELECT p FROM Producto p WHERE"
                    + "(lower(p.nombre) LIKE CONCAT(:texto,'%'))");
            q.setParameter("texto",nombre);
            lista = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    
    
    
    
}
