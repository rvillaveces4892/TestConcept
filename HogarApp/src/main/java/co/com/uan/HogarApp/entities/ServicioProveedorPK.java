/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rvill
 */
@Embeddable
public class ServicioProveedorPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "PROVEEDOR_ID")
    private long proveedorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_ID")
    private long solicitudId;

    public ServicioProveedorPK() {
    }

    public ServicioProveedorPK(long proveedorId, long solicitudId) {
        this.proveedorId = proveedorId;
        this.solicitudId = solicitudId;
    }

    public long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(long solicitudId) {
        this.solicitudId = solicitudId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proveedorId;
        hash += (int) solicitudId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioProveedorPK)) {
            return false;
        }
        ServicioProveedorPK other = (ServicioProveedorPK) object;
        if (this.proveedorId != other.proveedorId) {
            return false;
        }
        if (this.solicitudId != other.solicitudId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.NotificacionProveedorPK[ proveedorId=" + proveedorId + ", solicitudId=" + solicitudId + " ]";
    }
    
}
