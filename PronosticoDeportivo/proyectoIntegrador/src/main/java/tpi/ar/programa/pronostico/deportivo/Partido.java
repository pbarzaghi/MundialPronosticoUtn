/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.deportivo;

import java.util.List;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.pronostico.PuntosResultado;

/**
 *
 * @author pbarzaghi
 */
public class Partido {
    
   private int idPartido;
   private Equipo equipo1;
   private Equipo equipo2;
   private int golesEquipo1;
   private int golesEquipo2;
   private Ronda ronda;
   
   
   // Clase PuntosResultado
    private PuntosResultado puntos;

    /**
     * @return the equipo1
     */
    public Equipo getEquipo1() {
        return equipo1;
    }

    /**
     * @param equipo1 the equipo1 to set
     */
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * @return the equipo2
     */
    public Equipo getEquipo2() {
        return equipo2;
    }

    /**
     * @param equipo2 the equipo2 to set
     */
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * @return the golesEquipo1
     */
    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    /**
     * @param golesEquipo1 the golesEquipo1 to set
     */
    public void setGolesEquipo1(int golesEquipo1) {
        
        if(golesEquipo1 <0)
            throw new GolesNegativoException("Intento ingresar un gol negativo");
        this.golesEquipo1 = golesEquipo1;
    }

    /**
     * @return the golesEquipo2
     */
    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    /**
     * @param golesEquipo2 the golesEquipo2 to set
     */
    public void setGolesEquipo2(int golesEquipo2) {
       if(golesEquipo2 <0)
            throw new GolesNegativoException("Intento ingresar un gol negativo");
        this.golesEquipo2 = golesEquipo2;
    }

    /**
     * @return the idPartido
     */
    public int getIdPartido() {
        return idPartido;
    }

    /**
     * @param idPartido the idPartido to set
     */
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
   
    public ResultadoEmun getResultado(Equipo equipo){
        
        if(equipo == null)
            return ResultadoEmun.EMPATE;
        if(equipo.getId()== this.equipo1.getId())
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
   
  

    /**
     * @return the puntos
     */
    public PuntosResultado getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(PuntosResultado puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the ronda
     */
    public Ronda getRonda() {
        return ronda;
    }

    /**
     * @param ronda the ronda to set
     */
    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
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
