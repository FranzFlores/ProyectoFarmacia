/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Detalle;

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
    
}
