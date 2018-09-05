/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rootMaster
 */
@Entity
@Table(name = "COORDENADAS", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordenadas.findAll", query = "SELECT c FROM Coordenadas c")
    , @NamedQuery(name = "Coordenadas.findByCoordenadaId", query = "SELECT c FROM Coordenadas c WHERE c.coordenadaId = :coordenadaId")
    , @NamedQuery(name = "Coordenadas.findByCoordenadaLatitud", query = "SELECT c FROM Coordenadas c WHERE c.coordenadaLatitud = :coordenadaLatitud")
    , @NamedQuery(name = "Coordenadas.findByCoordenadaLongitud", query = "SELECT c FROM Coordenadas c WHERE c.coordenadaLongitud = :coordenadaLongitud")
    , @NamedQuery(name = "Coordenadas.findByCoordenadaEstado", query = "SELECT c FROM Coordenadas c WHERE c.coordenadaEstado = :coordenadaEstado")})
public class Coordenadas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COORDENADA_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal coordenadaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "COORDENADA_LATITUD", nullable = false, length = 80)
    private String coordenadaLatitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "COORDENADA_LONGITUD", nullable = false, length = 80)
    private String coordenadaLongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COORDENADA_ESTADO", nullable = false)
    private Character coordenadaEstado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coordenadaId")
    private Usuarios usuarios;

    public Coordenadas() {
    }

    public Coordenadas(BigDecimal coordenadaId) {
        this.coordenadaId = coordenadaId;
    }

    public Coordenadas(BigDecimal coordenadaId, String coordenadaLatitud, String coordenadaLongitud, Character coordenadaEstado) {
        this.coordenadaId = coordenadaId;
        this.coordenadaLatitud = coordenadaLatitud;
        this.coordenadaLongitud = coordenadaLongitud;
        this.coordenadaEstado = coordenadaEstado;
    }

    public BigDecimal getCoordenadaId() {
        return coordenadaId;
    }

    public void setCoordenadaId(BigDecimal coordenadaId) {
        this.coordenadaId = coordenadaId;
    }

    public String getCoordenadaLatitud() {
        return coordenadaLatitud;
    }

    public void setCoordenadaLatitud(String coordenadaLatitud) {
        this.coordenadaLatitud = coordenadaLatitud;
    }

    public String getCoordenadaLongitud() {
        return coordenadaLongitud;
    }

    public void setCoordenadaLongitud(String coordenadaLongitud) {
        this.coordenadaLongitud = coordenadaLongitud;
    }

    public Character getCoordenadaEstado() {
        return coordenadaEstado;
    }

    public void setCoordenadaEstado(Character coordenadaEstado) {
        this.coordenadaEstado = coordenadaEstado;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coordenadaId != null ? coordenadaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordenadas)) {
            return false;
        }
        Coordenadas other = (Coordenadas) object;
        if ((this.coordenadaId == null && other.coordenadaId != null) || (this.coordenadaId != null && !this.coordenadaId.equals(other.coordenadaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Coordenadas[ coordenadaId=" + coordenadaId + " ]";
    }
    
}
