/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.repositorios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionBd;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.exception.FormatoIncorrectoException;
import tpi.ar.programa.entidades.Pronostico;
import tpi.ar.programa.entidades.Punto;
import tpi.ar.programa.entidades.Equipo;
import tpi.ar.programa.entidades.Partido;
import tpi.ar.programa.entidades.Participante;
import resources.MsgProperty;
import tpi.ar.programa.util.ClaseUtil;
import tpi.ar.programa.validador.ValidadorCampo;

/**
 *
 * @author pbarzaghi
 */
public class RepositorioBdPronostico {
    
  
  
    
     /*
      Este metodo lee dado el path del archivo los pronosticos.
      Por cada linea leida va generando la instancia Pronostico y obteniendo las
      instancia de Equipo,Partidode de la clase ClaseUtil que fueron cargadas con
      el metodo mapearPtosDeTablaPunto() y  mapearPartidosDeTablaResultado()
      Tambien genera la instancia Participante la cual se le van agregando los pronosticos 
      realizados.
      Return: List<Participante>
     
    */
    public List<Participante> obtenerParticipantesConPronostico() throws  Exception{
             ValidadorCampo validador= new ValidadorCampo();
      
            List<Participante> listaParticipante =new ArrayList();
     
            PreparedStatement stmt = null;
             ResultSet rs = null;
            Connection conn = null;
            Conexion conexion= new ConexionBd();
            
            String qry="Select * from pronostico";
            conn = (Connection) conexion.abrirConexion();
            stmt = conn.prepareStatement(qry); 
            rs = stmt.executeQuery(qry);
          
            while (rs.next()) {
                
                Pronostico pronostico= new Pronostico();
                pronostico.setId(rs.getInt("id"));
                String equipo1Name  =rs.getString("Equipo1");
                String equipo2Name =rs.getString("Equipo2");
               
                if(!(validador.validar(equipo1Name,"EQUIPO") &&
                    validador.validar(equipo2Name,"EQUIPO")    )    
                        )
                      throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.equipoMayuscula"));
                    
                Equipo equipo1Obj=(Equipo) ClaseUtil.obtenerObjeto(Equipo.class+equipo1Name);
                        //objCreacion.get(Equipo.class+equipo1Name);
                    
                 if(equipo1Obj == null)
                   throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.noExisteEquipo"));
                    
                Equipo equipo2Obj=(Equipo) ClaseUtil.obtenerObjeto(Equipo.class+equipo2Name);
                 
                 if(equipo2Obj == null)
                          throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.noExisteEquipo"));
                Partido partido= (Partido)   ClaseUtil.obtenerObjeto(Partido.class+ equipo1Obj.getNombre()+"_"+equipo2Obj.getNombre() );
            
               if(partido== null)
                  partido= (Partido)   ClaseUtil.obtenerObjeto(Partido.class+equipo2Obj.getNombre()+ "_"+
                                                                          equipo1Obj.getNombre() );
               if(partido == null)
                   throw  new  FormatoIncorrectoException(MsgProperty.getMensaje("error.noExistePartido"));  
                
               pronostico.setEquipo(equipo1Obj);
               
                if(!(validador.validar(rs.getString("ganado"), "PRONOSTICO")&&
                     validador.validar(rs.getString("empatado"), "PRONOSTICO")&&
                     validador.validar(rs.getString("perdido"), "PRONOSTICO")
                        ) )
                    throw  new  FormatoIncorrectoException(MsgProperty.getMensaje("error.pronosticoInvalido"));  
                
               pronostico.setResultado(
                 this.getResultadoPronostico(rs.getString("Ganado"),
                                                     rs.getString("Empatado"),
                                                     rs.getString("Perdido")) );
                //ClaseUtil.obtenerObjeto
                pronostico.setPuntosResultado((Punto) ClaseUtil.obtenerObjeto(Punto.class.toString()));
                pronostico.setPartido(partido);
                
                if(!validador.validar(rs.getString("Participante"),"PARTICIPANTE" ))
                     throw  new  FormatoIncorrectoException(MsgProperty.getMensaje("error.nameMayuscula"));  
           
                    
                
                Participante participante=(Participante) ClaseUtil.eliminarObjeto(Participante.class+
                                                           rs.getString("Participante"));
                
                
                
                if(participante == null) {
                         participante= new Participante( rs.getString("Participante"));
                     }else
                         listaParticipante.remove(participante);
                     
                  participante.addPronostico(pronostico);
                  //agrego los puntos por pronostico
                  participante.setCantidadPuntosObtenidos(participante.getCantidadPuntosObtenidos()+pronostico.getPuntos());

                  listaParticipante.add(participante);
                 ClaseUtil.agregarObjeto(Participante.class+participante.getNombre(),participante);
                 
              }
        conexion.cerrarConexion();
       
        return listaParticipante;  
    }     
    
    /**
     * Este metodo retorna que resultado fue segun el string por parametro ingresado.
     * @param strGanadorEq1
     * @param strEmpate
     * @param strGanador2
     * @return 
     */
     private ResultadoEmun getResultadoPronostico(String strGanadorEq1,
                                                  String strEmpate,
                                                  String strGanador2){

       
         if("X".equals(strGanadorEq1))
             return ResultadoEmun.GANADOR;
         else if("X".equals(strEmpate))
                  return ResultadoEmun.EMPATE;
         else
                  return ResultadoEmun.PERDEDOR;
}  
    
     
    
    
}
    
