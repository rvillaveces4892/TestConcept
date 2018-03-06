package edu.logica.singleton;

public class Log {
	
	private static Log instancia = new Log();
	
	private Log(){
		System.out.println("Log iniciado...");
	}
	
	public static Log getInstancia(){
		return instancia;
	}
	
	public void mensajeInformativo(String mensaje){
		System.out.print("INFO: ");
		System.out.println(mensaje);
	}
	
	public void mensajeAdvertencia(String mensaje){
		System.out.print("WARN: ");
		System.out.println(mensaje);
	}
	
	public void mensajeError(String mensaje){
		System.out.print("ERROR: ");
		System.out.println(mensaje);
	}	
	
}
