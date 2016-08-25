/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.recursos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    Connection conn = null;
    private String url, user, password;

    public Connection getConn() {
        try {            
            if (this.getDatosConexion()) {                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(this.url, this.user, this.password);
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());            
        }
        return conn;
    }

    private boolean getDatosConexion() {
        try {            
            Properties prop = new Properties();
            String propFileName = URLDecoder.decode(this.getClass().getClassLoader().getResource("/config.properties").getPath(),"UTF-8");
            File file = new File(propFileName);
            FileInputStream fis = new FileInputStream(file.getAbsoluteFile());
            prop.load(fis);
            if (fis == null) {
                throw new FileNotFoundException("Propiedades no encontradas dentro de: '" + propFileName + "'");
            }
            //Obtener Valores de la Conexion
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }
    }
}
