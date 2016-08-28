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
 * Esta clase define las propiedades y los comportamientos del objeto TipoDocu
 * @author Alexander José
 * @version 1.0
 */
@Entity
@Table(name = "tipo_docu", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocu.findAll", query = "SELECT t FROM TipoDocu t"),
    @NamedQuery(name = "TipoDocu.findByCodiTipoDocu", query = "SELECT t FROM TipoDocu t WHERE t.codiTipoDocu = :codiTipoDocu"),
    @NamedQuery(name = "TipoDocu.findByNombTipoDocu", query = "SELECT t FROM TipoDocu t WHERE t.nombTipoDocu = :nombTipoDocu"),
    @NamedQuery(name = "TipoDocu.findByFechAlta", query = "SELECT t FROM TipoDocu t WHERE t.fechAlta = :fechAlta"),
    @NamedQuery(name = "TipoDocu.findByFechBaja", query = "SELECT t FROM TipoDocu t WHERE t.fechBaja = :fechBaja")})
public class TipoDocu implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Variable privada: Id del tipo de documento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODI_TIPO_DOCU")
    private Long codiTipoDocu;
    /**
     * Variable privada: Nombre del tipo de documento
     */
    @Size(max = 50)
    @Column(name = "NOMB_TIPO_DOCU")
    private String nombTipoDocu;
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
    public TipoDocu() {
    }

    /**
     * Constructor de clase
     * @param codiTipoDocu Long que guarda el id del tipo de documento
     * @param nombTipoDocu String que guarda el nombre del tipo de documento
     * @param fechAlta Date que guarda la fecha en que se crea el registro
     * @param fechBaja Date que guarda la fecha en que se elimina el registro
     * @param esta byte que guarda el estado del registro
     */
    public TipoDocu(Long codiTipoDocu, String nombTipoDocu, Date fechAlta, Date fechBaja, byte[] esta) {
        this.codiTipoDocu = codiTipoDocu;
        this.nombTipoDocu = nombTipoDocu;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    /**
     * Constructor de clase
     * @param codiTipoDocu Long que guarda el id del tipo de documento
     */
    public TipoDocu(Long codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    /**
     * Metodo para obtener el id del registro
     * @return Long con id del tipo de documento
     */
    public Long getCodiTipoDocu() {
        return codiTipoDocu;
    }

    /**
     * Metodo que define el atributo codiTipoDocu del objeto TipoDocu
     * @param codiTipoDocu
     */
    public void setCodiTipoDocu(Long codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    /**
     * Metodo para obtener el nombre del tipo de documento
     * @return String con nombre del tipo de documento
     */
    public String getNombTipoDocu() {
        return nombTipoDocu;
    }

    /**
     * Metodo que define el atributo nombTipoDocu del objeto TipoDocu
     * @param nombTipoDocu String que guarda el nombre del tipo de documento
     */
    public void setNombTipoDocu(String nombTipoDocu) {
        this.nombTipoDocu = nombTipoDocu;
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
        hash += (codiTipoDocu != null ? codiTipoDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocu)) {
            return false;
        }
        TipoDocu other = (TipoDocu) object;
        if ((this.codiTipoDocu == null && other.codiTipoDocu != null) || (this.codiTipoDocu != null && !this.codiTipoDocu.equals(other.codiTipoDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.TipoDocu[ codiTipoDocu=" + codiTipoDocu + " ]";
    }

}
