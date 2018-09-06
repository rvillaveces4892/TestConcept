
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Servicio;

public interface IServicio {
    public List<Servicio> listarServicio(int identificador);
    public List<Servicio> listarServicios();
    public void solicitarServicio(int identificador);
}
