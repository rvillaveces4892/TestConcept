
package co.com.uan.HogarApp.facade;

import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;

public interface Fachada {
    //Categoria
    public Categoria obtenerCategoriaPorId(Long idCategoria);
    public List<Categoria> obtenerCategorias();
    //Servicio
    public Servicio obtenerServicioPorId(Long servicioId);
    public List<Servicio> obtenerServicios();
    public List<Servicio> obtenerServicioPorCategoria(Long categoriaId);
    //Usuario
    public Usuario obtenerUsuarioPorId(Long usuario_id) throws Exception;
    public Usuario obtenerUsusarioPorCorreo(String correo);
    public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception;
    public List<Usuario> obtenerProveedoresCercanos(String longitud, String latitud, Long servicioId);
    //Solicitud
    public Solicitud obtenerSolicitudPorId(Long solicitudId);
    public Solicitud crearSolicitud(Solicitud solicitud) throws Exception; 
    public List<Solicitud> obtenerSolicitudesDelCliente(Long usuario_id);
    //Notificaciones
    public List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud) throws Exception;
    public List<NotificacionProveedor> obtenerNotificacionesPorEstado(String estado);
    public List<NotificacionProveedor> obtenerNotificacionesPorEstadoYIdProveedor(String estado, Long idProveedor);
    public void cambioEstadoNotificacion(NotificacionProveedorPK notificacionProveedorPK) throws Exception;
    //cotizacion
    public Cotizacion crearCotizacion(Cotizacion cotizacion) throws Exception,IllegalArgumentException;
	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id);
	public boolean rechazarCotizacion(Long cotizacion_id);
	public List<Cotizacion> obtenerCotizacionesPorSolicitud(Long solicitud_id);
}
