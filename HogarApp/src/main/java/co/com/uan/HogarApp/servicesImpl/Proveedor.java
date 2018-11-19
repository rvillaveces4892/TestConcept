
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.utils.s.Encriptor;

@Component
@Configuration
public class Proveedor extends Persona{

    public static final Long idrol=2L;

    public Proveedor(){
        super(idrol);
    }
    
	public List<Usuario> obtenerProveedoresCercanos(String longitud, String latitud, Long servicioId) {
		List<Usuario> listreturn= new  ArrayList<>();
		StoredProcedureQuery query = getEm().createStoredProcedureQuery("proveedores_cercanos")
				.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN)
				.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT).setParameter(1, longitud)
				.setParameter(2, latitud).setParameter(3, servicioId);

		query.execute();
		List<Long> usuarioIds = new ArrayList<>();
		String commentCount = (String) query.getOutputParameterValue(4);
		if (commentCount != null && commentCount.length() > 0) {
			for (String id : commentCount.substring(1, commentCount.length()).split(":")) {
				usuarioIds.add(Long.valueOf(id));
			}
			Query findByUsuarioIdIn = getEm().createNamedQuery("Usuario.findByUsuarioIdIn");
			findByUsuarioIdIn.setParameter("usuarioIds", usuarioIds);
			listreturn = (List<Usuario>) findByUsuarioIdIn.getResultList();
			for (int i = 0; i < listreturn.size(); i++) {
				try {
					listreturn.get(i).setPassword(Encriptor.decrypt(listreturn.get(i).getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return listreturn;

	}

}
