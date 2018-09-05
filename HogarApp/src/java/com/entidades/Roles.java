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
@Table(name = "ROLES", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByRolId", query = "SELECT r FROM Roles r WHERE r.rolId = :rolId")
    , @NamedQuery(name = "Roles.findByRolNombre", query = "SELECT r FROM Roles r WHERE r.rolNombre = :rolNombre")
    , @NamedQuery(name = "Roles.findByRolEstado", query = "SELECT r FROM Roles r WHERE r.rolEstado = :rolEstado")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal rolId;
    @Size(max = 100)
    @Column(name = "ROL_NOMBRE", length = 100)
    private String rolNombre;
    @Column(name = "ROL_ESTADO")
    private Character rolEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolesRolId")
    private List<Usuarios> usuariosList;

    public Roles() {
    }

    public Roles(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Character getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(Character rolEstado) {
        this.rolEstado = rolEstado;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Roles[ rolId=" + rolId + " ]";
    }
    
}
