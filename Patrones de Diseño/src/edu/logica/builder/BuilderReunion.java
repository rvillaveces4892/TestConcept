/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

public class BuilderReunion extends BuilderCitas{
    public Cita getCita() throws InformacionIncompletaException{
        try{
            super.getCita();
        }
        finally{
            if (cita.getFechaFinal() == null){
                elementosRequeridos += FECHA_FINAL_REQUERIDA;
            }
            
            if (elementosRequeridos > 0){
                throw new InformacionIncompletaException(elementosRequeridos);
            }
        }
        return cita;
    }
}