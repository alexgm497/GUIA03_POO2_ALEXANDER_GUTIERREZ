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
public class Direcc {
    private int idDirec;
    private String nombDirec;

    public Direcc() {
    }

    public Direcc(int idDirec, String nombDirec) {
        this.idDirec = idDirec;
        this.nombDirec = nombDirec;
    }

    public int getIdDirec() {
        return idDirec;
    }

    public void setIdDirec(int idDirec) {
        this.idDirec = idDirec;
    }

    public String getNombDirec() {
        return nombDirec;
    }

    public void setNombDirec(String nombDirec) {
        this.nombDirec = nombDirec;
    }
    
    
}
