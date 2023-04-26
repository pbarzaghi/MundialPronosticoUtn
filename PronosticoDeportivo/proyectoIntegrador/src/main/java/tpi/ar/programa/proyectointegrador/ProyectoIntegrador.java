/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tpi.ar.programa.proyectointegrador;

import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.services.ServicesParticipante;
import tpi.ar.programa.model.ParticipanteModel;
import tpi.ar.programa.entidades.Participante;
import tpi.ar.programa.util.ClaseUtil;


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
     
          ServicesParticipante servicesParticipante = new ServicesParticipante();
        
          ParticipanteModel participanteGanador= new ParticipanteModel();
          ClaseUtil.inizializar();
        
          for (Participante participante : servicesParticipante.getListaParticipante()) {
                System.out.println(participanteGanador.puntajeTotalDelParticipante(participante));   
            }
        
           ClaseUtil.cleanTabla();
    }  
    
  
    
    
}