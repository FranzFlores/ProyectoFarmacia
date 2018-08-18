/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Factura;

/**
 *
 * @author franzandresflores
 */
public class FacturaDao extends AdaptadorDao{
    
    private Factura factura;
    
    public FacturaDao() {
        super(Factura.class);
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Factura getFactura() {
        if (factura == null) 
            factura = new Factura();        
        return factura;
    }
    
}
