/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import java.util.HashMap;
import java.util.List;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionFileCsv;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.FormatoIncorrectoException;
import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.deportivo.Ronda;

import tpi.ar.programa.validador.ValidadorCampo;

/**
 *
 * @author pbaraghi
 */
public class FileCsv {
    private  HashMap objCreacion;
    private  ValidadorCampo validador;
    
     public FileCsv(){
      
      if(objCreacion == null)
         objCreacion=new HashMap();
      validador=new ValidadorCampo();
    }

 
    
   //-------------------------------------------------------------
   // Levantar el archivo  Resultado
   //----------------------------------------
     public  void leerArchivoResultado() throws FileIntegradorException {
         
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
                      Equipo equipo1= (Equipo)  objCreacion.get(Equipo.class+campo[1]);
                     // VALIDACION DE CAMPO
                      if(equipo1 == null){
                          if(!validador.validar(campo[1],"EQUIPO")){
                           throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.equipoMayuscula"));
                   }
                         equipo1= new Equipo(campo[1], "SELECCIONADO");
                         equipo1.setId(idEquipo);
                         objCreacion.put(Equipo.class+campo[1], equipo1);
                         idEquipo++;
                      }
                       Equipo equipo2= (Equipo)  objCreacion.get(Equipo.class+campo[4]);
                         if(!validador.validar(campo[4],"EQUIPO")){
                           throw  new FormatoIncorrectoException(MsgProperty.getMensaje("error.equipoMayuscula"));
                         }
                       if(equipo2 == null){
                          equipo2= new Equipo(campo[4], "SELECCIONADO");
                          equipo2.setId(idEquipo);
                          objCreacion.put(Equipo.class+campo[4], equipo2);
                          idEquipo++;
                      }
                       Partido partido= (Partido)  objCreacion.get(Partido.class+equipo1.getNombre()+
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
                        partido.setPuntos((PuntosResultado)objCreacion.get(PuntosResultado.class));
                       objCreacion.put(Partido.class+equipo1.getNombre()+"_"+equipo2.getNombre(), partido);
                           idPartido++;
                        }

                       Ronda ronda= (Ronda)  objCreacion.get(Ronda.class+campo[0]);
                        if(ronda == null){
                            ronda = new Ronda();
                            ronda.setNro(Integer.parseInt(campo[0]));
                            partido.setRonda(ronda);
                            ronda.appendPartido(partido);
                            objCreacion.put(Ronda.class+String.valueOf(ronda.getNro()), ronda);
                        }else{
                             partido.setRonda(ronda); 
                            ronda.appendPartido(partido);
                             
                        }

                  }
             }
      
         }

   
     public void setearPuntosResultado(PuntosResultado puntos){
       objCreacion.put(PuntosResultado.class,puntos);   
        
    }
     
     public HashMap obtenerTablaPartidos(){
       return objCreacion;
     }
}
