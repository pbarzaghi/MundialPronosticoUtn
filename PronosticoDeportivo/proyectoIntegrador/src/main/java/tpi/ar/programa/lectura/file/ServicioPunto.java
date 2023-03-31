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
public class ServicioPunto {
     @CsvBindByPosition(position = 0)
      private Integer ptosGanar;
      
      @CsvBindByPosition(position = 1)
      private Integer ptosEmpatar;
      
      @CsvBindByPosition(position = 2)
      private Integer ptosPerder;
    
      @CsvBindByPosition(position = 3)
      private Integer ptosPartido;
      
      @CsvBindByPosition(position = 4)
      private Integer ptosRonda;
      
      @CsvBindByPosition(position = 5)
      private Integer ptosFase;

    /**
     * @return the ptosGanar
     */
    public Integer getPtosGanar() {
        return ptosGanar;
    }

    /**
     * @param ptosGanar the ptosGanar to set
     */
    public void setPtosGanar(Integer ptosGanar) {
        this.ptosGanar = ptosGanar;
    }

    /**
     * @return the ptosEmpatar
     */
    public Integer getPtosEmpatar() {
        return ptosEmpatar;
    }

    /**
     * @param ptosEmpatar the ptosEmpatar to set
     */
    public void setPtosEmpatar(Integer ptosEmpatar) {
        this.ptosEmpatar = ptosEmpatar;
    }

    /**
     * @return the ptosPerder
     */
    public Integer getPtosPerder() {
        return ptosPerder;
    }

    /**
     * @param ptosPerder the ptosPerder to set
     */
    public void setPtosPerder(Integer ptosPerder) {
        this.ptosPerder = ptosPerder;
    }

    /**
     * @return the ptosPartido
     */
    public Integer getPtosPartido() {
        return ptosPartido;
    }

    /**
     * @param ptosPartido the ptosPartido to set
     */
    public void setPtosPartido(Integer ptosPartido) {
        this.ptosPartido = ptosPartido;
    }

    /**
     * @return the ptosRonda
     */
    public Integer getPtosRonda() {
        return ptosRonda;
    }

    /**
     * @param ptosRonda the ptosRonda to set
     */
    public void setPtosRonda(Integer ptosRonda) {
        this.ptosRonda = ptosRonda;
    }

    /**
     * @return the ptosFase
     */
    public Integer getPtosFase() {
        return ptosFase;
    }

    /**
     * @param ptosFase the ptosFase to set
     */
    public void setPtosFase(Integer ptosFase) {
        this.ptosFase = ptosFase;
    }

  
}
