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
 * Esta clase define las propiedades y los comportamientos del objeto LugaAcce
 * @author Alexander José
 * @version 1.0
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
    /**
     * Variable privada: Id del lugar de acceso
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODI_LUGA_ACCE")
    private Long codiLugaAcce;
    /**
     * Variable privada: Nombre del lugar de acceso
     */
    @Size(max = 100)
    @Column(name = "NOMB_LUGA_ACCE")
    private String nombLugaAcce;
    /**
     * Variable privada: Fecha en que se crea el registro
     */
    @Column(name = "FECH_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechAlta;
    /**
     * Variable privada: Fecha en que se elimina el registro
     */
    @Column(name = "FECH_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechBaja;
    /**
     * Variable privada: Estado del registro
     */
    @Lob
    @Column(name = "ESTA")
    private byte[] esta;

    /**
     * Constructor de clase
     */
    public LugaAcce() {
    }

    /**
     * Constructor de clase
     * @param codiLugaAcce Long que guarda el id del lugar de acceso
     */
    public LugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    /**
     * Constructor de clase
     * @param codiLugaAcce Long que guarda el id del lugar de acceso
     * @param nombLugaAcce String que guarda el nombre del lugar de acceso
     * @param fechAlta Date que guarda la fecha en que se crea el registro
     * @param fechBaja Date que guarda la fecha en que se elimina el registro
     * @param esta byte que guarda el estado del registro
     */
    public LugaAcce(Long codiLugaAcce, String nombLugaAcce, Date fechAlta, Date fechBaja, byte[] esta) {
        this.codiLugaAcce = codiLugaAcce;
        this.nombLugaAcce = nombLugaAcce;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    /**
     * Metodo para obtener el id del registro
     * @return Long con id del lugar de acceso
     */
    public Long getCodiLugaAcce() {
        return codiLugaAcce;
    }

    /**
     * Metodo que define el atributo codiLugaAcce del objeto LugaAcce
     * @param codiLugaAcce Long que guarda el id del lugar de acceso 
     */
    public void setCodiLugaAcce(Long codiLugaAcce) {
        this.codiLugaAcce = codiLugaAcce;
    }

    /**
     * Metodo para obtener el nombre del lugar de acceso
     * @return String con el nombre del lugar de acceso
     */
    public String getNombLugaAcce() {
        return nombLugaAcce;
    }

    /**
     * Metodo que define el atributo nombLugaAcce del objeto LugaAcce
     * @param nombLugaAcce String que guarda el nombre del lugar de acceso
     */
    public void setNombLugaAcce(String nombLugaAcce) {
        this.nombLugaAcce = nombLugaAcce;
    }

    /**
     * Metodo para obtener la fecha en que se crea el registro
     * @return Date con fecha en que se crea el registro
     */
    public Date getFechAlta() {
        return fechAlta;
    }

    /**
     * Metodo que define el atributo fechAlta del objeto LugaAcce
     * @param fechAlta Date que guarda la fecha en que se crea el registro
     */
    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    /**
     * Metodo para obtener la fecha en que se elimina el registro
     * @return Date con fecha en que se elimina el registro
     */
    public Date getFechBaja() {
        return fechBaja;
    }

    /**
     * Metodo que define el atributo fechBaja del objeto LugaAcce
     * @param fechBaja Date que guarda la fecha en que se elimina el registro
     */
    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    /**
     * Metodo para obtener el estado del registro
     * @return byte con el estado del registro
     */
    public byte[] getEsta() {
        return esta;
    }

    /**
     * Metodo que define el atributo esta del objeto LugaAcce
     * @param esta byte que guarda el estado del registro
     */
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
