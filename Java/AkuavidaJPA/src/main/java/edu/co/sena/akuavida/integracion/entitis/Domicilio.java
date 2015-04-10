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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByCuentaTipoDocumento", query = "SELECT d FROM Domicilio d WHERE d.domicilioPK.cuentaTipoDocumento = :cuentaTipoDocumento"),
    @NamedQuery(name = "Domicilio.findByCuentaNumeroDocumento", query = "SELECT d FROM Domicilio d WHERE d.domicilioPK.cuentaNumeroDocumento = :cuentaNumeroDocumento"),
    @NamedQuery(name = "Domicilio.findByCiudad", query = "SELECT d FROM Domicilio d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "Domicilio.findByDireccion", query = "SELECT d FROM Domicilio d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Domicilio.findByTelefono", query = "SELECT d FROM Domicilio d WHERE d.telefono = :telefono")})
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DomicilioPK domicilioPK;
    @Basic(optional = false)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    @JoinColumns({
        @JoinColumn(name = "Cuenta_Tipo_Documento", referencedColumnName = "Tipo_Documento", insertable = false, updatable = false),
        @JoinColumn(name = "Cuenta_Numero_Documento", referencedColumnName = "Numero_Documento", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "Municipio_idMunicipio", referencedColumnName = "idMunicipio")
    @ManyToOne(optional = false)
    private Municipio municipioidMunicipio;

    public Domicilio() {
    }

    public Domicilio(DomicilioPK domicilioPK) {
        this.domicilioPK = domicilioPK;
    }

    public Domicilio(DomicilioPK domicilioPK, String ciudad, String direccion, String telefono) {
        this.domicilioPK = domicilioPK;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Domicilio(String cuentaTipoDocumento, String cuentaNumeroDocumento) {
        this.domicilioPK = new DomicilioPK(cuentaTipoDocumento, cuentaNumeroDocumento);
    }

    public DomicilioPK getDomicilioPK() {
        return domicilioPK;
    }

    public void setDomicilioPK(DomicilioPK domicilioPK) {
        this.domicilioPK = domicilioPK;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Municipio getMunicipioidMunicipio() {
        return municipioidMunicipio;
    }

    public void setMunicipioidMunicipio(Municipio municipioidMunicipio) {
        this.municipioidMunicipio = municipioidMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioPK != null ? domicilioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.domicilioPK == null && other.domicilioPK != null) || (this.domicilioPK != null && !this.domicilioPK.equals(other.domicilioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono + ", municipioidMunicipio=" + municipioidMunicipio + '}';
    }



   
    
}
