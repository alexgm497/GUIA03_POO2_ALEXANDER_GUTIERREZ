/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Personas;
import com.sv.udb.recursos.Conexion;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander José
 */
public class PersonasCtrl {
    public boolean guar(Personas obje, InputStream foto, String FechAlta){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO PERS VALUES(?,?,?,?,?,?,STR_TO_DATE(?, '%d-%m-%Y'),?,?,?,?,STR_TO_DATE(?, '%d-%m-%Y %H:%i:%s'),NULL,NULL)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getIdPers());
            cmd.setString(2, obje.getNombPers());
            cmd.setString(3, obje.getApelPers());
            cmd.setBlob(4, foto);
            cmd.setInt(5, obje.getIdTipo());
            cmd.setString(6, obje.getGenePers());
            cmd.setString(7, obje.getFechNaci());
            cmd.setString(8, obje.getDui());
            cmd.setString(9, obje.getNit());
            cmd.setString(10, obje.getTipoSangre());
            cmd.setInt(11, obje.getIdDirec());
            cmd.setString(12, FechAlta);
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public int consNum(){
        int cant = 0;
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT COUNT(*) FROM PERS";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            if(rs.next()){
                cant = rs.getInt(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return cant;
    }
    public List<Personas> consTodo(){
        List<Personas> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT p.CODI_PERS, p.NOMB_PERS, p.APEL_PERS, t.NOMB_TIPO_PERS, (SELECT CASE WHEN p.GENE_PERS = 'M' THEN 'Masculino' ELSE 'Femenino' END) AS Genero,DATE_FORMAT(p.FECH_NACI_PERS, '%d-%m-%Y') AS Nacimiento, p.DUI_PERS, p.NIT_PERS, p.TIPO_SANG_PERS, u.NOMB_UBIC_GEOG from pers p, ubic_geog u, tipo_pers t WHERE u.CODI_UBIC_GEOG = p.CODI_UBIC_GEOG AND p.CODI_TIPO_PERS = t.CODI_TIPO_PERS AND p.FECH_BAJA IS NULL";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public Personas cons(int idPers){
        Personas resp = null;
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT p.CODI_PERS, p.NOMB_PERS, p.APEL_PERS, p.CODI_TIPO_PERS, (SELECT CASE WHEN p.GENE_PERS = 'M' THEN 'Masculino' ELSE 'Femenino' END) AS Genero,DATE_FORMAT(p.FECH_NACI_PERS, '%d-%m-%Y') AS Nacimiento, p.DUI_PERS, p.NIT_PERS, p.TIPO_SANG_PERS, p.CODI_UBIC_GEOG from pers p WHERE p.FECH_BAJA IS NULL AND p.CODI_PERS = ?";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            cmd.setInt(1, idPers);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = new Personas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public boolean actu(Personas obje, InputStream foto, String Fecha){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String ConsultaNumHist = "SELECT COUNT(*) FROM PERS_HIST";
            PreparedStatement cmd = cn.prepareStatement(ConsultaNumHist);
            ResultSet rs = cmd.executeQuery();
            rs.next();
            int numHist = rs.getInt(1) + 1;
            String ConsultaCopia = "SELECT P.CODI_PERS, P.NOMB_PERS, P.APEL_PERS, P.FOTO_PERS, P.CODI_TIPO_PERS, P.GENE_PERS, DATE_FORMAT(P.FECH_NACI_PERS, '%Y-%m-%d %H:%i:%s'), P.DUI_PERS, P.NIT_PERS, P.TIPO_SANG_PERS, P.CODI_UBIC_GEOG FROM pers P WHERE P.CODI_PERS = ?";
            cmd = cn.prepareStatement(ConsultaCopia);
            cmd.setInt(1, obje.getIdPers());
            rs = cmd.executeQuery();
            rs.next();
            String ConsultaPegar = "INSERT INTO PERS_HIST VALUES(?,?,?,?,?,?,?,STR_TO_DATE(?, '%d-%m-%Y %H:%i:%s'),NULL,NULL)";
            cmd = cn.prepareStatement(ConsultaPegar);
            cmd.setInt(1, numHist);
            cmd.setInt(2, obje.getIdPers());
            cmd.setString(3, rs.getString(2));
            cmd.setString(4, rs.getString(3));
            cmd.setBlob(5, rs.getBlob(4));
            cmd.setInt(6, rs.getInt(5));
            cmd.setInt(7, rs.getInt(11));
            cmd.setString(8, Fecha);
            cmd.executeUpdate();
            String ConsultaActu = "UPDATE PERS SET NOMB_PERS = ?, APEL_PERS = ?, FOTO_PERS = ?, CODI_TIPO_PERS = ?, CODI_UBIC_GEOG = ? WHERE CODI_PERS = ?";
            cmd = cn.prepareStatement(ConsultaActu);
            cmd.setString(1, obje.getNombPers());
            cmd.setString(2, obje.getApelPers());
            cmd.setBlob(3, foto);
            cmd.setInt(4, obje.getIdTipo());
            cmd.setInt(5, obje.getIdDirec());
            cmd.setInt(6, obje.getIdPers());
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    public boolean elim(Personas obje, String Fecha){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE PERS SET FECH_BAJA = STR_TO_DATE(?, '%d-%m-%Y %H:%i:%s') WHERE CODI_PERS = ?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, Fecha);
            cmd.setInt(2, obje.getIdPers());
            cmd.executeUpdate();
            resp = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!= null){
                try{
                    if(!cn.isClosed()){
                        cn.close();
                    }
                }catch(SQLException ex){
                     ex.printStackTrace();
                }
            }
        }
        return resp;
    }
}
