/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;


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
    
    
}
