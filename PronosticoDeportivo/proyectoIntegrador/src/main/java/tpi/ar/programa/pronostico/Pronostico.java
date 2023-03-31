/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;

import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;

/**
 *
 * @author pbarzaghi
 */
public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEmun resultado;
//    private Persona participante;
    // esto va reemplazar el "private ResultadoEmun resultado;"
    private PuntosResultado puntosResultado;
   
    
   
    
    

    /**
     * @return the partido
     */
    public Partido getPartido() {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the resultado
     */
    public ResultadoEmun getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultadoEmun resultado) {
        this.resultado = resultado;
    }

    /**

    
    /*
       Este metodo retorna 1 si acepto el pronostico y cero sino.
       // Este metodo se puede utilizar en caso que el puntaje sea dinamico
           
      */
      
      public int getPuntos(){
          
         ResultadoEmun resultadoReal=   this.partido.getResultado(this.equipo);
         // en caso que haciente el pronostico con el resultado del partido obtengo los puntos
         // por aceptar. En caso negativo 0
         if(this.resultado.equals(resultadoReal))
            return   this.getPuntosResultado().getPuntoAcierto();
         
      return 0;
        
      }

   

    /**
     * @return the puntosResultado
     */
    public PuntosResultado getPuntosResultado() {
        return puntosResultado;
    }

    /**
     * @param puntosResultado the puntosResultado to set
     */
    public void setPuntosResultado(PuntosResultado puntosResultado) {
        this.puntosResultado = puntosResultado;
    }


   

  
    
}
