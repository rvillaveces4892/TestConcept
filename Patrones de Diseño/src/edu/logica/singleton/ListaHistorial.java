/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ListaHistorial{
    private List historial = Collections.synchronizedList(new ArrayList());
    private static ListaHistorial instancia = new ListaHistorial();
    
    private ListaHistorial(){ }
    
    public static ListaHistorial getInstancia(){
        return instancia;
    }
    
    public void addComando(String comando){
        historial.add(comando);
        Log log = Log.getInstancia();
        log.mensajeInformativo("Adicionando comando...");
    }
    
    public Object undoCommand(){
    	Log log = Log.getInstancia();
        log.mensajeInformativo("Desahaciendo comando...");
        return historial.remove(historial.size() - 1);
    }
    
    public String toString(){
    	Log log = Log.getInstancia();
        log.mensajeInformativo("Imprimiendo comandos...");
        StringBuffer resultado = new StringBuffer();
        for (int i = 0; i < historial.size(); i++){
            resultado.append("  ");
            resultado.append(historial.get(i));
            resultado.append("\n");
        }
        return resultado.toString();
    }
}