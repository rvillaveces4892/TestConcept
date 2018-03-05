package co.com.uan.formas;

import co.com.uan.figuras.Circulo;

public class Cubo extends Circulo {

	public Cubo(double radio) {
		super(radio);
	}

	@Override
	public String CalcularArea() {
		return String.valueOf(((4 / 3) * pi * (Math.pow(getRadio(), 3.0))));
	}
}
