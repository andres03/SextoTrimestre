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
public class ItemsDelCarritoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Producto_ID_producto")
    private String productoIDproducto;
    @Basic(optional = false)
    @Column(name = "Carrito_De_Compras_ID_Carrito")
    private String carritoDeComprasIDCarrito;

    public ItemsDelCarritoPK() {
    }

    public ItemsDelCarritoPK(String productoIDproducto, String carritoDeComprasIDCarrito) {
        this.productoIDproducto = productoIDproducto;
        this.carritoDeComprasIDCarrito = carritoDeComprasIDCarrito;
    }

    public String getProductoIDproducto() {
        return productoIDproducto;
    }

    public void setProductoIDproducto(String productoIDproducto) {
        this.productoIDproducto = productoIDproducto;
    }

    public String getCarritoDeComprasIDCarrito() {
        return carritoDeComprasIDCarrito;
    }

    public void setCarritoDeComprasIDCarrito(String carritoDeComprasIDCarrito) {
        this.carritoDeComprasIDCarrito = carritoDeComprasIDCarrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoIDproducto != null ? productoIDproducto.hashCode() : 0);
        hash += (carritoDeComprasIDCarrito != null ? carritoDeComprasIDCarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsDelCarritoPK)) {
            return false;
        }
        ItemsDelCarritoPK other = (ItemsDelCarritoPK) object;
        if ((this.productoIDproducto == null && other.productoIDproducto != null) || (this.productoIDproducto != null && !this.productoIDproducto.equals(other.productoIDproducto))) {
            return false;
        }
        if ((this.carritoDeComprasIDCarrito == null && other.carritoDeComprasIDCarrito != null) || (this.carritoDeComprasIDCarrito != null && !this.carritoDeComprasIDCarrito.equals(other.carritoDeComprasIDCarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemsDelCarritoPK{" + "productoIDproducto=" + productoIDproducto + ", carritoDeComprasIDCarrito=" + carritoDeComprasIDCarrito + '}';
    }

    
}
