
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Usuario;

@Component
@Configuration
public class Proveedor extends Persona {

	public static final Long idrol = 2L;

	public Proveedor() {
		super(idrol);
	}

	@Override
	public List<Usuario> getProveedoresCercanos(String longitud, String latitud, Long servicioId) {
		StoredProcedureQuery query = getEm().createStoredProcedureQuery("prc_obtener_proveedores_cercanos")
				.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT)
				.setParameter(1, longitud)
				.setParameter(2, latitud)
				.setParameter(3, servicioId);

		query.execute();
		List<Long> usuarioIds = new ArrayList<>();
		String commentCount = (String) query.getOutputParameterValue(4);
		if (commentCount != null && commentCount.length() > 0) {
			for (String id : commentCount.substring(1, commentCount.length()).split(":")) {
				usuarioIds.add(Long.valueOf(id));
			}
		}

		Query findByUsuarioIdIn = getEm().createNamedQuery("Usuario.findByUsuarioIdIn");
		findByUsuarioIdIn.setParameter("usuarioIds", usuarioIds);
		return (List<Usuario>) findByUsuarioIdIn.getResultList();

	}

}
