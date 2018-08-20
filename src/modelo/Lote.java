/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Lili
 */
@Entity
@Table(name = "Lote")
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  @Column(length =10)
    private Integer cantidad;

  @Column(length =10)
    private Integer codigo;

  @Column(length =10)
    private Double descuento;

  @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fabricacion;
    
  @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_vencimiento;
    
  @Column(length =40)
    private String lugar_fabricacion;
    
  @Column(length =40)
    private String numero_factura;
    
  @Column(length =10)
    private Double precio_compra;
    
  @Column(length =40)
    private String proovedor;
    
//  entidad débil con Detalle
  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
  @JoinColumn(referencedColumnName = "id", name = "id_inmueble", nullable = false)
  private Detalle detalle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
    
}
