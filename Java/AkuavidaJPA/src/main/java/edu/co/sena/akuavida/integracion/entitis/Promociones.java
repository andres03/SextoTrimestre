/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p"),
    @NamedQuery(name = "Promociones.findByIdPromocion", query = "SELECT p FROM Promociones p WHERE p.idPromocion = :idPromocion"),
    @NamedQuery(name = "Promociones.findByDescuentos", query = "SELECT p FROM Promociones p WHERE p.descuentos = :descuentos"),
    @NamedQuery(name = "Promociones.findByNombre", query = "SELECT p FROM Promociones p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Promociones.findByPrecio", query = "SELECT p FROM Promociones p WHERE p.precio = :precio")})
public class Promociones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Promocion")
    private String idPromocion;
    @Basic(optional = false)
    @Column(name = "Descuentos")
    private float descuentos;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Precio")
    private float precio;
    @JoinColumn(name = "Producto_ID_producto", referencedColumnName = "ID_producto")
    @ManyToOne(optional = false)
    private Producto productoIDproducto;

    public Promociones() {
    }

    public Promociones(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promociones(String idPromocion, float descuentos, String nombre, float precio) {
        this.idPromocion = idPromocion;
        this.descuentos = descuentos;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public float getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(float descuentos) {
        this.descuentos = descuentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Producto getProductoIDproducto() {
        return productoIDproducto;
    }

    public void setProductoIDproducto(Producto productoIDproducto) {
        this.productoIDproducto = productoIDproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Promociones{" + "idPromocion=" + idPromocion + ", descuentos=" + descuentos + ", nombre=" + nombre + ", precio=" + precio + ", productoIDproducto=" + productoIDproducto + '}';
    }


    
}
