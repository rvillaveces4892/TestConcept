
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.interfaces.ICategoria;
import co.com.uan.HogarApp.interfaces.IServicio;

@Component
@Configuration
public class CategoriaImpl implements ICategoria {

	@Autowired
	private EntityManager em;

	public CategoriaImpl() {
	}

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = em.createNamedQuery("Categoria.findAll", Categoria.class)
				.setParameter("estado", "ACTIVO").getResultList();
		return categorias;
	}

	@Override
	public Categoria findCategoriaByID(Long idCategoria) {
		Categoria categoria = em.createNamedQuery("Categoria.findByCategoriaId", Categoria.class)
				.setParameter("categoriaId", idCategoria).setParameter("estado", "ACTIVO").getSingleResult();
		return categoria;
	}
	
}
