/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class FactoriaDireccionVenezuela implements FactoriaDirecciones{
    public Direccion crearDireccion(){
        return new DireccionVenezuela();
    }
    
    public NumeroTelefonico crearNumeroDeTelefono(){
        return new NumeroTelefonicoVenezuela();
    }
}