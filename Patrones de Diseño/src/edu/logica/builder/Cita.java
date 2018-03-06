/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.util.ArrayList;
import java.util.Date;


public class Cita{
    private Date fechaInicial;
    private Date fechaFinal;
    private String descripcion;
    private ArrayList asistentes = new ArrayList();
    private Ubicacion ubicacion;
    public static final String FIN_DE_LINEA ="-";
    
    public Date getFechaInicial(){ return fechaInicial; }
    public Date getFechaFinal(){ return fechaFinal; }
    public String getDescription(){ return descripcion; }
    public ArrayList getAsistentes(){ return asistentes; }
    public Ubicacion getUbicacion(){ return ubicacion; }

    public void setDescripcion(String newDescription){ descripcion = newDescription; }
    public void setUbicacion(Ubicacion newLocation){ ubicacion = newLocation; }
    public void setFechaInicial(Date newStartDate){ fechaInicial = newStartDate; }
    public void setFechaFinal(Date newEndDate){ fechaFinal = newEndDate; }
    public void setAsistentes(ArrayList newAsistentes){
        if (newAsistentes != null){
            asistentes = newAsistentes;
        }
    }
    
    public void addAsistente(Contacto asistente){
        if (!asistentes.contains(asistente)){
            asistentes.add(asistente);
        }
    }
    
    public void removerAsistente(Contacto asistente){
        asistentes.remove(asistente);
    }
    
    public String toString(){
        return "  Descripción: " + descripcion + FIN_DE_LINEA +
            "  Inicio de la Reunión: " + fechaInicial + FIN_DE_LINEA +
            "  Fin de la reunión: " + fechaFinal + FIN_DE_LINEA +
            "  Ubicación: " + ubicacion + FIN_DE_LINEA +
            "  Asistentes: " + asistentes;
    }
}