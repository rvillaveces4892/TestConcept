package co.com.uan.HogarApp;

import java.util.ArrayList;
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
import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.facade.Fachada;
import co.com.uan.HogarApp.servicesImpl.CategoriaImpl;
import co.com.uan.HogarApp.servicesImpl.Cliente;
import co.com.uan.HogarApp.servicesImpl.CotizacionImpl;
import co.com.uan.HogarApp.servicesImpl.NotificacionImpl;
import co.com.uan.HogarApp.servicesImpl.Proveedor;
import co.com.uan.HogarApp.servicesImpl.ServicioImpl;
import co.com.uan.HogarApp.servicesImpl.SolicitudImpl;

@CrossOrigin(origins = "*")
@RestController
public class PrincipalController {

	@RequestMapping("/obtenerCategoriaPorId/{id}")
	public Categoria obtenerCategoriaPorId(@PathVariable Long id) {
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategoriaPorId(id);
	}

	@RequestMapping("/obtenerCategorias")
	public List<Categoria> obtenerCategorias() {
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategorias();
	}

	@RequestMapping("/obtenerServicioPorId/{id}")
	public Servicio obtenerServicioPorId(@PathVariable Long id) {
		Fachada servicio = new BridgeImpl(new ServicioImpl());
		return servicio.obtenerServicioPorId(id);
	}

	@RequestMapping("/obtenerServicios")
	public List<Servicio> obtenerServicios() {
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicios();
	}

	@RequestMapping("/obtenerServicioPorCategoria/{idCategoria}")
	public List<Servicio> obtenerServicioPorCategoria(@PathVariable Long idCategoria) {
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicioPorCategoria(idCategoria);
	}

	@RequestMapping("/obtenerUsuarioPorId/{id}")
	public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable Long id) {
		Fachada persona = new BridgeImpl(new Cliente());
		Usuario usuario = new Usuario();
		try {
			usuario = persona.obtenerUsuarioPorId(id);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/buscarUsuarioPorCorreo/{correo}")
	public Usuario obtenerUsusarioPorCorreo(@PathVariable String correo) {
		Fachada usuario = new BridgeImpl(new Cliente());
		return usuario.obtenerUsusarioPorCorreo(correo);
	}

	@RequestMapping(value = "/crearProveedor", method = RequestMethod.POST, consumes = "application/json")
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

	@RequestMapping(value = "/crearCliente", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> crearCliente(@RequestBody Usuario usuario) {
		Fachada cliente = new BridgeImpl(new Cliente());
		Usuario clienteCreated;
		try {
			clienteCreated = cliente.registrarPersona(usuario);
			return new ResponseEntity<>(clienteCreated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping("/obtenerProveedoresCercanos")
	public ResponseEntity<?> obtenerProveedoresCercanos(@RequestParam("longitud") String longitud,
			@RequestParam("latitud") String latitud, @RequestParam("servicioId") Long servicioId) {
		try {
			Fachada proveedor = new BridgeImpl(new Proveedor());
			List<Usuario> proveedores = new ArrayList<>();
			proveedores = proveedor.obtenerProveedoresCercanos(longitud, latitud, servicioId);
			// if(proveedores!=null&&!proveedores.isEmpty()) {
			return new ResponseEntity<>(proveedores, HttpStatus.OK);
			// } else {
			// return new ResponseEntity<>("No se encontraron proveedores cercanos",
			// HttpStatus.OK);
			// }
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/obtenerSolicitudPorId/{id}")
	public ResponseEntity<?> obtenerSolicitudPorId(@PathVariable Long id) {
		try {
			Fachada solicitudImpl = new BridgeImpl(new SolicitudImpl());
			Solicitud solicitud = solicitudImpl.obtenerSolicitudPorId(id);
			return new ResponseEntity<>(solicitud, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/crearSolicitud", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> crearSolicitud(@RequestBody Solicitud solicitud) {
		Fachada solicitudImpl = new BridgeImpl(new SolicitudImpl());
		Solicitud requestSolicitud = new Solicitud();
		try {
			//TODO: validar si el formato del correo es valido
			requestSolicitud = solicitudImpl.crearSolicitud(solicitud);
			return new ResponseEntity<>(requestSolicitud, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping("/obtenerSolicitudesDelCliente/{id}")
	public ResponseEntity<?> obtenerSolicitudesDelCliente(@PathVariable Long id) {
		try {
			Fachada solicitud = new BridgeImpl(new SolicitudImpl());
			List<Solicitud> solicitudes = solicitud.obtenerSolicitudesDelCliente(id);
			return new ResponseEntity<>(solicitudes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/obtenerNotificacionesPorEstado/{estado}")
	public ResponseEntity<?> obtenerNotificacionesPorEstado(@PathVariable String estado) {
		try {
			Fachada notificacion = new BridgeImpl(new NotificacionImpl());
			List<NotificacionProveedor> notificacionesProveedor = notificacion.obtenerNotificacionesPorEstado(estado);
			return new ResponseEntity<>(notificacionesProveedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/obtenerNotificacionesPorEstadoYIdProveedor")
	public ResponseEntity<?> obtenerNotificacionesPorEstadoYIdProveedor(@RequestParam("estado") String estado,
			@RequestParam("idProveedor") Long idProveedor) {
		try {
			Fachada notificacion = new BridgeImpl(new NotificacionImpl());
			List<NotificacionProveedor> notificacionesProveedor = notificacion
					.obtenerNotificacionesPorEstadoYIdProveedor(estado, idProveedor);
			return new ResponseEntity<>(notificacionesProveedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/cambioEstadoNotificacion", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> cambioEstadoNotificacion(@RequestBody NotificacionProveedorPK notificacionProveedorPK) {
		try {
			Fachada notificacion = new BridgeImpl(new NotificacionImpl());
			notificacion.cambioEstadoNotificacion(notificacionProveedorPK);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/crearCotizacion", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> crearCotizacion(@RequestBody Cotizacion cotizacion) {
		Fachada cotizacionImpl = new BridgeImpl(new CotizacionImpl());
		Cotizacion requestCotizacion = new Cotizacion();
		try {
			requestCotizacion = cotizacionImpl.crearCotizacion(cotizacion);
			return new ResponseEntity<>(requestCotizacion, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/aceptarCotizacion", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> aceptarCotizacion(@RequestBody Cotizacion cotizacion) {
		try {
			Fachada cotizacionImpl = new BridgeImpl(new CotizacionImpl());
			boolean resp = cotizacionImpl.aceptarCotizacion(cotizacion.getSolicitudId().getSolicitudId(), cotizacion.getCotizacionId());
			if (resp == true) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/rechazarCotizacion", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> rechazarCotizacion(@RequestBody Cotizacion cotizacion) {
		try {
			Fachada cotizacionImpl = new BridgeImpl(new CotizacionImpl());
			boolean resp = cotizacionImpl.rechazarCotizacion(cotizacion.getCotizacionId());
			if (resp == true) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/obtenerCotizacionesPorSolicitud/{id}")
	public ResponseEntity<?> obtenerCotizacionesPorSolicitud(@PathVariable Long id) {
		try {
			Fachada cotizacion = new BridgeImpl(new CotizacionImpl());
			List<Cotizacion> cotizaciones = cotizacion.obtenerCotizacionesPorSolicitud(id);
			return new ResponseEntity<>(cotizaciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
