/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.singleton;

public class EjecutarPatron{
    public static void main(String [] arguments){
        System.out.println("Ejemplo de Aplicacion del patron Singleton");
        System.out.println();
        System.out.println("Este ejemplo demuestra el uso del patron GoF");
        System.out.println(" Singleton, se crean dos editores GUI");
        System.out.println(" los cuales referencian a la misma lista de Eventos");

        
        System.out.println("Creando el primer Editor GUI");
        System.out.println();
        SingletonGui editor1 = new SingletonGui();
        editor1.crearGui();
        
        System.out.println("Creando el segundo editor GUI");
        System.out.println();
        SingletonGui editor2 = new SingletonGui();
        editor2.crearGui();
    }
}