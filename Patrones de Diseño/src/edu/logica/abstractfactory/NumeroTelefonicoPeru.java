package edu.logica.abstractfactory;

public class NumeroTelefonicoPeru extends NumeroTelefonico{

	private final String CODIGO_PAIS = "15";
	
	@Override
	public String getCodigoPais() {
		return CODIGO_PAIS;
	}

}
