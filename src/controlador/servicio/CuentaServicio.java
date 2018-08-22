/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.CuentaDao;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
            persona.getPersona().setApellidos("Jaramillo");
            persona.getPersona().setNombres("Daniela");
            persona.getPersona().setCedula("1111111111");
            persona.getPersona().setTelefono("2561482");
            persona.getPersona().setDireccion("Av. Siempre Viva");
            persona.getPersona().setExternal_id(UUID.randomUUID().toString());
            persona.getPersona().setRol(new RolServicio().buscarRolNombre("Administrador"));
            
            Cuenta c = new Cuenta();
            c.setUsuario("admin");
            c.setClave("pass");
            c.setCreacion(new Date());
            c.setEdicion(new Date());
            c.setExternal_id(UUID.randomUUID().toString());
            c.setPersona(persona.getPersona());
            persona.getPersona().setCuenta(c);
            persona.guardar();
        }
    }
    
    public Cuenta inicioSesion(String usuario, String clave){
        return obj.inicioSesion(usuario, clave);
    }
    
}
