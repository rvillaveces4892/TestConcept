/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author rvill
 */
@Entity
@Table(name = "SERVICIO_PROVEEDOR")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ServicioProveedor.findAll", query = "SELECT n FROM NotificacionProveedor n"),
		@NamedQuery(name = "ServicioProveedor.findByProveedorId", query = "SELECT n FROM NotificacionProveedor n WHERE n.notificacionProveedorPK.proveedorId = :proveedorId"),
		@NamedQuery(name = "ServicioProveedor.findBySolicitudId", query = "SELECT n FROM NotificacionProveedor n WHERE n.notificacionProveedorPK.solicitudId = :solicitudId"),
		@NamedQuery(name = "ServicioProveedor.findByDescripcion", query = "SELECT n FROM NotificacionProveedor n WHERE n.descripcion = :descripcion"),
		@NamedQuery(name = "ServicioProveedor.findByFechaCreacion", query = "SELECT n FROM NotificacionProveedor n WHERE n.fechaCreacion = :fechaCreacion"),
		@NamedQuery(name = "ServicioProveedor.findByEstado", query = "SELECT n FROM NotificacionProveedor n WHERE n.estado = :estado") })
public class ServicioProveedor implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected ServicioProveedorPK servicioProveedorPK;
	@JsonBackReference
	@JoinColumn(name = "SERVICIO_ID", referencedColumnName = "SERVICIO_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Servicio servicio;
	@JsonBackReference
	@JoinColumn(name = "USUARIO_ID_PROVEEDOR", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Usuario usuario;

	public ServicioProveedor() {
	}

	public ServicioProveedor(ServicioProveedorPK servicioProveedorPK, Servicio servicio, Usuario usuario) {
		super();
		this.servicioProveedorPK = servicioProveedorPK;
		this.servicio = servicio;
		this.usuario = usuario;
	}

	public ServicioProveedorPK getServicioProveedorPK() {
		return servicioProveedorPK;
	}

	public void setServicioProveedorPK(ServicioProveedorPK servicioProveedorPK) {
		this.servicioProveedorPK = servicioProveedorPK;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public String getNombreServicio() {
		return servicio.getDescripcion();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
