package co.com.concreto;

import co.com.abstracto.Triangulo;
import co.com.formas.Equilatero;
import co.com.formas.Escaleno;
import co.com.formas.Isosceles;
import co.com.interfaz.TrianguloFactoryMethod;

public class TrianguloFactory implements TrianguloFactoryMethod {


	@Override
	public Triangulo createTriangulo(int ladoA, int ladoB, int ladoC) {
		if((ladoA == ladoB) && (ladoA == ladoC)){
			return new Equilatero(ladoA, ladoB, ladoC);
		}else if((ladoA != ladoB) && (ladoA != ladoC) && (ladoB != ladoC)){
			return new Escaleno(ladoA, ladoB, ladoC);
		} else {
			return new Isosceles(ladoA, ladoB, ladoC);
		}
	}

}
