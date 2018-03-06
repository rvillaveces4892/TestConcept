/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class DireccionVenezuela extends Direccion{
    private static final String PAIS = "VENEZUELA";
    private static final String SEPARADOR_COMA = ",";
    
    public String getPais(){ return PAIS; }
    
    public String getDireccionCompleta(){
        return getCalle() + FIN_CADENA +
            getCiudad() + SEPARADOR_COMA + ESPACIO_BLANCO + getRegion() +
            ESPACIO_BLANCO + getCOdigoPostal() + FIN_CADENA +
            PAIS + FIN_CADENA;
    }
}