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
@Table(name = "items_del_carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsDelCarrito.findAll", query = "SELECT i FROM ItemsDelCarrito i"),
    @NamedQuery(name = "ItemsDelCarrito.findByProductoIDproducto", query = "SELECT i FROM ItemsDelCarrito i WHERE i.itemsDelCarritoPK.productoIDproducto = :productoIDproducto"),
    @NamedQuery(name = "ItemsDelCarrito.findByCantidad", query = "SELECT i FROM ItemsDelCarrito i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemsDelCarrito.findByCostoUnitario", query = "SELECT i FROM ItemsDelCarrito i WHERE i.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "ItemsDelCarrito.findByCostoTotal", query = "SELECT i FROM ItemsDelCarrito i WHERE i.costoTotal = :costoTotal"),
    @NamedQuery(name = "ItemsDelCarrito.findByCarritoDeComprasIDCarrito", query = "SELECT i FROM ItemsDelCarrito i WHERE i.itemsDelCarritoPK.carritoDeComprasIDCarrito = :carritoDeComprasIDCarrito")})
public class ItemsDelCarrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemsDelCarritoPK itemsDelCarritoPK;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Costo_Unitario")
    private float costoUnitario;
    @Basic(optional = false)
    @Column(name = "Costo_Total")
    private float costoTotal;
    @JoinColumn(name = "Carrito_De_Compras_ID_Carrito", referencedColumnName = "ID_Carrito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CarritoDeCompras carritoDeCompras;
    @JoinColumn(name = "Producto_ID_producto", referencedColumnName = "ID_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public ItemsDelCarrito() {
    }

    public ItemsDelCarrito(ItemsDelCarritoPK itemsDelCarritoPK) {
        this.itemsDelCarritoPK = itemsDelCarritoPK;
    }

    public ItemsDelCarrito(ItemsDelCarritoPK itemsDelCarritoPK, int cantidad, float costoUnitario, float costoTotal) {
        this.itemsDelCarritoPK = itemsDelCarritoPK;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
    }

    public ItemsDelCarrito(String productoIDproducto, String carritoDeComprasIDCarrito) {
        this.itemsDelCarritoPK = new ItemsDelCarritoPK(productoIDproducto, carritoDeComprasIDCarrito);
    }

    public ItemsDelCarritoPK getItemsDelCarritoPK() {
        return itemsDelCarritoPK;
    }

    public void setItemsDelCarritoPK(ItemsDelCarritoPK itemsDelCarritoPK) {
        this.itemsDelCarritoPK = itemsDelCarritoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public CarritoDeCompras getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(CarritoDeCompras carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
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
        hash += (itemsDelCarritoPK != null ? itemsDelCarritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsDelCarrito)) {
            return false;
        }
        ItemsDelCarrito other = (ItemsDelCarrito) object;
        if ((this.itemsDelCarritoPK == null && other.itemsDelCarritoPK != null) || (this.itemsDelCarritoPK != null && !this.itemsDelCarritoPK.equals(other.itemsDelCarritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemsDelCarrito{" + "cantidad=" + cantidad + ", costoUnitario=" + costoUnitario + ", costoTotal=" + costoTotal + ", carritoDeCompras=" + carritoDeCompras + '}';
    }


    
}
