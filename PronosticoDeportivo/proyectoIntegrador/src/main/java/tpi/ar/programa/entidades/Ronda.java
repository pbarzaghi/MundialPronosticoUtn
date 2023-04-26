/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.entidades;

import java.util.ArrayList;
import java.util.List;
import tpi.ar.programa.util.ClaseUtil;


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
    
  
     public Ronda getRonda(Partido partido){
        return (this.partidos.contains(partido)? this: null);
     }
    
     public boolean esRondaGanada(List<Pronostico> pronosticos){
        int cantidadDePartidosEnRonda=0;//this.partidos.size();
        int ptosObtenidosParaRonda=0;
        int cantidadAciertos=0;
         Punto ptos=(Punto) ClaseUtil.obtenerObjeto(Punto.class.toString());
         
         for (Pronostico pronostico : pronosticos) {
             if(pronostico.getPartido().getRonda().equals(this)){
                cantidadDePartidosEnRonda++; 
                Partido partido= pronostico.getPartido();
               if(pronostico.getResultado().equals(partido.getResultado(pronostico.getEquipo())))
                 ptosObtenidosParaRonda+=ptos.getPuntosRonda();
             
             }
         }
       
         cantidadAciertos= ptosObtenidosParaRonda /ptos.getPuntosRonda() ;
      
     return cantidadDePartidosEnRonda==cantidadAciertos;
     }
}


