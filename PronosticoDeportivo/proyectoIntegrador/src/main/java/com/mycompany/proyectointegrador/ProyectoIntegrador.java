/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;


import java.util.List;

import tpi.ar.programa.exception.FileIntegradorException;

import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.lectura.file.MsgProperty;

import tpi.ar.programa.lectura.file.ServicesFileCsvBd;
import tpi.ar.programa.lectura.file.ReadAllFileCsv;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.participante.Participante;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args)  {
   
     
      try {
         
          imprimirEtapa2(args);
       
         imprimirEtapa3();
           
       } catch (FileIntegradorException ex) {
            System.err.println( ex.getMessage());
             System.exit(1);
       }catch (GolesNegativoException ex) {
          
             System.err.println( ex.getMessage());
          
       
            System.exit(1);
       }      
      
      
    
    }
    
    private static void imprimirEtapa3() throws FileIntegradorException,GolesNegativoException{
      ServicesFileCsvBd services = new ServicesFileCsvBd();
          GanadorPronostico ganador= new GanadorPronostico();
         
       
            for (Participante participante : services.obtenerListaParticipante()) {
                System.out.println(ganador.puntajeParticipantePronostico(participante));   
            }
       
    
    }  
    
    private static void imprimirEtapa2(String[] args ) throws FileIntegradorException   {

        System.out.println("Path de archivo 1 .. "+args[0]);
        System.out.println("Path de archivo 2 .."+args[1]);
        System.out.println("Path de archivo 3 .."+args[2]);
        String csvResultado = args[0];
        String csvPronostico  = args[1];
        String csvPuntos = args[2];
       // Se dejo de unsar esta clase porque no podia realizar el empaquetamiento
       // con la dependencia que esta en el pom
       // FileCvs file= new FileCvs();
       
       ReadAllFileCsv file = new ReadAllFileCsv();
       
        List<Participante> listaParticipante;
        listaParticipante = file.leerArchivoPronostico(csvPuntos,
                    csvResultado,
                    csvPronostico);
         
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
          GanadorPronostico ganador= new GanadorPronostico();
         
           for (Participante participante : listaParticipante) {
                 System.out.println(ganador.puntajeParticipantePronostico(participante));
            }
              
          
          
          
    
    
    }
    
    
}