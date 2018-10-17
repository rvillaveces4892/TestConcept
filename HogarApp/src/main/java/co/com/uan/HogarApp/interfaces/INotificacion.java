
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;

public interface INotificacion {
    
    public List<NotificacionProveedor> crearNotificaciones(List<Usuario> proveedores,Solicitud solicitud);
    public List<NotificacionProveedor> obtenerNotificacionesPorEstado(String estado);
    public List<NotificacionProveedor> obtenerNotificacionesPorEstadoYIdProveedor(String estado,Long idProveedor);
    public void cambioEstadoNotificacion(NotificacionProveedorPK notificacionProveedorPK) throws Exception;
    
}
