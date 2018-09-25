
package co.com.uan.HogarApp.bridge;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.ApplicationContextHolder;
import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.ICategoria;
import co.com.uan.HogarApp.interfaces.ICotizacion;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.interfaces.IPersona;
import co.com.uan.HogarApp.interfaces.IServicio;
import co.com.uan.HogarApp.interfaces.ISolicitud;
import co.com.uan.HogarApp.servicesImpl.CategoriaImpl;
import co.com.uan.HogarApp.servicesImpl.Cliente;
import co.com.uan.HogarApp.servicesImpl.CotizacionImpl;
import co.com.uan.HogarApp.servicesImpl.NotificacionImpl;
import co.com.uan.HogarApp.servicesImpl.Proveedor;
import co.com.uan.HogarApp.servicesImpl.ServicioImpl;
import co.com.uan.HogarApp.servicesImpl.SolicitudImpl;

public class BridgeImpl extends Bridge {

	private IServicio servicio;
	private IPersona persona;
	private ICategoria categoria;
	private ICotizacion cotizacion;
	private INotificacion notificacion;
	private ISolicitud solicitudImpl;

	public BridgeImpl() {

	}

	public BridgeImpl(IServicio servicio) {
		this.servicio = ApplicationContextHolder.getContext().getBean(servicio.getClass());
	}

	public BridgeImpl(IPersona persona) {
		this.persona = ApplicationContextHolder.getContext().getBean(persona.getClass());
	}

	public BridgeImpl(ISolicitud solicitud) {
		this.solicitudImpl = ApplicationContextHolder.getContext().getBean(SolicitudImpl.class);
	}

	public BridgeImpl(ICategoria categoria) {
		this.categoria = ApplicationContextHolder.getContext().getBean(CategoriaImpl.class);
	}

	public BridgeImpl(ICotizacion cotizacion) {
		this.cotizacion = ApplicationContextHolder.getContext().getBean(CotizacionImpl.class);
	}

	public BridgeImpl(INotificacion notificacion) {
		this.notificacion = ApplicationContextHolder.getContext().getBean(NotificacionImpl.class);
	}

	@Override
	public Categoria obtenerCategoriaByID(Long idCategoria) {
		return this.categoria.findCategoriaByID(idCategoria);
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		return this.categoria.listarCategorias();
	}

	@Override
	public List<Servicio> obtenerServicios() {
		List<Servicio> servicios = this.servicio.obtenerServicios();
		return servicios;
	}

	@Override
	public Servicio obtenerServiciobyID(Long servicioId) {
		Servicio servicio = this.servicio.obtenerServiciobyID(servicioId);
		return servicio;
	}

	@Override
	public List<Servicio> obtenerServicioPorCategoria(Long categoriaId) {
		List<Servicio> servicios = this.servicio.obtenerServicioPorCategoria(categoriaId);
		return servicios;
	}

	@Override
	public Usuario obtenerUsusarioPorID(Long usuario_id) throws Exception {
		Usuario usuario = this.persona.buscarPersona(usuario_id);
		return usuario;
	}

	@Override
	public Usuario obtenerUsusarioPorCorreo(String correo) {
		Usuario usuario = this.persona.obtenerUsusarioPorCorreo(correo);
		return usuario;
	}

	@Override
	public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception {
		return persona.registrarPersona(usuario);
	}

	@Override
	public List<Usuario> buscarProveedoresCercanos(String longitud, String latitud, Long servicioId) {
		return persona.getProveedoresCercanos(longitud, latitud, servicioId);
	}

	@Override
	public Solicitud buscarSolicitud(Long solicitudId) {
		return solicitudImpl.buscarSolicitud(solicitudId);
	}

	@Override
	public Solicitud crearSolicitud(Solicitud solicitud) throws Exception {
		this.persona = ApplicationContextHolder.getContext().getBean(Cliente.class);
		this.servicio = ApplicationContextHolder.getContext().getBean(ServicioImpl.class);
		Usuario cliente = this.persona.buscarPersona(solicitud.getUsuarioIdCliente().getUsuarioId());
		Servicio servicio = this.servicio.obtenerServiciobyID(solicitud.getServicioId().getServicioId());
		solicitud.setUsuarioIdCliente(cliente);
		solicitud.setServicioId(servicio);
		return solicitudImpl.crearSolicitud(solicitud);
	}

	@Override
	public List<NotificacionProveedor> obtenerNotificacionesByEstado(String estado) {
		return notificacion.listarNotificacionByEstado(estado);
	}

	@Override
	public List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud) throws Exception {
		this.persona = ApplicationContextHolder.getContext().getBean(Proveedor.class);
		List<Usuario> proveedores = new ArrayList<>();
		if (solicitud.getUsuarioIdProveedor() != null && solicitud.getUsuarioIdProveedor().getUsuarioId() != null) {
			proveedores.add(this.persona.buscarPersona(solicitud.getUsuarioIdProveedor().getUsuarioId()));
		} else {
			proveedores = this.persona.getProveedoresCercanos(solicitud.getLongitud(),solicitud.getLatitud(),
					solicitud.getServicioId().getServicioId());
		}
		List<NotificacionProveedor> notificaciones = this.notificacion.crearNotificaciones(proveedores, solicitud);
		return notificaciones;
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
	public List<Cotizacion> buscarCotizacionesPorSolicitud(Long solicitud_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cotizacion> listarCotizacion(Long idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Solicitud> buscarSolicitudesDelCliente(Long usuario_id){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean rechazarCotizacion(Long cotizacion_id){
        // TODO Auto-generated method stub
        return false;
    }

}
