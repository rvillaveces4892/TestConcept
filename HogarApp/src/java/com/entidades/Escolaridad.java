/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rootMaster
 */
@Entity
@Table(name = "ESCOLARIDAD", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e")
    , @NamedQuery(name = "Escolaridad.findByEscolaridadId", query = "SELECT e FROM Escolaridad e WHERE e.escolaridadId = :escolaridadId")
    , @NamedQuery(name = "Escolaridad.findByEscolaridadNombre", query = "SELECT e FROM Escolaridad e WHERE e.escolaridadNombre = :escolaridadNombre")
    , @NamedQuery(name = "Escolaridad.findByEscolaridadEstado", query = "SELECT e FROM Escolaridad e WHERE e.escolaridadEstado = :escolaridadEstado")})
public class Escolaridad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESCOLARIDAD_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal escolaridadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ESCOLARIDAD_NOMBRE", nullable = false, length = 80)
    private String escolaridadNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESCOLARIDAD_ESTADO", nullable = false)
    private Character escolaridadEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escolaridadEscolaridadId")
    private List<Usuarios> usuariosList;

    public Escolaridad() {
    }

    public Escolaridad(BigDecimal escolaridadId) {
        this.escolaridadId = escolaridadId;
    }

    public Escolaridad(BigDecimal escolaridadId, String escolaridadNombre, Character escolaridadEstado) {
        this.escolaridadId = escolaridadId;
        this.escolaridadNombre = escolaridadNombre;
        this.escolaridadEstado = escolaridadEstado;
    }

    public BigDecimal getEscolaridadId() {
        return escolaridadId;
    }

    public void setEscolaridadId(BigDecimal escolaridadId) {
        this.escolaridadId = escolaridadId;
    }

    public String getEscolaridadNombre() {
        return escolaridadNombre;
    }

    public void setEscolaridadNombre(String escolaridadNombre) {
        this.escolaridadNombre = escolaridadNombre;
    }

    public Character getEscolaridadEstado() {
        return escolaridadEstado;
    }

    public void setEscolaridadEstado(Character escolaridadEstado) {
        this.escolaridadEstado = escolaridadEstado;
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
        hash += (escolaridadId != null ? escolaridadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.escolaridadId == null && other.escolaridadId != null) || (this.escolaridadId != null && !this.escolaridadId.equals(other.escolaridadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Escolaridad[ escolaridadId=" + escolaridadId + " ]";
    }
    
}
