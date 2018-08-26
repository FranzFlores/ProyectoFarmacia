/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.CuentaDao;
import java.util.Date;
import java.util.List;
import modelo.Cuenta;

/**
 *
 * @author franzandresflores
 */
public class CuentaServicio {
    
    private CuentaDao obj = new CuentaDao();
    
    public Cuenta getCuenta(){
        return obj.getCuenta();
    }
    
    public boolean guardar(){
        return obj.guardar();
    }
    
    public List<Cuenta> todos(){
        return obj.listar();
    }
    
    public Cuenta obtener(Long id){
        return (Cuenta) obj.obtener(id);
    }
    
    public void fijarCuenta(Cuenta persona){
        obj.setCuenta(persona);
    }
    
    public void crearCuentaAdmin(){
        if (todos().isEmpty()) {
            PersonaServicio persona = new PersonaServicio();
            persona.getPersona().setNombre("Franz Flores");
            persona.getPersona().setCedula("1104015928");
            persona.getPersona().setTelefono("2572310");
            persona.getPersona().setDireccion("Andrés Bello y Juan Jose Peña");
            persona.getPersona().setRol(new RolServicio().buscarRolNombre("Administrador"));
            
            Cuenta c = new Cuenta();
            c.setUsuario("franz");
            c.setClave("franz");
            c.setCreacion(new Date());
            c.setPersona(persona.getPersona());
            persona.getPersona().setCuenta(c);
            persona.guardar();
        }
    }
    
    public Cuenta crearCuenta(String usuario,String clave,PersonaServicio ps){
        Cuenta c = new Cuenta();
        c.setUsuario(usuario);
        c.setClave(clave);
        c.setCreacion(new Date());
        c.setPersona(ps.getPersona());
        return c;
    }
    
    public Cuenta inicioSesion(String usuario, String clave){
        return obj.inicioSesion(usuario, clave);
    }
    
}
