/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander José
 */
@Entity
@Table(name = "luga_acce", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LugaAcce.findAll", query = "SELECT l FROM LugaAcce l"),
    @NamedQuery(name = "LugaAcce.findByCodiLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.codiLugaAcce = :codiLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByNombLugaAcce", query = "SELECT l FROM LugaAcce l WHERE l.nombLugaAcce = :nombLugaAcce"),
    @NamedQuery(name = "LugaAcce.findByFechAlta", query = "SELECT l FROM LugaAcce l WHERE l.fechAlta = :fechAlta"),
    @NamedQuery(name = "LugaAcce.findByFechBaja", query = "SELECT l FROM LugaAcce l WHERE l.fechBaja = :fechBaja")})
public class LugaAcce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODI_LUGA_ACCE")
    private Long codiLugaAcce;
    @Size(max = 100)
    @Column(name = "NOMB_LUGA_ACCE")
    private String nombLugaAcce;
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;

    public LugaAcce() {
    }

    public LugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    public LugaAcce(Long codiLugaAcce, String nombLugaAcce, Date fechAlta, Date fechBaja, byte[] esta) {
        this.codiLugaAcce = codiLugaAcce;
        this.nombLugaAcce = nombLugaAcce;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    public Long getCodiLugaAcce() {
        return codiLugaAcce;
    }

    public void setCodiLugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    public String getNombLugaAcce() {
        return nombLugaAcce;
    }

    public void setNombLugaAcce(String nombLugaAcce) {
        this.nombLugaAcce = nombLugaAcce;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFechBaja() {
        return fechBaja;
    }

    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    public byte[] getEsta() {
        return esta;
    }

    public void setEsta(byte[] esta) {
        this.esta = esta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLugaAcce != null ? codiLugaAcce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LugaAcce)) {
            return false;
        }
        LugaAcce other = (LugaAcce) object;
        if ((this.codiLugaAcce == null && other.codiLugaAcce != null) || (this.codiLugaAcce != null && !this.codiLugaAcce.equals(other.codiLugaAcce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.LugaAcce[ codiLugaAcce=" + codiLugaAcce + " ]";
    }
    
}
