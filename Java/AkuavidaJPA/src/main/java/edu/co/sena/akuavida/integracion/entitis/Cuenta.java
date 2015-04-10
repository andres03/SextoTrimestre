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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author toshiba_
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByTipoDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Cuenta.findByNumeroDocumento", query = "SELECT c FROM Cuenta c WHERE c.cuentaPK.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Cuenta.findByPrimerNombre", query = "SELECT c FROM Cuenta c WHERE c.primerNombre = :primerNombre"),
    @NamedQuery(name = "Cuenta.findBySegundoNombre", query = "SELECT c FROM Cuenta c WHERE c.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Cuenta.findByPrimerApellido", query = "SELECT c FROM Cuenta c WHERE c.primerApellido = :primerApellido"),
    @NamedQuery(name = "Cuenta.findBySegundoApellido", query = "SELECT c FROM Cuenta c WHERE c.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Cuenta.findByCorreo", query = "SELECT c FROM Cuenta c WHERE c.correo = :correo"),
    @NamedQuery(name = "Cuenta.findByDireccion", query = "SELECT c FROM Cuenta c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cuenta.findByTelefono", query = "SELECT c FROM Cuenta c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cuenta.findByRool", query = "SELECT c FROM Cuenta c WHERE c.rool = :rool"),
    @NamedQuery(name = "Cuenta.findByActivo", query = "SELECT c FROM Cuenta c WHERE c.activo = :activo")})
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaPK cuentaPK;
    @Basic(optional = false)
    @Column(name = "Primer_Nombre")
    private String primerNombre;
    @Column(name = "Segundo_Nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "Primer_Apellido")
    private String primerApellido;
    @Column(name = "Segundo_Apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "Rool")
    private String rool;
    @Basic(optional = false)
    @Column(name = "Activo")
    private boolean activo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private Domicilio domicilio;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}, mappedBy = "cuenta")
    private List<Factura> facturaList;
    @JoinColumn(name = "Ususario_idUsusario", referencedColumnName = "idUsusario")
    @ManyToOne(optional = false)
    private Ususario ususarioidUsusario;

    public Cuenta() {
    }

    public Cuenta(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public Cuenta(CuentaPK cuentaPK, String primerNombre, String primerApellido, String correo, String direccion, String rool, boolean activo) {
        this.cuentaPK = cuentaPK;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.correo = correo;
        this.direccion = direccion;
        this.rool = rool;
        this.activo = activo;
    }

    public Cuenta(String tipoDocumento, String numeroDocumento) {
        this.cuentaPK = new CuentaPK(tipoDocumento, numeroDocumento);
    }

    public CuentaPK getCuentaPK() {
        return cuentaPK;
    }

    public void setCuentaPK(CuentaPK cuentaPK) {
        this.cuentaPK = cuentaPK;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getRool() {
        return rool;
    }

    public void setRool(String rool) {
        this.rool = rool;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Ususario getUsusarioidUsusario() {
        return ususarioidUsusario;
    }

    public void setUsusarioidUsusario(Ususario ususarioidUsusario) {
        this.ususarioidUsusario = ususarioidUsusario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaPK != null ? cuentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.cuentaPK == null && other.cuentaPK != null) || (this.cuentaPK != null && !this.cuentaPK.equals(other.cuentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + ", rool=" + rool + ", activo=" + activo + ", ususarioidUsusario=" + ususarioidUsusario + '}';
    }

  
    
}
