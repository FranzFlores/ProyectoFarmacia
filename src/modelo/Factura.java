/*
    Clase del modelo que tiene los datos de la factura
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

/**
 *
 * @author franzandresflores
 */
@Entity
@Setter
@Getter
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150)
    private String client; //Cliente OJO tiene que ser de tipo Persona
    @Column(length = 10)
    private Double subtotal; //Subtotal
    @Column(length = 10)
    private Double iva; //IVA
    @Column(length = 10)
    private Double discount; //Descuento
    @Column(length = 10)
    private Double total; //Total
    
    
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
