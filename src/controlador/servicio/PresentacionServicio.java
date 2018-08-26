/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.PresentacionDao;
import java.util.List;
import modelo.Presentacion;

/**
 *
 * @author franzandresflores
 */
public class PresentacionServicio {
    
    private PresentacionDao obj = new PresentacionDao();
    
    public Presentacion getPresentacion(){
        return obj.getPresentacion();
    }
    
    public boolean guardar(){
        return obj.guardar();
    }
    
    public List<Presentacion> todos(){
        return obj.listar();
    }
    
    public Presentacion obtener(Long id){
        return (Presentacion) obj.obtener(id);
    }
    
    public void fijarPresentacion(Presentacion presentacion){
        obj.setPresentacion(presentacion);
    }
    
    public Presentacion getPresentacionNombre(String nombre){
        return obj.getPresentacionNombre(nombre);
    }
    
     public List<Presentacion> buscar(String nombre){
         return obj.buscar(nombre);
     }
    
     public Presentacion buscarNombre(String nombre){
         return obj.buscarNombre(nombre);
     }
     
    
    
}
