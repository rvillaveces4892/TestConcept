package co.com.uan.figuras;

import co.com.uan.polimorfismo.FiguraGeometrica;

public class Rectangulo extends FiguraGeometrica {

	private double ladoA;

	private double ladoB;

	/**
	 * 
	 * @param ladoA
	 * @param ladoB
	 */
	public Rectangulo(double ladoA, double ladoB) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}

	@Override
	public String CalcularArea() {
		return "Area del Rectangulo = " + (ladoA * ladoB);
	}

	@Override
	public String CalcularPerimetro() {
		return "Perimetro del rectangulo = " + ((2 * ladoA) + (2 * ladoB));
	}

	public double getLadoA() {
		return ladoA;
	}

	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}

	public double getLadoB() {
		return ladoB;
	}

	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}

}
