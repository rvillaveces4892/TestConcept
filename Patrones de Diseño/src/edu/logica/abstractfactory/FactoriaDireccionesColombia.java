/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class FactoriaDireccionesColombia implements FactoriaDirecciones{
    public Direccion crearDireccion(){
        return new DireccionColombia();
    }
    
    public NumeroTelefonico crearNumeroDeTelefono(){
        return new NumeroTelefonicoColombia();
    }
}