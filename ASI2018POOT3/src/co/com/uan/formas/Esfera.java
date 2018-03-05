package co.com.uan.formas;

import co.com.uan.figuras.Circulo;

public class Esfera extends Circulo {

	/**
	 * 
	 * @param radio
	 */
	public Esfera(double radio) {
		super(radio);
	}

	@Override
	public String CalcularArea() {
		return "Area de la esfera = " + ((4 * pi * (Math.pow(getRadio(), 2.0))));
	}

	public String calcularVolumen() {
		return "Volumen de la esfera = " + (((4 / 3) * pi * (Math.pow(getRadio(), 3.0))));
	}
}
