/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author rvill
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedStoredProcedureQuery(name = "Usuario.calcular", procedureName = "prc_obtener_proveedores_cercanos", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_cliente", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "id_servicio", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "ids", type = String.class) })
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
		@NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
		@NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
		@NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres"),
		@NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
		@NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
		@NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
		@NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
		@NamedQuery(name = "Usuario.findByDescripcionPerfil", query = "SELECT u FROM Usuario u WHERE u.descripcionPerfil = :descripcionPerfil"),
		@NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
		@NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
		@NamedQuery(name = "Usuario.findByUsuarioIdIn", query = "SELECT u FROM Usuario u WHERE u.usuarioId IN (:usuarioIds)") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "USUARIO_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@Column(name = "USUARIO_ID")
	private Long usuarioId;
	@Size(max = 20)
	@Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "PASSWORD")
	private String password;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "NOMBRES")
	private String nombres;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "CORREO")
	private String correo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "DIRECCION")
	private String direccion;
	@Size(max = 11)
	@Column(name = "TELEFONO")
	private String telefono;
	@Size(max = 1000)
	@Column(name = "DESCRIPCION_PERFIL")
	private String descripcionPerfil;
	@Column(name = "FECHA_CREACION",columnDefinition="FECHA_CREACION DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion = new Date();
	@Size(max = 10)
	@Column(name = "ESTADO")
	private String estado = "ACTIVO";
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdCalificador", fetch = FetchType.LAZY)
//    private List<Calificacion> calificacionList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdCalificado", fetch = FetchType.LAZY)
//    private List<Calificacion> calificacionList1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdProveedor", fetch = FetchType.LAZY)
//    private List<Cotizacion> cotizacionList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
//    private List<NotificacionProveedor> notificacionProveedorList;
//    @OneToMany(mappedBy = "usuarioIdProveedor", fetch = FetchType.LAZY)
//    private List<Solicitud> solicitudList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdCliente", fetch = FetchType.LAZY)
//    private List<Solicitud> solicitudList1;

	@JoinColumn(name = "COORDENADA_ID", referencedColumnName = "COORDENADA_ID")
	@OneToOne(cascade=CascadeType.ALL ,fetch = FetchType.LAZY)
	private Coordenadas coordenadaId;

	@JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Rol rolId;

	public Usuario() {
	}

	public Usuario(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Usuario(Long usuarioId, String password, String nombres, String apellidos, String correo, String direccion) {
		this.usuarioId = usuarioId;
		this.password = password;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.direccion = direccion;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
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

//    @XmlTransient
//    public List<Calificacion> getCalificacionList() {
//        return calificacionList;
//    }
//
//    public void setCalificacionList(List<Calificacion> calificacionList) {
//        this.calificacionList = calificacionList;
//    }
//
//    @XmlTransient
//    public List<Calificacion> getCalificacionList1() {
//        return calificacionList1;
//    }
//
//    public void setCalificacionList1(List<Calificacion> calificacionList1) {
//        this.calificacionList1 = calificacionList1;
//    }
//
//    @XmlTransient
//    public List<Cotizacion> getCotizacionList() {
//        return cotizacionList;
//    }
//
//    public void setCotizacionList(List<Cotizacion> cotizacionList) {
//        this.cotizacionList = cotizacionList;
//    }
//
//    @XmlTransient
//    public List<NotificacionProveedor> getNotificacionProveedorList() {
//        return notificacionProveedorList;
//    }
//
//    public void setNotificacionProveedorList(List<NotificacionProveedor> notificacionProveedorList) {
//        this.notificacionProveedorList = notificacionProveedorList;
//    }
//
//    @XmlTransient
//    public List<Solicitud> getSolicitudList() {
//        return solicitudList;
//    }
//
//    public void setSolicitudList(List<Solicitud> solicitudList) {
//        this.solicitudList = solicitudList;
//    }
//
//    @XmlTransient
//    public List<Solicitud> getSolicitudList1() {
//        return solicitudList1;
//    }
//
//    public void setSolicitudList1(List<Solicitud> solicitudList1) {
//        this.solicitudList1 = solicitudList1;
//    }

	public Coordenadas getCoordenadaId() {
		return coordenadaId;
	}

	public void setCoordenadaId(Coordenadas coordenadaId) {
		this.coordenadaId = coordenadaId;
	}

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (usuarioId != null ? usuarioId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.usuarioId == null && other.usuarioId != null)
				|| (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "app.Usuario[ usuarioId=" + usuarioId + " ]";
	}

}
