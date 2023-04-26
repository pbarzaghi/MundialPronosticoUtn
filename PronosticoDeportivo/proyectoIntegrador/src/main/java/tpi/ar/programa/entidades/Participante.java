/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */


@lombok.Getter
@lombok.Setter
public class Participante extends Persona{
    
    private List<Pronostico> pronosticos;
    private Integer cantidadPuntosObtenidos;
    
    public Participante(String nombre) {
        super(nombre);
       this.pronosticos=new ArrayList<>();
       this.cantidadPuntosObtenidos=0;
    }

   
    public void addPronostico(Pronostico pronostico){
       this.pronosticos.add(pronostico);
    }
    
    public void removePronostico(Pronostico pronostico){
     this.pronosticos.remove(pronostico);
    }
    
    public boolean existePronostico(Pronostico pronostico){
    
      return this.pronosticos.contains(pronostico);
    }
    
    public boolean existeParticipante(String nombre){
      return this.getNombre().equals(nombre);
    }
    
    
}
