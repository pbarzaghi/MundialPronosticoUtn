/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.pronostico.deportivo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;

/**
 *
 * @author pbarzaghi
 */
public class PartidoTest {
    
    private Equipo equipo1;
    private Equipo equipo2;
    private Partido partido;
 
    @BeforeEach
    public void init(){
         equipo1=new Equipo("ARGENTINA","SELECCION");
         equipo1.setId(1);
        
         equipo2=new Equipo("BRAZIL","SELECCION");
         equipo2.setId(2);
         
         partido=new Partido();
         partido.setEquipo1(equipo1);
          partido.setEquipo2(equipo2);
    }
    @Test
    public void equipo1GanoPartido(){
       partido.setGolesEquipo1(2);
       partido.setGolesEquipo2(1);
         Assertions.assertTrue(partido.getGolesEquipo1()>partido.getGolesEquipo2());
       
    }
     @Test
    public void equipo1ResultadoGanadorPartido(){
       partido.setGolesEquipo1(2);
       partido.setGolesEquipo2(1);
         Assertions.assertEquals(ResultadoEmun.GANADOR ,
                                partido.getResultado(equipo1));
       
    }
    
    
    
    @Test
    public void equipo2GanoPartido(){
      partido.setGolesEquipo1(1);
       partido.setGolesEquipo2(2);
         Assertions.assertEquals(ResultadoEmun.GANADOR ,
                                partido.getResultado(equipo2));
    
    
    }
    
     @Test
    public void equipo1ResultadoPerdedorPartido(){
       partido.setGolesEquipo1(1);
       partido.setGolesEquipo2(2);
         Assertions.assertEquals(ResultadoEmun.PERDEDOR ,
                                partido.getResultado(equipo1));
       
    }
    
    
    @Test
    public void empatoPartido(){
      partido.setGolesEquipo1(2);
       partido.setGolesEquipo2(2);
         Assertions.assertEquals(ResultadoEmun.EMPATE ,
                                partido.getResultado(equipo1));
    
    
    }
    
    
    
}
