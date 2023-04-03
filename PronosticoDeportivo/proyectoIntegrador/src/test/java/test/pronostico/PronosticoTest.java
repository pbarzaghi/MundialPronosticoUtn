/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.pronostico;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;
import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.deportivo.Ronda;


/**
 *
 * @author pbarzaghi
 */
public class PronosticoTest {
    
    
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Equipo equipo4;
   
    private Partido partido1;
    private Partido partido2;
    
    private ResultadoEmun resultadoPronostico;
    private PuntosResultado puntos;
    private Pronostico pronostico1;

    
    @BeforeEach
    public void init(){
        
         equipo1=new Equipo("ARGENTINA","SELECCION");
         equipo1.setId(1);
        
         equipo2=new Equipo("BRAZIL","SELECCION");
         equipo2.setId(2);
         
         
       
         partido1=new Partido();
         // ARGENTINA - BRAZIL
         partido1.setEquipo1(equipo1);
         partido1.setEquipo2(equipo2);
        
           //ARGENTINA - CHILE
       
          
           
         equipo3=new Equipo("CHILE","SELECCION");
         equipo3.setId(3);
         
        // equipo4=new Equipo("URUGUAY","SELECCION");
       //  equipo4.setId(4);
          partido2=new Partido();
         //Argentina - CHILE
         partido2.setEquipo1(equipo1);
         partido2.setEquipo2(equipo3);
         
         puntos= new PuntosResultado();
         puntos.setPuntoAcierto(1);
         puntos.setPuntosRonda(2);
         
         puntos.setPuntoGanar(3);
         puntos.setPuntoEmpatar(1);
         puntos.setPuntoPerder(0);
    
         
         pronostico1 = new Pronostico();
         pronostico1.setPuntosResultado(puntos);
         
       
         
    }
    
    
    
    @Test
    public void acertoPronostico(){
    
        partido1.setGolesEquipo1(3);
        partido1.setGolesEquipo2(2);
        pronostico1.setPartido(partido1);
        
        pronostico1.setResultado(resultadoPronostico.GANADOR);
        pronostico1.setEquipo(equipo1);
        
       Assertions.assertTrue( 
       pronostico1.acertoResultado(partido1.getResultado(pronostico1.getEquipo()))
       );
       
    }
        @Test
         public void puntajePorAceptar2Partidos(){
    
                partido1.setGolesEquipo1(3);
                partido1.setGolesEquipo2(2);
                pronostico1.setPartido(partido1);
                
                partido2.setEquipo1(equipo1);
                partido2.setEquipo1(equipo3);
                partido2.setGolesEquipo1(3);
                partido2.setGolesEquipo2(2);

                pronostico1.setResultado(resultadoPronostico.GANADOR);
                pronostico1.setEquipo(equipo1);

                Pronostico pronostico2= new Pronostico();
                pronostico2.setEquipo(equipo2);
                pronostico2.setPartido(partido2);
                pronostico2.setPuntosResultado(puntos);
                 pronostico2.setResultado(resultadoPronostico.PERDEDOR);
                 Assertions.assertEquals(2,pronostico1.getPuntos()+pronostico2.getPuntos());
                 
                

      
         }

}

