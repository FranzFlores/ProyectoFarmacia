/*
    Clase del modelo que tiene los datos de la factura
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.*;

/**
 *
 * @author franzandresflores
 */
@Entity
@Setter
@Getter
@Table(name = "factura")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    @Column(length = 10)
    private Double descuento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEmision;
    
    @Column(length = 10)
    private Double iva;
    
    @Column(length = 10)
    private Double precioFinal;
    
    @Column(length = 10)
    private Double subTotal;

//  Entidad Debil (Relacion con Persona)
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_persona")
    private Persona persona;

//  Entidad Fuerte (Relacion con Detalle)
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Detalle> listaDetalle = new ArrayList<>();
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "model.Factura[ id=" + id + " ]";
    }
    
}
