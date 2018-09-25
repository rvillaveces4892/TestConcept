
package co.com.uan.HogarApp.bridge;

import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Cotizacion;
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
	
	//Personas
	@Override
	public abstract Usuario obtenerUsusarioPorID(Long usuario_id) throws Exception;
	
	@Override
    public abstract Usuario obtenerUsusarioPorCorreo(String correo);
	
	@Override
    public abstract List<Usuario> buscarProveedoresCercanos(String longitud, String latitud, Long servicioId);
    
	@Override
	public abstract Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception;

	// solicitud
	@Override
	public abstract Solicitud buscarSolicitud(Long solicitudId);

	@Override
	public abstract Solicitud crearSolicitud(Solicitud solicitud) throws Exception;

	// Notificaciones
	@Override
	public abstract List<NotificacionProveedor> obtenerNotificacionesByEstado(String estado);

	@Override
	public abstract List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud) throws Exception;

	//Cotizacion
	@Override
	public abstract Cotizacion crearCotizacion(Cotizacion cotizacion);

	@Override
	public abstract boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id);
	
	@Override
	public abstract List<Cotizacion> buscarCotizacionesPorSolicitud(Long solicitud_id);

	@Override
	public abstract List<Cotizacion> listarCotizacion(Long idProveedor);
}
