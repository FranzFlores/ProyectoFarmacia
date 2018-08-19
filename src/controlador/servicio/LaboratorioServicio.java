/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.LaboratorioDao;
import java.util.List;
import modelo.Laboratorio;

/**
 *
 * @author franzandresflores
 */
public class LaboratorioServicio {
    
    private LaboratorioDao obj = new LaboratorioDao();
    
    public Laboratorio getLaboratorio(){
        return obj.getLaboratorio();
    }
    
    public boolean guardar(){
        return obj.guardar();
    }
    
    public List<Laboratorio> todos(){
        return obj.listar();
    }
    
    public Laboratorio obtener(Long id){
        return (Laboratorio) obj.obtener(id);
    }
    
    public void fijarLaboratorio(Laboratorio laboratorio){
        obj.setLaboratorio(laboratorio);
    }
    
    public Laboratorio getLaboratorioNombre(String nombre){
        return obj.getLaboratorioNombre(nombre);
    }
    
//    public void crearLaboratorio(String laboratorio){
//        getLaboratorio().setNombre(laboratorio);
//        guardar();
//        fijarLaboratorio(null);
//    }
    
    
    
}
