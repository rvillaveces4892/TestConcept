package co.com.uan.figuras;

import co.com.uan.polimorfismo.FiguraGeometrica;

public class Circulo extends FiguraGeometrica {

	protected double pi = 3.1416;

	private double radio;

	/**
	 * 
	 * @param radio
	 */
	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public String CalcularArea() {
		return "Area del Circulo = " + (pi * (Math.pow(radio, 2.0)));
	}

	@Override
	public String CalcularPerimetro() {
		return "Perimetro del Circulo = " + (2 * pi * getRadio());
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
