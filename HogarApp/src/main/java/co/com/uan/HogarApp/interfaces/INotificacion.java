
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;

public interface INotificacion {
    
    public List<NotificacionProveedor> crearNotificaciones(List<Usuario> proveedores,Solicitud solicitud);
    public List<NotificacionProveedor> listarNotificacionByEstado(String estado);
    
}
