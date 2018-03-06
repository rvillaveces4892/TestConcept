/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.util.Date;
import java.util.ArrayList;

public class BuilderCitas{
    
    public static final int FECHA_INICIAL_REQUERIDA = 1;
    public static final int FECHA_FINAL_REQUERIDA = 2;
    public static final int DESCRIPCION_REQUERIDA = 4;
    public static final int ASISTENTE_REQUERIDO = 8;
    public static final int UBICACION_REQUERIDA = 16;
    
    protected Cita cita;
    
    protected int elementosRequeridos;
    
    public void construirCita(){
        cita = new Cita();
    }
    
    public void crearFecha(Date fechaInicial, Date fechaFinal){
        Date currentDate = new Date();
        if ((fechaInicial != null) && (fechaInicial.after(currentDate))){
            cita.setFechaInicial(fechaInicial);
        }
        if ((fechaFinal != null) && (fechaFinal.after(fechaInicial))){
            cita.setFechaFinal(fechaFinal);
        }
    }
    
    public void crearDescripcion(String newDescripcion){
        cita.setDescripcion(newDescripcion);
    }
    
    public void crearAsistentes(ArrayList asistentes){
        if ((asistentes != null) && (!asistentes.isEmpty())){
            cita.setAsistentes(asistentes);
        }
    }
    
    public void crearUbicacion(Ubicacion newUbicacion){
        if (newUbicacion != null){
            cita.setUbicacion(newUbicacion);
        }
    }
    
    public Cita getCita() throws InformacionIncompletaException{
        elementosRequeridos = 0;
        
        if (cita.getFechaInicial() == null){
            elementosRequeridos += FECHA_INICIAL_REQUERIDA;
        }
        
        if (cita.getUbicacion() == null){
            elementosRequeridos += UBICACION_REQUERIDA;
        }
        
        if (cita.getAsistentes().isEmpty()){
            elementosRequeridos += ASISTENTE_REQUERIDO;
        }
        
        if (elementosRequeridos > 0){
            throw new InformacionIncompletaException(elementosRequeridos);
        }
        return cita;
    }
    
    public int getElementosRequeridos(){ return elementosRequeridos; }
}