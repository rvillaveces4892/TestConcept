/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public abstract class Direccion{
    private String calle;
    private String ciudad;
    private String region;
    private String codigopostal;
    
    public static final String FIN_CADENA ="-";
       
    public static final String ESPACIO_BLANCO = " ";
    
    public String getCalle(){ return calle; }
    public String getCiudad(){ return ciudad; }
    public String getCOdigoPostal(){ return codigopostal; }
    public String getRegion(){ return region; }
    public abstract String getPais();
    
    public String getDireccionCompleta(){
        return calle + FIN_CADENA +
            ciudad + ESPACIO_BLANCO + codigopostal + FIN_CADENA;
    }
    
    public void setCalle(String newCalle){ calle = newCalle; }
    public void setCiudad(String newCiudad){ ciudad = newCiudad; }
    public void setRegion(String newRegion){ region = newRegion; }
    public void setCodigoPostal(String newCodigoPostal){ codigopostal = newCodigoPostal; }
}