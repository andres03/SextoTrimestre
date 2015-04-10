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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByIDCategoria", query = "SELECT c FROM Categorias c WHERE c.iDCategoria = :iDCategoria"),
    @NamedQuery(name = "Categorias.findByNombre", query = "SELECT c FROM Categorias c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Categorias.findByActiva", query = "SELECT c FROM Categorias c WHERE c.activa = :activa"),
    @NamedQuery(name = "Categorias.findByPariente", query = "SELECT c FROM Categorias c WHERE c.pariente = :pariente")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID_Categoria")
    private Integer iDCategoria;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Activa")
    private boolean activa;
    @Basic(optional = false)
    @Column(name = "Pariente")
    private int pariente;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "categoriasIDCategoria")
    private List<Producto> productoList;

    public Categorias() {
    }

    public Categorias(Integer iDCategoria) {
        this.iDCategoria = iDCategoria;
    }

    public Categorias(Integer iDCategoria, String nombre, boolean activa, int pariente) {
        this.iDCategoria = iDCategoria;
        this.nombre = nombre;
        this.activa = activa;
        this.pariente = pariente;
    }

    public Integer getIDCategoria() {
        return iDCategoria;
    }

    public void setIDCategoria(Integer iDCategoria) {
        this.iDCategoria = iDCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getPariente() {
        return pariente;
    }

    public void setPariente(int pariente) {
        this.pariente = pariente;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCategoria != null ? iDCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.iDCategoria == null && other.iDCategoria != null) || (this.iDCategoria != null && !this.iDCategoria.equals(other.iDCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorias{" + "iDCategoria=" + iDCategoria + ", nombre=" + nombre + ", activa=" + activa + ", pariente=" + pariente + '}';
    }

  
    
}
