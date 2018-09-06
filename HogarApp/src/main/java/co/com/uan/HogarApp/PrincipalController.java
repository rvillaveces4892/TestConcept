package co.com.uan.HogarApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.uan.HogarApp.bridge.BridgeImpl;
import co.com.uan.HogarApp.entities.Coordenadas;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.facade.Fachada;
import co.com.uan.HogarApp.services.CoordenadaServices;
import co.com.uan.HogarApp.services.ServicioServices;
import co.com.uan.HogarApp.servicesImpl.Persona;
import co.com.uan.HogarApp.servicesImpl.Proveedor;

@RestController
public class PrincipalController {
	
	@Autowired
	private CoordenadaServices coordenadaService;
	
	@Autowired
	private ServicioServices servicioService;
	
	@Autowired
	private Persona usuarioService;
	
	@RequestMapping("/hola")
	public String obtenerProveedoresCercanos() {
		return "proveedores";
	}
	
	@RequestMapping("/crearProveedor")
	public void crearProveedor() {
		Usuario userProveedor = new Usuario();
		userProveedor.setUsuarioId(1L);
		
//		return "proveedores";
	}
	@RequestMapping("/findAllCoordenadas")
	public List<Coordenadas> findAllCoordenadas(){		
		return coordenadaService.getCoordenadas();
	}
	
	@RequestMapping("/findC")
	public List<Coordenadas> findC(@RequestParam("l") String longitud,
									@RequestParam("e") String estado){
		return coordenadaService.findByChriterias(longitud, estado);
	}
	
	@RequestMapping("/findAllServicio")
	public List<Servicio> findAll(){
		return servicioService.getServicios();
	}

//	@RequestMapping("/findAllProvedoresCercanos")
//	public List<Usuario> findAllProvedoresCercanos(@RequestParam("usuarioIdCliente") Long usuarioIdCliente,
//												@RequestParam("servicioId") Long servicioId){
//		return usuarioService.getProveedoresCercanos(usuarioIdCliente, servicioId);
//	}
	
	@RequestMapping("/findAllProvedoresCercanos")
	public List<Usuario> findAllProvedoresCercanos(@RequestParam("usuarioIdCliente") Long usuarioIdCliente,
												@RequestParam("servicioId") Long servicioId){
		Fachada proveedor = new BridgeImpl(new Proveedor());
//	    System.out.println(proveedor.obtenerPersonaByID(524));
		return proveedor.buscarProveedoresCercanos(usuarioIdCliente, servicioId);
	}
	
	@RequestMapping(value = "/usuario/create", method = RequestMethod.POST)
    public String newUsuario(@RequestBody Usuario usuario){
		System.out.println(usuario.getNombres());
//        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

}
