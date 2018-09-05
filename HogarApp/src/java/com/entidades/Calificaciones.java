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
@Table(name = "CALIFICACIONES", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c")
    , @NamedQuery(name = "Calificaciones.findByCalificacionId", query = "SELECT c FROM Calificaciones c WHERE c.calificacionId = :calificacionId")
    , @NamedQuery(name = "Calificaciones.findByClienteId", query = "SELECT c FROM Calificaciones c WHERE c.clienteId = :clienteId")
    , @NamedQuery(name = "Calificaciones.findByProveedorId", query = "SELECT c FROM Calificaciones c WHERE c.proveedorId = :proveedorId")
    , @NamedQuery(name = "Calificaciones.findByCalificacionComentario", query = "SELECT c FROM Calificaciones c WHERE c.calificacionComentario = :calificacionComentario")
    , @NamedQuery(name = "Calificaciones.findByCalificacionEstrellas", query = "SELECT c FROM Calificaciones c WHERE c.calificacionEstrellas = :calificacionEstrellas")
    , @NamedQuery(name = "Calificaciones.findByCalificacionEstado", query = "SELECT c FROM Calificaciones c WHERE c.calificacionEstado = :calificacionEstado")
    , @NamedQuery(name = "Calificaciones.findByCalificacionCreacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacionCreacion = :calificacionCreacion")})
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal calificacionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID", nullable = false)
    private BigInteger clienteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROVEEDOR_ID", nullable = false)
    private BigInteger proveedorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "CALIFICACION_COMENTARIO", nullable = false, length = 400)
    private String calificacionComentario;
    @Column(name = "CALIFICACION_ESTRELLAS")
    private BigInteger calificacionEstrellas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION_ESTADO", nullable = false)
    private Character calificacionEstado;
    @Column(name = "CALIFICACION_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calificacionCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calificacionesCalificacionId")
    private List<Usuarios> usuariosList;

    public Calificaciones() {
    }

    public Calificaciones(BigDecimal calificacionId) {
        this.calificacionId = calificacionId;
    }

    public Calificaciones(BigDecimal calificacionId, BigInteger clienteId, BigInteger proveedorId, String calificacionComentario, Character calificacionEstado) {
        this.calificacionId = calificacionId;
        this.clienteId = clienteId;
        this.proveedorId = proveedorId;
        this.calificacionComentario = calificacionComentario;
        this.calificacionEstado = calificacionEstado;
    }

    public BigDecimal getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(BigDecimal calificacionId) {
        this.calificacionId = calificacionId;
    }

    public BigInteger getClienteId() {
        return clienteId;
    }

    public void setClienteId(BigInteger clienteId) {
        this.clienteId = clienteId;
    }

    public BigInteger getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(BigInteger proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getCalificacionComentario() {
        return calificacionComentario;
    }

    public void setCalificacionComentario(String calificacionComentario) {
        this.calificacionComentario = calificacionComentario;
    }

    public BigInteger getCalificacionEstrellas() {
        return calificacionEstrellas;
    }

    public void setCalificacionEstrellas(BigInteger calificacionEstrellas) {
        this.calificacionEstrellas = calificacionEstrellas;
    }

    public Character getCalificacionEstado() {
        return calificacionEstado;
    }

    public void setCalificacionEstado(Character calificacionEstado) {
        this.calificacionEstado = calificacionEstado;
    }

    public Date getCalificacionCreacion() {
        return calificacionCreacion;
    }

    public void setCalificacionCreacion(Date calificacionCreacion) {
        this.calificacionCreacion = calificacionCreacion;
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
        hash += (calificacionId != null ? calificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.calificacionId == null && other.calificacionId != null) || (this.calificacionId != null && !this.calificacionId.equals(other.calificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Calificaciones[ calificacionId=" + calificacionId + " ]";
    }
    
}
