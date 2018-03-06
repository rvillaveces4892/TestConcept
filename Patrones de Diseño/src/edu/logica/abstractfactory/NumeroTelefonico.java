/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public abstract class NumeroTelefonico{
    private String numeroTelefonico;
    public abstract String getCodigoPais();
    
    public String getNumeroTelefonico(){ return numeroTelefonico; }
    
    public void setNumeroTelefonico(String newNumero){
        try{
            Long.parseLong(newNumero);
            numeroTelefonico = newNumero;
        }
        catch (NumberFormatException exc){
        }
    }
}