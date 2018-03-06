package edu.logica.abstractfactory;

public class FactoriaDireccionesPeru implements FactoriaDirecciones{

	@Override
	public Direccion crearDireccion() {
		return new DireccionPeru();
	}

	@Override
	public NumeroTelefonico crearNumeroDeTelefono() {
		return new NumeroTelefonicoPeru();
	}

}
