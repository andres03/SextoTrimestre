/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "carrito_de_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarritoDeCompras.findAll", query = "SELECT c FROM CarritoDeCompras c"),
    @NamedQuery(name = "CarritoDeCompras.findByIDCarrito", query = "SELECT c FROM CarritoDeCompras c WHERE c.iDCarrito = :iDCarrito"),
    @NamedQuery(name = "CarritoDeCompras.findByTotal", query = "SELECT c FROM CarritoDeCompras c WHERE c.total = :total"),
    @NamedQuery(name = "CarritoDeCompras.findBySubtotal", query = "SELECT c FROM CarritoDeCompras c WHERE c.subtotal = :subtotal")})
public class CarritoDeCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Carrito")
    private String iDCarrito;
    @Basic(optional = false)
    @Column(name = "Total")
    private float total;
    @Basic(optional = false)
    @Column(name = "Subtotal")
    private float subtotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritoDeCompras",fetch = FetchType.EAGER)
    private List<ItemsDelCarrito> itemsDelCarritoList;

    public CarritoDeCompras() {
    }

    public CarritoDeCompras(String iDCarrito) {
        this.iDCarrito = iDCarrito;
    }

    public CarritoDeCompras(String iDCarrito, float total, float subtotal) {
        this.iDCarrito = iDCarrito;
        this.total = total;
        this.subtotal = subtotal;
    }

    public String getIDCarrito() {
        return iDCarrito;
    }

    public void setIDCarrito(String iDCarrito) {
        this.iDCarrito = iDCarrito;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    @XmlTransient
    public List<ItemsDelCarrito> getItemsDelCarritoList() {
        return itemsDelCarritoList;
    }

    public void setItemsDelCarritoList(List<ItemsDelCarrito> itemsDelCarritoList) {
        this.itemsDelCarritoList = itemsDelCarritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCarrito != null ? iDCarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarritoDeCompras)) {
            return false;
        }
        CarritoDeCompras other = (CarritoDeCompras) object;
        if ((this.iDCarrito == null && other.iDCarrito != null) || (this.iDCarrito != null && !this.iDCarrito.equals(other.iDCarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarritoDeCompras{" + "iDCarrito=" + iDCarrito + ", total=" + total + ", subtotal=" + subtotal + '}';
    }


    
}
