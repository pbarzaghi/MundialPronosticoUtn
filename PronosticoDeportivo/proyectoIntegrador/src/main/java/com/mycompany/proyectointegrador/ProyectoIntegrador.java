/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.util.List;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
    
        //TODO aca hay que leer los archivos por parametros no como esta ahora
        

        String csvResultado = "src\\main\\resources\\resultado.csv";         
        String csvPronostico = "src\\main\\resources\\pronostico.csv"; 
     
    
       FileCvs file= new FileCvs();
     // tengo que ejecutar primero resultado para poder crear los objetos
   //   List<Ronda> listaRonda= file.leerArchivoResultado(csvResultdo);
      List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
    
        GanadorPronostico ganador= new GanadorPronostico();
        System.out.println( ganador.ganadorDelPronostico(listaPronostico));
         

      
    }
    
  
    
    
    
    
    
}
