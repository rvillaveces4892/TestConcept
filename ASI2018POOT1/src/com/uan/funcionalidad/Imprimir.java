package com.uan.funcionalidad;

import com.uan.core.Animal;
import com.uan.core.Gato;
import com.uan.core.Sapo;
import com.uan.core.Tortuga;
import com.uan.workshop.Alimentacion;
import com.uan.workshop.Estructura;

public class Imprimir {
	
	/**
	 * Procedimiento para crear un objeto de tipo Alimentación
	 * @param alimentacion: parámetro de asignación del tipo de alimento.
	 * @return objeto de tipo Alimentacion
	 */
	public static Alimentacion crearAlimentacion(String alimentacion) {
		Alimentacion objAlimentacion = new Alimentacion(alimentacion);
		return objAlimentacion;
	}
	
	/**
	 * Procedimiento para crear un objeto de tipo Estructura
	 * @param estructura: parámetro de asignación del tipo de estructura
	 * @return objeto de tipo Estructura
	 */
	public static Estructura crearEstrutura(String estructura) {
		Estructura objEstructura = new Estructura(estructura);
		return objEstructura;
	}

	
	
	public static void main(String[] args) {
		
		Animal gatico = new Gato();
		gatico.setNombre("Matias");
		gatico.setEdad(2);
		String verAlimentacion = gatico.tipoAlimentacion(crearAlimentacion("Carnívoro"));
		String verEstructura = gatico.tipoestructura(crearEstrutura("Vertebrado"));
		gatico.comunicarse();
		gatico.tipoAnimal();
		gatico.mecanismoDefensa();
		System.out.println(verAlimentacion+"\n"+ verEstructura);
		System.out.println();
		
		
		Animal tortuguita = new Tortuga();
		tortuguita.setNombre("Lentejita");
		tortuguita.setEdad(4);
		String verAlimentacionTortuga = tortuguita.tipoAlimentacion(crearAlimentacion("Herbívoro"));
		String verEstructuraTortuga = tortuguita.tipoestructura(crearEstrutura("Vertebrado"));
		tortuguita.comunicarse();
		tortuguita.tipoAnimal();
		tortuguita.mecanismoDefensa();
		System.out.println(verAlimentacionTortuga+"\n"+ verEstructuraTortuga);
		System.out.println();
		
		
		//Utilizando métodos especializados de la clase SAPO
		Animal sapito = new Sapo();
		sapito.setNombre("Rin rin Renacuajo");
		sapito.setEdad(2);
		String verAlimentacionSapo = sapito.tipoAlimentacion(crearAlimentacion("Carnívoro"));
		String verEstructuraSapo = sapito.tipoestructura(crearEstrutura("Vertebrado"));
		sapito.comunicarse();
		sapito.tipoAnimal();
		sapito.mecanismoDefensa();
		//Ejecución de los métodos especializados
		Sapo espSapo = new Sapo();
		espSapo.comerMoscas();
		espSapo.cambiarHabitat();
		
		
		System.out.println(verAlimentacionSapo+"\n"+ verEstructuraSapo);
		System.out.println();
		
	}

}
