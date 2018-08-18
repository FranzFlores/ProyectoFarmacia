/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Presentacion;

/**
 *
 * @author franzandresflores
 */
public class PresentacionDao extends AdaptadorDao{
    
    private Presentacion presentacion;
    
    public PresentacionDao() {
        super(Presentacion.class);
    }
    
    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public Presentacion getPresentacion() {
        if (presentacion == null) 
            presentacion = new Presentacion();        
        return presentacion;
    }
    
}
