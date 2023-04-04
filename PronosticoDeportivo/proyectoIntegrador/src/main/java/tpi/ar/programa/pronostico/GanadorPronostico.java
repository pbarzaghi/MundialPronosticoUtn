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
          
          // funcionalidad: separo la lista de pronostico en <ronda, list<Pronostico>> para chequear
          // que cada list<Pronostico> de una ronda acerto el participante y poder obtener
          // los puntos extras por ronda
          int puntoExtraRonda=0; 
          Map map = (Map) this.listPronosticoPorRonda(pronosticos);
           Iterator entries = map.entrySet().iterator();
         int nroRonda=0;
           while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Ronda key = (Ronda)entry.getKey();
                List<Pronostico> value = (List<Pronostico>)entry.getValue(); 
          
                if(this.isPronosticoDeUnaRonda(value)){
                        puntoExtraRonda+=this.puntoExtraPorRonda(value.get(0));
                         nroRonda++;
                }
          }
          
         
    
              return imprimirGanadorConPuntajePronostico(participante.getNombre()+" "+participante.getApellido(),
                                       String.valueOf(puntajeAcierto),
                                       String.valueOf(cantidadPronosticos),
                                         String.valueOf(puntajeTotal),
                                         String.valueOf(puntoExtraRonda),
                                         String.valueOf(nroRonda)
                                       );
    }
    
    
    
    /*
     Este metodo devuelve el valor extra que se tiene por ganar el Pronostico una ronda
    */
    
    public int puntoExtraPorRonda(Pronostico pronostico){
      if( pronostico.getPartido().getRonda().esRondaGanada(pronostico.getEquipo()))
            return pronostico.getPuntosResultado().getPuntosRonda();
      return 0;
    
    }
    
    
    
    /*
     Este metodo retorna un booleano si todos los pronosticos esta
    aceptados.
    La lista de pronostico que ingresan pertenecen a un ronda
    */
    
    
    public boolean isPronosticoDeUnaRonda(List<Pronostico> pronosticos){
      
         boolean okRonda=true;
       
        for (Pronostico pronostico : pronosticos) {
           
            Partido partido=pronostico.getPartido();
            Equipo equipo=partido.getEquipoGanador();
              if (ResultadoEmun.EMPATE.equals(pronostico.getResultado()) && equipo == null)
                 okRonda=true;
            else
                if(pronostico.getEquipo().equals(equipo)&&
                    pronostico.getResultado().equals(partido.getResultado(equipo)) )
                  okRonda=true;
                else if (pronostico.getResultado().equals(partido.getResultado(equipo)) )
                   okRonda=true;
                else return false;     
         
        }
        return okRonda;
    
    }
 
    
    /*
     Metodo para imprimir el ganador
    */
    private String imprimirGanadorConPuntajePronostico(String participante,
                                                       String puntajeAceptado, 
                                                       String cantidadPronosticos,
                                                       String puntajeTotal,
                                                       String extraRonda,
                                                       String cantRonda){
                                                      // String cantidadRondaGanada) {
        
        
        int totalRonda = Integer.parseInt(extraRonda)*Integer.parseInt(cantRonda);
   
        int valoTotal= Integer.parseInt(puntajeTotal)+
                   Integer.parseInt(extraRonda)+totalRonda;
        return "---------------------------------- \n " +
                "Participante: "+participante +
               "\n Acerto "+puntajeAceptado + "/"+ cantidadPronosticos +
               "\n Total Puntos; "+ puntajeTotal +
               "\n "+
                " Total de rondas ganadas "+cantRonda +"\n"
                + " Puntos extra por ganar ronda " +extraRonda + " total extra "+totalRonda + 
               "\n Suma total de  "+
                valoTotal + " Puntos"
             //   +  extraRonda+" Puntos " 
            //    + " Sumanto  Puntaje de "+(Integer.sum(Integer.parseInt(extraRonda),
            //                                           Integer.parseInt(puntajeAceptado)))
                + " \n(FASES NO CONTABILIZADAS)"+
              "\n ---------------------------------- "  ;
    
    
    }

    /**
     * @return the puntajeTotal
     */
    public int getPuntajeTotal() {
        return puntajeTotal;
    }
    
    /*
     En este metodo ingresa una List<Pronostico> y devuelve
    una Map<Ronda,List<Pronostico>
    Lo que realiza este metodo separar cada pronostico segun su ronda
    dado que varios pronostico pueden serde una ronda
    
    */
    
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
    
    

   