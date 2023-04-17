/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.model;



import tpi.ar.programa.entidades.Pronostico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.entidades.Equipo;
import tpi.ar.programa.entidades.Fase;
import tpi.ar.programa.entidades.Partido;
import tpi.ar.programa.entidades.Ronda;

import tpi.ar.programa.entidades.Participante;


/**
 *
 * @author pbarzaghi
 */
public class ParticipanteModel {
  private Map tablaSumaDeFase;
  private ArrayList<Fase> listaFaseConRondaPerdida;
    /*
     Este metodo returna los puntos de una participante segun su lista de Pronostico
    */
    public String puntajeTotalDelParticipante(Participante participante ){
         int puntajeTotal=0;
         int puntajeAcierto=0;
           int puntoExtraRonda=0; 
        
         
          List<Pronostico> pronosticos=participante.getPronosticos();
          int cantidadPronosticos=pronosticos.size();
          puntajeTotal= pronosticos.stream().mapToInt(p -> p.getPuntos()).sum();
          puntajeAcierto=pronosticos.stream().mapToInt(p -> 
                p.getResultado().equals(p.getPartido().getResultado(p.getEquipo()))
                ?1:0).sum();
          
          // funcionalidad: separo la lista de pronostico en <ronda, list<Pronostico>> para chequear
          // que cada list<Pronostico> de una ronda acerto el participante y poder obtener
          // los puntos extras por ronda
        
          
          //----------------------------------------------------------------
          // 
          Map map = (Map) this.listPronosticoPorRonda(pronosticos);
           tablaSumaDeFase= new HashMap();
           listaFaseConRondaPerdida=new ArrayList<>();
          
           Iterator entries = map.entrySet().iterator();
         int nroRonda=0;
           while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Ronda key = (Ronda)entry.getKey();
                List<Pronostico> value = (List<Pronostico>)entry.getValue(); 
             
       
             if(this.isPronosticoDeUnaRonda(value)){
                     puntoExtraRonda = value.get(0).getPuntosResultado().getPuntosRonda(); 
                      nroRonda++;
                 this.sumarPuntosEnFase(key.getFase()); 
              }else
                   this.sacarFase(key.getFase());
               
          }
          
          // fin de obtencion de los puntos extras y aciertos de Fase
           HashMap mapCantidadRondaEnFase= (HashMap) this.listcantidadRondaPorFase(pronosticos);
          int aciertoFase=this.cantidaDeAciertoFase(mapCantidadRondaEnFase);
          int ptosExtraPorFase=(pronosticos.get(0)).getPuntosResultado().getPuntosFase();
          int totalFases=mapCantidadRondaEnFase.size();
              
            
              return imprimirGanadorConPuntajePronostico(participante.getNombre()+" "+participante.getApellido(),
                                       String.valueOf(puntajeAcierto),
                                       String.valueOf(cantidadPronosticos),
                                         String.valueOf(puntajeTotal),
                                         String.valueOf(puntoExtraRonda),
                                         String.valueOf(nroRonda),
                                         String.valueOf(aciertoFase),
                                         String.valueOf(ptosExtraPorFase),
                                          String.valueOf(totalFases)
                                       );
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
           
          
           // Si el equipo Ganador es null --> resultado partido dio Empate
            if(equipo==null) // El partido fue un empate tenemos que analizar el pronostico
              okRonda= ResultadoEmun.EMPATE.equals(pronostico.getResultado());            
            
            else
                // Si el equipo que elegi es el mismo que gano el partido
                if(equipo.equals(pronostico.getEquipo()))
                   okRonda= pronostico.getResultado().equals(partido.getResultado(equipo));
                else
                    okRonda=( pronostico.getResultado().equals(partido.getResultado(pronostico.getEquipo())));
          
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
                                                       String cantRonda,
                                                       String cantidadFase,
                                                       String extraFase,
                                                       String cantTotalFase
                                                      
                                                       ){
                                                   
        int totalRonda = Integer.parseInt(extraRonda)*Integer.parseInt(cantRonda);
        int cantTotalDeFase= Integer.decode(cantTotalFase);
        int cantidadAciertoFase =Integer.parseInt(cantidadFase);
        
        int ptosFase=Integer.parseInt(extraFase)*cantidadAciertoFase;
        
        int valoTotal= Integer.parseInt(puntajeTotal)+totalRonda +ptosFase;
        return "---------------------------------- \n " +
                "Participante: "+participante +"\n"+
                "Acerto: "+puntajeAceptado + "/"+ cantidadPronosticos +"\n"+
                "Total Puntos: "+ puntajeTotal + "\n"+
                "Total de rondas ganadas: "+cantRonda +"\n"+
                "Puntos extra por ganar una ronda: " +extraRonda + " Total en ronda: "+totalRonda + "\n"+
                "Total de fases ganadas: "+cantidadAciertoFase + "/"+ cantTotalDeFase +"\n"+
                "Puntos extra por ganar una fase: " +extraFase + " Total en fase: "+ptosFase+ "\n"+
                "Suma total de : "+      valoTotal + " Puntos";
        
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
                
                auxPronostico = new ArrayList<Pronostico>();
                auxPronostico.add(pronostico);
                tablaRonda.put(ronda, auxPronostico );
               
            }else{
                auxPronostico  =(ArrayList<Pronostico>) tablaRonda.remove(ronda);
                  auxPronostico.add(pronostico);
                  tablaRonda.put(ronda, auxPronostico );
                }
        }
       return tablaRonda;
    }
    
    
       /*
           Este metodo me retorna la cantidad de ronda que tiene  cada Fase
        */
    
       public Map listcantidadRondaPorFase(List<Pronostico> pronosticos){
         
          Map tableFase=new HashMap();
        for (Pronostico pronostico : pronosticos) {
            Fase fase=pronostico.getPartido().getRonda().getFase();
              if(! tableFase.containsKey(fase.getNro())){
                int cantidadRondas=fase.getRondas().size();
                 tableFase.put(fase.getNro(), new Integer(cantidadRondas) );
               }
        }
       
        return tableFase;
    
      }
   
        
         private int cantidaDeAciertoFase(Map tabla){
             int cantidadFase=0;
            
            Iterator entries = tabla.entrySet().iterator();
        
           while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                Integer keyFase = (Integer)entry.getKey();
                Integer valueInteger = (Integer)entry.getValue();
                Integer total=(Integer) tablaSumaDeFase.get(keyFase);
                 if(total != null)
                     cantidadFase++;
             }
               
             return cantidadFase;
         
         }

         
     private void sumarPuntosEnFase(Fase fase) {
      
          // Si la face se NO se encuentra en la ListaDeFasePerdida entonces la agrego en la tabla de fase
         if(! listaFaseConRondaPerdida.contains(fase)){  // 
                if(this.tablaSumaDeFase.containsKey(fase.getNro())){
                 int aux= ((Integer)tablaSumaDeFase.remove(fase.getNro())).intValue()+1;
                 tablaSumaDeFase.put(fase.getNro(),new Integer(aux));
             }else{
                     tablaSumaDeFase.put(fase.getNro(),new Integer(1));
             }
         }
       
    }   
              
         
         
    private void sacarFase(Fase fase) {
       // if(this.tablaSumaDeFase.containsKey(fase.getNro()))
          tablaSumaDeFase.remove(fase);
          listaFaseConRondaPerdida.add(fase);
                  
    }  
        
       
    }
     
    