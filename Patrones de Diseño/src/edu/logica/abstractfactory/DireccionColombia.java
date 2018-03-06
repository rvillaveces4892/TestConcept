/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class DireccionColombia extends Direccion{
    private static final String PAIS = "COLOMBIA";
    
    public String getPais(){ return PAIS; }
    
    public String getDireccionCompleta(){
        return getCalle() + FIN_CADENA +
            getCOdigoPostal() + ESPACIO_BLANCO + getCiudad() +
            FIN_CADENA + PAIS + FIN_CADENA;
    }
}