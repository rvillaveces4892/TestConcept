package co.com.uan.enumeration;

public enum FigurasEnum {
	Cuadrado("Cuadrado"), Rectangulo("Rectangulo"), Circulo("Circulo"), Esfera("Esfera"), Cono("Cono");

	private final String desc;

	private FigurasEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

}
