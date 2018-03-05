package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Pulpo extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("El pulpo grita");
	}

	@Override
	public String tipoAlimentacion(Alimentacion alimentacion) {
		return "Soy un animal "+ alimentacion.getTipoAlimentacion();
	}

	@Override
	public String tipoestructura(Estructura estructura) {
		return "Soy "+ estructura.getTipoEstructura();
	}

	@Override
	public void tipoAnimal() {
		System.out.println("Pulpo: Yo soy el animal que m�s tent�culos tiene. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " a�os");
		
	}
	
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Escupo tinta para protegerme");
		
	}

}
