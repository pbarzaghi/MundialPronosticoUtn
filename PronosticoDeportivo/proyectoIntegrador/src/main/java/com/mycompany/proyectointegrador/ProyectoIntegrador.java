/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.util.List;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;
import tpi.ar.programa.pronostico.deportivo.Ronda;

/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
    
        //TODO aca hay que leer los archivos por parametros no como esta ahora
        
       // System.out.println("args "+ args.length);
        String csvResultado = "src\\main\\resources\\resultado.csv";         
        String csvPronostico = "src\\main\\resources\\pronostico.csv"; 
      //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
   
      
      
      /*  
 
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningÃºn archivo como argumento!");
            System.exit(88);
        }
     
    */
    
       FileCvs file= new FileCvs();
     // tengo que ejecutar primero resultado para poder crear los objetos
   //   List<Ronda> listaRonda= file.leerArchivoResultado(csvResultdo);
      List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
    
        GanadorPronostico ganador= new GanadorPronostico();
        ganador.ganadorDelPronostico(listaPronostico);
        
        // Imprimir el orden de los ganadores y sus puntos
          //    ganador.getParticipantePuntos();
    
        
    }
    
  
    
    
    
    
    
}
