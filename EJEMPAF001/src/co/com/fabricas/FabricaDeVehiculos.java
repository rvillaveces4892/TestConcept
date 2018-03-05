package co.com.fabricas;

import co.com.interfaces.Vehiculo;
import co.com.interfaces.VehiculoDeTransporte;

/**
 * Clase que permite la creacion de un servicio
 * 
 * @author chenao
 *
 */
public class FabricaDeVehiculos {
	public static void crearFabricaDeVehiculo(VehiculoDeTransporte factory) {
		/** Aplicamos Polimorfismo */
		Vehiculo objetoVehiculo = factory.crearVehiculo();
		objetoVehiculo.codigoDeVehiculo();
	}
}