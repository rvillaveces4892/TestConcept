
package co.com.uan.HogarApp.facade;

import java.util.List;

import co.com.uan.HogarApp.entities.Usuario;

public interface Fachada {
    
    public List obtenerServiciobyID(int idServicio);
    public List obtenerServicios();
    public void solicitarServicio(int identificador);
    
    public List obtenerPersonaByID(int idPersona);
    public List obtenerPersonas();
    public abstract List buscarProveedor(int servicio);
    public List<Usuario> buscarProveedoresCercanos(Long usuarioIdCliente, Long servicioId);
    public void registrarPersona(List persona);
    
    public List obtenerCategorias();
    public List obtenerCategoriaByID(int idCategoria);
    
    public void notificarProveedor(int servicio);
    public List obtenerNotificacionByEstado(String estado);
    
    public List obtenerCotizacion(int idProveedor);
    public void enviarCotizacion(int idCliente);
    
}
