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
 * Esta clase define las propiedades y los comportamientos del objeto TipoGafe
 * @author Alexander José
 * @version 1.0
 */
@Entity
@Table(name = "tipo_gafe", catalog = "regivisitas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGafe.findAll", query = "SELECT t FROM TipoGafe t"),
    @NamedQuery(name = "TipoGafe.findByCodiTipoGafe", query = "SELECT t FROM TipoGafe t WHERE t.codiTipoGafe = :codiTipoGafe"),
    @NamedQuery(name = "TipoGafe.findByNombTipoGafe", query = "SELECT t FROM TipoGafe t WHERE t.nombTipoGafe = :nombTipoGafe"),
    @NamedQuery(name = "TipoGafe.findByFechAlta", query = "SELECT t FROM TipoGafe t WHERE t.fechAlta = :fechAlta"),
    @NamedQuery(name = "TipoGafe.findByFechBaja", query = "SELECT t FROM TipoGafe t WHERE t.fechBaja = :fechBaja")})
public class TipoGafe implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Variable privada: Id del tipo de gafete
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODI_TIPO_GAFE")
    private Long codiTipoGafe;
    /**
     * Variable privada: Nombre del tipo de gafete
     */
    @Size(max = 200)
    @Column(name = "NOMB_TIPO_GAFE")
    private String nombTipoGafe;
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
    public TipoGafe() {
    }

    /**
     *
     * @param codiTipoGafe Long que guarda el id del tipo de gafete
     * @param nombTipoGafe String que guarda el nombre del tipo de gafete
     * @param fechAlta Date que guarda la fecha en que se crea el registro
     * @param fechBaja Date que guarda la fecha en que se elimina el registro
     * @param esta byte que guarda el estado del registro
     */
    public TipoGafe(Long codiTipoGafe, String nombTipoGafe, Date fechAlta, Date fechBaja, byte[] esta) {
        this.codiTipoGafe = codiTipoGafe;
        this.nombTipoGafe = nombTipoGafe;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    /**
     * Constructor de clase
     * @param codiTipoGafe  Long que guarda el id del tipo de gafete
     */
    public TipoGafe(Long codiTipoGafe) {
        this.codiTipoGafe = codiTipoGafe;
    }

    /**
     * Metodo para obtener el id del registro
     * @return Long con id del tipo de gafete
     */
    public Long getCodiTipoGafe() {
        return codiTipoGafe;
    }

    /**
     * Metodo que define el atributo codiTipoGafe del objeto TipoGafe
     * @param codiTipoGafe Long que guarda el id del tipo de gafete
     */
    public void setCodiTipoGafe(Long codiTipoGafe) {
        this.codiTipoGafe = codiTipoGafe;
    }

    /**
     * Metodo para obtener el nombre del tipo de gafete
     * @return String con nombre del tipo de gafete
     */
    public String getNombTipoGafe() {
        return nombTipoGafe;
    }

    /**
     * Metodo que define el atributo nombTipoGafe del objeto TipoGafe
     * @param nombTipoGafe String que guarda el nombre del tipo de gafete
     */
    public void setNombTipoGafe(String nombTipoGafe) {
        this.nombTipoGafe = nombTipoGafe;
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
        hash += (codiTipoGafe != null ? codiTipoGafe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGafe)) {
            return false;
        }
        TipoGafe other = (TipoGafe) object;
        if ((this.codiTipoGafe == null && other.codiTipoGafe != null) || (this.codiTipoGafe != null && !this.codiTipoGafe.equals(other.codiTipoGafe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.TipoGafe[ codiTipoGafe=" + codiTipoGafe + " ]";
    }
    
}
