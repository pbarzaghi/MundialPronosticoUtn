/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.entidades;

/**
 *
 * @author pbarzaghi
 */

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Equipo {
  private int id;
  private String nombre;
  private String descripcion;
  

  
  public Equipo(String nombre,String descripcion){
    super(); 
    this.nombre=nombre;
    this.descripcion=descripcion;
  
  }
    
}
