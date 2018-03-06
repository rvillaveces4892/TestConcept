/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

public class ContactoImpl implements Contacto{
	
    public static final String SPACE = " ";
    private String nombres;
    private String apellidos;
    private String saludo;  // Sr, Sra, Srta, etc...
    private String empresa;
    
    public ContactoImpl(String newNombre, String newApellido,
        String newSaludo, String newEmpresa){
            nombres = newNombre;
            apellidos = newApellido;
            saludo = newSaludo;
            empresa = newEmpresa;
    }
    
    public String getNombre(){ return nombres; }
    public String getApellido(){ return apellidos; }
    public String getSaludo(){ return saludo; }
    public String getEmpresa(){ return empresa; }
    
    public void setNombre(String newNombre){ nombres = newNombre; }
    public void setApellido(String newApellido){ apellidos = newApellido; }
    public void setSaludo(String newSaludo){ saludo = newSaludo; }
    public void setEmpresa(String newEmpresa){ empresa = newEmpresa; }
    
    public String toString(){
        return nombres + SPACE + apellidos;
    }
}