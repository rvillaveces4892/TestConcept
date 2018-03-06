/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.prototype;

public class EjecutarPatron{
    public static void main(String [] arguments){
        System.out.println("Ejemplo del patron Prototype");
        System.out.println();
        System.out.println("Este ejemplo crea un objeto Direccion,");
        System.out.println(" el cual puede ser duplicado llamando el metodo clonar del mismo objeto");
        System.out.println(" ...Esta es una caracteristica fundamental en la programacion OO.");
        System.out.println();
        
        System.out.println("Creando la primera direccion.");
        Direccion direccion1 = new Direccion("Cra 8 Nro 40-53", "Teusaquillo", "BOGOTA", "5711515");
        System.out.println("La primera direccion ha sido creada.");
        System.out.println("    Codigo Hash = " + direccion1.hashCode());
        System.out.println(direccion1);
        System.out.println();
        
        System.out.println("creando segundo direccion usando el metodo clonar");
        Direccion direccion2 = (Direccion)direccion1.copiar();
        System.out.println("La segunda direccion ha sido creada a partir del original.");
        System.out.println("    Codigo Hash = " + direccion2.hashCode());
        System.out.println(direccion2);
        System.out.println();
        
        System.out.println("Creando el primér teléfono.");
        Telefono telefono1 = new Telefono("oficina","1224","3070707");
        System.out.println("El primér teléfono ha sido creado.");
        System.out.println("    Codigo Hash = " + telefono1.hashCode());
        System.out.println(telefono1);
        System.out.println();
        
        System.out.println("creando segundo teléfono usando el metodo copiar");
        Telefono telefono2 = (Telefono)telefono1.copiar();
        System.out.println("El segundo teléfono ha sido creada a partir del original.");
        System.out.println("    Codigo Hash = " + telefono2.hashCode());
        System.out.println(telefono2);
        System.out.println();        

    }
}