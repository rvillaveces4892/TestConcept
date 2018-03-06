package edu.logica.factorymethod;

public abstract class Cuadrilatero {

	private int ladoA;
	private int ladoB;
	private int ladoC;
	private int ladoD;
	
	public Cuadrilatero(int ladoA, int ladoB, int ladoC, int ladoD) {
		super();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
		this.ladoD = ladoD;
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

	public int getLadoC() {
		return ladoC;
	}

	public void setLadoC(int ladoC) {
		this.ladoC = ladoC;
	}

	public int getLadoD() {
		return ladoD;
	}

	public void setLadoD(int ladoD) {
		this.ladoD = ladoD;
	}
	
	public abstract String getDescripcion();
	
}
