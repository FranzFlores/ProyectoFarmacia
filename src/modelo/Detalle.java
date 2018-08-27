
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
 * @author lili
 */
@Entity
@Setter
@Getter
@Table(name = "detalle")
public class Detalle implements Serializable {

    //Campos de la clase
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 4)
    private Integer cantidad;
    
    @Column(length =4)
    private Double precioTotal;
    
    @Column(length =4)
    private Double precioUnitario;
    
    //Entidad Debil(Relacion con Lote)
    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "id_lote",nullable = false)
    private Lote lote;
    
    
    //Entidad Debil (Relacion con Factura)
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_factura")
    private Factura factura;



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Detalle[ id=" + id + " ]";
    }

} //Cierre de la clase Entity
