package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Trucha extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("La trucha no emite sonidos");
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
		System.out.println("Trucha: Yo soy un pez de agua dulce. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " años");
		
	}
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Soy un animal indefenso");
		
	}

}
