/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class NumeroTelefonicoVenezuela extends NumeroTelefonico{
    private static final String CODIGO_PAIS = "01";
    private static final int LONGITUD_NUMERO = 10;
    
    public String getCodigoPais(){ return CODIGO_PAIS; }
    
    public void setNumeroTelefonico(String newNumero){
        if (newNumero.length() == LONGITUD_NUMERO){
            super.setNumeroTelefonico(newNumero);
        }
    }
}