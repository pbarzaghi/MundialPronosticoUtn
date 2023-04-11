/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import tpi.ar.programa.exception.FileIntegradorException;

/**
 *
 * @author pbarzaghi
 */
public class ConexionBd implements Conexion{

     public PreparedStatement stmt = null;
      public ResultSet rs = null;
      private Connection conn = null;
      private  final String PROPERTIES_JDBC = "jdbc.properties"; 
    

  

    @Override
    public void cerrarConexion(Object object) throws Exception{
       this.conn=(Connection) object;
        try {
               if (rs != null) rs.close();
               if (stmt != null) stmt.close();
               if (conn != null) this.conn.close();
           } catch (SQLException ex) {
                  throw new FileIntegradorException(ex.getMessage());
           }
    }

    @Override
    public Object abrirConexion(Object object) throws Exception{
      
            String url,user,pass;
        
            Properties properties=null;
        try {
             properties =(Properties) object;
             url =properties.getProperty("jdbc.url");
             user =properties.getProperty("jdbc.user");
             pass =properties.getProperty("jdbc.pass");
             Class.forName(properties.getProperty( "jdbc.driver"));
             conn= DriverManager.getConnection(url, user, pass);
           
            
        } catch (ClassNotFoundException ex) {
                throw new FileIntegradorException(ex.getMessage());
      
       }
        
         return conn;
    }
    
}
