
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.interfaces.ICotizacion;

@Component
@Configuration
public class CotizacionImpl implements ICotizacion {

	@Autowired
	private EntityManager em;

	public CotizacionImpl() {
	}

	@Override
	public Cotizacion crearCotizacion(Cotizacion cotizacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cotizacion> buscarCotizacionPorSolicitud(Long solicitud_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cotizacion> listarCotizacion(Long idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

}
