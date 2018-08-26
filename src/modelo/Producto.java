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
import javax.persistence.Table;
import lombok.*;

/**
 *
 * @author franzandresflores
 */
@Entity
@Getter
@Setter
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 60)
    private String nombre;
    
    @Column(length = 60,updatable=false,unique=true)
    private String codigo;
    
    @Column(length = 5)
    private Double precioCompra;
    
    @Column(length = 10)
    private Double iva;
    
    @Column(length = 10)
    private Double ganancia;
   
    @Column(length = 5)
    private Double precioVenta;
    
    @Column(length = 10)
    private Double descuento;
    
    @Column(length = 10)
    private Double precioDescuento;
    
    @Column(length = 5)
    private Integer stock;
    
    //Entidad Fuerte(Relacion con Lote)
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "producto",fetch =FetchType.LAZY)
    private List<Lote> listaLote= new ArrayList<>();

       // Entidad Débil (Relación con Presentacion)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "id_presentacion")
    private Presentacion presentacion;

    // Entidad Débil (Relación con Laboratorio)
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "id_laboratorio")
    private Laboratorio laboratorio;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producto[ id=" + id + " ]";
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
