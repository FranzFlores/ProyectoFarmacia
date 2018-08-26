/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;

import lombok.Setter;

/**
 *
 * @author Rodrigo
 */
@Entity
@Getter
@Setter
@Table(name="persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 10,unique=true)
    private String cedula;
    
    @Column(length = 60)
    private String nombre;
    
    @Column(length = 80)
    private String direccion;
    
    @Column(length = 10) 
    private String telefono;

    
    //Entidad Debil(Relacion con Rol)
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_rol")
    private Rol rol;
    
    //Entidad Fuerte(Relacion con Cuenta)
    @OneToOne (cascade = CascadeType.ALL, mappedBy = "persona",fetch = FetchType.LAZY)
    private Cuenta cuenta;
    
    //Entidad Fuerte(Relacion con Factura)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "persona",fetch =FetchType.LAZY)
    private List<Factura> listafactura= new ArrayList<Factura>();
    
    //Entidad Fuerte(Relacion con Lote)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "persona",fetch =FetchType.LAZY)
    private List<Lote> listaLote= new ArrayList<Lote>();
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cliente[ id=" + id + " ]";
    }
    
}
