
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Solicitud;

public interface ISolicitud{
    public Solicitud obtenerSolicitud(Long solicitudId);
    public Solicitud crearSolicitud(Solicitud solicitud);
    public List<Solicitud> obtenerSolicitudesDelCliente(Long usuario_id);
}
