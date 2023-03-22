/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico;

import tpi.ar.programa.enumerado.ResultadoEmun;
import tpi.ar.programa.pronostico.deportivo.Equipo;
import tpi.ar.programa.pronostico.deportivo.Partido;
import tpi.ar.programa.pronostico.participante.Persona;

/**
 *
 * @author pbarzaghi
 */
public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEmun resultado;
    private Persona participante;

    /**
     * @return the partido
     */
    public Partido getPartido() {
        return partido;
    }

    /**
     * @param partido the partido to set
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the resultado
     */
    public ResultadoEmun getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultadoEmun resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the participante
     */
    public Persona getParticipante() {
        return participante;
    }

    /**
     * @param participante the participante to set
     */
    public void setParticipante(Persona participante) {
        this.participante = participante;
    }
    
}
