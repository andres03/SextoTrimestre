/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByProductoIDproducto", query = "SELECT i FROM Item i WHERE i.itemPK.productoIDproducto = :productoIDproducto"),
    @NamedQuery(name = "Item.findByPedidoFacturaIDFactura", query = "SELECT i FROM Item i WHERE i.itemPK.pedidoFacturaIDFactura = :pedidoFacturaIDFactura"),
    @NamedQuery(name = "Item.findByCantidad", query = "SELECT i FROM Item i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Item.findByCostoTotal", query = "SELECT i FROM Item i WHERE i.costoTotal = :costoTotal"),
    @NamedQuery(name = "Item.findByCostoUnitario", query = "SELECT i FROM Item i WHERE i.costoUnitario = :costoUnitario")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Costo_Total")
    private float costoTotal;
    @Basic(optional = false)
    @Column(name = "Costo_Unitario")
    private float costoUnitario;
    @JoinColumn(name = "Pedido_Factura_ID_Factura", referencedColumnName = "Factura_ID_Factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "Producto_ID_producto", referencedColumnName = "ID_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(ItemPK itemPK, int cantidad, float costoTotal, float costoUnitario) {
        this.itemPK = itemPK;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.costoUnitario = costoUnitario;
    }

    public Item(String productoIDproducto, int pedidoFacturaIDFactura) {
        this.itemPK = new ItemPK(productoIDproducto, pedidoFacturaIDFactura);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "cantidad=" + cantidad + ", costoTotal=" + costoTotal + ", costoUnitario=" + costoUnitario + '}';
    }

  
    
}
