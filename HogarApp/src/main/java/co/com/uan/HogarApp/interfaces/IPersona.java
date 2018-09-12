
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Usuario;

public interface IPersona {
    
   public List<?> consultarPersona(int identificador);
   public List<?> consultarPersonas();
   public List<?> buscarProveedor(int servicio);
   public Usuario buscarPersona(Long id);
   public Usuario registrarPersona(Usuario usuario);
   public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId);
   
}
