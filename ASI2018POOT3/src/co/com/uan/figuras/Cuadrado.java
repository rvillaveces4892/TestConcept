package co.com.uan.figuras;

import co.com.uan.polimorfismo.FiguraGeometrica;

public class Cuadrado extends FiguraGeometrica {

	private double lado;

	/**
	 * 
	 * @param lado
	 */
	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public String CalcularArea() {
		return "Area del cuadrado = " + (Math.pow(getLado(), 2.0));
	}

	@Override
	public String CalcularPerimetro() {
		return "Perimetro del cuadrado" + (4 * getLado());
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

}
