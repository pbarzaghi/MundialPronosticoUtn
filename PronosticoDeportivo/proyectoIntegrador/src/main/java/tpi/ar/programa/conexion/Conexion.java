/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpi.ar.programa.conexion;

/**
 *
 * @author pbarzaghi
 */
public interface Conexion {
    
    public Object abrirConexion(Object path) throws Exception;
     public void  cerrarConexion(Object path) throws Exception;;
    
    
}
