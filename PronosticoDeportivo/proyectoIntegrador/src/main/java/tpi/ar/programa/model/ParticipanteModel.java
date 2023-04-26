/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.model;



import tpi.ar.programa.entidades.Pronostico;
import java.util.ArrayList;
import java.util.List;
import tpi.ar.programa.entidades.Fase;
import tpi.ar.programa.entidades.Ronda;
import tpi.ar.programa.entidades.Participante;
import tpi.ar.programa.entidades.Punto;
import tpi.ar.programa.util.ClaseUtil;


/**
 *
 * @author pbarzaghi
 */
public class ParticipanteModel {
  private  ArrayList<Fase> listaDeTodasLasFase;
  private ArrayList<Fase> listaFaseConRondaPerdida;
  private ArrayList<Ronda> listaRondaPerdida;
  
    /**
     * Este metodo recibe como parametro un participante, del cual se va obtener los resultados 
     * del pronostico con sus aciertos
     * @param participante
     * @return un String con los aciertos de cada partido,ronda y fase con los puntos obtenidos 
     */
     public String puntajeTotalDelParticipante(Participante participante ){
           List<Pronostico> pronosticos=participante.getPronosticos(); 
           listaDeTodasLasFase= new ArrayList<>();
           listaFaseConRondaPerdida=new ArrayList<>();
           listaRondaPerdida=new ArrayList<>();

          Punto pto=(Punto) ClaseUtil.obtenerObjeto(Punto.class.toString());
          // tenemos la cantidad de pronostico que se realizaron
          int cantidadPronosticos=pronosticos.size();
          //tenemos la cantidad de aciertos que realizo el participante
          int cantidadAciertosEnPronostico=participante.getCantidadPuntosObtenidos()/ pto.getPuntoAcierto();
          // obtengo la suma de punto que realizo el participante en el pronostico
          int sumaPuntosAcertadosPronostico=participante.getCantidadPuntosObtenidos();
         // Contabiliza la cantidad de veces que acepto una ronda
          int cantidadRondasConAcierto=0;
          //Total de ronda que hay en un pronostico
          int totalDeRonda=0;
          // Esta variable contabiliza la cantidad de veces que se realizo una fase
          int cantidadFaseConAcierto=0;
          // Esta variable dice que cantidad de fase hay en un pronostico
          int totalDeFase=0;
          
          // En esta lista vamos a cargar todas las ronda que tenemos en un pronostico
          List<String> listaContarTodasLasRonda=new ArrayList<>();
         
           for (Pronostico pronostico : pronosticos) {
             // Pregunta si la ronda no es ganada  
             if(!pronostico.getPartido().getRonda().esRondaGanada(pronosticos)){
                 /**
                  * Estos dos metodos agregan en la lista <<listaFaseConRondaPerdida>> la fase y
                  * <<listaRondaPerdida>> la ronda para despues saber que cantidad de fase y ronda
                  * no se tienen que contabilizar en la variable que acerto Ronda y Fase.
                  */
                 this.descontarRonda(pronostico.getPartido().getRonda());
                 this.descontarFase(pronostico.getPartido().getRonda().getFase());
              }
             
             
        
            /**
             * Este metodo carga la variable <<listaDeTodasLasFase>> con todas 
             * las fase que tenga el pronostico
             */          
             this.agregarTodasLaFaseLista(pronostico.getPartido().getRonda().getFase()); 
             
             if(!listaContarTodasLasRonda.contains(String.valueOf(pronostico.getPartido().getRonda().getNro())))
                listaContarTodasLasRonda.add(String.valueOf(pronostico.getPartido().getRonda().getNro()));
            }
           
           totalDeRonda=listaContarTodasLasRonda.size();
           cantidadRondasConAcierto=listaContarTodasLasRonda.size()-this.listaRondaPerdida.size();
           cantidadFaseConAcierto=this.listaDeTodasLasFase.size()- this.listaFaseConRondaPerdida.size();
           totalDeFase=this.listaDeTodasLasFase.size();
         
            return         imprimirParticipante(participante.getNombre(),
                                        cantidadAciertosEnPronostico ,
                                        sumaPuntosAcertadosPronostico,
                                        cantidadPronosticos,
                                        cantidadRondasConAcierto,
                                        totalDeRonda,
                                        cantidadFaseConAcierto,
                                        totalDeFase);
                             
            
     }  
    
   
   
    
   
   
   
