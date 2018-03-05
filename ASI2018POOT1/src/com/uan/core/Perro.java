package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Perro extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("El perro ladra fuerte");
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
		System.out.println("Perrito: Yo soy el mejor amigo de los humanos. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " años");
		
	}
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Muerdo para protegerme");
		
	}

}
