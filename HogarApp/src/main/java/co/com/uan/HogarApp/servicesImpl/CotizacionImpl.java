
package co.com.uan.HogarApp.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.boot.model.source.spi.EmbeddableMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Solicitud;
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
	public Cotizacion crearCotizacion(Cotizacion cotizacion) throws Exception {
		try {
			Solicitud solicitud = em.find(Solicitud.class, cotizacion.getSolicitudId().getSolicitudId());
			if (solicitud != null) {
				if (solicitud.getEstado().equals("CREADA")) {
					Query findCotizacionBySolicitud = em
							.createNamedQuery(Cotizacion.FIND_COTIZACIONS_BY_SOLICITUDAND_USER)
							.setParameter(1, cotizacion.getSolicitudId().getSolicitudId())
							.setParameter(2, cotizacion.getUsuarioIdProveedor().getUsuarioId());
					List<Cotizacion> list = (List<Cotizacion>) findCotizacionBySolicitud.getResultList();
					if (list != null && !list.isEmpty()) {
						throw new Exception("El proveedor ya cotizo esta solicitud.");
					}
				} else {
					throw new Exception(
							"La solicitud [" + cotizacion.getSolicitudId().getSolicitudId() + "] ya fue confirmada.");
				}
			} else {
				throw new Exception("La solicitud [" + cotizacion.getSolicitudId().getSolicitudId() + "] no existe.");
			}
			em.persist(cotizacion);
			NotificacionProveedor noti = em.find(NotificacionProveedor.class, new NotificacionProveedorPK(cotizacion.getUsuarioIdProveedor().getUsuarioId(), cotizacion.getSolicitudId().getSolicitudId()));
			noti.setDescripcion("¡La solicitud fue atendida!");
			noti.setEstado("LEIDA");
			noti.setFechaCreacion(new Date());
			em.merge(noti);
			return cotizacion;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	@Override
	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id) {
		try {
			Solicitud solicitud = em.find(Solicitud.class, solicitud_id);
			if (solicitud != null&&solicitud.getEstado().equals("CREADA")) {
				em.createNamedQuery(Cotizacion.ACEPTAR_COTIZACION).setParameter(1, Cotizacion.ESTADO_RECHAZADA)
						.setParameter(2, solicitud_id).setParameter(3, cotizacion_id).executeUpdate();
				em.createNamedQuery(Cotizacion.UPDATE_ESTADO_BY_ID).setParameter(1, Cotizacion.ESTADO_ACEPTADA)
						.setParameter(2, cotizacion_id).executeUpdate();
				em.createNativeQuery(Cotizacion.UPDATE_IDPROVEEDOR_SOLICITUD).setParameter(1, cotizacion_id)
						.setParameter(2, solicitud_id).setParameter(3, solicitud_id).executeUpdate();
				Cotizacion cotizacion = em.find(Cotizacion.class, cotizacion_id);
				NotificacionProveedor noti = em.find(NotificacionProveedor.class, new NotificacionProveedorPK(cotizacion.getUsuarioIdProveedor().getUsuarioId(), solicitud_id));
				noti.setDescripcion("¡Solicitud y cotización aceptada!");
				noti.setEstado("ACEPTADA");
				noti.setFechaCreacion(new Date());
				em.merge(noti);
			}
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
			Cotizacion cotizacion = em.find(Cotizacion.class, cotizacion_id);
			Solicitud solicitud = em.find(Solicitud.class, cotizacion.getSolicitudId().getSolicitudId());
			if(solicitud!=null&&solicitud.getEstado().equals("CREADA")) {
				em.createNamedQuery(Cotizacion.UPDATE_ESTADO_BY_ID).setParameter(1, Cotizacion.ESTADO_RECHAZADA)
				.setParameter(2, cotizacion_id).executeUpdate();
				NotificacionProveedor noti = em.find(NotificacionProveedor.class, new NotificacionProveedorPK(cotizacion.getUsuarioIdProveedor().getUsuarioId(), solicitud.getSolicitudId()));
				noti.setDescripcion("Cotización rechazada.");
				noti.setEstado("RECHAZADA");
				noti.setFechaCreacion(new Date());
				em.merge(noti);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
