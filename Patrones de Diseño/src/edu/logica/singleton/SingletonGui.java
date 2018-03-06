/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.singleton;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SingletonGui implements ActionListener{
    private JFrame mainFrame;
    private JTextArea display;
    private JButton newContacto, newCita, undo, actualizar, salir;
    private JPanel controlPanel, displayPanel;
    private static int contadorHistorico;
    
    public void crearGui(){
        mainFrame = new JFrame("Ejemplo de aplicación del Patron Singleton");
        Container contenedor = mainFrame.getContentPane();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));
        
        displayPanel = new JPanel();
        display = new JTextArea(20, 60);
        display.setEditable(false);
        displayPanel.add(display);
        contenedor.add(displayPanel);
        
        controlPanel = new JPanel();
        newContacto = new JButton("Crear Contacto");
        newCita = new JButton("Crear Cita");
        undo = new JButton("Deshacer");
        actualizar = new JButton("Actualizar");
        salir = new JButton("Salir");
        controlPanel.add(newContacto);
        controlPanel.add(newCita);
        controlPanel.add(undo);
        controlPanel.add(actualizar);
        controlPanel.add(salir);
        contenedor.add(controlPanel);
        
        newContacto.addActionListener(this);
        newCita.addActionListener(this);
        undo.addActionListener(this);
        actualizar.addActionListener(this);
        salir.addActionListener(this);
        
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public void actualizarDisplay(String accion){
        display.setText(accion + "\nComando enviado:\n" +
            ListaHistorial.getInstancia().toString());
    }
    
    public void actionPerformed(ActionEvent evt){
        Object origen = evt.getSource();
        if (origen == newContacto){
            addComando(" Nuevo Contacto");
        }
        else if (origen == newCita){
            addComando(" Nueva Cita");
        }
        else if (origen == undo){
            deshacer();
        }
        else if (origen == actualizar){
            actualizarDisplay("");
        }
        else if (origen == salir){
            exitApplication();
        }
    }
    
    private class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent evt){
            exitApplication();
        }
    }
    
    private void addComando(String mensaje){
        ListaHistorial.getInstancia().addComando((++contadorHistorico) + mensaje);
        actualizarDisplay("Adicionar acción: " + mensaje);
    }
    
    private void deshacer(){
        Object resultado = ListaHistorial.getInstancia().undoCommand();
        contadorHistorico--;
        actualizarDisplay("Deshacer acción: " + resultado);
    }
    
    private void exitApplication(){
        System.exit(0);
    }
}