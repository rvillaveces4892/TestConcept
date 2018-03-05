package org.formacion.builder;

public class Main {

	public static void main(String[] args) {

		// este codigo debe compilar

		Persona madre = new Persona.Builder("Maria")
				.setMunicipio("Selva")
				.setMayor(37)
				.setLugarTrabajo("Google")
				.build();

		Persona hijo = new Persona.Builder("Alexandra")
				.setMenor(4)
				.setColegio("Colegio de selva")
				.build();

		// esta codigo NO debe compilar
		/*
		 * Persona mal = new Persona.Builder("Luisa") .setMayor(20)
		 * .setColegio("Colegio de Villa Arriba") .build();
		 */
	}
}
