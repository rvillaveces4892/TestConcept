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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rootMaster
 */
@Entity
@Table(name = "CATEGORIA_SERVICIO", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaServicio.findAll", query = "SELECT c FROM CategoriaServicio c")
    , @NamedQuery(name = "CategoriaServicio.findByCatserId", query = "SELECT c FROM CategoriaServicio c WHERE c.catserId = :catserId")})
public class CategoriaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATSER_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal catserId;
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "CATEGORIA_ID", nullable = false)
    @ManyToOne(optional = false)
    private Categorias categoriaId;
    @JoinColumn(name = "SERVICIO_ID", referencedColumnName = "SERVICIO_ID", nullable = false)
    @ManyToOne(optional = false)
    private Servicios servicioId;

    public CategoriaServicio() {
    }

    public CategoriaServicio(BigDecimal catserId) {
        this.catserId = catserId;
    }

    public BigDecimal getCatserId() {
        return catserId;
    }

    public void setCatserId(BigDecimal catserId) {
        this.catserId = catserId;
    }

    public Categorias getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categorias categoriaId) {
        this.categoriaId = categoriaId;
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
        hash += (catserId != null ? catserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaServicio)) {
            return false;
        }
        CategoriaServicio other = (CategoriaServicio) object;
        if ((this.catserId == null && other.catserId != null) || (this.catserId != null && !this.catserId.equals(other.catserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.CategoriaServicio[ catserId=" + catserId + " ]";
    }
    
}
