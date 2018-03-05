package co.com.uan.interfaz;

import java.util.ArrayList;
import java.util.List;

import co.com.uan.figuras.Circulo;
import co.com.uan.figuras.Cuadrado;
import co.com.uan.figuras.Rectangulo;
import co.com.uan.figuras.Triangulo;
import co.com.uan.formas.Cono;
import co.com.uan.formas.Esfera;
import co.com.uan.polimorfismo.FiguraGeometrica;

public class Imprimir {

	public static List<FiguraGeometrica> figuras = new ArrayList<>();

	public static void main(String[] args) {
		figuras.add(new Circulo(20));
		figuras.add(new Esfera(30));
		figuras.add(new Rectangulo(2, 3));
		figuras.add(new Cuadrado(3));
		figuras.add(new Cono(5, 10, 5));
		imprimir();
	}

	public static void imprimir() {
		if (figuras != null && !figuras.isEmpty()) {
			for (FiguraGeometrica figuraGeometrica : figuras) {
				System.out.println(figuraGeometrica.CalcularArea());
				switch (figuraGeometrica.getClass().getSimpleName()) {
				case "Esfera":
					Esfera esfera = (Esfera) figuraGeometrica;
					System.out.println(esfera.calcularVolumen());
					break;
				case "Cono":
					Cono cono = (Cono) figuraGeometrica;
					System.out.println(cono.calcularVolumen());
					System.out.println(cono.calcularAreaLateral());
					break;
				default:
					System.out.println(figuraGeometrica.CalcularPerimetro());
					break;
				}

			}
		}
	}

}
