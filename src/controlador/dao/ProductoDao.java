
package controlador.dao;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Producto;

/**
 * La clase se encarga de gestionar la creacion y modificacion de la tabla
 * producto dentro de la base de datos
 * @author Luis Villalta
 * @version:18/08/2018
 * @see AdaptadorDao
 */
public class ProductoDao extends AdaptadorDao{
    
    // Campos de la clase 
    private Producto producto;
    
        /**
     * Constructor para la clase ProductoDao por defecto heredada de la clase
     * AdaptadorDao
     */
    public ProductoDao() {
        super(Producto.class);
    }// Cierre del constructor
    
        /**
     * Metodo que brinda el producto al objeto de tipo producto
     * @param producto el parametro se encarga de dar producto al objeto de tipo
     * producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }// Cierre del metodo 

         /**
     * Método metodo para obtener producto en el caso de que no este creada
     *
     * @return producto
     */
    public Producto getProducto() {
        if (producto == null) 
            producto = new Producto();        
        return producto;
    } // Cierre del metodo
    
        /**
     * Método metodo que compara si el precio es igual a 0
     * @return se encarga de obtener el precio
     */
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
    }//Cierre del metodo
    
    
        /**
     * Metodo que obtiene el objeto de tipo Producto
     *
     * @param nombre atributo requerido. necesarion para obtencion el Producto
     * @return Se encarga de obtener el objeto de tipoproducto
     */
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
    }//Cierre del metodo

    
} //Cierre de la clase 
