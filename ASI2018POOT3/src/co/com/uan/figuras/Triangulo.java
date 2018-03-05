package co.com.uan.figuras;

import co.com.uan.polimorfismo.FiguraGeometrica;

public class Triangulo extends FiguraGeometrica {

	private int base;
	private int ladoA;
	private int ladoB;

	public Triangulo() {
		super();
	}

	/**
	 * 
	 * @param base
	 * @param ladoA
	 * @param ladoB
	 */
	public Triangulo(int base, int ladoA, int ladoB) {
		super();
		this.base = base;
		this.ladoA = ladoA;
		this.ladoB = ladoB;
	}

	@Override
	public String CalcularArea() {

		return "Area del triagulo = " + (getBase() * ((getLadoA() * getLadoB()) / getBase()) / 2);
	}

	@Override
	public String CalcularPerimetro() {
		return "Perimetro del triagulo = " + (getBase() * getLadoA() * getLadoB());
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getLadoA() {
		return ladoA;
	}

	public void setLadoA(int ladoA) {
		this.ladoA = ladoA;
	}

	public int getLadoB() {
		return ladoB;
	}

	public void setLadoB(int ladoB) {
		this.ladoB = ladoB;
	}

}
