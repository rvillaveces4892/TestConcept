
package co.com.uan.HogarApp.servicesImpl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.interfaces.ISolicitud;

@Component
@Configuration
public class SolicitudImpl implements ISolicitud {

	@Autowired
	private EntityManager em;

	public SolicitudImpl() {
	}

	@Transactional
	@Override
	public Solicitud crearSolicitud(Solicitud solicitud) {
		em.persist(solicitud);
		return solicitud;
	}

	@Override
	public Solicitud buscarSolicitud(Long solicitudId) {
//		Solicitud solicitud = em.find(Solicitud.class, solicitudId);
		Solicitud solicitud = em.createNamedQuery("Solicitud.findByEstadoAndId", Solicitud.class)
				.setParameter("solicitudId", solicitudId).setParameter("estado", "CREADA").getSingleResult();
		return solicitud;

	}
}
