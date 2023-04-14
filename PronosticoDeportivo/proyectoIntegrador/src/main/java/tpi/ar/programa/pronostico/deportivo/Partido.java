/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.deportivo;

import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.pronostico.PuntosResultado;

/**
 *
 * @author pbarzaghi
 */
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Partido {
    
   private int idPartido;
   private Equipo equipo1;
   private Equipo equipo2;
   private int golesEquipo1;
   private int golesEquipo2;
   private Ronda ronda;
   private PuntosResultado puntos;

   

    /**
     * @param golesEquipo1 the golesEquipo1 to set
     */
    public void setGolesEquipo1(int golesEquipo1) {
        
        this.golesEquipo1 = golesEquipo1;
    }

    
    /**
     * @param golesEquipo2 the golesEquipo2 to set
     */
    public void setGolesEquipo2(int golesEquipo2) {
      
        this.golesEquipo2 = golesEquipo2;
    }

   
    public ResultadoEmun getResultado(Equipo equipo){
        
        if(equipo == null)
            return ResultadoEmun.EMPATE;
        if(equipo.getNombre().equals(this.equipo1.getNombre()))
                 return getResultadoPorGoles(this.golesEquipo1,golesEquipo2);
          else       
               return getResultadoPorGoles(this.golesEquipo2,golesEquipo1);
       
    }
    public ResultadoEmun getResultadoPorGoles(int goles1,int goles2){
    
      if(goles1 > goles2)
                  return ResultadoEmun.GANADOR;
              else  if(goles1 < goles2 )
                       return ResultadoEmun.PERDEDOR;
                 else
                    return ResultadoEmun.EMPATE;
    
    }
   
  

   
    public Equipo getEquipoGanador(){
       if(ResultadoEmun.GANADOR.equals(
                this.getResultadoPorGoles(golesEquipo1, golesEquipo2)))
               return this.equipo1;
        else if(ResultadoEmun.GANADOR.equals(
                this.getResultadoPorGoles(golesEquipo2, golesEquipo1)))
               return this.equipo2;
         return null; 
       }
              
}                  
