
package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase Entity define los atributos de 'Rol' que se utilizaran en la base de datos
 *
 * @author Alberto Ortega
 * @version 13/07/2018
 */
@Entity
@Setter
@Getter
@Table(name="rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 60)
    private String nombre;
    
    //Entidad Fuerte (Relacion con Persona)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "rol",fetch =FetchType.LAZY)
    private List<Persona> listaPersona= new ArrayList<Persona>();
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Rol[ id=" + id + " ]";
    }
    
}//Cierre de clase Entity
