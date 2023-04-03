/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.deportivo.Ronda;

import tpi.ar.programa.pronostico.participante.Participante;


/**
 *
 * @author pbarzaghi
 */
public class GanadorPronostico {
     
    private int puntajeTotal=0;
    private int puntajeAcierto=0;
        
    
    /*
     Este metodo returna los puntos de una participante segun su lista de Pronostico
    */
    public String puntajeParticipantePronostico(Participante participante ){
         
          List<Pronostico> pronosticos=participante.getPronosticos();
          int cantidadPronosticos=pronosticos.size();
          puntajeTotal= pronosticos.stream().mapToInt(p -> p.getPuntos()).sum();
          puntajeAcierto=pronosticos.stream().mapToInt(p -> 
                p.getResultado().equals(p.getPartido().getResultado(p.getEquipo()))
                ?1:0).sum();
          
          
          // TODO: falta distinguir que pronostico pertenece a que ronda
          // dado que todos los pronosticos vienen juntos
          // Abria que hacer una collection por cada ronda de Pronosticos
          // y ahi preguntar si isPronosticoDeUnaRonda
          
          int puntoExtraRonda=0; 
          if(this.isPronosticoDeUnaRonda(pronosticos)){
                puntoExtraRonda+=this.puntoExtraPorRonda(pronosticos.get(0));
          }
          
          
         
      // int puntosExtraRonda= this.reglaPuntoExtraRonda(pronosticos);
                  
          System.out.println(" lista de ronda "+puntoExtraRonda);
              return imprimirGanadorConPuntajePronostico(participante.getNombre()+" "+participante.getApellido(),
                                       String.valueOf(puntajeAcierto),
                                       String.valueOf(cantidadPronosticos),
                                         String.valueOf(puntajeTotal)
                                       
                                       );
    }
    
    
    
    
    public int puntoExtraPorRonda(Pronostico pronostico){
      if( pronostico.getPartido().getRonda().esRondaGanada(pronostico.getEquipo()))
            return pronostico.getPuntosResultado().getPuntosRonda();
      return 0;
    
    }
    
    
    
    
    
    public boolean isPronosticoDeUnaRonda(List<Pronostico> pronosticos){
      
        
        boolean aceptaron=false;
        for (Pronostico pronostico : pronosticos) {
            Partido partido=pronostico.getPartido();
            if(partido.getRonda().esRondaGanada(pronostico.getEquipo()))
                if(pronostico.getResultado().equals(partido.getResultado(pronostico.getEquipo())))  
                    aceptaron=true;
                 else
                    aceptaron=false;
            else
                aceptaron=false;
        }
        return aceptaron;
    
    }
 
    
    /*
     Metodo para imprimir el ganador
    */
    private String imprimirGanadorConPuntajePronostico(String participante,
                                                       String puntajeAceptado, 
                                                       String cantidadPronosticos,
                                                       String puntajeTotal){
                                                      // String extraRonda,
                                                      // String cantidadRondaGanada) {
        
        
   
        return "Participante: "+participante +
               " Acerto "+puntajeAceptado +
               " / "+cantidadPronosticos +
               "  total Puntos; "+ puntajeTotal
             //  " + " +cantidadRondaGanada +" Rondas Ganadas sumo  "
             //   +  extraRonda+" Puntos " 
            //    + " Sumanto  Puntaje de "+(Integer.sum(Integer.parseInt(extraRonda),
            //                                           Integer.parseInt(puntajeAceptado)))
                + " sin contabilizar Rondas Ni fases)";
    
    
    }

    /**
     * @return the puntajeTotal
     */
    public int getPuntajeTotal() {
        return puntajeTotal;
    }

   
}
    
    

   