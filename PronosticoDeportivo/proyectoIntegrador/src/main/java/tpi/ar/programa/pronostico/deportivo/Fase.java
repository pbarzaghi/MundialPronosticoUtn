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
public class Fase {
    private List <Ronda> rondas;
    private int nro;
    
    
      public void appendRonda(Ronda ronda) {
          if (this.rondas == null)
              this.rondas= new ArrayList<>();
             
          rondas.add(ronda);   
      }
    
    
}
