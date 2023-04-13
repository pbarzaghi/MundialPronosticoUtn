/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;


import java.util.List;

import tpi.ar.programa.exception.FileIntegradorException;

import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.lectura.file.ServicesFileCsvBd;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.participante.Participante;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args)  {
   
     
      try {
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
    
  
    
    
}