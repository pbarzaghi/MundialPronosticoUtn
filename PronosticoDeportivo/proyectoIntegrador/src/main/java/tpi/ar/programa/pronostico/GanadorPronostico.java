/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;

import java.util.ArrayList;

import java.util.List;
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
        return imprimirGanadorConPuntajePronostico(participante.getNombre()+" "+participante.getApellido(),
                                       String.valueOf(puntajeAcierto),
                                       String.valueOf(cantidadPronosticos),
                                         String.valueOf(puntajeTotal)
                                       );
    }
    
    /*
     Metodo para imprimir el ganador
    */
    private String imprimirGanadorConPuntajePronostico(String participante,
                                                       String puntajeAceptado, 
                                                       String cantidadPronosticos,
                                                       String puntajeTotal) {
        
        
   
        return "Participante: "+participante +
               " Acerto "+puntajeAceptado +
               " / "+cantidadPronosticos +
               "  total Puntos; "+ puntajeTotal +
               " (sin contabilizar rondas y fases)";
    
    
    }

    /**
     * @return the puntajeTotal
     */
    public int getPuntajeTotal() {
        return puntajeTotal;
    }

   
    
}
