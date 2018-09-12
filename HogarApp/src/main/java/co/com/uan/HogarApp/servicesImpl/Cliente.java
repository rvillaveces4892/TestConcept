
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Usuario;


@Component
@Configuration
public class Cliente extends Persona {

	public static final Long idrol = 1L;

	public Cliente() {
		super(idrol);
	}

	@Override
	public List<Cliente> consultarPersona(int identificador) {
		List<Cliente> cliente = new ArrayList<>();
//		setNombres("Eduardo");
//		setApellidos("Michaela");
		cliente.add(this);
		return cliente;
	}

	@Override
	public List<Cliente> consultarPersonas() {
		List<Cliente> cliente = new ArrayList<>();
//		setNombres("Eduardo");
//		setApellidos("Michaela");
		cliente.add(this);
//		setNombres("Martina");
//		setApellidos("Mendez");
		cliente.add(this);
		return cliente;
	}

	@Override
	public List buscarProveedor(int servicio) {
		throw new UnsupportedOperationException("No es aplicable");
	}

	@Override
	public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
