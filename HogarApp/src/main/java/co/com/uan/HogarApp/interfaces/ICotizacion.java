
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Cotizacion;

public interface ICotizacion {

	public Cotizacion crearCotizacion(Cotizacion cotizacion);

	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id);
	
	public boolean rechazarCotizacion(Long solicitud_id, Long cotizacion_id);

	public List<Cotizacion> buscarCotizacionPorSolicitud(Long solicitud_id);

	public List<Cotizacion> listarCotizacion(Long idProveedor);

}
