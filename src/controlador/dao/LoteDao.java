/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Lote;

/**
 *
 * @author Lili
 */
public class LoteDao extends AdaptadorDao {

    private Lote lote;

    public LoteDao() {
        super(Lote.class);
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Lote getLote() {
        if (lote == null) {
            lote = new Lote();
        }
        return lote;
    }

    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if (lote.getId() != null) {
                modificar(lote);
            } else {
                guardar(lote);
            }
            guardar(lote);
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verificar;
    }
    

    public Lote buscarCodigo(String codigo) {
        Lote p = null;
        try {
            Query q = getManager().createQuery("SELECT p FROM Lote p WHERE "
                    + "p.producto.codigo = :codigo");
            q.setParameter("codigo", codigo);
            p = (Lote)q.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public Lote restarStock(String codigo,Integer cant){
        Lote p = buscarCodigo(codigo);
        Integer aux = p.getCantidad() - cant;
        p.setCantidad(aux);
        return p;
    }
    
}
