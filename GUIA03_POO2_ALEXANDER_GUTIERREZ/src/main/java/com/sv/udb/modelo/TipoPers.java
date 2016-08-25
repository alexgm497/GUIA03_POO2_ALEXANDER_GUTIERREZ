/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Alexander José
 */
public class TipoPers {
    private int idTipo;
    private String nombTipo;

    public TipoPers() {
    }

    public TipoPers(int idTipo, String NombTipo) {
        this.idTipo = idTipo;
        this.nombTipo = NombTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombTipo() {
        return nombTipo;
    }

    public void setNombTipo(String NombTipo) {
        this.nombTipo = NombTipo;
    }
    
    
}
