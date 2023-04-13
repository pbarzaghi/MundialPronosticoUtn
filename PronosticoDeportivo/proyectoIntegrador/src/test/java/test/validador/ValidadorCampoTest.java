/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.validador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.validador.ValidadorCampo;


/**
 *
 * @author pbarzaghi
 */
public class ValidadorCampoTest {
    
    
    @Test
    public void validarNombreEquipo(){
          ValidadorCampo nombreEquipo = new ValidadorCampo();
         // El nombre del equipo debe  ser todo en mayuscula
      
           Assertions.assertFalse(nombreEquipo.validar("Argentina", "EQUIPO"));
          
          // ESTE ES CORRECTO
          Assertions.assertTrue(nombreEquipo.validar("ARGENTINA", "EQUIPO"));
         
          // Solo letras musculas o espacio en blancos
     
         Assertions.assertFalse(nombreEquipo.validar("ARABIA_SAUDITA", "EQUIPO"));
          
        // ESTE ES CORRECTO
          Assertions.assertTrue(nombreEquipo.validar("ARABIA SAUDITA", "EQUIPO"));
    }
    
    
   @Test
    public void validarGolesDeEquipo(){
          ValidadorCampo nombreEquipo = new ValidadorCampo();
         // El nro tiene que se un entero de 0..9 y tampoco puede haber tres digitos
        
        Assertions.assertFalse(nombreEquipo.validar("-1", "GOLES"));
          
          // ESTE ES CORRECTO
          Assertions.assertTrue(nombreEquipo.validar("1", "GOLES"));
         
          //NO dan los tiempos para hacer mas de 100 goles
   
          Assertions.assertFalse(nombreEquipo.validar("100", "GOLES"));
          
        // ESTE ES CORRECTO
          Assertions.assertTrue(nombreEquipo.validar("12", "GOLES"));
    
              // ESTE ES CORRECTO
          Assertions.assertTrue(nombreEquipo.validar("0", "GOLES"));
    
    }
    
    
}
