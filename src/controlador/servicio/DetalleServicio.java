/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.DetalleDao;
import java.util.List;
import modelo.Detalle;
import modelo.Factura;
import modelo.Lote;

/**
 *
 * @author franzandresflores
 */
public class DetalleServicio {
    
    private DetalleDao obj = new DetalleDao();
    
    public Detalle getDetalle(){
        return obj.getDetalle();
    }
    
    public boolean guardar(){
        return obj.guardar();
    }
    
    public List<Detalle> todos(){
        return obj.listar();
    }
    
    public Detalle obtener(Long id){
        return (Detalle) obj.obtener(id);
    }
    
    public void fijarDetalle(Detalle persona){
        obj.setDetalle(persona);
    }
    
    public Detalle fijarFactura(FacturaServicio factura,Integer cant,Lote lote){
        return obj.fijarFactura(factura, cant, lote);
    }
    
    
}
