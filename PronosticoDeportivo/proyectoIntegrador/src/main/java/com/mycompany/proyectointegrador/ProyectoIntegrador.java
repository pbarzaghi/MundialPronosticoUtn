/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.util.List;
import javax.swing.JOptionPane;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.Pronostico;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
        String csvResultado = "src\\main\\resources\\resultado";
        String csvPronostico = "src\\main\\resources\\pronostico"; 
        String extension=".csv";
       
        
   
        boolean salida=true;
        String strNrofileResultado;
        do{
         strNrofileResultado=elegirNroDeNombreDeArchivo("RESULTADO");
            switch(strNrofileResultado) {
                case  "1" , "2" , "3":
                    csvResultado = csvResultado + strNrofileResultado + extension;
                    salida=false;
                    break;
                     
                default:
                     strNrofileResultado= elegirNroDeNombreDeArchivo("RESULTADO");
        
            }
        
        }while(salida);
        
        
                
         salida=true;
         String strNrofilePronostico;
        do{
            strNrofilePronostico= elegirNroDeNombreDeArchivo("PRONOSTICO");
             
           switch(strNrofileResultado) {
                case  "1" , "2" , "3":
                      csvPronostico =csvPronostico + strNrofilePronostico + extension;; 
                     salida=false;
                    break;   
                default:
                       strNrofilePronostico= elegirNroDeNombreDeArchivo("PRONOSTICO");
             
            }
              }while(salida);   
     
    
       FileCvs file= new FileCvs();
    
      List<Pronostico> listaPronostico= file.leerArchivoPronostico(csvResultado,csvPronostico);
   
      // Invocar los metodos para obtebner los resulados una ves cargados los objetos
    GanadorPronostico ganador= new GanadorPronostico();
    String participanteGanadora=ganador.ganadorDelPronostico(listaPronostico);
   

   // imprimo por consola y tambien por pantalla
    System.out.println(participanteGanadora);
    JOptionPane.showMessageDialog(null, participanteGanadora);
    
      
    }
    
  
    
   private static String elegirNroDeNombreDeArchivo(String nameFile){
   
   
     String strNrofile= JOptionPane.showInputDialog(null,"Elija el N° de archivo: 1 - 2 - 3"," ARCHIVO "+nameFile+" A LEER ",3);
         
     return strNrofile;
   } 
    
    
    
}
