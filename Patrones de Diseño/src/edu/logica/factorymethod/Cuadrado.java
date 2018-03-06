package edu.logica.factorymethod;

public class Cuadrado extends Cuadrilatero{

	public Cuadrado(int ladoA, int ladoB, int ladoC, int ladoD) {
		super(ladoA, ladoB, ladoC, ladoD);
	}

	@Override
	public String getDescripcion() {
		return "Cuadrado";
	}

}
