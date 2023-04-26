/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.services;


import tpi.ar.programa.repositorios.RepositorioFileResultado;
import tpi.ar.programa.repositorios.RepositorioBdPronostico;
import java.io.IOException;
import java.util.List;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.entidades.Punto;
import tpi.ar.programa.entidades.Participante;
import tpi.ar.programa.repositorios.RepositorioBdPunto;
import tpi.ar.programa.util.ClaseUtil;

/**
 *
 * @author pbarzaghi
 */
public class ServicesParticipante {
    
   
    
    public List<Participante> getListaParticipante() throws  FileIntegradorException{
        
          List<Participante> participantes;
        
        try {
               
          
           
           // Cargo los punto de la BD y dejo los objetos en la HashMap de ClaseUtil     
           RepositorioBdPunto repositorioPunto=new RepositorioBdPunto(); 
           repositorioPunto.obtenerPtosDeTablaPunto();
            
           // Cargo los resultados de la BD y dejo los objetos en la HashMap de ClaseUtil
            RepositorioFileResultado resultadoPartidos= new RepositorioFileResultado();
            resultadoPartidos.obtenerPartidosDeTablaResultado();
           
            // Cargo los pronosticos del archivo y obtengo los objetos en la HashMap de ClaseUtil   
            RepositorioBdPronostico repositorioPronostico=new RepositorioBdPronostico();  
            participantes= repositorioPronostico.obtenerParticipantesConPronostico();
            
           
          
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