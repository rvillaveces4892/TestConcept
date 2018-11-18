
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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

	@Transactional
	@Override
	public Cotizacion crearCotizacion(Cotizacion cotizacion) {
		em.persist(cotizacion);
		return cotizacion;
	}

	@Transactional
	@Override
	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id) {
		try {
			em.createNativeQuery(Cotizacion.ACEPTAR_COTIZACION).setParameter(1, Cotizacion.ESTADO_RECHAZADA)
					.setParameter(2, solicitud_id).setParameter(3, cotizacion_id).executeUpdate();
			em.createNamedQuery(Cotizacion.UPDATE_ESTADO_BY_ID).setParameter(1, Cotizacion.ESTADO_ACEPTADA)
					.setParameter(2, cotizacion_id).executeUpdate();
			em.createNativeQuery(
					Cotizacion.UPDATE_IDPROVEEDOR_SOLICITUD)
					.setParameter(1, cotizacion_id).setParameter(2, solicitud_id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cotizacion> obtenerCotizacionPorSolicitud(Long solicitud_id) {
		Query findCotizacionBySolicitud = em.createNamedQuery(Cotizacion.FIND_COTIZACIONS_BY_SOLICITUD);
		findCotizacionBySolicitud.setParameter(Cotizacion.SOLICITUD_ID, solicitud_id);
		return (List<Cotizacion>) findCotizacionBySolicitud.getResultList();
	}

	@Transactional
	@Override
	public boolean rechazarCotizacion(Long cotizacion_id) {
		try {
			em.createNamedQuery(Cotizacion.UPDATE_ESTADO_BY_ID).setParameter(1, Cotizacion.ESTADO_RECHAZADA)
					.setParameter(2, cotizacion_id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
