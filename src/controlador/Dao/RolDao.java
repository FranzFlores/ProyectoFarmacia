/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Rol;

/**
 *
 * @author Rodrigo
 */
public class RolDao extends AdaptadorDao{
    private Rol rol;

    public RolDao() {
        super(Rol.class);
    }

    public Rol getRol() {
        if (rol==null) {
            rol= new Rol();
    
        }return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
