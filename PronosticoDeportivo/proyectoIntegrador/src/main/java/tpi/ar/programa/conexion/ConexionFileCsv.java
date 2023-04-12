/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.conexion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import tpi.ar.programa.exception.FileIntegradorException;


/**
 *
 * @author pbarzaghi
 */
public class ConexionFileCsv implements Conexion{

     private  List<String> listStr=null;
     private String path;
  
    @Override
    public Object abrirConexion() throws FileIntegradorException {
        try {
        
          Path pathString= Paths.get(this.path); 
         
           this.listStr = Files.readAllLines(pathString);

          } catch (IOException ex) {
          throw new FileIntegradorException(ex.getMessage());
        }
        
        return (Object) this.listStr;
    }
    
    
    

    @Override
    public void cerrarConexion() throws FileIntegradorException{
      //TODO: no hace nada
           
    }
     @Override
     public void setConection(Object obj){
         this.path=(String)obj;
     }
   
    
}
