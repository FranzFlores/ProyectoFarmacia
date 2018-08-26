/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.servicio.FacturaServicio;
import controlador.servicio.LoteServicio;
import java.util.List;
import javax.persistence.Query;
import modelo.Detalle;
import modelo.Factura;
import modelo.Lote;

/**
 *
 * @author franzandresflores
 */
public class DetalleDao extends AdaptadorDao{
    
    private Detalle detalle;
    
    public DetalleDao() {
        super(Detalle.class);
    }
    
    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Detalle getDetalle() {
        if (detalle == null) 
            detalle = new Detalle();        
        return detalle;
    }
    
     public boolean guardar(){
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            guardar(detalle);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }
     
     public Detalle fijarFactura(FacturaServicio factura,Integer cant,Lote lote){
         getDetalle().setFactura(factura.getFactura());
         getDetalle().setCantidad(cant);
         getDetalle().setLote(lote);
         return getDetalle();
     }

     
    
}
