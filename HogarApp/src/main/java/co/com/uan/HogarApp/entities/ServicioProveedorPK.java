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
	@Column(name = "USUARIO_ID_PROVEEDOR")
	private long usuarioIdProveedor;
	@Basic(optional = false)
	@NotNull
	@Column(name = "SERVICIO_ID")
	private long servicioId;

	public ServicioProveedorPK() {
	}

	public ServicioProveedorPK(long usuarioIdProveedor, long servicioId) {
		this.usuarioIdProveedor = usuarioIdProveedor;
		this.servicioId = servicioId;
	}

	public long getUsuarioIdProveedor() {
		return usuarioIdProveedor;
	}

	public void setUsuarioIdProveedor(long usuarioIdProveedor) {
		this.usuarioIdProveedor = usuarioIdProveedor;
	}

	public long getServicioId() {
		return servicioId;
	}

	public void setServicioId(long servicioId) {
		this.servicioId = servicioId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) usuarioIdProveedor;
		hash += (int) servicioId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ServicioProveedorPK)) {
			return false;
		}
		ServicioProveedorPK other = (ServicioProveedorPK) object;
		if (this.usuarioIdProveedor != other.usuarioIdProveedor) {
			return false;
		}
		if (this.servicioId != other.servicioId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "app.NotificacionProveedorPK[ usuarioIdProveedor=" + usuarioIdProveedor + ", servicioId=" + servicioId + " ]";
	}

}
