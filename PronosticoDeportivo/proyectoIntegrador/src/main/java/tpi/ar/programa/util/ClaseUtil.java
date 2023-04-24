/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pbarzaghi
 */
public class ClaseUtil {
    
    
    private static Map tablaObjetosIntegrador;
    
    public ClaseUtil(){
      tablaObjetosIntegrador= new HashMap();
    } 
    
    
    public static Object obtenerObjeto(String clave){
      
         if(tablaObjetosIntegrador==null)
             new ClaseUtil();
        return tablaObjetosIntegrador.get(clave);
        
    }
    
    public static Object eliminarObjeto(String clave){
      
         if(tablaObjetosIntegrador==null)
             new ClaseUtil();
        return tablaObjetosIntegrador.remove(clave);
        
    }
    
     public static Object remplazarObjeto(String clave,Object objeto){
      
         if(tablaObjetosIntegrador==null)
             new ClaseUtil();
        return tablaObjetosIntegrador.replace(clave,objeto);
        
    }
     
      public static Object agregarObjeto(String clave,Object objeto){
      
         if(tablaObjetosIntegrador==null)
             new ClaseUtil();
        return tablaObjetosIntegrador.put(clave,objeto);
        
    }
     
   
      public static Map obtenerTabla(){
      
         if(tablaObjetosIntegrador==null)
             new ClaseUtil();
        return tablaObjetosIntegrador;
        
    }
     
    
}
