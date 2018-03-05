package com.uan.core;

import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Sapo extends Animal {

	@Override
	public void comunicarse() {
		System.out.println("El sapo croe");
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
		System.out.println("Sapo: Yo soy el anfibio más saltarín. Me llamo "+getNombre() +" y tengo "+ getEdad()+ " años");
		
	}
	
	@Override
	public void mecanismoDefensa() {
		System.out.println("Segrego veneno por mi piel para protegerme");
		
	}
	
	// Procedimientos especializados
	public void cambiarHabitat() {
		System.out.println("Habitat: Puedo pasar del ambiente acuático al terreste sin problemas");
	}
	
	
	public void comerMoscas() {
		System.out.println("Me gusta comer moscas");
	}
	
	
	

}
