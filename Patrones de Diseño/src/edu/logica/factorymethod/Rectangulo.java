package edu.logica.factorymethod;

public class Rectangulo extends Cuadrilatero{

	public Rectangulo(int ladoA, int ladoB, int ladoC, int ladoD) {
		super(ladoA, ladoB, ladoC, ladoD);
	}

	@Override
	public String getDescripcion() {
		return "Rectángulo";
	}

}
