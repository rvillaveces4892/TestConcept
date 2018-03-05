package co.com.fabricas;

import javax.swing.JOptionPane;

import co.com.clases.Taxi;
import co.com.interfaces.Vehiculo;
import co.com.interfaces.VehiculoDeTransporte;

/**
 * Clase que permite la creacion de un objeto Taxi
 * 
 * @author chenao
 *
 */
public class FabricaTaxis implements VehiculoDeTransporte {
	@Override
	public Vehiculo crearVehiculo() {
		Taxi miTaxi = new Taxi();
		miTaxi.setCodigo(miTaxi.generarCodigo());
		JOptionPane.showMessageDialog(null, "Se ha creado un nuevo Objeto Taxi");
		return miTaxi;
	}
}