/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Lili
 */
@Entity
@Table(name = "lote")
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5)
    private Integer cantidad;

    @Column(length = 60)
    private Integer nombre;

 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFabricacion;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(length = 40)
    private String numero_factura;

    @Column(length = 10)
    private Double precio_compra;
    
    //Entidad Fuerte(Relacion con Producto)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "lote",fetch =FetchType.LAZY)
    private List<Producto> listaProducto= new ArrayList<Producto>();
    

    //Entidad Debil(Relacion con Persona) //Proveedor
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",nullable = false, name = "id_proveedor")
    private Persona persona;
    
    //Entidad Fuerte(Relacion con Detalle)
    @OneToOne (cascade = CascadeType.ALL, mappedBy = "lote",fetch = FetchType.LAZY)
    private Detalle detalle;
    
    

    // Entidad Débil (Relación con Presentacion)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "id_presentacion")
    private Presentacion presentacion;

    // Entidad Débil (Relación con Laboratorio)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "id_laboratorio")
    private Laboratorio laboratorio;

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
