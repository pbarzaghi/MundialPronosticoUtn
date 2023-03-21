/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.List;
import tpi.ar.programa.pronostico.Pronostico;
import tpi.ar.programa.pronostico.deportivo.Ronda;


/**
 *
 * @author pbarzaghi
 */
public class FileCvs {
    
    
    
    /*
      Este metodo lee dado el path del archivo los pronosticos y retorna una lista de pronostico
    cargados desde el archivo
    */
    public List<Pronostico> leerArchivoPronostico(String path){
    
      List <ServicioPronostico> listaDeSuscripciones;
        try {
            // En esta primera lÃ­nea definimos el archivos que va a ingresar
            listaDeSuscripciones = new CsvToBeanBuilder(new FileReader(path))
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ServicioPronostico.class)
                    .build()
                    .parse();
            //El resultado de este mÃ©todo nos da una lita del objetos
      
      
      for ( ServicioPronostico suscripcion : listaDeSuscripciones) {
          System.out.println(suscripcion.getNombreEquipo1() + ";" + suscripcion.getNombreEquipo2() + ";" + 
                  suscripcion.getNombreParticipante()+ ";" + suscripcion.getResultadoGanador1()+ ";" + suscripcion.getResultadoEmpate()+";" + suscripcion.getResultadoGanador2());
           // TODO Aca hay que implementar la logica para cargar la lista de pronostico
      }
   
      } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
      System.out.println(" ----- F I N CARGAR PRONOSTICOS -------");  
     //TODO: Esto no va esta, tiene que retornar la lista de pronostico cargada por arhivos   
     return null;   
    }
    
    
    
    /*
      Este metodo debe leer el archivo de resultado y cargarlos
    
    */
    
     public List <Ronda> leerArchivoResultado(String path){
    
      List <ServicioResultado> listaDeSuscripciones;
        try {
            // En esta primera lÃ­nea definimos el archivos que va a ingresar
            listaDeSuscripciones = new CsvToBeanBuilder(new FileReader(path))
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ServicioResultado.class)
                    .build()
                    .parse();
        
            //El resultado de este mÃ©todo nos da una lita del objetos
      
      
      for ( ServicioResultado suscripcion : listaDeSuscripciones) {
        System.out.println("implementar logica para cargar la ronda con sus partidos y equipos"+suscripcion.toString());
          System.out.println(suscripcion.getNombreEquipo1() + ";" + suscripcion.getCantGoles1Equipo1() + ";" +
                  suscripcion.getNombreEquipo2() + ";" + suscripcion.getCantGoles1Equipo2()+ ";" + suscripcion.getNroRonda());
        
      }
      } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    
        System.out.println(" ----- F I N CARGAR RESULTADOS -------");
      //  Esto return null no va. Tiene que retornar la lista de los resultados de los partido 
      // es decir la ronda 
    return null;
 
}
     
}
