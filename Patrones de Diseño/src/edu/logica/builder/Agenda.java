/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.util.Date;
import java.util.ArrayList;
public class Agenda{
	
    public Cita crearCita(BuilderCitas builder,
        Date fechaInicial, Date fechaFinal, String descripcion,
        Ubicacion ubicacion, ArrayList asistentes) throws InformacionIncompletaException{
            if (builder == null){
                builder = new BuilderCitas();
            }
        builder.construirCita();
        builder.crearFecha(fechaInicial, fechaFinal);
        builder.crearDescripcion(descripcion);
        builder.crearAsistentes(asistentes);
        builder.crearUbicacion(ubicacion);
        return builder.getCita();
    }
}