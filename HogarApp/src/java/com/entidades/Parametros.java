/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author rootMaster
 */
@Entity
@Table(name = "PARAMETROS", catalog = "", schema = "C##HOGARAPP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p")
    , @NamedQuery(name = "Parametros.findByParametroId", query = "SELECT p FROM Parametros p WHERE p.parametroId = :parametroId")
    , @NamedQuery(name = "Parametros.findByParametroValor", query = "SELECT p FROM Parametros p WHERE p.parametroValor = :parametroValor")
    , @NamedQuery(name = "Parametros.findByParametroDescripcion", query = "SELECT p FROM Parametros p WHERE p.parametroDescripcion = :parametroDescripcion")
    , @NamedQuery(name = "Parametros.findByParametroEstado", query = "SELECT p FROM Parametros p WHERE p.parametroEstado = :parametroEstado")
    , @NamedQuery(name = "Parametros.findByParametroCreacion", query = "SELECT p FROM Parametros p WHERE p.parametroCreacion = :parametroCreacion")})
public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARAMETRO_ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal parametroId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PARAMETRO_VALOR", nullable = false, length = 200)
    private String parametroValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PARAMETRO_DESCRIPCION", nullable = false, length = 300)
    private String parametroDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARAMETRO_ESTADO", nullable = false)
    private Character parametroEstado;
    @Column(name = "PARAMETRO_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parametroCreacion;

    public Parametros() {
    }

    public Parametros(BigDecimal parametroId) {
        this.parametroId = parametroId;
    }

    public Parametros(BigDecimal parametroId, String parametroValor, String parametroDescripcion, Character parametroEstado) {
        this.parametroId = parametroId;
        this.parametroValor = parametroValor;
        this.parametroDescripcion = parametroDescripcion;
        this.parametroEstado = parametroEstado;
    }

    public BigDecimal getParametroId() {
        return parametroId;
    }

    public void setParametroId(BigDecimal parametroId) {
        this.parametroId = parametroId;
    }

    public String getParametroValor() {
        return parametroValor;
    }

    public void setParametroValor(String parametroValor) {
        this.parametroValor = parametroValor;
    }

    public String getParametroDescripcion() {
        return parametroDescripcion;
    }

    public void setParametroDescripcion(String parametroDescripcion) {
        this.parametroDescripcion = parametroDescripcion;
    }

    public Character getParametroEstado() {
        return parametroEstado;
    }

    public void setParametroEstado(Character parametroEstado) {
        this.parametroEstado = parametroEstado;
    }

    public Date getParametroCreacion() {
        return parametroCreacion;
    }

    public void setParametroCreacion(Date parametroCreacion) {
        this.parametroCreacion = parametroCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametroId != null ? parametroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.parametroId == null && other.parametroId != null) || (this.parametroId != null && !this.parametroId.equals(other.parametroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Parametros[ parametroId=" + parametroId + " ]";
    }
    
}
