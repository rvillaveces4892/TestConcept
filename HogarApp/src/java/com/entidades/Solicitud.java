/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rootMaster
 */
@Entity
@Table(name = "SOLICITUD", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findBySolicitudId", query = "SELECT s FROM Solicitud s WHERE s.solicitudId = :solicitudId")
    , @NamedQuery(name = "Solicitud.findByClienteId", query = "SELECT s FROM Solicitud s WHERE s.clienteId = :clienteId")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal solicitudId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID", nullable = false)
    private BigInteger clienteId;
    @JoinColumn(name = "SERVICIO_ID", referencedColumnName = "SERVICIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Servicios servicioId;

    public Solicitud() {
    }

    public Solicitud(BigDecimal solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Solicitud(BigDecimal solicitudId, BigInteger clienteId) {
        this.solicitudId = solicitudId;
        this.clienteId = clienteId;
    }

    public BigDecimal getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(BigDecimal solicitudId) {
        this.solicitudId = solicitudId;
    }

    public BigInteger getClienteId() {
        return clienteId;
    }

    public void setClienteId(BigInteger clienteId) {
        this.clienteId = clienteId;
    }

    public Servicios getServicioId() {
        return servicioId;
    }

    public void setServicioId(Servicios servicioId) {
        this.servicioId = servicioId;
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
        return "com.entidades.Solicitud[ solicitudId=" + solicitudId + " ]";
    }
    
}
