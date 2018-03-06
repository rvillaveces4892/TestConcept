/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


public class EjecutarPatron{
    private static Calendar newFecha = Calendar.getInstance();
    
    public static void main(String [] arguments){
        Cita cita = null;
        
		System.out.println("*****************************************************************************");
		System.out.println("*****************************************************************************");
        System.out.println("Ejemplo de implementacion del patron Builder");
        System.out.println();
        System.out.println("Este ejemplo muestra como se realiza la implementacion del patron Builder");
        System.out.println("el patron es utilizado para crear objetos Cita en una aplicacion de Agenda Personal.");
        System.out.println();
        
        System.out.println("Creacion del objeto Agenda para programar las citas.");
        Agenda agenda = new Agenda();
        
        System.out.println();
        
        // Creacion del constructor Generico
        BuilderCitas citaBuilder = new BuilderCitas();
        try{
            System.out.println("Creacion de una nueva cita con el Builder de Citas");
            // Se crea el producto
            cita = agenda.crearCita(
                citaBuilder, fechaCita(2016, 4, 1, 15, 00), fechaCita(2017, 4, 1, 16, 00), "Patrones de Creacion: Builder, AbstracFactory, FactoryMethod, Prototype y Singleton", new UbicacionImpl("Universidad, Curso Modelos"),
                crearAsistentes(4));
            System.out.println("Se creo la Cita satisfactoriamente.");
            System.out.println("Informacion de la cita:");
            System.out.println(cita);
            System.out.println();
        }
        catch (InformacionIncompletaException exc){
            printExceptions(exc);
        }
        
        // Creacion del Builder Concreto
		System.out.println("*****************************************************************************");
		System.out.println("*****************************************************************************");
        System.out.println("Creacion mediante el Builder de Reunion.");
        BuilderReunion reunionBuilder = new BuilderReunion();
        try{
            System.out.println("Creacion de una nueva cita a partir del Builder de Reunion");
            System.out.println("(es importante notar que se puede producir una exception si ");
            System.out.println(" se coloca como obligatoria la fecha de finalizacion en el ");
            System.out.println(" constructor de Reuniones)");
            
            // Se crea el producto
            cita = agenda.crearCita(reunionBuilder, fechaCita(2017, 4, 15, 15, 00),	fechaCita(2017, 4, 15, 17, 00), "Laboratorio de patrones de Creacion", new UbicacionImpl("Udistrital - , Lab 502 ING"),
                crearAsistentes(30));
			System.out.println("*****************************************************************************");
            System.out.println("Se creo la cita correctamente.");
            System.out.println("Informacion de la Cita:");
            System.out.println(cita);
            System.out.println();
        }
        catch (InformacionIncompletaException exc){
            printExceptions(exc);
        }
        
		
    }
    
    public static Date fechaCita(int anio, int mes, int dia, int hora, int minuto){
        newFecha.set(anio, mes, dia, hora, minuto);
        return newFecha.getTime();
    }
    
    public static ArrayList crearAsistentes(int numeroACrear){
        ArrayList group = new ArrayList();
        for (int i = 0; i < numeroACrear; i++){
            group.add(new ContactoImpl("John", getApellido(i), "Profesor del grupo", "Universidad Distrital"));
        }
        return group;
    }
    
    public static String getApellido(int index){
        String nombre = "";    
        switch (index % 6){
            case 0: nombre = "Velasquez";
                break;
            case 1: nombre = "Perez";
                break;
            case 2: nombre = "Gomez";
                break;
            case 3: nombre = "Fernandez";
                break;
            case 4: nombre = "Ortiz";
                break;
            case 5: nombre = "Martinez";
                break;
        }
        return nombre;
    }
    
    public static void printExceptions(InformacionIncompletaException exc){
        int codigoDeEstado = exc.getInformacionRequerida();
        
        System.out.println("Imposible crear una cita: Se requiere informacion adicional");
        if ((codigoDeEstado & InformacionIncompletaException.FECHA_INICIAL_REQUERIDA) > 0){
            System.out.println("  Una fecha de inicio es requerida para registrar una Cita.");
        }
        if ((codigoDeEstado & InformacionIncompletaException.FECHA_FINAL_REQUERIDA) > 0){
            System.out.println("  Una fecha-hora de finalizacion es requerida para registrar la cita.");
        }
        if ((codigoDeEstado & InformacionIncompletaException.DESCRIPCION_REQUERIDA) > 0){
            System.out.println("  Una descripcion de Cita es requerida para completar el registro de la Cita.");
        }
        if ((codigoDeEstado & InformacionIncompletaException.ASISTENTE_REQUERIDO) > 0){
            System.out.println("  Por lo menos un asistente es requerido para completar esta Cita.");
        }
        if ((codigoDeEstado & InformacionIncompletaException.UBICACION_REQUERIDA) > 0){
            System.out.println("  Una Ubicacion o lugar es requerido para completar la Cita.");
        }
        System.out.println();
    }
}