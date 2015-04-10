/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByFacturaIDFactura", query = "SELECT p FROM Pedido p WHERE p.facturaIDFactura = :facturaIDFactura"),
    @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pedido.findBySubtotal", query = "SELECT p FROM Pedido p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Factura_ID_Factura")
    private Integer facturaIDFactura;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "Subtotal")
    private float subtotal;
    @Basic(optional = false)
    @Column(name = "Total")
    private float total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Item> itemList;
    @JoinColumn(name = "Factura_ID_Factura", referencedColumnName = "ID_Factura", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Factura factura;

    public Pedido() {
    }

    public Pedido(Integer facturaIDFactura) {
        this.facturaIDFactura = facturaIDFactura;
    }

    public Pedido(Integer facturaIDFactura, float subtotal, float total) {
        this.facturaIDFactura = facturaIDFactura;
        this.subtotal = subtotal;
        this.total = total;
    }

    public Integer getFacturaIDFactura() {
        return facturaIDFactura;
    }

    public void setFacturaIDFactura(Integer facturaIDFactura) {
        this.facturaIDFactura = facturaIDFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaIDFactura != null ? facturaIDFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.facturaIDFactura == null && other.facturaIDFactura != null) || (this.facturaIDFactura != null && !this.facturaIDFactura.equals(other.facturaIDFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "facturaIDFactura=" + facturaIDFactura + ", fecha=" + fecha + ", subtotal=" + subtotal + ", total=" + total + '}';
    }


    
}
