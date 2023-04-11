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
import java.util.logging.Level;
import java.util.logging.Logger;
import tpi.ar.programa.exception.FileIntegradorException;


/**
 *
 * @author pbarzaghi
 */
public class ConexionFileCsv implements Conexion{

     private  List<String> listStr=null;
  
    @Override
    public Object abrirConexion(Object object) throws FileIntegradorException {
        try {
          Path pathString= Paths.get((String) object); 
         
           this.listStr = Files.readAllLines(pathString);

          } catch (IOException ex) {
          throw new FileIntegradorException(ex.getMessage());
        }
        
        return (Object) this.listStr;
    }
    
    
    

    @Override
    public void cerrarConexion(Object path) {
      //TODO: no hace nada
           
    }

   
    
}
