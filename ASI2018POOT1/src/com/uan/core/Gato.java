package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Gato extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("El gato maulla");
		
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
		System.out.println("Gatico: Yo soy el más tierno de los animales. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " años");
		
	}
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Araño y muerdo para protegerme");
		
	}

}
