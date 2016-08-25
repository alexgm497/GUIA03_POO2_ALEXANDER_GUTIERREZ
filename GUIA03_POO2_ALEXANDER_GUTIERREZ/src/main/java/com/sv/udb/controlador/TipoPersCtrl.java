/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoPers;
import com.sv.udb.recursos.Conexion;
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
public class TipoPersCtrl {
    public List<TipoPers> consTodo(){
        List<TipoPers> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try{
            String consulta = "SELECT * FROM TIPO_PERS ORDER BY CODI_TIPO_PERS ASC";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new TipoPers(rs.getInt(1), rs.getString(2)));
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
    
}
