/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author toshiba_
 */
@Embeddable
public class DomicilioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Cuenta_Tipo_Documento")
    private String cuentaTipoDocumento;
    @Basic(optional = false)
    @Column(name = "Cuenta_Numero_Documento")
    private String cuentaNumeroDocumento;

    public DomicilioPK() {
    }

    public DomicilioPK(String cuentaTipoDocumento, String cuentaNumeroDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public String getCuentaTipoDocumento() {
        return cuentaTipoDocumento;
    }

    public void setCuentaTipoDocumento(String cuentaTipoDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentaTipoDocumento != null ? cuentaTipoDocumento.hashCode() : 0);
        hash += (cuentaNumeroDocumento != null ? cuentaNumeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioPK)) {
            return false;
        }
        DomicilioPK other = (DomicilioPK) object;
        if ((this.cuentaTipoDocumento == null && other.cuentaTipoDocumento != null) || (this.cuentaTipoDocumento != null && !this.cuentaTipoDocumento.equals(other.cuentaTipoDocumento))) {
            return false;
        }
        if ((this.cuentaNumeroDocumento == null && other.cuentaNumeroDocumento != null) || (this.cuentaNumeroDocumento != null && !this.cuentaNumeroDocumento.equals(other.cuentaNumeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DomicilioPK{" + "cuentaTipoDocumento=" + cuentaTipoDocumento + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + '}';
    }

 
    
}
