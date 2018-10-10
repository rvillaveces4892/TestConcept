
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.entities.Usuario;

public interface IPersona {
    
   public Usuario obtenerUsusarioPorCorreo(String correo);
   public Usuario obtenerPersona(Long id) throws Exception;
   public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception;
   public List<Usuario> obtenerProveedoresCercanos(String longitud, String latitud, Long servicioId);
   
}
