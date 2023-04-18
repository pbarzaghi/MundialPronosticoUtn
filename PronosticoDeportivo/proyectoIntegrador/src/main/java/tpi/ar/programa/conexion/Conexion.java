/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpi.ar.programa.conexion;

import tpi.ar.programa.exception.FileIntegradorException;

/**
 *
 * @author pbarzaghi
 */
public interface Conexion {
    public void setConection(Object obj);
    public Object abrirConexion() throws FileIntegradorException;
    public void  cerrarConexion() throws FileIntegradorException;
    
    
}
