/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.participante;

import tpi.ar.programa.enumerado.TipoDocumento;

/**
 *
 * @author pbarzaghi
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class Persona {
    private String nombre;
    private String apellido;
    private int nroDoc;
    private TipoDocumento tipoDoc;
    
    
public Persona(String nombre){
        this.nombre=nombre;
        this.apellido="";
}
      
    
    
}
