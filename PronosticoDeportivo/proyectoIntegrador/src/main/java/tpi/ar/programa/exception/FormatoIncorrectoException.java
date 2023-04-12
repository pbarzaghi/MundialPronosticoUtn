/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.exception;

/**
 *
 * @author pbarzaghi
 */
public class FormatoIncorrectoException  extends RuntimeException{
    
       private String mensajeError;

     public FormatoIncorrectoException(String msgError){
        mensajeError=msgError;
     }   

    @Override
    public String getMessage() {
      return this.mensajeError;   
    }
}
