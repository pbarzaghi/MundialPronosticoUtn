/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.validador;

import java.util.regex.Pattern;

/**
 *
 * @author pbarzaghi
 */
public class ValidadorCampo {
    
            
    public boolean validar(String campo,String tipo){
     
       
       String patron;
       boolean ok=true;
        
       switch (tipo) {
            case "EQUIPO":
                  // Expresion regular. Cadena con mayuscula y puede aceptar espacio       
                patron="[A-Z ]+";
                ok=this.patternMmatcher(patron, campo);  
                
              
                break;
           case "GOLES":
                    // Expresion regular. Cadena numeros de 0 a 99       
                    patron="[0-9]+{1,2}";
                    ok=this.patternMmatcher(patron, campo);  
                    break; 
                       
           case "PARTICIPANTE":
                    patron="([A-Z ]+|[a-z ])+";
                    ok =this.patternMmatcher(patron, campo); 
                  
                    break; 
                  
           case "PRONOSTICO" :  
                    patron="([X]|[O])";
                    ok =this.patternMmatcher(patron, campo);  
                    break; 
           case "NOMBRE_MAYUSCULA" : 
               // Expresion regular. Cadena con mayuscula.       
                patron="[A-Z]+";
                ok=this.patternMmatcher(patron, campo);  
                break;
        }
        return ok;
    }
    
    
    
    private boolean patternMmatcher(String patron,String cadena){
       
        final Pattern pattern = Pattern.compile(patron);
        return pattern.matcher(cadena).matches();
    }   
}
