
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.entities.Usuario;

public interface IPersona {
    
   public List<Usuario> consultarPersona(int identificador);
   public List<Usuario> consultarPersonas();
   public Usuario obtenerUsusarioPorCorreo(String correo);
   public Usuario buscarPersona(Long id) throws Exception;
   public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception;
   public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId);
   
}
