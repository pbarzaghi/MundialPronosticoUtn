/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.exception;

/**
 *
 * @author pbarzaghi
 */
public class GolesNegativoException extends RuntimeException{
    
     
     public GolesNegativoException(String msgError){
       super(msgError);
     }   

}
