package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Ave extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("El ave canta arm�nicamente");
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
		System.out.println("Ave: Yo soy el due�o de los cielos. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " a�os");
		
	}

	@Override
	public void mecanismoDefensa() {
		System.out.println("Picoteo para protegerme");
		
	}

}
