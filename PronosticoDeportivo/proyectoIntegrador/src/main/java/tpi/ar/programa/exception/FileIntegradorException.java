/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.exception;

import java.io.IOException;

/**
 *
 * @author pbarzaghi
 */
public class FileIntegradorException extends IOException{
    private String mensajeError;

     public FileIntegradorException(String msgError){
        mensajeError=msgError;
     }    
     
}
