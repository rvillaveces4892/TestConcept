package co.com.uan.formas;

import co.com.uan.figuras.Circulo;

public class Cilindro extends Circulo {

	private long altura;

	public Cilindro(double radio) {
		super(radio);
	}

	@Override
	public String CalcularArea() {
		return String.valueOf(2 * pi * getRadio() * altura);
	}

	public String calcularVolumen() {
		return String.valueOf(pi * Math.pow(getRadio(), 2.0) * altura);
	}

	public long getAltura() {
		return altura;
	}

	public void setAltura(long altura) {
		this.altura = altura;
	}

}
