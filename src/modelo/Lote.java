
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

/**
 * La clase define los atributos que se usaran en la tabla Lote dentro de la base de datos  
 * @author Franz Flores
 * @version 15/07/2018
 */
@Entity
@Getter
@Setter
@Table(name = "lote")
public class Lote implements Serializable {

    //Campos de la clase
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5)
    private Integer cantidad;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFabricacion;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCompra;

    @Column(length = 10)
    private Double precioUnitario;
    
    @Column(length = 10)
    private Double precioTotal;

    //Entidad Debil(Relacion con Producto) 
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_producto")
    private Producto producto;
    
    //Entidad Debil(Relacion con Persona)
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_persona")
    private Persona persona;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Lote[ id=" + id + " ]";
    }

} //Cierre de la clase Entity
