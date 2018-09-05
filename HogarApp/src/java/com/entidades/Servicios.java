/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SERVICIOS", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findByServicioId", query = "SELECT s FROM Servicios s WHERE s.servicioId = :servicioId")
    , @NamedQuery(name = "Servicios.findByServicioDetalle", query = "SELECT s FROM Servicios s WHERE s.servicioDetalle = :servicioDetalle")
    , @NamedQuery(name = "Servicios.findByServicioCostopromedio", query = "SELECT s FROM Servicios s WHERE s.servicioCostopromedio = :servicioCostopromedio")
    , @NamedQuery(name = "Servicios.findByServicioEstado", query = "SELECT s FROM Servicios s WHERE s.servicioEstado = :servicioEstado")
    , @NamedQuery(name = "Servicios.findByServicioCreacion", query = "SELECT s FROM Servicios s WHERE s.servicioCreacion = :servicioCreacion")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal servicioId;
    @Size(max = 200)
    @Column(name = "SERVICIO_DETALLE", length = 200)
    private String servicioDetalle;
    @Size(max = 30)
    @Column(name = "SERVICIO_COSTOPROMEDIO", length = 30)
    private String servicioCostopromedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ESTADO", nullable = false)
    private Character servicioEstado;
    @Column(name = "SERVICIO_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servicioCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioId")
    private List<CategoriaServicio> categoriaServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioId")
    private List<Solicitud> solicitudList;

    public Servicios() {
    }

    public Servicios(BigDecimal servicioId) {
        this.servicioId = servicioId;
    }

    public Servicios(BigDecimal servicioId, Character servicioEstado) {
        this.servicioId = servicioId;
        this.servicioEstado = servicioEstado;
    }

    public BigDecimal getServicioId() {
        return servicioId;
    }

    public void setServicioId(BigDecimal servicioId) {
        this.servicioId = servicioId;
    }

    public String getServicioDetalle() {
        return servicioDetalle;
    }

    public void setServicioDetalle(String servicioDetalle) {
        this.servicioDetalle = servicioDetalle;
    }

    public String getServicioCostopromedio() {
        return servicioCostopromedio;
    }

    public void setServicioCostopromedio(String servicioCostopromedio) {
        this.servicioCostopromedio = servicioCostopromedio;
    }

    public Character getServicioEstado() {
        return servicioEstado;
    }

    public void setServicioEstado(Character servicioEstado) {
        this.servicioEstado = servicioEstado;
    }

    public Date getServicioCreacion() {
        return servicioCreacion;
    }

    public void setServicioCreacion(Date servicioCreacion) {
        this.servicioCreacion = servicioCreacion;
    }

    @XmlTransient
    public List<CategoriaServicio> getCategoriaServicioList() {
        return categoriaServicioList;
    }

    public void setCategoriaServicioList(List<CategoriaServicio> categoriaServicioList) {
        this.categoriaServicioList = categoriaServicioList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioId != null ? servicioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.servicioId == null && other.servicioId != null) || (this.servicioId != null && !this.servicioId.equals(other.servicioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Servicios[ servicioId=" + servicioId + " ]";
    }
    
}
