
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Usuario;

public interface IPersona {
    
   public List<?> consultarPersona(int identificador);
   public List<?> consultarPersonas();
   public List<?> buscarProveedor(int servicio);
   public void registrarPersona(List<?> persona);
   public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId);
   
}
