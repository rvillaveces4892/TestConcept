/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

public class InformacionIncompletaException extends Exception{
    private static final String MENSAJE = "La Cita no fue creada porque no suministro la informacion requerida";
 
// Constantes de lanzamiento de excepciones

    public static final int FECHA_INICIAL_REQUERIDA = 1;
    public static final int FECHA_FINAL_REQUERIDA = 2;
    public static final int DESCRIPCION_REQUERIDA = 4;
    public static final int ASISTENTE_REQUERIDO = 8;
    public static final int UBICACION_REQUERIDA = 16;
    private int informacionRequerida;
    
    public InformacionIncompletaException(int elementosRequeridos){
        super(MENSAJE);
        informacionRequerida = elementosRequeridos;
    }
    
    public int getInformacionRequerida(){ return informacionRequerida; }
}