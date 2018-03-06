/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.builder;

import java.io.Serializable;
public interface Contacto extends Serializable{
  
    public String getNombre();
    public String getApellido();
    public String getSaludo();
    public String getEmpresa();
    
    public void setNombre(String newFirstName);
    public void setApellido(String newLastName);
    public void setSaludo(String newTitle);
    public void setEmpresa(String newOrganization);
}