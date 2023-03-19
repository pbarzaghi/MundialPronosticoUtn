/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.pronostico.participante;

import tpi.ar.programa.enumerado.TipoDocumento;

/**
 *
 * @author pbarzaghi
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int nroDoc;
    private TipoDocumento tipoDoc;

    
    public Persona(String nombre,String apellido,int nroDoc,TipoDocumento tipo){
      this.nombre=nombre;
      this.apellido=apellido;
      this.nroDoc=nroDoc;
      this.tipoDoc=tipo;
    
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nroDoc
     */
    public int getNroDoc() {
        return nroDoc;
    }

    /**
     * @param nroDoc the nroDoc to set
     */
    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    /**
     * @return the tipoDoc
     */
    public TipoDocumento getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(TipoDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    
    
    
    
}
