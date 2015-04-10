/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author toshiba_
 */
@Embeddable
public class InventarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_Inventario")
    private int iDInventario;
    @Basic(optional = false)
    @Column(name = "Producto_ID_producto")
    private String productoIDproducto;

    public InventarioPK() {
    }

    public InventarioPK(int iDInventario, String productoIDproducto) {
        this.iDInventario = iDInventario;
        this.productoIDproducto = productoIDproducto;
    }

    public int getIDInventario() {
        return iDInventario;
    }

    public void setIDInventario(int iDInventario) {
        this.iDInventario = iDInventario;
    }

    public String getProductoIDproducto() {
        return productoIDproducto;
    }

    public void setProductoIDproducto(String productoIDproducto) {
        this.productoIDproducto = productoIDproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDInventario;
        hash += (productoIDproducto != null ? productoIDproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.iDInventario != other.iDInventario) {
            return false;
        }
        if ((this.productoIDproducto == null && other.productoIDproducto != null) || (this.productoIDproducto != null && !this.productoIDproducto.equals(other.productoIDproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventarioPK{" + "iDInventario=" + iDInventario + ", productoIDproducto=" + productoIDproducto + '}';
    }


}
