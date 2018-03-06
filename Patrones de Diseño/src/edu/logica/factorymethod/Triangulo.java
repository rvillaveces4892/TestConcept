package edu.logica.factorymethod;

public abstract class Triangulo {
	
	private int LadoA;
	private int LadoB;
	private int LadoC;
	
	public Triangulo(int ladoA,int ladoB, int ladoC){
		setLadoA(ladoA);
		setLadoB(ladoB);
		setLadoC(ladoC);
	}
	public abstract String getDescripcion();	
	public int getLadoA() {
		return LadoA;
	}
	public void setLadoA(int ladoA) {
		LadoA = ladoA;
	}
	public int getLadoB() {
		return LadoB;
	}
	public void setLadoB(int ladoB) {
		LadoB = ladoB;
	}
	public int getLadoC() {
		return LadoC;
	}
	public void setLadoC(int ladoC) {
		LadoC = ladoC;
	}
	
	
		

}
