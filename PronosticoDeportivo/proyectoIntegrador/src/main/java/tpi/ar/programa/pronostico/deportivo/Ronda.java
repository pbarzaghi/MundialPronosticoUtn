/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.deportivo;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pbarzaghi
 */
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Ronda {
    
    private List <Partido> partidos;
    private int nro;
    private Fase fase;
    

   
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
     /*
      Este metodo se fija si el equipo ingresado gano en esa ronda
      devolviendo un boolean.
      
     */
     
     public boolean esRondaGanada(Equipo equipo){
         boolean ganoRonda=false;
         for (Partido partido : partidos) {
            if(partido.getEquipo1().equals(equipo))
                    ganoRonda= partido.getEquipoGanador().equals(equipo);
            else
               if(partido.getEquipo2().equals(equipo))
                    ganoRonda= partido.getEquipoGanador().equals(equipo);
         }
     return ganoRonda;
     }
}


