package co.com.fabricas;

import javax.swing.JOptionPane;

import co.com.clases.Bus;
import co.com.interfaces.Vehiculo;
import co.com.interfaces.VehiculoDeTransporte;

/**
 * Clase que permite la creacion de un objeto Bus
 * 
 * @author chenao
 *
 */
public class FabricaBuses implements VehiculoDeTransporte {
	public Vehiculo crearVehiculo() {
		Bus miBus = new Bus();
		miBus.setCodigo(miBus.generarCodigo());
		JOptionPane.showMessageDialog(null, "Se ha creado un nuevo Objeto Bus  ");
		return miBus;
	}
}