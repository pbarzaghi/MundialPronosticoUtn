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
         
          puntos= new Punto();
         puntos.setPuntoAcierto(1);
         puntos.setPuntosRonda(2);
         
         puntos.setPuntoGanar(3);
         puntos.setPuntoEmpatar(1);
         puntos.setPuntoPerder(0);
    
         
         pronostico1 = new Pronostico();
         pronostico1.setPuntosResultado(puntos);
         
        
        
    
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
      pronostico2.setPuntosResultado(puntos);
      pronostico2.setPartido(partido2);
      pronostico2.setResultado(resultadoPronostico.GANADOR);
      pronostico2.setEquipo(equipo1);

      ParticipanteModel ganador= new ParticipanteModel();
      
      
     List<Pronostico> pronosticos = new ArrayList<Pronostico> ();
        pronosticos.add(pronostico1);
         pronosticos.add(pronostico2);
      Assertions.assertTrue(ganador.isPronosticoDeUnaRonda(pronosticos));
    
    }
    
    
   @Test
    public void pronosticoSeparadoPorCollectionRonda(){
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
       
      // ARGENTINA - URUGUAY
       partido3.setGolesEquipo1(4);
       partido3.setGolesEquipo2(2);
       
       Partido partido4 = new Partido();
      // CHILE - URUGUAY
      
       partido4.setEquipo1(equipo3);
       partido4.setEquipo2(equipo4);
       partido4.setGolesEquipo1(1);
       partido4.setGolesEquipo2(4);
       
       
       
       Ronda ronda2= new Ronda();
       ronda2.setNro(2);
       partido3.setRonda(ronda2);
       partido4.setRonda(ronda2);
       ronda2.appendPartido(partido3);
       ronda2.appendPartido(partido4);
       
     
// Partidos de la 1ra Ronda  
      ronda1.setPartidos(partidos);
      pronostico1.setPartido(partido1);
      pronostico1.setResultado(resultadoPronostico.GANADOR);
      pronostico1.setEquipo(equipo1);
     
      Pronostico pronostico2 = new Pronostico();
      pronostico2.setPuntosResultado(puntos);
      pronostico2.setPartido(partido2);
      pronostico2.setResultado(resultadoPronostico.GANADOR);
      pronostico2.setEquipo(equipo1);

      Pronostico pronostico3 = new Pronostico();
      pronostico3.setPuntosResultado(puntos);
      pronostico3.setPartido(partido3);
      pronostico3.setResultado(resultadoPronostico.GANADOR);
      pronostico3.setEquipo(equipo1);

      Pronostico pronostico4 = new Pronostico();
      pronostico4.setPuntosResultado(puntos);
      pronostico4.setPartido(partido4);
      pronostico4.setResultado(resultadoPronostico.GANADOR);
      pronostico4.setEquipo(equipo4);

      
      ParticipanteModel ganador= new ParticipanteModel();
      
      
     ArrayList<Pronostico>  pronosticosAux = new ArrayList<Pronostico> ();
          pronosticosAux.add(pronostico1);
        pronosticosAux.add(pronostico2);
       pronosticosAux.add( pronostico3);
       pronosticosAux.add(pronostico4);
      
         
      Map map = (Map) ganador.listPronosticoPorRonda(pronosticosAux);
      Iterator entries = map.entrySet().iterator();
      while (entries.hasNext()) {
          Map.Entry entry = (Map.Entry) entries.next();
         Ronda key = (Ronda)entry.getKey();
         List<Pronostico> value = (List<Pronostico>)entry.getValue();  
                      
          Assertions.assertTrue(ganador.isPronosticoDeUnaRonda(value));
          }
      
    
    }
    
}
