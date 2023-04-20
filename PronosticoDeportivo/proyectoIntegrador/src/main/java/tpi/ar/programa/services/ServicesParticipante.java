/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.services;


import tpi.ar.programa.repositorios.RepositorioFileResultado;
import tpi.ar.programa.repositorios.RepositorioBdPronostico;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.enumerado.PuntosResultado;
import tpi.ar.programa.entidades.Participante;
import tpi.ar.programa.repositorios.RepositorioBdPunto;

/**
 *
 * @author pbarzaghi
 */
public class ServicesParticipante {
    
   
    
    public List<Participante> getListaParticipante() throws  FileIntegradorException{
        
          List<Participante> participantes;
        
        try {
                // CARGO LOS PUNTOS DE LA BD
          
           RepositorioBdPunto repositorioPunto=new RepositorioBdPunto(); 
           PuntosResultado tablaDePuntos=repositorioPunto.getTablaDePuntos();
            
          
            RepositorioFileResultado resultadoPartidos= new RepositorioFileResultado();
          // Seteo los TablaPuntos para que se carguen en los resultados de los partidos
            resultadoPartidos.setearPuntosResultado(tablaDePuntos);
            HashMap tablaResultadoPartido=resultadoPartidos.getResultadoPartidos();
            
            RepositorioBdPronostico repositorioPronostico=new RepositorioBdPronostico();  
            // obtengo la tabla de resultados obtenida de metodo getResultadoPartidos
            participantes= repositorioPronostico.getParticipantesConPronostico(tablaResultadoPartido);
           
          
        } catch (RuntimeException ex) {
            
           throw  new GolesNegativoException(ex.getMessage());
        } catch (IOException ex) {
           throw new FileIntegradorException(ex.getMessage());
        } catch (Exception ex) {
           throw new FileIntegradorException(ex.getMessage());
        }
         
    return participantes;
   }
}