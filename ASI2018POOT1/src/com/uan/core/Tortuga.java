package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Tortuga extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("La tortuga emite un ronquido");
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
		System.out.println("Tortuguita: Yo soy el más lento de los animales. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " años");
		
	}
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Me escondo en el caparazón para protegerme");
		
	}

}
