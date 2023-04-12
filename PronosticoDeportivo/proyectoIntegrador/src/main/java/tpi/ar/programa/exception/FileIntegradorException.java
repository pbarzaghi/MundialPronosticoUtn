/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author pbarzaghi
 */
public class FileIntegradorException  extends Exception {
    private String mensajeError;

    
public FileIntegradorException(String msg){

    this.mensajeError=msg;
}
     
     
    
    @Override
    public String getMessage() {
      return this.mensajeError;   
    }
     
  
}
