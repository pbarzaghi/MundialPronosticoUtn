/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;



import java.util.ArrayList;
import java.util.Collection;
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
          
           Map map = (Map) this.listPronosticoPorRonda(pronosticos);
           Iterator entries = map.entrySet().iterator();
          while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Ronda key = (Ronda)entry.getKey();
                List<Pronostico> value = (List<Pronostico>)entry.getValue(); 
          
                if(this.isPronosticoDeUnaRonda(value)){
                        puntoExtraRonda+=this.puntoExtraPorRonda(value.get(0));
                 }
          }
          
         
    
              return imprimirGanadorConPuntajePronostico(participante.getNombre()+" "+participante.getApellido(),
                                       String.valueOf(puntajeAcierto),
                                       String.valueOf(cantidadPronosticos),
                                         String.valueOf(puntajeTotal),
                                         String.valueOf(puntoExtraRonda)
                                       
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
            Equipo equipo=partido.getEquipoGanador();
            if(ResultadoEmun.EMPATE.equals(pronostico.getResultado()) && equipo == null){
               if(!aceptaron)
                 aceptaron=true;
            } else if(pronostico.getEquipo().equals(equipo)&&
                    pronostico.getResultado().equals(partido.getResultado(equipo)) ){
               if(!aceptaron)
                 aceptaron=true;
            } else
                if(! pronostico.getResultado().equals(partido.getResultado(equipo)))   
                { if(aceptaron)
                    aceptaron=false;  
                }
                
        }
        return aceptaron;
    
    }
 
    
    /*
     Metodo para imprimir el ganador
    */
    private String imprimirGanadorConPuntajePronostico(String participante,
                                                       String puntajeAceptado, 
                                                       String cantidadPronosticos,
                                                       String puntajeTotal,
                                                       String extraRonda){
                                                      // String cantidadRondaGanada) {
        
        int valor= Integer.parseInt(puntajeTotal)+
                   Integer.parseInt(extraRonda);
   
        return "Participante: "+participante +
               " Acerto "+puntajeAceptado +
               " / "+ cantidadPronosticos +
               "  total Puntos; "+ puntajeTotal +
               " + " +extraRonda +" de Rondas Ganadas suma total de  "+
                valor + " "
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
    
    
    public Map listPronosticoPorRonda(List<Pronostico> pronosticos){
      Map tablaRonda = new HashMap();
        for (Pronostico pronostico : pronosticos) {
            Ronda ronda=pronostico.getPartido().getRonda();
            List<Pronostico> auxPronostico;
            if(!tablaRonda.containsKey(ronda)){
                auxPronostico= new ArrayList<Pronostico>();
                auxPronostico.add(pronostico);
                tablaRonda.put(ronda, auxPronostico );
               }else{
                  auxPronostico=(ArrayList<Pronostico>)tablaRonda.remove(ronda);
                  auxPronostico.add(pronostico);
                  tablaRonda.put(ronda, auxPronostico );
                }
        }
    
       return tablaRonda;
    }
     
}
    
    

   