
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Servicio;

public interface IServicio {
	public List<Servicio> obtenerServicios();
    public Servicio obtenerServiciobyID(Long servicioId);
    public List<Servicio> obtenerServicioPorCategoria(Long categoriaId);
    
}
