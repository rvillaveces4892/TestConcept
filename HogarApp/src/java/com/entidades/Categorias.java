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
@Table(name = "CATEGORIAS", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")
    , @NamedQuery(name = "Categorias.findByCategoriaId", query = "SELECT c FROM Categorias c WHERE c.categoriaId = :categoriaId")
    , @NamedQuery(name = "Categorias.findByCategoriaNombre", query = "SELECT c FROM Categorias c WHERE c.categoriaNombre = :categoriaNombre")
    , @NamedQuery(name = "Categorias.findByCategoriaEstado", query = "SELECT c FROM Categorias c WHERE c.categoriaEstado = :categoriaEstado")
    , @NamedQuery(name = "Categorias.findByCategoriaCreacion", query = "SELECT c FROM Categorias c WHERE c.categoriaCreacion = :categoriaCreacion")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal categoriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CATEGORIA_NOMBRE", nullable = false, length = 100)
    private String categoriaNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA_ESTADO", nullable = false)
    private Character categoriaEstado;
    @Column(name = "CATEGORIA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date categoriaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId")
    private List<CategoriaServicio> categoriaServicioList;

    public Categorias() {
    }

    public Categorias(BigDecimal categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Categorias(BigDecimal categoriaId, String categoriaNombre, Character categoriaEstado) {
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.categoriaEstado = categoriaEstado;
    }

    public BigDecimal getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(BigDecimal categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public Character getCategoriaEstado() {
        return categoriaEstado;
    }

    public void setCategoriaEstado(Character categoriaEstado) {
        this.categoriaEstado = categoriaEstado;
    }

    public Date getCategoriaCreacion() {
        return categoriaCreacion;
    }

    public void setCategoriaCreacion(Date categoriaCreacion) {
        this.categoriaCreacion = categoriaCreacion;
    }

    @XmlTransient
    public List<CategoriaServicio> getCategoriaServicioList() {
        return categoriaServicioList;
    }

    public void setCategoriaServicioList(List<CategoriaServicio> categoriaServicioList) {
        this.categoriaServicioList = categoriaServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaId != null ? categoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.categoriaId == null && other.categoriaId != null) || (this.categoriaId != null && !this.categoriaId.equals(other.categoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Categorias[ categoriaId=" + categoriaId + " ]";
    }
    
}
