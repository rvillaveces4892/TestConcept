
package co.com.uan.HogarApp.bridge;

import java.util.List;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.facade.Fachada;

public abstract class Bridge implements Fachada {

	// Categorías
	@Override
	public abstract Categoria obtenerCategoriaByID(Long idCategoria);

	@Override
	public abstract List<Categoria> obtenerCategorias();

	// Servicios
	@Override
	public abstract List<Servicio> obtenerServicios();

	@Override
	public abstract Servicio obtenerServiciobyID(Long servicioId);

	@Override
	public abstract List<Servicio> obtenerServicioPorCategoria(Long categoriaId);

	@Override
	public abstract Usuario registrarPersona(Usuario usuario);

	// solicitud
	@Override
	public abstract Solicitud buscarSolicitud(Long solicitudId);

	@Override
	public abstract Solicitud crearSolicitud(Solicitud solicitud);

	// Notificaciones
	@Override
	public abstract List<NotificacionProveedor> obtenerNotificacionByEstado(String estado);

	@Override
	public abstract List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud);

}
