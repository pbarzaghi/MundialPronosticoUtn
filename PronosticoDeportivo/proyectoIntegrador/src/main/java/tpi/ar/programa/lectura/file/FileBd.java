/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionBd;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.FormatoIncorrectoException;
import tpi.ar.programa.pronostico.Pronostico;

import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.participante.Participante;
import tpi.ar.programa.validador.ValidadorCampo;

/**
 *
 * @author pbarzaghi
 */
public class FileBd {
    
  
   
    
    public  PuntosResultado leerArchivoPuntos(Properties properties)throws Exception{
          PreparedStatement stmt = null;
          ResultSet rs = null;
          Connection conn = null;
          Conexion conexion= new ConexionBd();
          PuntosResultado puntos=null;
          String qry="Select * from puntos";
          conn = (Connection) conexion.abrirConexion(properties);
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
         conexion.cerrarConexion(conn);
         return puntos;
    }
    
    
     /*
      Este metodo lee dado el path del archivo los pronosticos y retorna una lista de Participante con
     los pronostico realizado
    cargados desde el archivo
    */
    public List<Participante> leerArchivoPronostico(Properties properties,HashMap object) throws  Exception{
             ValidadorCampo validador= new ValidadorCampo();
            HashMap objCreacion=( HashMap)object;
            List<Participante> listaParticipante =new ArrayList();
     
             PreparedStatement stmt = null;
             ResultSet rs = null;
            Connection conn = null;
            Conexion conexion= new ConexionBd();
            
            String qry="Select * from pronostico";
            conn = (Connection) conexion.abrirConexion(properties);
            stmt = conn.prepareStatement(qry); 
            rs = stmt.executeQuery(qry);
          
            while (rs.next()) {
                
                Pronostico pronostico= new Pronostico();
                pronostico.setId(rs.getInt("id"));
                String equipo1Name  =rs.getString("Equipo1");
                String equipo2Name =rs.getString("Equipo2");
               
                if(!(validador.validar(equipo1Name,"NOMBRE_MAYUSCULA") &&
                    validador.validar(equipo2Name,"NOMBRE_MAYUSCULA")    )    
                        )
                      throw  new FormatoIncorrectoException(" NOMBRE DE EQUIPO EN MAYUSCULA");
                    
                Equipo equipo1Obj=(Equipo)objCreacion.get(Equipo.class+equipo1Name);
                 if(equipo1Obj == null)
                         throw new FileIntegradorException("No encontro el Equipo ");
                    
                Equipo equipo2Obj=(Equipo)objCreacion.get(Equipo.class+equipo2Name);
                 
                 if(equipo2Obj == null)
                          throw new FileIntegradorException("No encontro el Equipo ");
                Partido partido= (Partido)  objCreacion.get(Partido.class+ equipo1Obj.getNombre()+"_"+equipo2Obj.getNombre() );
            
               if(partido== null)
                  partido= (Partido)  objCreacion.get(Partido.class+equipo2Obj.getNombre()+ "_"+
                                                                          equipo1Obj.getNombre() );
               if(partido == null)
                     throw new FileIntegradorException("No encontro el Partido con los equipo "+ equipo1Obj.getNombre()
                                             + " " +equipo2Obj.getNombre());
                
               
             
               pronostico.setEquipo(equipo1Obj);
               
                if(!(validador.validar(rs.getString("Ganado"), "RDO_PRONOSTICO")&&
                     validador.validar(rs.getString("Empatado"), "RDO_PRONOSTICO")&&
                     validador.validar(rs.getString("Perdido"), "RDO_PRONOSTICO")
                        ) )
                    throw  new FormatoIncorrectoException(" Los resultado Pronostico Incorrectos");
                
               pronostico.setResultado(
                 this.getResultadoPronostico(rs.getString("Ganado"),
                                                     rs.getString("Empatado"),
                                                     rs.getString("Perdido")) );
               
                pronostico.setPuntosResultado((PuntosResultado) objCreacion.get(PuntosResultado.class));
                pronostico.setPartido(partido);
                
                if(!validador.validar(rs.getString("Participante"),"NOMBRE_MAYUSCULA" ))
                     throw  new FormatoIncorrectoException("EL NOMBRE DE LA PARTICIPANTE VA EN MAYUCULA");
                
                Participante participante=(Participante)  objCreacion.remove(Participante.class+
                                                           rs.getString("Participante"));
                if(participante == null) {
                         participante= new Participante( rs.getString("Participante"));
                     }else
                         listaParticipante.remove(participante);
                     
                  participante.addPronostico(pronostico);
                  listaParticipante.add(participante);
                  objCreacion.put(Participante.class+participante.getNombre(),participante);
                 
              }
        conexion.cerrarConexion(conn);
        return listaParticipante;  
    }     
    
private ResultadoEmun getResultadoPronostico(String strGanadorEq1,String strEmpate,String strGanador2){

       
         if("X".equals(strGanadorEq1))
             return ResultadoEmun.GANADOR;
         else if("X".equals(strEmpate))
                  return ResultadoEmun.EMPATE;
         else
                  return ResultadoEmun.PERDEDOR;
}  
    
    
    
    
    
    
}
    
