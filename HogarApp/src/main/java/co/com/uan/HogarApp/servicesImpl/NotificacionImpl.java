
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.interfaces.ISolicitud;

@Component
@Configuration
public class NotificacionImpl implements INotificacion {

	@Autowired
	private EntityManager em;

	public NotificacionImpl() {
	}

	@Override
	public List<NotificacionProveedor> listarNotificacionByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<NotificacionProveedor> crearNotificaciones(List<Usuario> proveedores, Solicitud solicitud) {
		List<NotificacionProveedor> notificaciones = new ArrayList<>();
		if (proveedores != null && !proveedores.isEmpty()) {
			for (Usuario proveedor : proveedores) {
				NotificacionProveedor notificacion = new NotificacionProveedor();
				NotificacionProveedorPK notificacionProveedorPK = new NotificacionProveedorPK(proveedor.getUsuarioId(), solicitud.getSolicitudId());
				notificacion.setNotificacionProveedorPK(notificacionProveedorPK);
				notificacion.setSolicitud(solicitud);
				notificacion.setUsuario(proveedor);
				em.persist(notificacion);
				notificaciones.add(notificacion);
			}
		}
		
		return notificaciones;
	}

}
