package co.com.uan.HogarApp.services;

import java.util.List;

import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Usuario;

public interface UsuarioServices {

	public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId);

}
