/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author rvill
 */
@Entity
@Table(name = "COORDENADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordenadas.findAll", query = "SELECT c FROM Coordenadas c")
    , @NamedQuery(name = "Coordenadas.findByCoordenadaId", query = "SELECT c FROM Coordenadas c WHERE c.coordenadaId = :coordenadaId")
    , @NamedQuery(name = "Coordenadas.findByLatitud", query = "SELECT c FROM Coordenadas c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "Coordenadas.findByLongitud", query = "SELECT c FROM Coordenadas c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "Coordenadas.findByFechaCreacion", query = "SELECT c FROM Coordenadas c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Coordenadas.findByEstado", query = "SELECT c FROM Coordenadas c WHERE c.estado = :estado")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coordenadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "COORDENADA_ID_SEQ", allocationSize=1)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "COORDENADA_ID")
    private Long coordenadaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "LATITUD")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "LONGITUD")
    private String longitud;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = new Date();
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO")
    private String estado = "ACTIVO";
    
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coordenadaId", fetch = FetchType.LAZY)
    private Usuario usuario;

    public Coordenadas() {
    }

    public Coordenadas(Long coordenadaId) {
        this.coordenadaId = coordenadaId;
    }

    public Coordenadas(Long coordenadaId, String latitud, String longitud, String estado) {
        this.coordenadaId = coordenadaId;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
    }

    public Long getCoordenadaId() {
        return coordenadaId;
    }

    public void setCoordenadaId(Long coordenadaId) {
        this.coordenadaId = coordenadaId;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return "app.Coordenadas[ coordenadaId=" + coordenadaId + " ]";
    }
    
}
