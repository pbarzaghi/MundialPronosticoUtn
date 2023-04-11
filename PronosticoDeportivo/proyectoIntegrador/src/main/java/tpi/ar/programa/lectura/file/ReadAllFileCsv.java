/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.FormatoIncorrectoException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.pronostico.Pronostico;
import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.deportivo.Ronda;
import tpi.ar.programa.pronostico.participante.Participante;
import tpi.ar.programa.validador.ValidadorCampo;

/**
 *
 * @author pbarzaghi
 */
public class ReadAllFileCsv {
     private  HashMap objCreacion;
     private  ValidadorCampo validador;
    
     public ReadAllFileCsv(){
      
      if(objCreacion == null)
         objCreacion=new HashMap();
      validador=new ValidadorCampo();
    }

 /*
      Este metodo debe leer el archivo de resultado y cargarlos
    
    */
    
    public  void leerArchivoPuntos(String path)throws FileIntegradorException,FormatoIncorrectoException{
         
            Path pathPuntos= Paths.get(path);
            List<String> listaPuntos=null;
            boolean primeraLineaArchivo=true;
         try {
           
             listaPuntos= Files.readAllLines(pathPuntos);
             for (String listaPunto : listaPuntos) {
                    PuntosResultado puntos = new PuntosResultado();
                    
             String[] campo=listaPunto.split(",");
          
                
             if(primeraLineaArchivo)
                primeraLineaArchivo=false;
             else{
                    puntos.setPuntoGanar(Integer.parseInt(campo[0]));
                    puntos.setPuntoEmpatar(Integer.parseInt(campo[1]));        
                    puntos.setPuntoPerder(Integer.parseInt(campo[2]));
                    puntos.setPuntoAcierto(Integer.parseInt(campo[3]));
                    puntos.setPuntosRonda(Integer.parseInt(campo[4]));
                    puntos.setPuntosFase(Integer.parseInt(campo[5]));
                    objCreacion.put(PuntosResultado.class,puntos);
                    }           
            }
         } catch(NumberFormatException e1){
              System.out.println(" EEE"+e1.getMessage());
            throw new FormatoIncorrectoException(e1.getMessage());
         }
            catch (IOException ex) { 
             throw new FileIntegradorException("No encontro el Archivo"+path + "ERROR : "+ex.getMessage());
         }
    }
    
   //-------------------------------------------------------------
   // Levantar el archivo  Resultado
   //----------------------------------------
     public  void leerArchivoResultado(String path) throws FileIntegradorException,FormatoIncorrectoException,GolesNegativoException{
     
         
          Path pathResultados= Paths.get(path);
          List<String> listaResultado=null;
         try {
             boolean primeraLineaArchivo=true;
             listaResultado= Files.readAllLines(pathResultados);
          
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
                               throw new FormatoIncorrectoException("FORMATO INCORRECTO NOMBRE EQUIPO");
                          }
                         equipo1= new Equipo(campo[1], "SELECCIONADO");
                         equipo1.setId(idEquipo);
                         objCreacion.put(Equipo.class+campo[1], equipo1);
                         idEquipo++;
                      }
                       Equipo equipo2= (Equipo)  objCreacion.get(Equipo.class+campo[4]);
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
                               throw new GolesNegativoException("FORMATO INCORRECTO DE GOLES");
                          }
                        
                           
                           partido.setGolesEquipo1(Integer.parseInt(campo[2]));
                           partido.setGolesEquipo2(Integer.parseInt(campo[3]));
                           partido.setPuntos((PuntosResultado)objCreacion.get(PuntosResultado.class));

                      //   ResultadoEmun resultaPartido=partido.getResultadoPorGoles(Integer.parseInt(campo[2]),
                        //                                                           Integer.parseInt(campo[3]));
                         
                   //      partido.setPuntos( (PuntosResultado)objCreacion.get(PuntosResultado.class+resultaPartido.toString()));

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
         catch(NumberFormatException e1){
              throw new FormatoIncorrectoException(e1.getMessage());
         }
         catch (IOException ex) {
             throw new FileIntegradorException("No encontro el Archivo"+path);
        }
    
      
    
 
}
 //-----------------------------------------------------------------------------
 //   Levantar el archivo  Pronostico   
 //-------------------------------------------------------------------------- 
     
     /*
      Este metodo lee dado el path del archivo los pronosticos y retorna una lista de Participante con
     los pronostico realizado
    cargados desde el archivo
    */
    public List<Participante> leerArchivoPronostico(String path) throws FileIntegradorException, FormatoIncorrectoException{
      
             List<Participante> listaParticipante =new ArrayList();
         try {
          
             
             Path pathPronostico= Paths.get(path);
             List<String> listaPronosticos=null;
             
             boolean primeraLineaArchivo=true;
             listaPronosticos= Files.readAllLines(pathPronostico);
            
             
             
             for (String lineaPronostico : listaPronosticos) {
                 String[] campo=lineaPronostico.split(",");
                   
                 if(primeraLineaArchivo)
                     primeraLineaArchivo=false;
                 else{
                     Pronostico pronostico=new Pronostico();
                     Equipo equipo1= (Equipo)  objCreacion.get(Equipo.class+campo[1]);
                     if(equipo1 == null){
                         System.out.println("NO EXISTE EL Equipo "+campo[1]);
                         throw new FileIntegradorException("No encontro el Equipo ");
                     }
                     
                     Partido partido= (Partido)  objCreacion.get(Partido.class+campo[1]+"_"+
                             campo[5]);
                     if(partido== null)
                         partido= (Partido)  objCreacion.get(Partido.class+campo[5]+"_"+
                                 campo[1]);
                     if(partido == null){
                         System.out.println("NO EXISTE EL PARTIDO "+campo[1]+"_"+ campo[5]);
                         // hay que generar la Excepcion
                         throw new FileIntegradorException("No encontro el Partido con los equipo"+ campo[1]+ " " +campo[5]);
                     }
                     
                     
                     pronostico.setEquipo(equipo1);
                     pronostico.setPartido(partido);
                     pronostico.setResultado(getResultadoPronostico(campo[2],
                             campo[3],
                             campo[4]));
                     
                     pronostico.setPuntosResultado((PuntosResultado) objCreacion.get(PuntosResultado.class));
                        
                     Participante participante=(Participante)  objCreacion.remove(Participante.class+campo[0]);
                     
                     if(participante == null) {
                         participante= new Participante(campo[0]);
                     }else
                         listaParticipante.remove(participante);
                     
                     participante.addPronostico(pronostico);
                     listaParticipante.add(participante);
                     objCreacion.put(Participante.class+participante.getNombre(),participante);
              
                 }
            }
          } 
         catch(NumberFormatException e1){
             
            throw new FormatoIncorrectoException(e1.getMessage());
         } catch (IOException ex) {
             throw new FileIntegradorException("No encontro el Archivo "+path +" Error: "+ex.getMessage());
         }
         
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
   
     
     public List<Participante> leerArchivoPronostico(String pathPuntos,
                                                    String pathResultado,
                                                    String pathPronostico) 
                                        throws
                                                FileIntegradorException,GolesNegativoException,FormatoIncorrectoException
     {
         this.leerArchivoPuntos(pathPuntos);
         
         this.leerArchivoResultado( pathResultado); 
         
         return this.leerArchivoPronostico(pathPronostico);
     }
    
    
}
