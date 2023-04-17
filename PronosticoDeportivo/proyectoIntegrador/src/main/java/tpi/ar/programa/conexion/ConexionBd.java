/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tpi.ar.programa.exception.FileIntegradorException;
import resources.MsgProperty;

/**
 *
 * @author pbarzaghi
 */
public class ConexionBd implements Conexion{

     public PreparedStatement stmt = null;
     public ResultSet rs = null;
     private static Connection conn = null;
   
     @Override
    public void cerrarConexion() throws FileIntegradorException{
      
        try {
               if ( rs != null && !rs.isClosed()) {rs.close();rs=null;}
               if (stmt != null && !stmt.isClosed()) {stmt.close(); stmt=null;}
               if (conn != null && !conn.isClosed()){ this.conn.close(); conn=null;}
           } catch (SQLException ex) {
                  throw new FileIntegradorException(MsgProperty.getMensaje("error.sentenciaSql"));
           }
    }

    @Override
    public Object abrirConexion() throws FileIntegradorException {
      String url,user,pass;
         try {
            
             url = MsgProperty.getMensaje("jdbc.url");
             user =MsgProperty.getMensaje("jdbc.user");
             pass =MsgProperty.getMensaje("jdbc.pass");
             Class.forName(MsgProperty.getMensaje("jdbc.driver"));
             if (conn != null && !conn.isClosed()){ this.conn.close(); conn=null;}
             conn= DriverManager.getConnection(url, user, pass);
            
         } catch (FileIntegradorException ex) {
            throw new FileIntegradorException(MsgProperty.getMensaje("error.abrirBd"));
         }catch (ClassNotFoundException ex) {
           throw new FileIntegradorException(MsgProperty.getMensaje("error.driverManager"));
          } catch (SQLException ex) {
              throw new FileIntegradorException(MsgProperty.getMensaje("error.sentenciaSql"));
         }
         
          return conn;
    }
    
    
     @Override
      public void setConection(Object obj){
         this.conn=(Connection)obj;
      }
    
}
