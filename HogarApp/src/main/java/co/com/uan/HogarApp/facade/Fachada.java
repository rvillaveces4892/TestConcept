
package co.com.uan.HogarApp.facade;

import java.util.List;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;

public interface Fachada {
    //Categoria
    public List<Categoria> obtenerCategorias();
    public Categoria obtenerCategoriaByID(Long idCategoria);
    //Servicio
    public List<Servicio> obtenerServicios();
    public Servicio obtenerServiciobyID(Long servicioId);
    public List<Servicio> obtenerServicioPorCategoria(Long categoriaId);
    //Usuario
    public Usuario obtenerUsusarioPorID(Long usuario_id);
    public Usuario obtenerUsusarioPorCorreo(String correo);
    public List<Usuario> buscarProveedoresCercanos(Long usuarioIdCliente, Long servicioId);
    public Usuario registrarPersona(Usuario usuario);
    //Solicitud
    public Solicitud buscarSolicitud(Long solicitudId);
    public Solicitud crearSolicitud(Solicitud solicitud); 
    //Notificaciones
    public List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud);
    public List<NotificacionProveedor> obtenerNotificacionByEstado(String estado);
    
    //cotizacion
    public Cotizacion crearCotizacion(Cotizacion cotizacion);
	public boolean aceptarCotizacion(Long solicitud_id, Long cotizacion_id);
	public List<Cotizacion> buscarCotizacionPorSolicitud(Long solicitud_id);
	public List<Cotizacion> listarCotizacion(Long idProveedor);
}
