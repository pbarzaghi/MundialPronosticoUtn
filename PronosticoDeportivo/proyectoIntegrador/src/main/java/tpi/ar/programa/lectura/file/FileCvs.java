/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.Pronostico;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.deportivo.Ronda;



/**
 *
 * @author pbarzaghi
 */
public class FileCvs {
    
    private static  HashMap objCreacion;
    public FileCvs(){
      
      if(objCreacion == null)
         objCreacion=new HashMap();
      
    }
    
    /*
      Este metodo lee dado el path del archivo los pronosticos y retorna una lista de pronostico
    cargados desde el archivo
    */
    public List<Pronostico> leerArchivoPronostico(String path){
    
        
       List <Pronostico> listaPronostico=new ArrayList();   
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
          
          Pronostico pronostico=new Pronostico();
          Equipo equipo1= (Equipo)  objCreacion.get(Equipo.class+suscripcion.getNombreEquipo1());
          if(equipo1 == null){
             System.out.println("NO EXISTE EL Equipo "+suscripcion.getNombreEquipo1());
                 // hay que generar la Excepcion  
          }
           
           Partido partido= (Partido)  objCreacion.get(Partido.class+suscripcion.getNombreEquipo1()+"_"+
                                                            suscripcion.getNombreEquipo2());
           if(partido== null)
               partido= (Partido)  objCreacion.get(Partido.class+suscripcion.getNombreEquipo2()+"_"+
                                                            suscripcion.getNombreEquipo1());
           if(partido == null)
               System.out.println("NO EXISTE EL PARTIDO "+suscripcion.getNombreEquipo1()+"_"+
                                                            suscripcion.getNombreEquipo2());
                 // hay que generar la Excepcion  
         
           
             pronostico.setEquipo(equipo1);
             pronostico.setPartido(partido);
             
              if(partido.getEquipo1().getId()== equipo1.getId() ){
                  if( partido.getGolesEquipo1() > partido.getGolesEquipo2())
                     pronostico.setResultado(ResultadoEmun.GANADOR);
                    else  if( partido.getGolesEquipo1() < partido.getGolesEquipo2())
                          pronostico.setResultado(ResultadoEmun.PERDEDOR);
                       else
                           pronostico.setResultado(ResultadoEmun.EMPATE); 
              }else {
                  if( partido.getGolesEquipo1()< partido.getGolesEquipo2())
                     pronostico.setResultado(ResultadoEmun.GANADOR);
                    else  if( partido.getGolesEquipo1() > partido.getGolesEquipo2())
                          pronostico.setResultado(ResultadoEmun.PERDEDOR);
                       else
                           pronostico.setResultado(ResultadoEmun.EMPATE);
                  }  
             
          listaPronostico.add(pronostico);
          System.out.println(suscripcion.getNombreEquipo1() + ";" + suscripcion.getNombreEquipo2() + ";" + 
                  suscripcion.getNombreParticipante()+ ";" + suscripcion.getResultadoGanador1()+ ";" + suscripcion.getResultadoEmpate()+";" + suscripcion.getResultadoGanador2());
           // TODO Aca hay que implementar la logica para cargar la lista de pronostico
          }
     
      } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
      System.out.println(" ----- F I N CARGAR PRONOSTICOS -------");  
     //TODO: Esto no va esta, tiene que retornar la lista de pronostico cargada por arhivos   
     return listaPronostico;   
    }
    
    
    
    /*
      Este metodo debe leer el archivo de resultado y cargarlos
    
    */
    
     public List <Ronda> leerArchivoResultado(String path){
    
      List <ServicioResultado> listaDeSuscripciones;
      List <Ronda> listaRondas =new ArrayList();
        try {
            // En esta primera lÃ­nea definimos el archivos que va a ingresar
            listaDeSuscripciones = new CsvToBeanBuilder(new FileReader(path))
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ServicioResultado.class)
                    .build()
                    .parse();
        
            //El resultado de este mÃ©todo nos da una lita del objetos
      
      int idEquipo=1;
      for ( ServicioResultado suscripcion : listaDeSuscripciones) {
          //  cargar la estruc de ronda partido equipo pers
          
          Equipo equipo1= (Equipo)  objCreacion.get(Equipo.class+suscripcion.getNombreEquipo1().strip());
          if(equipo1 == null){
             equipo1= new Equipo(suscripcion.getNombreEquipo1().strip(), "SELECCIONADO");
             equipo1.setId(idEquipo);
             objCreacion.put(Equipo.class+equipo1.getNombre().strip(), equipo1);
             idEquipo++;
          }
           
           
         
           Equipo equipo2= (Equipo)  objCreacion.get(Equipo.class+suscripcion.getNombreEquipo2().strip());
           if(equipo2 == null){
               equipo2= new Equipo(suscripcion.getNombreEquipo2(), "SELECCIONADO");
              equipo2.setId(idEquipo);
              objCreacion.put(Equipo.class+equipo2.getNombre(), equipo2);

               idEquipo++;
          }
                   
           Partido partido= (Partido)  objCreacion.get(Partido.class+String.valueOf(equipo1.getId())+"_"+String.valueOf(equipo2.getId()) );
           if(partido == null){
               partido =new Partido();
               partido.setEquipo1(equipo1);
               partido.setEquipo2(equipo2);
               partido.setGolesEquipo1(suscripcion.getCantGoles1Equipo1());
               partido.setGolesEquipo2(suscripcion.getCantGoles1Equipo2());
               objCreacion.put(Partido.class+equipo1.getNombre()+"_"+equipo2.getNombre(), partido);
            }
          
           Ronda ronda= (Ronda)  objCreacion.get(Ronda.class+suscripcion.getNroRonda().toString());
            if(ronda == null){
                ronda = new Ronda();
                ronda.setNro(suscripcion.getNroRonda());
                ronda.appendPartido(partido);
                listaRondas.add(ronda);
                 objCreacion.put(Ronda.class+String.valueOf(ronda.getNro()), ronda);
            }
          System.out.println(suscripcion.getNombreEquipo1() + ";" + suscripcion.getCantGoles1Equipo1() + ";" +
                  suscripcion.getNombreEquipo2() + ";" + suscripcion.getCantGoles1Equipo2()+ ";" + suscripcion.getNroRonda());
        
      }
      } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    
        System.out.println(" ----- F I N CARGAR RESULTADOS -------");
      //  Esto return null no va. Tiene que retornar la lista de los resultados de los partido 
      // es decir la ronda 
    return listaRondas;
 
}
     
}
