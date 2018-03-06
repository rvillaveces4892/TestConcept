/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.abstractfactory;

public class EjecutarPatron{
    public static void main(String [] arguments){
        System.out.println("Ejemplo del patron Abstract Factory");
        System.out.println();
        System.out.println(" (Cree el diagrama de clases para el patron. Este framework");
        System.out.println("  le permite anexar en forma dinamica nuevas factorias");
        System.out.println("  que representen a otros paises. La forma seria parecida a");
        System.out.println("  conectar y listo. En este caso se conectarian las nuevas factorias");
        System.out.println("  y los nuevos Productos representados por el pais concreto)");
        System.out.println();
        
        System.out.println("Creadndo una direccion en Venezuela:");
        FactoriaDirecciones venFactoriaDireccion = new FactoriaDireccionVenezuela();
        Direccion venDireccion = venFactoriaDireccion.crearDireccion();
        NumeroTelefonico venTelefono = venFactoriaDireccion.crearNumeroDeTelefono();
        
        venDireccion.setCalle("123");
        venDireccion.setCiudad("Caracas");
        venDireccion.setRegion("CA");
        venDireccion.setCodigoPostal("54321");
        venTelefono.setNumeroTelefonico("7039214722");
        
        System.out.println("Direccion en Venezuela:");
        System.out.println(venDireccion.getDireccionCompleta());
        System.out.println("Telefono en Venezuela:");
        System.out.println(venTelefono.getNumeroTelefonico());
        System.out.println();
        System.out.println();
        
        System.out.println("Creando direccion y telefono en Colombia:");
        FactoriaDirecciones colFactoriaDireccion = new FactoriaDireccionesColombia();
        Direccion colombia_Direccion = colFactoriaDireccion.crearDireccion();
        NumeroTelefonico colombia_Telefono = colFactoriaDireccion.crearNumeroDeTelefono();
        
        colombia_Direccion.setCalle("Cra 8 Nro. 40-52");
        colombia_Direccion.setCiudad("Bogota");
        colombia_Direccion.setCodigoPostal("5712258");
        colombia_Telefono.setNumeroTelefonico("3239300");
        
        System.out.println("Direccion en Colombia:");
        System.out.println(colombia_Direccion.getDireccionCompleta());
        System.out.println("Numero de Telefono en Colombia:");
        System.out.println(colombia_Telefono.getNumeroTelefonico());
        
        System.out.println();
        System.out.println();
        
        System.out.println("Creando direccion y telefono en Perú:");
        FactoriaDirecciones peruFactoriaDireccion = new FactoriaDireccionesPeru();
        Direccion peru_Direccion = peruFactoriaDireccion.crearDireccion();
        NumeroTelefonico peru_Telefono = peruFactoriaDireccion.crearNumeroDeTelefono();
        
        peru_Direccion.setCalle("Cra 17 Nro. 97-03");
        peru_Direccion.setCiudad("Lima");
        peru_Direccion.setCodigoPostal("151");
        peru_Telefono.setNumeroTelefonico("7853492");
        
        System.out.println("Direccion en Perú:");
        System.out.println(peru_Direccion.getDireccionCompleta());
        System.out.println("Numero de Telefono en Perú:");
        System.out.println(peru_Telefono.getNumeroTelefonico());        
    }
}