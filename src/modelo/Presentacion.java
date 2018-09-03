
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
 * La clase  Entity define los atributos que se utilizaran  dentro en la tabla presentacion en la base de datos
 * @author luis villalta
 * @version:14/07/2018
 */
@Entity
@Getter
@Setter
@Table(name = "presentacion")
public class Presentacion implements Serializable {
//Campos de la clase 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 60)
    private String nombre;
    
    //Entidad Fuerte(Relacion con Lote)
    @OneToMany(mappedBy = "presentacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> listaProducto = new ArrayList<>();
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Presentacion[ id=" + id + " ]";
    }
    
}//cierre de la clase Entity
