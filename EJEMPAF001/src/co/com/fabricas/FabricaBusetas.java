package co.com.fabricas;

import javax.swing.JOptionPane;

import co.com.clases.Buseta;
import co.com.interfaces.Vehiculo;
import co.com.interfaces.VehiculoDeTransporte;

/**
 * Clase que permite la creacion de un objeto Buseta
 * 
 * @author chenao
 *
 */
public class FabricaBusetas implements VehiculoDeTransporte {
	@Override
	public Vehiculo crearVehiculo() {
		Buseta miBuseta = new Buseta();
		miBuseta.setCodigo(miBuseta.generarCodigo());
		JOptionPane.showMessageDialog(null, "Se ha creado un nuevo Objeto Buseta");
		return miBuseta;
	}
}