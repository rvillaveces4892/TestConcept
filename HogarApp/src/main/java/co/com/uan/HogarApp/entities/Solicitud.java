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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rvill
 */
@Entity
@Table(name = "SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findBySolicitudId", query = "SELECT s FROM Solicitud s WHERE s.solicitudId = :solicitudId")
    , @NamedQuery(name = "Solicitud.findByDescripcion", query = "SELECT s FROM Solicitud s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Solicitud.findByLongitud", query = "SELECT s FROM Solicitud s WHERE s.longitud = :longitud")
    , @NamedQuery(name = "Solicitud.findByLatitud", query = "SELECT s FROM Solicitud s WHERE s.latitud = :latitud")
    , @NamedQuery(name = "Solicitud.findByDireccion", query = "SELECT s FROM Solicitud s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Solicitud.findByFechaCreacion", query = "SELECT s FROM Solicitud s WHERE s.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_ID")
    private Long solicitudId;
    @Size(max = 400)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 80)
    @Column(name = "LONGITUD")
    private String longitud;
    @Size(max = 80)
    @Column(name = "LATITUD")
    private String latitud;
    @Size(max = 80)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudId", fetch = FetchType.LAZY)
    private List<Cotizacion> cotizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitud", fetch = FetchType.LAZY)
    private List<NotificacionProveedor> notificacionProveedorList;
    @JoinColumn(name = "SERVICIO_ID", referencedColumnName = "SERVICIO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio servicioId;
    @JoinColumn(name = "USUARIO_ID_PROVEEDOR", referencedColumnName = "USUARIO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioIdProveedor;
    @JoinColumn(name = "USUARIO_ID_CLIENTE", referencedColumnName = "USUARIO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdCliente;

    public Solicitud() {
    }

    public Solicitud(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @XmlTransient
    public List<NotificacionProveedor> getNotificacionProveedorList() {
        return notificacionProveedorList;
    }

    public void setNotificacionProveedorList(List<NotificacionProveedor> notificacionProveedorList) {
        this.notificacionProveedorList = notificacionProveedorList;
    }

    public Servicio getServicioId() {
        return servicioId;
    }

    public void setServicioId(Servicio servicioId) {
        this.servicioId = servicioId;
    }

    public Usuario getUsuarioIdProveedor() {
        return usuarioIdProveedor;
    }

    public void setUsuarioIdProveedor(Usuario usuarioIdProveedor) {
        this.usuarioIdProveedor = usuarioIdProveedor;
    }

    public Usuario getUsuarioIdCliente() {
        return usuarioIdCliente;
    }

    public void setUsuarioIdCliente(Usuario usuarioIdCliente) {
        this.usuarioIdCliente = usuarioIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudId != null ? solicitudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solicitudId == null && other.solicitudId != null) || (this.solicitudId != null && !this.solicitudId.equals(other.solicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Solicitud[ solicitudId=" + solicitudId + " ]";
    }
    
}
