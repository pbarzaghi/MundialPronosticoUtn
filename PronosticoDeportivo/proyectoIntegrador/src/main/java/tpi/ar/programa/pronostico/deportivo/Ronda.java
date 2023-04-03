/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.deportivo;

import java.util.ArrayList;
import java.util.List;
import tpi.ar.programa.enumerado.ResultadoEmun;

/**
 *
 * @author pbarzaghi
 */
public class Ronda {
    
    private List <Partido> partidos;
    private int nro;
    

   

    /**
     * @return the nro
     */
    public int getNro() {
        return nro;
    }

    /**
     * @param nro the nro to set
     */
    public void setNro(int nro) {
        this.nro = nro;
    }

    /**
     * @return the partidos
     */
    public List <Partido> getPartidos() {
        return partidos;
    }

    /**
     * @param partidos the partidos to set
     */
    public void setPartidos(List <Partido> partidos) {
        this.partidos = partidos;
    }
    
      public void appendPartido(Partido partido) {
          if (this.partidos == null)
              this.partidos= new ArrayList<>();
             
          partidos.add(partido);   
      }
    
     public int getNroRonda(Partido partido){
           return (partidos.contains(partido)?getNro():0);
     } 

     public boolean validarPartidoEnARonda(Partido partido){
         return partidos.contains(partido);
      }
     
     public Ronda getRonda(Partido partido){
        return (this.partidos.contains(partido)? this: null);
     }
     
     public boolean esRondaGanada(Equipo equipo){

         
        return this.partidos.stream().allMatch( p -> ResultadoEmun.GANADOR.equals(
                                                 ( p.getResultado(p.getEquipo1()))));
        
     }
}


