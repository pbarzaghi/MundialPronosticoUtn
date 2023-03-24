/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;

import java.util.List;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.deportivo.Partido;

/**
 *
 * @author pbarzaghi
 */
public class GanadorPronostico {
    
    private  int cantidadPuntos=0;
   
    
    /*
     El metodo ganadorDelPronostic: Dada una lista de Pronostico, la recorro
     obteniendo los partidos y determinando como salieron.
     Segun el resultado del partido y el pronosticado se determa el puntaje 
     que se le da.
     Este metodo retorna un String de la concatenacion del Participante y la
     cantidad de punto que hizo
    */
      public String ganadorDelPronostico(  List<Pronostico> listaPronostico){ 
         
          String participante="";
           for ( Pronostico pronostico : listaPronostico) {
           
                 Partido partido =  pronostico.getPartido();
                 ResultadoEmun resultadoPartido=   partido.getResultado(pronostico.getEquipo());
                 cantidadPuntos+=obtenerPuntaje(pronostico.getResultado(),resultadoPartido);
                // TODO Este codigo se tiene que modificar cuando sean varias representantes
                  if("".equals(participante))
                      if(! participante.equals(pronostico.getParticipante().getNombre()))
                             participante=pronostico.getParticipante().getNombre();
                
           }
           
          return strGanadorConPuntaje(participante,cantidadPuntos);
      }
      
      /*
       Este metodo retorna 1 si acepto el pronostico y cero sino.
       // Este metodo se puede utilizar en caso que el puntaje sea dinamico
           
      */
      
      private int obtenerPuntaje(ResultadoEmun resulPronostico,ResultadoEmun resulPartido){
          
         if(resulPronostico == resulPartido)
             return 1;
         else
             return 0;
      }

    private String strGanadorConPuntaje(String participante, int cantidadPuntos) {
        
        return " La participante "+participante+" hizo "+ cantidadPuntos +" punto en el Pronostico";
    }
      
    public int getCantidadPuntos(){
       return this.cantidadPuntos;
    }  
}
        
    

  