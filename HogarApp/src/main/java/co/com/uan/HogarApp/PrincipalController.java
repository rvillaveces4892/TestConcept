package co.com.uan.HogarApp;

import java.util.List;

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
	
	@RequestMapping("/findAllCategorias")
	public List<Categoria> findAllCategorias(){		
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategorias();
	}
	
	@RequestMapping("/findCategoriaById/{id}")
	public Categoria findCategoriaById(@PathVariable Long id){		
		Fachada categoria = new BridgeImpl(new CategoriaImpl());
		return categoria.obtenerCategoriaByID(id);
	}
	
	@RequestMapping("/findAllServicios")
	public List<Servicio> findAllServicios(){		
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicios();
	}
	
	@RequestMapping("/findServicioById/{id}")
	public Servicio findServicioById(@PathVariable Long id){		
		Fachada servicio = new BridgeImpl(new ServicioImpl());
		return servicio.obtenerServiciobyID(id);
	}
	
	@RequestMapping("/findAllServiciosByCategoriaId/{idCategoria}")
	public List<Servicio> findAllServiciosByCategoriaId(@PathVariable Long idCategoria){		
		Fachada servicios = new BridgeImpl(new ServicioImpl());
		return servicios.obtenerServicioPorCategoria(idCategoria);
	}
	
	@RequestMapping("/findAllProvedoresCercanos")
	public List<Usuario> findAllProvedoresCercanos(@RequestParam("usuarioIdCliente") Long usuarioIdCliente,
												@RequestParam("servicioId") Long servicioId){		
		Fachada proveedor = new BridgeImpl(new Proveedor());
		return proveedor.buscarProveedoresCercanos(usuarioIdCliente, servicioId);
	}
	
	@RequestMapping(value = "/proveedor/create", method = RequestMethod.POST, consumes = "application/json")
    public Usuario crearProveedor(@RequestBody Usuario usuario){
		Fachada proveedor = new BridgeImpl(new Proveedor());
        return proveedor.registrarPersona(usuario);
    }
	
	@RequestMapping(value = "/cliente/create", method = RequestMethod.POST, consumes = "application/json")
    public Usuario crearCliente(@RequestBody Usuario usuario){
		Fachada cliente = new BridgeImpl(new Cliente());
        return cliente.registrarPersona(usuario);
    }
	
	@RequestMapping("/solicitud/{id}")
	public Solicitud buscarSolicitud(@PathVariable Long id){
		System.out.println("id sol : "+id);
		Fachada solicitud = new BridgeImpl(new SolicitudImpl());
		return solicitud.buscarSolicitud(id);
	}
	
	@RequestMapping(value = "/solicitud/create", method = RequestMethod.POST, consumes = "application/json")
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud){
		Fachada solicitudImpl = new BridgeImpl(new SolicitudImpl());
        Solicitud requestSolicitud = solicitudImpl.crearSolicitud(solicitud);
        
        Fachada notificacionImpl = new BridgeImpl(new NotificacionImpl());
        List<NotificacionProveedor> notificaciones = notificacionImpl.crearNotificaciones(solicitud);
        requestSolicitud.setNotificacionProveedorList(notificaciones);
        return requestSolicitud;
    }

}
