package co.com.formas;

import co.com.abstracto.Triangulo;

public class Isosceles extends Triangulo{

	public Isosceles(int ladoA, int ladoB, int ladoC) {
		super(ladoA, ladoB, ladoC);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Soy un triangulo Isosceles";
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
