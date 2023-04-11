/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import tpi.ar.programa.pronostico.PuntosResultado;
import tpi.ar.programa.pronostico.participante.Participante;

/**
 *
 * @author pbarzaghi
 */
public class ServicesFileCsvBd {
    
    private String pathProperties="src\\main\\java\\resources\\";
    private  final String PROPERTIES_JDBC = "jdbc.properties"; 
    private  final String PROPERTIES_CONFIG= "configuracion.properties";
    private   Properties properties;
    
    public List<Participante> obtenerListaParticipante() throws FileNotFoundException, IOException, Exception{
        
         properties = new Properties();
         properties.load(new FileInputStream(pathProperties+PROPERTIES_CONFIG));
         properties.load(new FileInputStream(pathProperties+PROPERTIES_JDBC));
        
         // CARGO LOS PUNTOS DE LA BD 
         FileBd db=new FileBd();
         PuntosResultado puntos=db.leerArchivoPuntos(properties);
         
         // SETEO LOS PUNTOS EN LA CLASE FILE PARA CUANDO CARGUE LOS RESULTADOS AGREGAR LOS PUNTOS
         FileCsv csv= new FileCsv();
         csv.setearPuntosResultado(puntos);
         String pathResultado=properties.getProperty("file.path")+
                              //pathProperties      +
                              properties.getProperty("file.resultado") ;
         csv.leerArchivoResultado(pathResultado);
         List<Participante> participantes= db.leerArchivoPronostico(properties,   csv.obtenerTablaPartidos());
         return participantes;
        
    }
    
}
