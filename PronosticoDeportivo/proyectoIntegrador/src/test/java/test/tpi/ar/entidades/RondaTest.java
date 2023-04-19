/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.tpi.ar.entidades;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.entidades.Equipo;
import tpi.ar.programa.entidades.Partido;
import tpi.ar.programa.entidades.Ronda;

/**
 *
 * @author pbarzaghi
 */
public class RondaTest {
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Equipo equipo4;
  
    private Partido partido1;
    private Partido partido2;
    private Partido partido3;
   
    
    List<Partido> partidos;
    private Ronda ronda1;
   
    
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
         
        
        
    
    }
    
    
    @Test
    public void equipo1GanoRonda(){
     //ARGENTINA - BRAZIL
        partido1.setGolesEquipo1(3);
        partido1.setGolesEquipo2(1);
        partidos.add(partido1);
    
     //ARGENTINA - CHILE
       partido2.setGolesEquipo1(3);
       partido2.setGolesEquipo2(2);
       partidos.add(partido2);
     
    //ARGENTINA - URUGUAY   
      partido3.setGolesEquipo1(3);
      partido3.setGolesEquipo2(2);
      partidos.add(partido3);
     // Partidos de la 1ra Ronda  
      ronda1.setPartidos(partidos);
      Assertions.assertTrue(ronda1.esRondaGanada(equipo1));
     }
    
     @Test
    public void equipo1Gano2Ronda(){
     //ARGENTINA - BRAZIL
        partido1.setGolesEquipo1(3);
        partido1.setGolesEquipo2(1);
        partidos.add(partido1);
    
     //ARGENTINA - CHILE
       partido2.setGolesEquipo1(3);
       partido2.setGolesEquipo2(2);
       partidos.add(partido2);
     
     
       List<Partido> partidos2 =new ArrayList<Partido>();
    //ARGENTINA - URUGUAY   
      partido3.setGolesEquipo1(3);
      partido3.setGolesEquipo2(2);
     
      Equipo equipo5 = new Equipo("PARAGUAY","SELECCION");
      equipo5.setId(5);
       
     Partido partido4= new Partido();
      partido4.setEquipo1(equipo1);
     
      partido4.setEquipo2(equipo5);
      
      partido4.setGolesEquipo1(3);
     partido4.setGolesEquipo2(2);
      
      partidos2.add(this.partido3);
      partidos2.add(partido4);
      Ronda ronda2= new Ronda();
      ronda2.setNro(2);
      
      this.ronda1.setPartidos(this.partidos);
      ronda2.setPartidos(partidos2);
      
      
     Assertions.assertTrue(ronda1.esRondaGanada(this.equipo1)
                             && ronda2.esRondaGanada(this.equipo1) ); 
      
    
        
    }
    
    
    @Test
    public void argentinaJugoConBrazilEnLaRonda(){
       
        
        partido1.setEquipo1(equipo1);
        partido1.setEquipo2(equipo2);
        partido1.setGolesEquipo1(3);
        partido1.setGolesEquipo2(3);
        
        partido2.setEquipo1(equipo3);
        partido2.setEquipo2(equipo4);
        partido2.setGolesEquipo1(3);
        partido2.setGolesEquipo2(1);
        
        ronda1.appendPartido(partido2);
        ronda1.appendPartido(partido1);
        Assertions.assertTrue(ronda1.validarPartidoEnARonda(partido1));
    
    }
}
