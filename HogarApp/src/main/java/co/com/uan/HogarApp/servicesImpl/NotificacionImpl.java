
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.utils.s.Encriptor;

@Component
@Configuration
public class NotificacionImpl implements INotificacion {

	@Autowired
	private EntityManager em;

	public NotificacionImpl() {
	}

	@Override
	public List<NotificacionProveedor> obtenerNotificacionesPorEstado(String estado) {
		List<NotificacionProveedor> notificacionProveedor = new ArrayList<>();
		try {
			notificacionProveedor = em
					.createNamedQuery("NotificacionProveedor.findByEstado", NotificacionProveedor.class)
					.setParameter("estado", estado).getResultList();
			return notificacionProveedor;
		} catch (NoResultException e) {
			return notificacionProveedor;
		}
	}
	
	@Override
	public List<NotificacionProveedor> obtenerNotificacionesPorEstadoYIdProveedor(String estado,Long idProveedor) {
		List<NotificacionProveedor> notificacionProveedor = new ArrayList<>();
		try {
			notificacionProveedor = em
					.createNamedQuery("NotificacionProveedor.findByEstadoAndIdProveedor", NotificacionProveedor.class)
					.setParameter("estado", estado).setParameter("proveedorId", idProveedor).getResultList();
			
			return notificacionProveedor;
		} catch (NoResultException e) {
			return notificacionProveedor;
		}
	}

	@Transactional
	@Override
	public List<NotificacionProveedor> crearNotificaciones(List<Usuario> proveedores, Solicitud solicitud) {
		List<NotificacionProveedor> notificaciones = new ArrayList<>();
		if (proveedores != null && !proveedores.isEmpty()) {
			for (Usuario proveedor : proveedores) {
				NotificacionProveedor notificacion = new NotificacionProveedor();
				NotificacionProveedorPK notificacionProveedorPK = new NotificacionProveedorPK(proveedor.getUsuarioId(),
						solicitud.getSolicitudId());
				notificacion.setNotificacionProveedorPK(notificacionProveedorPK);
				notificacion.setSolicitud(solicitud);
				try {
					proveedor.setPassword(Encriptor.encrypt(proveedor.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				notificacion.setUsuario(proveedor);
				em.persist(notificacion);
				notificaciones.add(notificacion);
			}
		}

		return notificaciones;
	}

	@Transactional
	@Override
	public void cambioEstadoNotificacion(NotificacionProveedorPK notificacionProveedorPK) throws Exception {
		try {
			NotificacionProveedor objTmp = em.find(NotificacionProveedor.class, notificacionProveedorPK);
			objTmp.setEstado("LEIDA");
			em.merge(objTmp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}
