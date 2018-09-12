
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.interfaces.IServicio;

@Component
@Configuration
public class ServicioImpl implements IServicio {

	@Autowired
	private EntityManager em;

	public ServicioImpl() {
	}

	@Override
	public List<Servicio> obtenerServicios() {
		List<Servicio> servicios = em.createNamedQuery("Servicio.findAll", Servicio.class)
				.setParameter("estado", "ACTIVO").getResultList();
		return servicios;
	}

	@Override
	public Servicio obtenerServiciobyID(Long servicioId) {
		Servicio servicio = em.createNamedQuery("Servicio.findByServicioId", Servicio.class)
		.setParameter("servicioId", servicioId).setParameter("estado", "ACTIVO").getSingleResult();
		return servicio;
	}

	@Override
	public List<Servicio> obtenerServicioPorCategoria(Long categoriaId) {
		List<Servicio> servicios = em.createNamedQuery("Servicio.findBycategoriaIdAndEstado", Servicio.class)
				.setParameter("categoriaId", categoriaId).setParameter("estado", "ACTIVO").getResultList();
		return servicios;
	}

}
