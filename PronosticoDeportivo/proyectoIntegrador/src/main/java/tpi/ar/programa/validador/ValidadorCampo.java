/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.validador;

/**
 *
 * @author pbarzaghi
 */
public class ValidadorCampo {
    
            
    public boolean validar(String campo,String tipo){
    
        boolean ok=true;
        
       switch (tipo) {
            case "EQUIPO":
                        // realizar expresion regular para validar
                       //ok=false;  
                       break;
           case "GOLES":
                                    
                     // realizar expresion regular para validar
                     //ok=false;
                      break; 
                       
           case "PARTICIPANTE":
                      // realizar expresion regular para validar
                       //ok=false;
                       break; 
            
         
           case "PRONOSTICO" :  
                        // realizar expresion regular para validar
                         //ok=false;
                         break;  
           case "NOMBRE_MAYUSCULA" : 
              //ok=false;
               break; 
        }
        return ok;
 
        
        
    
    }
}
