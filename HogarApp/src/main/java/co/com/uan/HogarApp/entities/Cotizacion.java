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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "COTIZACION")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
		@NamedQuery(name = "Cotizacion.findByCotizacionId", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionId = :cotizacionId"),
		@NamedQuery(name = "Cotizacion.findCotizacionsBySolicitud", query = "SELECT c FROM Cotizacion c WHERE c.solicitudId.solicitudId = :solicitudId"),
		@NamedQuery(name = "Cotizacion.findByValor", query = "SELECT c FROM Cotizacion c WHERE c.valor = :valor"),
		@NamedQuery(name = "Cotizacion.findByFechaEstimada", query = "SELECT c FROM Cotizacion c WHERE c.fechaEstimada = :fechaEstimada"),
		@NamedQuery(name = "Cotizacion.findByDuracion", query = "SELECT c FROM Cotizacion c WHERE c.duracion = :duracion"),
		@NamedQuery(name = "Cotizacion.findByFechaCreacion", query = "SELECT c FROM Cotizacion c WHERE c.fechaCreacion = :fechaCreacion"),
		@NamedQuery(name = "Cotizacion.findByEstado", query = "SELECT c FROM Cotizacion c WHERE c.estado = :estado"),
		@NamedQuery(name = "Cotizacion.findCotizacionsBySolicitudAndUser", query = "SELECT c FROM Cotizacion c WHERE c.solicitudId.solicitudId = ? AND c.usuarioIdProveedor.usuarioId = ? AND c.estado in ('CREADA','ACEPTADA') "),
		@NamedQuery(name = "Cotizacion.updateEstadoById", query = "UPDATE Cotizacion c SET c.estado = ? WHERE c.cotizacionId = ? "),
		@NamedQuery(name = "Cotizacion.aceptarCotizacion", query = "UPDATE Cotizacion c SET c.estado = ? WHERE c.solicitudId.solicitudId = ? AND c.cotizacionId != ? ") })
public class Cotizacion implements Serializable {

	public static final String UPDATE_IDPROVEEDOR_SOLICITUD = "UPDATE SOLICITUD S SET S.ESTADO = 'ACEPTADA', S.USUARIO_ID_PROVEEDOR = (SELECT C.USUARIO_ID_PROVEEDOR FROM COTIZACION C WHERE C.COTIZACION_ID = ? AND C.SOLICITUD_ID = ?) WHERE S.SOLICITUD_ID = ? ";
	public static final String SOLICITUD_ID = "solicitudId";
	public static final String ESTADO_ACEPTADA = "ACEPTADA";
	public static final String ESTADO_RECHAZADA = "RECHAZADA";
	public static final String UPDATE_ESTADO_BY_ID = "Cotizacion.updateEstadoById";
	public static final String FIND_COTIZACIONS_BY_SOLICITUD = "Cotizacion.findCotizacionsBySolicitud";
	public static final String ACEPTAR_COTIZACION = "Cotizacion.aceptarCotizacion";
	public static final String FIND_COTIZACIONS_BY_SOLICITUDAND_USER = "Cotizacion.findCotizacionsBySolicitudAndUser";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "COTIZACION_COTIZACION_ID_SEQ", allocationSize = 1)
	@Basic(optional = false)
	@Column(name = "COTIZACION_ID")
	private Long cotizacionId;
	@Column(name = "VALOR")
	private Long valor;
	@Column(name = "FECHA_ESTIMADA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEstimada;
	@Column(name = "DURACION")
	private Integer duracion;
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion = new Date();
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "ESTADO")
	private String estado = "CREADA";
	@JsonBackReference
	@JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Solicitud solicitudId;
	@JoinColumn(name = "USUARIO_ID_PROVEEDOR", referencedColumnName = "USUARIO_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Usuario usuarioIdProveedor;

	public Cotizacion() {
	}

	public Cotizacion(Long cotizacionId) {
		this.cotizacionId = cotizacionId;
	}

	public Cotizacion(Long cotizacionId, String estado) {
		this.cotizacionId = cotizacionId;
		this.estado = estado;
	}

	public Long getCotizacionId() {
		return cotizacionId;
	}

	public void setCotizacionId(Long cotizacionId) {
		this.cotizacionId = cotizacionId;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Date getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(Date fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Solicitud getSolicitudId() {
		return solicitudId;
	}

	public void setSolicitudId(Solicitud solicitudId) {
		this.solicitudId = solicitudId;
	}

	public Usuario getUsuarioIdProveedor() {
		return usuarioIdProveedor;
	}

	public void setUsuarioIdProveedor(Usuario usuarioIdProveedor) {
		this.usuarioIdProveedor = usuarioIdProveedor;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cotizacionId != null ? cotizacionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cotizacion)) {
			return false;
		}
		Cotizacion other = (Cotizacion) object;
		if ((this.cotizacionId == null && other.cotizacionId != null)
				|| (this.cotizacionId != null && !this.cotizacionId.equals(other.cotizacionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "app.Cotizacion[ cotizacionId=" + cotizacionId + " ]";
	}

}
