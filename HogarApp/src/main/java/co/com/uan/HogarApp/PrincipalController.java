package co.com.uan.HogarApp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.uan.HogarApp.bridge.BridgeImpl;
import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.facade.Fachada;
import co.com.uan.HogarApp.servicesImpl.CategoriaImpl;
import co.com.uan.HogarApp.servicesImpl.Cliente;
import co.com.uan.HogarApp.servicesImpl.NotificacionImpl;
import co.com.uan.HogarApp.servicesImpl.Proveedor;
import co.com.uan.HogarApp.servicesImpl.ServicioImpl;
import co.com.uan.HogarApp.servicesImpl.SolicitudImpl;

@RestController
public class PrincipalController {

	@RequestMapping("/buscarUsuarioPorID/{id}")
	public Usuario buscarUsuarioPorID(@PathVariable Long id) {
		Fachada persona = new BridgeImpl(new Cliente());
		Usuario usuario = new Usuario();
		try {
			usuario = persona.obtenerUsusarioPorID(id);
			return usuario;
		} catch (Exception e) {
			return usuario;
		}
	}

	@RequestMapping("/buscarUsuarioPorCorreo/{correo}")
	public Usuario buscarUsuarioPorCorreo(@PathVariable String correo) {
		Fachada usuario = new BridgeImpl(new Cliente());
		return usuario.obtenerUsusarioPorCorreo(correo);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping("/findAllCategorias")
	public List<Categoria> findAllCategorias() {
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategorias();
	}

	@RequestMapping("/findCategoriaById/{id}")
	public Categoria findCategoriaById(@PathVariable Long id) {
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategoriaByID(id);
	}

	@RequestMapping("/findAllServicios")
	public List<Servicio> findAllServicios() {
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicios();
	}

	@RequestMapping("/findServicioById/{id}")
	public Servicio findServicioById(@PathVariable Long id) {
		Fachada servicio = new BridgeImpl(new ServicioImpl());
		return servicio.obtenerServiciobyID(id);
	}

	@RequestMapping("/findAllServiciosByCategoriaId/{idCategoria}")
	public List<Servicio> findAllServiciosByCategoriaId(@PathVariable Long idCategoria) {
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicioPorCategoria(idCategoria);
	}

	@RequestMapping("/findAllProvedoresCercanos")
	public List<Usuario> findAllProvedoresCercanos(@RequestParam("usuarioIdCliente") Long usuarioIdCliente,
			@RequestParam("servicioId") Long servicioId) {
		Fachada proveedor = new BridgeImpl(new Proveedor());
		return proveedor.buscarProveedoresCercanos(usuarioIdCliente, servicioId);
	}

	@RequestMapping(value = "/proveedor/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> crearProveedor(@RequestBody Usuario usuario) {
		Fachada proveedor = new BridgeImpl(new Proveedor());
		Usuario proveedorCreated;
		try {
			proveedorCreated = proveedor.registrarPersona(usuario);
			return new ResponseEntity<>(proveedorCreated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/cliente/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> crearCliente(@RequestBody Usuario usuario) {
		Fachada cliente = new BridgeImpl(new Cliente());
		Usuario clienteCreated;
		try {
			clienteCreated = cliente.registrarPersona(usuario);
			return new ResponseEntity<>(clienteCreated, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("exception message : "+e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping("/solicitud/{id}")
	public Solicitud buscarSolicitud(@PathVariable Long id) {
		Fachada solicitud = new BridgeImpl(new SolicitudImpl());
		return solicitud.buscarSolicitud(id);
	}

	@RequestMapping(value = "/solicitud/create", method = RequestMethod.POST, consumes = "application/json")
	public Solicitud crearSolicitud(@RequestBody Solicitud solicitud) {
		Fachada solicitudImpl = new BridgeImpl(new SolicitudImpl());
		Solicitud requestSolicitud = new Solicitud();
		try {
			requestSolicitud = solicitudImpl.crearSolicitud(solicitud);
			Fachada notificacionImpl = new BridgeImpl(new NotificacionImpl());
			List<NotificacionProveedor> notificaciones = notificacionImpl.crearNotificaciones(solicitud);
			requestSolicitud.setNotificacionProveedorList(notificaciones);
			return requestSolicitud;
		} catch (Exception e) {
			return requestSolicitud;
		}

	}

}
