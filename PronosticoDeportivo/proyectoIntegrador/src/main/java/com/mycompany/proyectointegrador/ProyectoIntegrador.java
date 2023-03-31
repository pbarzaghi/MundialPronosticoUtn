/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.lectura.file.FileCvs;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.participante.Participante;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
        try {
            String csvResultado = "src\\main\\resources\\resultado";
            String csvPronostico = "src\\main\\resources\\pronostico";
            String extension=".csv";
            boolean salida=true;
            String csvPuntos = "src\\main\\resources\\puntos"+extension;
            String strNrofileResultado;
            do{
                strNrofileResultado=elegirNroDeNombreDeArchivo("RESULTADO");
                switch(strNrofileResultado) {
                    case  "1" , "2" , "3":
                        csvResultado = csvResultado +
                                strNrofileResultado
                                
                                + extension;
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
                        csvPronostico =csvPronostico +
                                strNrofilePronostico
                                + extension;;
                                salida=false;
                                break;
                    default:
                        strNrofilePronostico= elegirNroDeNombreDeArchivo("PRONOSTICO");
                        
                }
            }while(salida);
            
            
            FileCvs file= new FileCvs();
        
            
           
            List<Participante> listaParticipante= file.leerArchivoPronostico(csvPuntos,csvResultado,csvPronostico);
            // Invocar los metodos para obtebner los resulados una ves cargados los objetos
            GanadorPronostico ganador= new GanadorPronostico();
           
         //  Esta es mi logica, uds traten de implementar la suya para etapa 2
         /*   String cadenaSalida="";
            for (Participante participante : listaParticipante) {
                cadenaSalida+= ganador.puntajeParticipantePronostico(participante) +
                        "\n";
                System.out.println(ganador.puntajeParticipantePronostico(participante));
            }
            JOptionPane.showMessageDialog(null,cadenaSalida);
          */
        } catch (FileIntegradorException ex) {
                System.out.println( ex.toString()  );
        
        } catch (NullPointerException e){
             System.out.println( "El sistema cerro de forma Abrupta" +e.getMessage() );
        
        }catch (HeadlessException e){
         System.out.println( "El sistema sufrio un error inesperado"  );
        }
    
      
    }
    
  
    
   private static String elegirNroDeNombreDeArchivo(String nameFile){
   
   
     String strNrofile= JOptionPane.showInputDialog(null,"Elija el N° de archivo: 1 - 2 - 3"," ARCHIVO "+nameFile+" A LEER ",3);
         
     return strNrofile;
   } 
    
    
    
}
