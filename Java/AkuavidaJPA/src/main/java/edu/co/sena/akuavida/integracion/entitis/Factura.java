/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIDFactura", query = "SELECT f FROM Factura f WHERE f.iDFactura = :iDFactura"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Factura")
    private Integer iDFactura;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private Pago pago;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_Tipo_Documento", referencedColumnName = "Tipo_Documento"),
        @JoinColumn(name = "Cuenta_Numero_Documento", referencedColumnName = "Numero_Documento")})
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private Pedido pedido;

    public Factura() {
    }

    public Factura(Integer iDFactura) {
        this.iDFactura = iDFactura;
    }

    public Integer getIDFactura() {
        return iDFactura;
    }

    public void setIDFactura(Integer iDFactura) {
        this.iDFactura = iDFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFactura != null ? iDFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.iDFactura == null && other.iDFactura != null) || (this.iDFactura != null && !this.iDFactura.equals(other.iDFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "iDFactura=" + iDFactura + ", fecha=" + fecha + '}';
    }

 

  
    
}
