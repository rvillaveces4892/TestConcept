package edu.logica.factorymethod;

public class EjecutarPatron {
	
	public static void main(String [] args){
		FiguraFactoryMethod factory= new FiguraConcretaFactoryMethod();
		Triangulo triangulo= factory.crearTriangulo(10, 8, 7);
		System.out.println(triangulo.getDescripcion());
		Cuadrilatero cuadrilatero = factory.crearCuadrilatero(2, 9, 2, 9);
		System.out.println(cuadrilatero.getDescripcion());
	}

}
