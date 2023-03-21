/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import tpi.ar.programa.lectura.file.FileCvs;

/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
    
        //TODO aca hay que leer los archivos por parametros no como esta ahora
        
        String csvResultdo = "..\\proyectoIntegrador\\src\\main\\resources\\resultado.csv";         
        String csvPronostico = "..\\proyectoIntegrador\\src\\main\\resources\\pronostico.csv"; 
      //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
   
      
      /*  
 
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningÃºn archivo como argumento!");
            System.exit(88);
        }
     
    */
    
        FileCvs file= new FileCvs();
        
        file.leerArchivoResultado(csvResultdo);
        file.leerArchivoPronostico(csvPronostico);
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
        
    }
}
