package edu.logica.factorymethod;

public interface FiguraFactoryMethod {
	
	public Triangulo crearTriangulo(int lasoA,int ladoB,int ladoC);
	
	public Cuadrilatero crearCuadrilatero(int ladoA,int ladoB,int ladoC, int ladoD);

}
