package edu.logica.factorymethod;

public class FiguraConcretaFactoryMethod  implements FiguraFactoryMethod{

	@Override
	public Triangulo crearTriangulo(int ladoA, int ladoB, int ladoC) {
	
		if ((ladoA==ladoB)&&(ladoA==ladoC)){
			return new Equilatero(ladoA, ladoB, ladoC);
		}else if((ladoA!=ladoB)&&(ladoA!=ladoC) &&(ladoB!=ladoC)){
			return new Escaleno(ladoA, ladoB, ladoC);
		}else{
			return new Isoceles(ladoA, ladoB, ladoC);
		}
	}

	@Override
	public Cuadrilatero crearCuadrilatero(int ladoA, int ladoB, int ladoC, int ladoD) {
		if(ladoA == ladoB && ladoB == ladoC && ladoC == ladoD){
			return new Cuadrado(ladoA, ladoB, ladoC, ladoD);
		}else if(ladoA == ladoC && ladoB == ladoD){
			return new Rectangulo(ladoA, ladoB, ladoC, ladoD);
		}
		return null;
	}

}
