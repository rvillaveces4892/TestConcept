package co.com.formas;

import co.com.abstracto.Triangulo;

public class Equilatero extends Triangulo {

	public Equilatero(int ladoA, int ladoB, int ladoC) {
		super(ladoA, ladoB, ladoC);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescripcion() {

		return "Soy un triangulo Equilatero";
	}

	@Override
	public double getSuperficie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dibujate() {
		// TODO Auto-generated method stub

	}

}
