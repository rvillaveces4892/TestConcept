package co.com.uan.formas;

import co.com.uan.figuras.Triangulo;

public class Cono extends Triangulo {

	private int altura;
	private int alturaG;
	private double radio;

	/**
	 * 
	 * @param altura
	 * @param alturaG
	 * @param radio
	 */
	public Cono(int altura, int alturaG, double radio) {
		super();
		this.altura = altura;
		this.alturaG = alturaG;
		this.radio = radio;
	}

	@Override
	public String CalcularArea() {
		return "Area del cono es ="
				+ ((Math.PI * (double) getAlturaG() * getRadio()) + (Math.PI * Math.pow(getRadio(), 2)));
	}

	public String calcularAreaLateral() {
		return "Area lateral del cono es = " + (Math.PI * (double) getAlturaG() * getRadio());
	}

	public String calcularVolumen() {
		return "Volumen del cono es = " + (Math.PI * Math.pow(getRadio(), 2) * getAltura()) / 3;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAlturaG() {
		return alturaG;
	}

	public void setAlturaG(int alturaG) {
		this.alturaG = alturaG;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
