package co.com.principal;

import co.com.abstracto.Triangulo;
import co.com.concreto.TrianguloFactory;
import co.com.interfaz.TrianguloFactoryMethod;

public class Main {

	public static void main(String[] args) {
	
		TrianguloFactoryMethod factory = new TrianguloFactory();
		Triangulo triangulo = factory.createTriangulo(11, 10, 10);
		System.out.println(triangulo.getDescripcion());

	}

}
