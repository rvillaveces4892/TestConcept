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
@Table(name = "NOTIFICACION_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotificacionProveedor.findAll", query = "SELECT n FROM NotificacionProveedor n")
    , @NamedQuery(name = "NotificacionProveedor.findByProveedorId", query = "SELECT n FROM NotificacionProveedor n WHERE n.notificacionProveedorPK.proveedorId = :proveedorId")
    , @NamedQuery(name = "NotificacionProveedor.findBySolicitudId", query = "SELECT n FROM NotificacionProveedor n WHERE n.notificacionProveedorPK.solicitudId = :solicitudId")
    , @NamedQuery(name = "NotificacionProveedor.findByDescripcion", query = "SELECT n FROM NotificacionProveedor n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "NotificacionProveedor.findByFechaCreacion", query = "SELECT n FROM NotificacionProveedor n WHERE n.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "NotificacionProveedor.findByEstado", query = "SELECT n FROM NotificacionProveedor n WHERE n.estado = :estado")})
public class ServicioProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicioProveedorPK servicioProveedorPK;
    @JsonBackReference
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio solicitud;
    @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public ServicioProveedor() {
    }

//    public ServicioProveedor(NotificacionProveedorPK notificacionProveedorPK) {
//        this.notificacionProveedorPK = notificacionProveedorPK;
//    }
//
//    public ServicioProveedor(NotificacionProveedorPK notificacionProveedorPK, String estado) {
//        this.notificacionProveedorPK = notificacionProveedorPK;
//        this.estado = estado;
//    }
//
//    public ServicioProveedor(long proveedorId, long solicitudId) {
//        this.notificacionProveedorPK = new NotificacionProveedorPK(proveedorId, solicitudId);
//    }
//
//    public NotificacionProveedorPK getNotificacionProveedorPK() {
//        return notificacionProveedorPK;
//    }
//
//    public void setNotificacionProveedorPK(NotificacionProveedorPK notificacionProveedorPK) {
//        this.notificacionProveedorPK = notificacionProveedorPK;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public Date getFechaCreacion() {
//        return fechaCreacion;
//    }
//
//    public void setFechaCreacion(Date fechaCreacion) {
//        this.fechaCreacion = fechaCreacion;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public Solicitud getSolicitud() {
//        return solicitud;
//    }
//
//    public void setSolicitud(Solicitud solicitud) {
//        this.solicitud = solicitud;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (notificacionProveedorPK != null ? notificacionProveedorPK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ServicioProveedor)) {
//            return false;
//        }
//        ServicioProveedor other = (ServicioProveedor) object;
//        if ((this.notificacionProveedorPK == null && other.notificacionProveedorPK != null) || (this.notificacionProveedorPK != null && !this.notificacionProveedorPK.equals(other.notificacionProveedorPK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "app.NotificacionProveedor[ notificacionProveedorPK=" + notificacionProveedorPK + " ]";
//    }
    
}
