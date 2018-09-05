/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author rootMaster
 */
@Entity
@Table(name = "NOTIFICACIONES", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n")
    , @NamedQuery(name = "Notificaciones.findByNotificacionId", query = "SELECT n FROM Notificaciones n WHERE n.notificacionId = :notificacionId")
    , @NamedQuery(name = "Notificaciones.findByNotificacionDetalle", query = "SELECT n FROM Notificaciones n WHERE n.notificacionDetalle = :notificacionDetalle")
    , @NamedQuery(name = "Notificaciones.findByNotificacionEstado", query = "SELECT n FROM Notificaciones n WHERE n.notificacionEstado = :notificacionEstado")
    , @NamedQuery(name = "Notificaciones.findByNotificacionCreacion", query = "SELECT n FROM Notificaciones n WHERE n.notificacionCreacion = :notificacionCreacion")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTIFICACION_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal notificacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOTIFICACION_DETALLE", nullable = false, length = 300)
    private String notificacionDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTIFICACION_ESTADO", nullable = false)
    private BigInteger notificacionEstado;
    @Column(name = "NOTIFICACION_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificacionCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificacionesNotificacionId")
    private List<Usuarios> usuariosList;

    public Notificaciones() {
    }

    public Notificaciones(BigDecimal notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Notificaciones(BigDecimal notificacionId, String notificacionDetalle, BigInteger notificacionEstado) {
        this.notificacionId = notificacionId;
        this.notificacionDetalle = notificacionDetalle;
        this.notificacionEstado = notificacionEstado;
    }

    public BigDecimal getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(BigDecimal notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getNotificacionDetalle() {
        return notificacionDetalle;
    }

    public void setNotificacionDetalle(String notificacionDetalle) {
        this.notificacionDetalle = notificacionDetalle;
    }

    public BigInteger getNotificacionEstado() {
        return notificacionEstado;
    }

    public void setNotificacionEstado(BigInteger notificacionEstado) {
        this.notificacionEstado = notificacionEstado;
    }

    public Date getNotificacionCreacion() {
        return notificacionCreacion;
    }

    public void setNotificacionCreacion(Date notificacionCreacion) {
        this.notificacionCreacion = notificacionCreacion;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificacionId != null ? notificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.notificacionId == null && other.notificacionId != null) || (this.notificacionId != null && !this.notificacionId.equals(other.notificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Notificaciones[ notificacionId=" + notificacionId + " ]";
    }
    
}
