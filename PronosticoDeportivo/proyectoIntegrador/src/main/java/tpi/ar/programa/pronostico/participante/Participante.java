/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.participante;

import java.util.ArrayList;
import java.util.List;
import tpi.ar.programa.pronostico.Pronostico;

/**
 *
 * @author Usuario
 */
public class Participante extends Persona{
    
    private List<Pronostico> pronosticos;
    public Participante(String nombre) {
        super(nombre);
       this.pronosticos=new ArrayList<>();
    }

    /**
     * @return the pronosticos
     */
    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    /**
     * @param pronosticos the pronosticos to set
     */
    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
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
