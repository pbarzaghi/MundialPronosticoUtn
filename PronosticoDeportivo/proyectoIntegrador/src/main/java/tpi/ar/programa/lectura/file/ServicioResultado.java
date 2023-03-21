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
public class ServicioResultado {
    
    @CsvBindByPosition(position = 0)
    private Integer nroRonda;
    
    @CsvBindByPosition(position = 1)
    private String nombreEquipo1;
    
    @CsvBindByPosition(position = 2)
    private Integer cantGoles1Equipo1;
    
   @CsvBindByPosition(position = 3)
    private Integer cantGoles1Equipo2;
   
 @CsvBindByPosition(position = 4)
    private String nombreEquipo2;

    /**
     * @return the nroRonda
     */
    public Integer getNroRonda() {
        return nroRonda;
    }

    /**
     * @param nroRonda the nroRonda to set
     */
    public void setNroRonda(Integer nroRonda) {
        this.nroRonda = nroRonda;
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
     * @return the cantGoles1Equipo1
     */
    public Integer getCantGoles1Equipo1() {
        return cantGoles1Equipo1;
    }

    /**
     * @param cantGoles1Equipo1 the cantGoles1Equipo1 to set
     */
    public void setCantGoles1Equipo1(Integer cantGoles1Equipo1) {
        this.cantGoles1Equipo1 = cantGoles1Equipo1;
    }

    /**
     * @return the cantGoles1Equipo2
     */
    public Integer getCantGoles1Equipo2() {
        return cantGoles1Equipo2;
    }

    /**
     * @param cantGoles1Equipo2 the cantGoles1Equipo2 to set
     */
    public void setCantGoles1Equipo2(Integer cantGoles1Equipo2) {
        this.cantGoles1Equipo2 = cantGoles1Equipo2;
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