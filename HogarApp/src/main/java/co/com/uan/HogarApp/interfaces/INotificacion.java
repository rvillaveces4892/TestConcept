
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.NotificacionProveedor;

public interface INotificacion {
    
    public void notificarProveedor(int servicio);
    public List<NotificacionProveedor> listarNotificacionByEstado(String estado);
    
}
