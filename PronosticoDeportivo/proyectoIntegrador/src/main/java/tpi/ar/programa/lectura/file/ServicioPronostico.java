/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.lectura.file;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author pbarzaghi
 */
public class ServicioPronostico {
      @CsvBindByPosition(position = 0)
      private String nombreParticipante;
      
      @CsvBindByPosition(position = 1)
      private String nombreEquipo1;
       
      @CsvBindByPosition(position = 2)
      private String resultadoGanador1;
      
      @CsvBindByPosition(position = 3)
       private String resultadoEmpate;
    
      @CsvBindByPosition(position = 4)
      private String resultadoGanador2;
    
      @CsvBindByPosition(position = 5)
      private String nombreEquipo2;

    /**
     * @return the nombreParticipante
     */
    public String getNombreParticipante() {
        return nombreParticipante;
    }

    /**
     * @param nombreParticipante the nombreParticipante to set
     */
    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    /**
     * @return the nombreEquipo1
     */
    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    /**
     * @param nombreEquipo1 the nombreEquipo1 to set
     */
    public void setNombreEquipo1(String nombreEquipo1) {
        this.nombreEquipo1 = nombreEquipo1;
    }

    /**
     * @return the resultadoGanador1
     */
    public String getResultadoGanador1() {
        return resultadoGanador1;
    }

    /**
     * @param resultadoGanador1 the resultadoGanador1 to set
     */
    public void setResultadoGanador1(String resultadoGanador1) {
        this.resultadoGanador1 = resultadoGanador1;
    }

    /**
     * @return the resultadoEmpate
     */
    public String getResultadoEmpate() {
        return resultadoEmpate;
    }

    /**
     * @param resultadoEmpate the resultadoEmpate to set
     */
    public void setResultadoEmpate(String resultadoEmpate) {
        this.resultadoEmpate = resultadoEmpate;
    }

    /**
     * @return the resultadoGanador2
     */
    public String getResultadoGanador2() {
        return resultadoGanador2;
    }

    /**
     * @param resultadoGanador2 the resultadoGanador2 to set
     */
    public void setResultadoGanador2(String resultadoGanador2) {
        this.resultadoGanador2 = resultadoGanador2;
    }

    /**
     * @return the nombreEquipo2
     */
    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    /**
     * @param nombreEquipo2 the nombreEquipo2 to set
     */
    public void setNombreEquipo2(String nombreEquipo2) {
        this.nombreEquipo2 = nombreEquipo2;
    }
    
    
}
