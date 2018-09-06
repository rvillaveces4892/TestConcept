package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.repositories.UsuarioRepository;
import co.com.uan.HogarApp.services.UsuarioServices;

@Component("usuarioService")
@Transactional
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Usuario> getProveedoresCercanos(Long usuarioIdCliente, Long servicioId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prc_obtener_proveedores_cercanos")
				.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT).setParameter(1, usuarioIdCliente)
				.setParameter(2, servicioId);

		query.execute();
		List<Long> usuarioIds = new ArrayList<>();
		String commentCount = (String) query.getOutputParameterValue(3);
		if (commentCount != null && commentCount.length() > 0) {
			for (String id : commentCount.substring(1, commentCount.length()).split(":")) {
				usuarioIds.add(Long.valueOf(id));
			}
		}
		return usuarioRepository.findByUsuarioIdIn(usuarioIds);
	}
}
