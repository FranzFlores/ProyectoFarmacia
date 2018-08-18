/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
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
    
    
    
    
}
