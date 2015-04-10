/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIDInventario", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.iDInventario = :iDInventario"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByProductoIDproducto", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.productoIDproducto = :productoIDproducto"),
    @NamedQuery(name = "Inventario.findByCantidadProductoComprado", query = "SELECT i FROM Inventario i WHERE i.cantidadProductoComprado = :cantidadProductoComprado"),
    @NamedQuery(name = "Inventario.findByFechaDeCompra", query = "SELECT i FROM Inventario i WHERE i.fechaDeCompra = :fechaDeCompra")})
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioPK inventarioPK;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Cantidad_Producto_Comprado")
    private float cantidadProductoComprado;
    @Basic(optional = false)
    @Column(name = "Fecha_De_Compra")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCompra;
    @JoinColumn(name = "Producto_ID_producto", referencedColumnName = "ID_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Inventario(InventarioPK inventarioPK, int cantidad, float cantidadProductoComprado, Date fechaDeCompra) {
        this.inventarioPK = inventarioPK;
        this.cantidad = cantidad;
        this.cantidadProductoComprado = cantidadProductoComprado;
        this.fechaDeCompra = fechaDeCompra;
    }

    public Inventario(int iDInventario, String productoIDproducto) {
        this.inventarioPK = new InventarioPK(iDInventario, productoIDproducto);
    }

    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCantidadProductoComprado() {
        return cantidadProductoComprado;
    }

    public void setCantidadProductoComprado(float cantidadProductoComprado) {
        this.cantidadProductoComprado = cantidadProductoComprado;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
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
        hash += (inventarioPK != null ? inventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.inventarioPK == null && other.inventarioPK != null) || (this.inventarioPK != null && !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "cantidad=" + cantidad + ", cantidadProductoComprado=" + cantidadProductoComprado + ", fechaDeCompra=" + fechaDeCompra + '}';
    }

 

 
    
}
