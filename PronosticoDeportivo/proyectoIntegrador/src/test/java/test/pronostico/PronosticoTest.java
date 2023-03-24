/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.pronostico;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;

/**
 *
 * @author pbarzaghi
 */
public class PronosticoTest {
    
    
       @Test
       public void probarArchivosResultado1Pronostico1(){
          
           String csvResultado = "src\\main\\resources\\resultado1.csv";
            String csvPronostico = "src\\main\\resources\\pronostico1.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(3, ganador.getCantidadPuntos());
            
       
       }
       @Test
       public void probarArchivosResultado1Pronostico2(){
              
           String csvResultado = "src\\main\\resources\\resultado1.csv";
            String csvPronostico = "src\\main\\resources\\pronostico2.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(0, ganador.getCantidadPuntos());
          }
       
       @Test
       public void probarArchivosResultado1Pronostico3(){
              String csvResultado = "src\\main\\resources\\resultado1.csv";
            String csvPronostico = "src\\main\\resources\\pronostico3.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(3, ganador.getCantidadPuntos());
       
       }
       @Test
       public void probarArchivosResultado2Pronostico1(){
            String csvResultado = "src\\main\\resources\\resultado2.csv";
            String csvPronostico = "src\\main\\resources\\pronostico1.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(1, ganador.getCantidadPuntos());
       
       
       }
       @Test
       public void probarArchivosResultado2Pronostico2(){
            String csvResultado = "src\\main\\resources\\resultado2.csv";
            String csvPronostico = "src\\main\\resources\\pronostico2.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(2, ganador.getCantidadPuntos());
       
       }
       
       @Test
       public void probarArchivosResultado2Pronostico3(){
              String csvResultado = "src\\main\\resources\\resultado2.csv";
            String csvPronostico = "src\\main\\resources\\pronostico3.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(1, ganador.getCantidadPuntos());
       
       }
       
       @Test
       public void probarArchivosResultado3Pronostico1(){
            String csvResultado = "src\\main\\resources\\resultado3.csv";
            String csvPronostico = "src\\main\\resources\\pronostico1.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(1, ganador.getCantidadPuntos());
       
       }
       @Test
       public void probarArchivosResultado3Pronostico2(){
        String csvResultado = "src\\main\\resources\\resultado3.csv";
            String csvPronostico = "src\\main\\resources\\pronostico2.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(1, ganador.getCantidadPuntos());
       
       }
       @Test
       public void probarArchivosResultado3Pronostico3(){
        String csvResultado = "src\\main\\resources\\resultado3.csv";
            String csvPronostico = "src\\main\\resources\\pronostico3.csv"; 
            FileCvs file= new FileCvs();
            List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
            GanadorPronostico ganador= new GanadorPronostico();
            System.out.println(ganador.ganadorDelPronostico(listaPronostico));
             Assertions.assertEquals(0, ganador.getCantidadPuntos());
       }  

       
}

