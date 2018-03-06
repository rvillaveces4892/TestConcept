/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.io.Serializable;
public interface Ubicacion extends Serializable{
    public String getUbicacion();
    public void setUbicacion(String newUbicacion);
}