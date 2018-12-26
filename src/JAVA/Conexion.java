/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Naga
 */
public class Conexion {

    private String usuario;
    private String pass;

    public Conexion(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    public Connection getConexion(){
        Connection conn=null;
        try {
            //variables para conectarnos
            String driver="com.mysql.jdbc.Driver";
            String prefix="jdbc:"+"mysql:";
            String hostName="//localhost:3306/";
            String urlFolder="";
            String dbName="pe7";
            String url=prefix+hostName+urlFolder+dbName;
            String user=usuario;
            String password=pass;
            //establecemos la conexion
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Fallo en la conexion");
        }
        return conn;
    }
}
