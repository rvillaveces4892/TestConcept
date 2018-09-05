/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rootMaster
 */
@Entity
@Table(name = "USUARIOS", catalog = "", schema = "C##HOGARAPP", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COORDENADA_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuarioId", query = "SELECT u FROM Usuarios u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuarios.findByUsuarioNombres", query = "SELECT u FROM Usuarios u WHERE u.usuarioNombres = :usuarioNombres")
    , @NamedQuery(name = "Usuarios.findByUsuarioApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuarioApellidos = :usuarioApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuarioCorreo", query = "SELECT u FROM Usuarios u WHERE u.usuarioCorreo = :usuarioCorreo")
    , @NamedQuery(name = "Usuarios.findByUsuarioContrasenia", query = "SELECT u FROM Usuarios u WHERE u.usuarioContrasenia = :usuarioContrasenia")
    , @NamedQuery(name = "Usuarios.findByUsuarioTelefono", query = "SELECT u FROM Usuarios u WHERE u.usuarioTelefono = :usuarioTelefono")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USUARIO_NOMBRES", nullable = false, length = 80)
    private String usuarioNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USUARIO_APELLIDOS", nullable = false, length = 80)
    private String usuarioApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USUARIO_CORREO", nullable = false, length = 80)
    private String usuarioCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO_CONTRASENIA", nullable = false, length = 50)
    private String usuarioContrasenia;
    @Size(max = 11)
    @Column(name = "USUARIO_TELEFONO", length = 11)
    private String usuarioTelefono;
    @JoinColumn(name = "CALIFICACIONES_CALIFICACION_ID", referencedColumnName = "CALIFICACION_ID", nullable = false)
    @ManyToOne(optional = false)
    private Calificaciones calificacionesCalificacionId;
    @JoinColumn(name = "COORDENADA_ID", referencedColumnName = "COORDENADA_ID", nullable = false)
    @OneToOne(optional = false)
    private Coordenadas coordenadaId;
    @JoinColumn(name = "ESCOLARIDAD_ESCOLARIDAD_ID", referencedColumnName = "ESCOLARIDAD_ID", nullable = false)
    @ManyToOne(optional = false)
    private Escolaridad escolaridadEscolaridadId;
    @JoinColumn(name = "NOTIFICACIONES_NOTIFICACION_ID", referencedColumnName = "NOTIFICACION_ID", nullable = false)
    @ManyToOne(optional = false)
    private Notificaciones notificacionesNotificacionId;
    @JoinColumn(name = "ROLES_ROL_ID", referencedColumnName = "ROL_ID", nullable = false)
    @ManyToOne(optional = false)
    private Roles rolesRolId;

    public Usuarios() {
    }

    public Usuarios(BigDecimal usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuarios(BigDecimal usuarioId, String usuarioNombres, String usuarioApellidos, String usuarioCorreo, String usuarioContrasenia) {
        this.usuarioId = usuarioId;
        this.usuarioNombres = usuarioNombres;
        this.usuarioApellidos = usuarioApellidos;
        this.usuarioCorreo = usuarioCorreo;
        this.usuarioContrasenia = usuarioContrasenia;
    }

    public BigDecimal getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigDecimal usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombres() {
        return usuarioNombres;
    }

    public void setUsuarioNombres(String usuarioNombres) {
        this.usuarioNombres = usuarioNombres;
    }

    public String getUsuarioApellidos() {
        return usuarioApellidos;
    }

    public void setUsuarioApellidos(String usuarioApellidos) {
        this.usuarioApellidos = usuarioApellidos;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioContrasenia() {
        return usuarioContrasenia;
    }

    public void setUsuarioContrasenia(String usuarioContrasenia) {
        this.usuarioContrasenia = usuarioContrasenia;
    }

    public String getUsuarioTelefono() {
        return usuarioTelefono;
    }

    public void setUsuarioTelefono(String usuarioTelefono) {
        this.usuarioTelefono = usuarioTelefono;
    }

    public Calificaciones getCalificacionesCalificacionId() {
        return calificacionesCalificacionId;
    }

    public void setCalificacionesCalificacionId(Calificaciones calificacionesCalificacionId) {
        this.calificacionesCalificacionId = calificacionesCalificacionId;
    }

    public Coordenadas getCoordenadaId() {
        return coordenadaId;
    }

    public void setCoordenadaId(Coordenadas coordenadaId) {
        this.coordenadaId = coordenadaId;
    }

    public Escolaridad getEscolaridadEscolaridadId() {
        return escolaridadEscolaridadId;
    }

    public void setEscolaridadEscolaridadId(Escolaridad escolaridadEscolaridadId) {
        this.escolaridadEscolaridadId = escolaridadEscolaridadId;
    }

    public Notificaciones getNotificacionesNotificacionId() {
        return notificacionesNotificacionId;
    }

    public void setNotificacionesNotificacionId(Notificaciones notificacionesNotificacionId) {
        this.notificacionesNotificacionId = notificacionesNotificacionId;
    }

    public Roles getRolesRolId() {
        return rolesRolId;
    }

    public void setRolesRolId(Roles rolesRolId) {
        this.rolesRolId = rolesRolId;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Usuarios[ usuarioId=" + usuarioId + " ]";
    }
    
}
