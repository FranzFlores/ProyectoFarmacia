/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Dao;

import modelo.Persona;

/**
 *
 * @author Rodrigo
 */
public class PersonaDao extends AdaptadorDao{
    
    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (persona==null) {
            persona= new Persona();
    
        }return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
