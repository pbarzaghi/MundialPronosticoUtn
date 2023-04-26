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
        Assertions.assertTrue(ronda1.equals(ronda1.getRonda(partido1)));
    
    }
}
