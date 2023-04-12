/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;


import java.io.IOException;
import java.util.List;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.participante.Participante;

/**
 *
 * @author pbarzaghi
 */
public class ServicesFileCsvBd {
    
   
    
    public List<Participante> obtenerListaParticipante() throws  FileIntegradorException{
        
          List<Participante> participantes;
        
        try {
                // CARGO LOS PUNTOS DE LA BD
            FileBd db=new FileBd();
            PuntosResultado puntos=db.leerArchivoPuntos();
            
            // SETEO LOS PUNTOS EN LA CLASE FILE PARA CUANDO CARGUE LOS RESULTADOS AGREGAR LOS PUNTOS
            FileCsv csv= new FileCsv();
            csv.setearPuntosResultado(puntos);
            csv.leerArchivoResultado();
            participantes= db.leerArchivoPronostico( csv.obtenerTablaPartidos());
          
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