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
    
   
    
    public static void inizializar(){
       tablaObjetosIntegrador= new HashMap();

    }
    
    public static Object obtenerObjeto(String clave){
      
         if(tablaObjetosIntegrador==null)
             inizializar();
        return tablaObjetosIntegrador.get(clave);
        
    }
    
    public static Object eliminarObjeto(String clave){
      
         if(tablaObjetosIntegrador==null)
            inizializar();
        return tablaObjetosIntegrador.remove(clave);
        
    }
    
     public static Object remplazarObjeto(String clave,Object objeto){
      
         if(tablaObjetosIntegrador==null)
            inizializar();
        return tablaObjetosIntegrador.replace(clave,objeto);
        
    }
     
      public static Object agregarObjeto(String clave,Object objeto){
      
         if(tablaObjetosIntegrador==null)
            inizializar();
        return tablaObjetosIntegrador.put(clave,objeto);
        
    }
     
   
      public static Map obtenerTabla(){
      
         if(tablaObjetosIntegrador==null)
            inizializar();
        return tablaObjetosIntegrador;
        
    }
     
     public static void cleanTabla(){
        if(tablaObjetosIntegrador!=null)
              tablaObjetosIntegrador.clear();
     } 
}
