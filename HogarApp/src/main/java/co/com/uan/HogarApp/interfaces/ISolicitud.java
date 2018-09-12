
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;

public interface ISolicitud {
//    public List<Servicio> listarServicio(int identificador);
//    public List<Servicio> listarServicios();
//    public void solicitarServicio(int identificador);
    public Solicitud buscarSolicitud(Long solicitudId);
	public Solicitud crearSolicitud(Solicitud solicitud);
}
