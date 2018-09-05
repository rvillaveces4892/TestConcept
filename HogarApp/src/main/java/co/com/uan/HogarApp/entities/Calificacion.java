/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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

/**
 *
 * @author rvill
 */
@Entity
@Table(name = "CALIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByCalificacionId", query = "SELECT c FROM Calificacion c WHERE c.calificacionId = :calificacionId")
    , @NamedQuery(name = "Calificacion.findByComentario", query = "SELECT c FROM Calificacion c WHERE c.comentario = :comentario")
    , @NamedQuery(name = "Calificacion.findByValor", query = "SELECT c FROM Calificacion c WHERE c.valor = :valor")
    , @NamedQuery(name = "Calificacion.findByFechaCreacion", query = "SELECT c FROM Calificacion c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Calificacion.findByEstado", query = "SELECT c FROM Calificacion c WHERE c.estado = :estado")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFICACION_ID")
    private Long calificacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "COMENTARIO")
    private String comentario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "USUARIO_ID_CALIFICADOR", referencedColumnName = "USUARIO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdCalificador;
    @JoinColumn(name = "USUARIO_ID_CALIFICADO", referencedColumnName = "USUARIO_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdCalificado;

    public Calificacion() {
    }

    public Calificacion(Long calificacionId) {
        this.calificacionId = calificacionId;
    }

    public Calificacion(Long calificacionId, String comentario, String estado) {
        this.calificacionId = calificacionId;
        this.comentario = comentario;
        this.estado = estado;
    }

    public Long getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(Long calificacionId) {
        this.calificacionId = calificacionId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public Usuario getUsuarioIdCalificador() {
        return usuarioIdCalificador;
    }

    public void setUsuarioIdCalificador(Usuario usuarioIdCalificador) {
        this.usuarioIdCalificador = usuarioIdCalificador;
    }

    public Usuario getUsuarioIdCalificado() {
        return usuarioIdCalificado;
    }

    public void setUsuarioIdCalificado(Usuario usuarioIdCalificado) {
        this.usuarioIdCalificado = usuarioIdCalificado;
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
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionId == null && other.calificacionId != null) || (this.calificacionId != null && !this.calificacionId.equals(other.calificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.Calificacion[ calificacionId=" + calificacionId + " ]";
    }
    
}
