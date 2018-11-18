
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.IPersona;
import co.com.uan.HogarApp.utils.s.Encriptor;

public abstract class Persona implements IPersona {

	@Autowired
	private EntityManager em;

	private Long rolId;

	public Persona(Long idRol) {
		this.rolId = idRol;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public Usuario obtenerPersona(Long id) throws NotFoundException, Exception {
		Usuario persona = new Usuario();
		try {
			persona = em.find(Usuario.class, id);
			persona.setPassword(Encriptor.decrypt(persona.getPassword()));
			return persona;
		} catch (Exception e) {
			throw new NotFoundException("EL usuario ["+id+"] no existe.");
		}
	}

	@Transactional
	@Override
	public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception {
		Usuario existUsuario = new Usuario();
		List<Long> idServices = new ArrayList<>();
		try {
			existUsuario = this.obtenerUsusarioPorCorreo(usuario.getCorreo());
			if (existUsuario != null && existUsuario.getUsuarioId() != null) {
				throw new NoResultException();
			}
			idServices.addAll(usuario.getServicesId());
			Rol rolProveedor = em.find(Rol.class, getRolId());
			usuario.setRolId(rolProveedor);
			usuario.setPassword(Encriptor.encrypt(usuario.getPassword()));
			em.persist(usuario);
			em.flush();
			if (getRolId() == 2L && idServices != null && !idServices.isEmpty()) {
				for (Long idSer : idServices) {
					em.createNativeQuery(
							"Insert into SERVICIO_PROVEEDOR (SERVICIO_ID,USUARIO_ID_PROVEEDOR) values (:a,:b)")
							.setParameter("a", idSer).setParameter("b", usuario.getUsuarioId()).executeUpdate();
				}
			}
			return usuario;
		} catch (NoResultException e) {
			throw new NoResultException("El usuario ya existe con ese correo");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Usuario obtenerUsusarioPorCorreo(String correo) {
		Usuario usuario = new Usuario();
		try {
			usuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class).setParameter("correo", correo.trim())
					.setParameter("estado", "ACTIVO").getSingleResult();
			usuario.setPassword(Encriptor.decrypt(usuario.getPassword()));
			return usuario;
		} catch (NoResultException e) {
			return usuario;
		} catch (Exception e) {
			return usuario;
		}
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> obtenerProveedoresCercanos(String longitud, String latitud, Long servicioId) {
		return null;
	}

	
	
}