     /**
      *  Agrega todas las fase verificando que no este cargada en la lista
      * @param fase 
      */
         
      private void agregarTodasLaFaseLista(Fase fase){
           if(!this.listaDeTodasLasFase.contains(fase)){
            listaDeTodasLasFase.add(fase);
           }
      
      }
      
   /**
    * Agrega a la lista <<listaRondaPerdida>> la ronda que no cumple
      con la condicion,que el pronostico no haya acertado el resultado
      del partido en esa ronda.
      * . 
    * @param ronda 
    */   
              
   private void descontarRonda(Ronda ronda) {
       
      if(!this.listaRondaPerdida.contains(ronda)) 
           listaRondaPerdida.add(ronda);
     
    }        
     /**
      * Agrega a la lista <<listaFaseConRondaPerdida>> la fase que no cumple
      * con la condicion que el pronostico no haya acertado toda la ronda de 
      * esa fase.
      * @param fase 
      */    
    private void descontarFase(Fase fase) {
      if(!listaFaseConRondaPerdida.contains(fase)) 
            listaFaseConRondaPerdida.add(fase);
     
    }  
    
     /**
    * 
    * @param participante
    * @param puntajeAceptado
    * @param pruebaSumaPuntosAcertados
    * @param cantidadPronosticos
    * @param cantidadRonda
    * @param totalRondas
    * @param cantidadFase
    * @param totalFase
    * @return un string con los datos que el participante acerto
    */
     
    
    private String imprimirParticipante(String participante,
                                       int cantidadAciertosEnPronostico ,
                                       int sumaPuntosAcertadosPronostico,
                                       int cantidadPronosticos,
                                       int cantidadRondasConAcierto,
                                       int totalDeRonda,
                                       int cantidadFaseConAcierto,
                                       int totalDeFase){
                                                   
       
       Punto ptos=(Punto) ClaseUtil.obtenerObjeto(Punto.class.toString());
     
   
        return "---------------------------------- \n " +
                "\t \t Participante: "+participante +"\n"+
                "Acerto: "+cantidadAciertosEnPronostico + "/"+ cantidadPronosticos +" \n"+
                "Pts por Acertar: "+ ptos.getPuntoAcierto()  +" - SubTotal: "+ (sumaPuntosAcertadosPronostico) + " Ptos.\n"+
                "\nTotal de rondas ganadas: "+cantidadRondasConAcierto +"/"+totalDeRonda+"\n"+
                "Ptos Bonus por ronda: " +ptos.getPuntosRonda() + " - SubTotal en ronda: "+(cantidadRondasConAcierto* ptos.getPuntosRonda() )+ " Ptos\n"+
                "\nTotal de fases Ganadas: "+ cantidadFaseConAcierto + "/"+  totalDeFase +"\n"+
                "Ptos Bonus por fase: " +ptos.getPuntosFase()  + " - SubTotal en fase: "+(cantidadFaseConAcierto*ptos.getPuntosFase() )+ " Ptos.\n"+
                "\nSuma total de (Acertar Pronostico + Bonus Ronda y Fase ): "+((cantidadAciertosEnPronostico* ptos.getPuntoAcierto())+(cantidadRondasConAcierto* ptos.getPuntosRonda() )+(cantidadFaseConAcierto*ptos.getPuntosFase() ))      
                
                + " Puntos";
        
    }
        
  
    }
     
    