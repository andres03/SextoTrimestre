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
@Table(name = "ususario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ususario.findAll", query = "SELECT u FROM Ususario u"),
    @NamedQuery(name = "Ususario.findByIdUsusario", query = "SELECT u FROM Ususario u WHERE u.idUsusario = :idUsusario"),
    @NamedQuery(name = "Ususario.findByPassword", query = "SELECT u FROM Ususario u WHERE u.password = :password"),
    @NamedQuery(name = "Ususario.findByRol", query = "SELECT u FROM Ususario u WHERE u.rol = :rol"),
    @NamedQuery(name = "Ususario.findByEstado", query = "SELECT u FROM Ususario u WHERE u.estado = :estado")})
public class Ususario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUsusario")
    private String idUsusario;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}, mappedBy = "ususarioidUsusario")
    private List<Cuenta> cuentaList;

    public Ususario() {
    }

    public Ususario(String idUsusario) {
        this.idUsusario = idUsusario;
    }

    public Ususario(String idUsusario, String password, String rol, String estado) {
        this.idUsusario = idUsusario;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public String getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(String idUsusario) {
        this.idUsusario = idUsusario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsusario != null ? idUsusario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ususario)) {
            return false;
        }
        Ususario other = (Ususario) object;
        if ((this.idUsusario == null && other.idUsusario != null) || (this.idUsusario != null && !this.idUsusario.equals(other.idUsusario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ususario{" + "idUsusario=" + idUsusario + ", password=" + password + ", rol=" + rol + ", estado=" + estado + '}';
    }


    
}
