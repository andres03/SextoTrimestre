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
public class ItemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Producto_ID_producto")
    private String productoIDproducto;
    @Basic(optional = false)
    @Column(name = "Pedido_Factura_ID_Factura")
    private int pedidoFacturaIDFactura;

    public ItemPK() {
    }

    public ItemPK(String productoIDproducto, int pedidoFacturaIDFactura) {
        this.productoIDproducto = productoIDproducto;
        this.pedidoFacturaIDFactura = pedidoFacturaIDFactura;
    }

    public String getProductoIDproducto() {
        return productoIDproducto;
    }

    public void setProductoIDproducto(String productoIDproducto) {
        this.productoIDproducto = productoIDproducto;
    }

    public int getPedidoFacturaIDFactura() {
        return pedidoFacturaIDFactura;
    }

    public void setPedidoFacturaIDFactura(int pedidoFacturaIDFactura) {
        this.pedidoFacturaIDFactura = pedidoFacturaIDFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoIDproducto != null ? productoIDproducto.hashCode() : 0);
        hash += (int) pedidoFacturaIDFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if ((this.productoIDproducto == null && other.productoIDproducto != null) || (this.productoIDproducto != null && !this.productoIDproducto.equals(other.productoIDproducto))) {
            return false;
        }
        if (this.pedidoFacturaIDFactura != other.pedidoFacturaIDFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemPK{" + "productoIDproducto=" + productoIDproducto + ", pedidoFacturaIDFactura=" + pedidoFacturaIDFactura + '}';
    }


    
}
