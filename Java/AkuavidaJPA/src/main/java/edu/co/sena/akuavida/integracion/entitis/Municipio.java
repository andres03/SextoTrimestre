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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByNombreMunicipio", query = "SELECT m FROM Municipio m WHERE m.nombreMunicipio = :nombreMunicipio")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMunicipio")
    private String idMunicipio;
    @Basic(optional = false)
    @Column(name = "Nombre_Municipio")
    private String nombreMunicipio;
    @JoinColumn(name = "Departamento_idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne(optional = false)
    private Departamento departamentoidDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioidMunicipio")
    private List<Domicilio> domicilioList;

    public Municipio() {
    }

    public Municipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipio(String idMunicipio, String nombreMunicipio) {
        this.idMunicipio = idMunicipio;
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public Departamento getDepartamentoidDepartamento() {
        return departamentoidDepartamento;
    }

    public void setDepartamentoidDepartamento(Departamento departamentoidDepartamento) {
        this.departamentoidDepartamento = departamentoidDepartamento;
    }

    @XmlTransient
    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio + ", departamentoidDepartamento=" + departamentoidDepartamento + '}';
    }

   
    
}
