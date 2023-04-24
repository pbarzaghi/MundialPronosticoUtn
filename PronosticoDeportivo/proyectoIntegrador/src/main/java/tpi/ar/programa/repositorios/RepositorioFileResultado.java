/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.repositorios;

import java.util.HashMap;
import java.util.List;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionFileCsv;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.FormatoIncorrectoException;
import tpi.ar.programa.entidades.PuntosResultado;
import tpi.ar.programa.entidades.Equipo;
import tpi.ar.programa.entidades.Fase;
import tpi.ar.programa.entidades.Partido;
import tpi.ar.programa.entidades.Ronda;
import resources.MsgProperty;
import tpi.ar.programa.util.ClaseUtil;

import tpi.ar.programa.validador.ValidadorCampo;

/**
 *
 * @author pbaraghi
 */
public class RepositorioFileResultado {

    private  ValidadorCampo validador;
    
     public RepositorioFileResultado(){
          validador=new ValidadorCampo();
    }

 
    /*
     Este metodo se conecta a la bd, ejecuta la consulta Sql, obteniendo todos los resultados de los partidos
     disputados. Por cada partido se va generando los objetos Equipo1,Equipo2,Partido,Ronda,Fase y
     cargardo en un HashMap que se encuentra en la ClaseUtil el cual tiene una variable de clase Map.
     */
  
     
     public  void mapearPartidosDeTablaResultado() throws FileIntegradorException {
         
         // Path pathResultados= Paths.get(path);
              List<String> listaResultado=null;
             String pathResultado=MsgProperty.getMensaje("file.path")+
                                     MsgProperty.getMensaje("file.resultado") ;
              
              boolean primeraLineaArchivo=true;
              Conexion conexion= new ConexionFileCsv();
              conexion.setConection(pathResultado);
             listaResultado= ( List<String> ) conexion.abrirConexion();
          
             for (String lineaResultado : listaResultado) {
                
                 String[] campo=lineaResultado.split(",");
                 
                 if(primeraLineaArchivo)
                    primeraLineaArchivo=false;
                 else{
                      int idEquipo=1;
                      int idPartido=1;
                      Equipo equipo1= (Equipo) ClaseUtil.obtenerObjeto(Equipo.class+campo[1]);
                     // VALIDACION DE CAMPO
                      if(equipo1 == null){
                          if(!validador.validar(campo[1],"EQUIPO")){
                           throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.equipoMayuscula"));
                   }
                         equipo1= new Equipo(campo[1], "SELECCIONADO");
                         equipo1.setId(idEquipo);
                          ClaseUtil.agregarObjeto(Equipo.class+campo[1], equipo1);
                         idEquipo++;
                      }
                       Equipo equipo2= (Equipo)  ClaseUtil.obtenerObjeto(Equipo.class+campo[4]);
                         if(!validador.validar(campo[4],"EQUIPO")){
                           throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.equipoMayuscula"));
                         }
                       if(equipo2 == null){
                          equipo2= new Equipo(campo[4], "SELECCIONADO");
                          equipo2.setId(idEquipo);
                           ClaseUtil.agregarObjeto(Equipo.class+campo[4], equipo2);
                          idEquipo++;
                      }
                       Partido partido= (Partido)  ClaseUtil.obtenerObjeto(Partido.class+equipo1.getNombre()+
                                                                                                "_"+
                                                                                  equipo2.getNombre() );
                       if(partido == null){
                           partido =new Partido();
                           partido.setIdPartido(idPartido);
                           partido.setEquipo1(equipo1);
                           partido.setEquipo2(equipo2);
                          // VALIDACION DE CAMPO
                           if(!  ( validador.validar(campo[2],"GOLES") &&
                                    validador.validar(campo[3],"GOLES") 
                                    )){
                               throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.gol"));
                       }
                        partido.setGolesEquipo1(Integer.parseInt(campo[2]));
                        partido.setGolesEquipo2(Integer.parseInt(campo[3]));
                        partido.setPuntos((PuntosResultado) ClaseUtil.obtenerObjeto("PuntosResultado.class"));
                        ClaseUtil.agregarObjeto(Partido.class+equipo1.getNombre()+"_"+equipo2.getNombre(), partido);
                           idPartido++;
                        }

                       Ronda ronda= (Ronda)   ClaseUtil.obtenerObjeto(Ronda.class+campo[0]);
                        if(ronda == null){
                            ronda = new Ronda();
                            ronda.setNro(Integer.parseInt(campo[0]));
                            partido.setRonda(ronda);
                            ronda.appendPartido(partido);
                             ClaseUtil.agregarObjeto(Ronda.class+String.valueOf(ronda.getNro()), ronda);
                        }else{
                             partido.setRonda(ronda); 
                            ronda.appendPartido(partido);
                             
                        }
                         Fase fase= (Fase)   ClaseUtil.obtenerObjeto(Fase.class+campo[5]); 
                          if(fase == null){
                            fase = new Fase();
                            fase.setNro(new Integer(campo[5]));
                            fase.appendRonda(ronda);
                             ClaseUtil.agregarObjeto(Fase.class+String.valueOf(fase.getNro()), fase);
                        }else{
                             fase.appendRonda(ronda);
                             
                        }
                        ronda.setFase(fase);
                  }
             }
      
         }

   
}
