/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.pronostico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.model.ParticipanteModel;
import tpi.ar.programa.entidades.Pronostico;
import tpi.ar.programa.entidades.Punto;
import tpi.ar.programa.entidades.Equipo;
import tpi.ar.programa.entidades.Partido;
import tpi.ar.programa.entidades.Ronda;
import tpi.ar.programa.util.ClaseUtil;

/**
 *
 * @author pbarzaghi
 */
public class ParticipanteModelTest {
     private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Equipo equipo4;
  
    private Partido partido1;
    private Partido partido2;
    private Partido partido3;
   
    
    List<Partido> partidos;
    private Ronda ronda1;
   
     private ResultadoEmun resultadoPronostico;
    private Punto puntos;
    private Pronostico pronostico1;
    
    @BeforeEach
    public void init(){
        
         equipo1=new Equipo("ARGENTINA","SELECCION");
         equipo1.setId(1);
        
         equipo2=new Equipo("BRAZIL","SELECCION");
         equipo2.setId(2);
         
         
         equipo3=new Equipo("CHILE","SELECCION");
         equipo3.setId(3);
         
         equipo4=new Equipo("URUGUAY","SELECCION");
         equipo4.setId(4);
       
         partido1=new Partido();
         // ARGENTINA - BRAZIL
         partido1.setEquipo1(equipo1);
         partido1.setEquipo2(equipo2);
        
         
         partido2=new Partido();
         // ARGENTINA - CHILE
         partido2.setEquipo1(equipo1);
         partido2.setEquipo2(equipo3);
        
         
          partido3=new Partido();
         // ARGENTINA - URUGUAY
         partido3.setEquipo1(equipo1);
         partido3.setEquipo2(equipo4);
         
         partidos= new ArrayList<Partido>();
         ronda1=new Ronda();
         ronda1.setNro(1);
         
         
    
         
         pronostico1 = new Pronostico();
        
         
        
        
    
    }
    
    
   @Test
    public void puntosXGanarRonda(){
     //ARGENTINA - BRAZIL
        partido1.setGolesEquipo1(3);
        partido1.setGolesEquipo2(1);
        partido1.setRonda(ronda1);
        partidos.add(partido1);
    
     //ARGENTINA - CHILE
       partido2.setGolesEquipo1(3);
       partido2.setGolesEquipo2(2);
       partido2.setRonda(ronda1);
       partidos.add(partido2);
     
// Partidos de la 1ra Ronda  
      ronda1.setPartidos(partidos);
      pronostico1.setPartido(partido1);
      pronostico1.setResultado(resultadoPronostico.GANADOR);
      pronostico1.setEquipo(equipo1);
      
      Pronostico pronostico2 = new Pronostico();
   
      pronostico2.setPartido(partido2);
      pronostico2.setResultado(resultadoPronostico.GANADOR);
      pronostico2.setEquipo(equipo1);
       ClaseUtil.inizializar();
       Punto punto=new Punto();
       punto.setPuntosRonda(3);
       ClaseUtil.agregarObjeto(Punto.class.toString(), punto);
       ParticipanteModel ganador= new ParticipanteModel();
      
      
     List<Pronostico> pronosticos = new ArrayList<Pronostico> ();
        pronosticos.add(pronostico1);
         pronosticos.add(pronostico2);
       for (Pronostico pronostico : pronosticos) {
            Assertions.assertTrue(pronostico.getPartido().getRonda().esRondaGanada(pronosticos)); 
       }
   
  
    
    }
    
    
   
 
}
