/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.InputStream;

/**
 *
 * @author Alexander José
 */
public class Personas {
    private int idPers, idTipo, idDirec, numPers;
    private String nombPers, apelPers, genePers, fechNaci, dui, nit, tipoSangre, nombTipo, nombUbic;

    public Personas() {
    }

    public Personas(int idPers, String nombPers, String apelPers, int idTipo, String genePers, String fechNaci, String dui, String nit, String tipoSangre, int idDirec) {
        this.idPers = idPers;
        this.idTipo = idTipo;
        this.idDirec = idDirec;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.genePers = genePers;
        this.fechNaci = fechNaci;
        this.dui = dui;
        this.nit = nit;
        this.tipoSangre = tipoSangre;
    }

    public Personas(int idPers, String nombPers, String apelPers, String nombTipo, String genePers, String fechNaci, String dui, String nit, String tipoSangre, String nombUbic) {
        this.idPers = idPers;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.genePers = genePers;
        this.fechNaci = fechNaci;
        this.dui = dui;
        this.nit = nit;
        this.nombTipo = nombTipo;
        this.nombUbic = nombUbic;
        this.tipoSangre = tipoSangre;
    }

    public String getNombTipo() {
        return nombTipo;
    }

    public void setNombTipo(String nombTipo) {
        this.nombTipo = nombTipo;
    }

    public String getNombUbic() {
        return nombUbic;
    }

    public void setNombUbic(String nombUbic) {
        this.nombUbic = nombUbic;
    }

    public Personas(int numPers) {
        this.numPers = numPers;
    }

    public int getNumPers() {
        return numPers;
    }

    public void setNumPers(int numPers) {
        this.numPers = numPers;
    }

    public int getIdPers() {
        return idPers;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdDirec() {
        return idDirec;
    }

    public void setIdDirec(int idDirec) {
        this.idDirec = idDirec;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public String getGenePers() {
        return genePers;
    }

    public void setGenePers(String genePers) {
        this.genePers = genePers;
    }

    public String getFechNaci() {
        return fechNaci;
    }

    public void setFechNaci(String fechNaci) {
        this.fechNaci = fechNaci;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    
}
