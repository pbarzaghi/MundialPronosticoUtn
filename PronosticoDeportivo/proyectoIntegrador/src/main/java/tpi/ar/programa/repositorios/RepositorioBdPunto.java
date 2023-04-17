/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionBd;
import tpi.ar.programa.exception.FileIntegradorException;
import resources.MsgProperty;
import tpi.ar.programa.enumerado.PuntosResultado;

/**
 *
 * @author pbarzaghi
 */
public class RepositorioBdPunto {
      public  PuntosResultado getTablaDePuntos() throws FileIntegradorException {
       
     
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Connection conn = null;
            Conexion conexion= new ConexionBd();
            PuntosResultado puntos=null;
            String qry="Select * from puntos";
        try{
            conn = (Connection) conexion.abrirConexion();
            stmt = conn.prepareStatement(qry);
            rs = stmt.executeQuery(qry);
            // Procesa los resultados
            if (rs.next()) {
                puntos= new PuntosResultado();
                puntos.setPuntoGanar(rs.getInt("ptosGanar"));
                puntos.setPuntoEmpatar(rs.getInt("ptosEmpatar"));  
                puntos.setPuntoPerder(rs.getInt("ptosPerder"));
                puntos.setPuntoAcierto(rs.getInt("ptosAcertar"));
                puntos.setPuntosRonda(rs.getInt("ptosRonda"));
                puntos.setPuntosFase(rs.getInt("ptosFase"));
            }
         
            conexion.cerrarConexion();
             
        } catch (SQLException ex) {
            throw new FileIntegradorException(MsgProperty.getMensaje("error.sentenciaSql"));
        }
     return puntos;

    }
    
    
}
