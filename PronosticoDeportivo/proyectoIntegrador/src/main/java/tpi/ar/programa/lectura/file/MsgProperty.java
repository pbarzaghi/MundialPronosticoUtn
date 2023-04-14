/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import tpi.ar.programa.exception.FileIntegradorException;

/**
 *
 * @author  pbarzaghi
 */
public class MsgProperty {
    
    private static MsgProperty instancia = null;
    private static Properties properties ;

    
    private MsgProperty() throws IOException{
         properties = new Properties();
         this.cargarProperties();
       }
    
    
    
    
    
   
    public static String getMensaje(String codigo) throws FileIntegradorException{
       
      String msgNoCargolaProperties="No hay ningun mensaje de Error cargado en el archivo error.properties";
      String salidaMsjCargado;
      try{
        
        if(instancia==null)
            instancia=new MsgProperty();
        
            salidaMsjCargado= MsgProperty.properties.getProperty(codigo);
           
            if (salidaMsjCargado == null)
                return msgNoCargolaProperties;
          
        } catch (IOException ex) {
            throw new FileIntegradorException("Error no se puede cargar el Archivo properties con la configuracion ");
        }
        return salidaMsjCargado ;
    }
    
    
    
    
   private void cargarProperties() throws FileNotFoundException, IOException{
            String pathProperties= "src\\main\\java\\resources\\";
            String PROPERTIES_ERROR= "error.properties";
            String PROPERTIES_JDBC = "jdbc.properties"; 
            String PROPERTIES_CONFIG= "configuracion.properties";
            
            properties= new Properties();
            properties.load(new FileInputStream(pathProperties+PROPERTIES_ERROR));
            properties.load(new FileInputStream(pathProperties+PROPERTIES_CONFIG));
            properties.load(new FileInputStream(pathProperties+PROPERTIES_JDBC));
         
    
    }
    
}
