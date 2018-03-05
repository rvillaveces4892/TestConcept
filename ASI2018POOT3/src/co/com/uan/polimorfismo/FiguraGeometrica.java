package co.com.uan.polimorfismo;

public abstract class FiguraGeometrica {

	private String color;

	public abstract String CalcularArea();

	public abstract String CalcularPerimetro();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
