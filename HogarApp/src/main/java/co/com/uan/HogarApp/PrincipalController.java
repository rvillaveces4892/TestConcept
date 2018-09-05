package co.com.uan.HogarApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.uan.HogarApp.entities.Coordenadas;
import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.services.CoordenadaServices;
import co.com.uan.HogarApp.services.RolServices;
import co.com.uan.HogarApp.services.ServicioServices;

@RestController
public class PrincipalController {
	
	@Autowired
	private CoordenadaServices coordenadaService;
	
	@Autowired
	private ServicioServices servicioService;
	
	@Autowired
	private RolServices rolService;
	
	
	
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

	@RequestMapping("/findAllRoles")
	public List<Rol> findAllRoles(){
//		AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
		return rolService.getRoles();
	}

}
