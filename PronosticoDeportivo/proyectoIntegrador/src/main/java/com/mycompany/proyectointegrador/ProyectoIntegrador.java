/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.util.List;
import javax.swing.JOptionPane;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
        String csvResultado="";         
        String csvPronostico = ""; 
        boolean salida=true;
        String strNrofileResultado;
        do{
         strNrofileResultado= JOptionPane.showInputDialog(null,"Elija el archivo: 1 - 2 - 3","ARCHIVO RESULTADO", 3);
            switch(strNrofileResultado) {
                case "1":
                    csvResultado = "src\\main\\resources\\resultado1.csv";
                    salida=false;
                    break;
                  case "2":
                     csvResultado = "src\\main\\resources\\resultado2.csv";  
                     salida=false;
                    break; 
                   case "3":
                     csvResultado = "src\\main\\resources\\resultado3.csv";
                     salida=false;
                    break;   
                default:
                     strNrofileResultado= JOptionPane.showInputDialog(null,"Elija el archivo: 1 - 2 - 3","ARCHIVO RESULTADO", 3);
        
            }
        
        }while(salida);
        
        
                
         salida=true;
         String strNrofilePronostico;
        do{
            strNrofilePronostico= JOptionPane.showInputDialog(null,"Elija el archivo: 1 - 2 - 3)","ARCHIVO PRONOSTICO ",3);
             
            switch( strNrofilePronostico) {
                case "1":
                     csvPronostico = "src\\main\\resources\\pronostico1.csv"; 
                    salida=false;
                    break;
                  case "2":
                      csvPronostico = "src\\main\\resources\\pronostico2.csv";   
                     salida=false;
                    break; 
                   case "3":
                      csvPronostico = "src\\main\\resources\\pronostico3.csv"; 
                     salida=false;
                    break;   
                default:
                       strNrofilePronostico= JOptionPane.showInputDialog(null,"Elija el archivo: 1 - 2 - 3)","ARCHIVO PRONOSTICO ",4);
             
            }
              }while(salida);   
     
    
       FileCvs file= new FileCvs();
     // tengo que ejecutar primero resultado para poder crear los objetos
   //   List<Ronda> listaRonda= file.leerArchivoResultado(csvResultdo);
      List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
    GanadorPronostico ganador= new GanadorPronostico();
    System.out.println( ganador.ganadorDelPronostico(listaPronostico));
         

      
    }
    
  
    
    
    
    
    
}
