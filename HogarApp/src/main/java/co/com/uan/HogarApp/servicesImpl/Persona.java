
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.IPersona;



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
	
	public Usuario buscarPersona(Long id) {
		Usuario persona = em.find(Usuario.class, id);
		return persona;
	}
	

	@Transactional
	@Override
	public Usuario registrarPersona(Usuario usuario) {
		Rol rolProveedor = em.find(Rol.class, getRolId());
		usuario.setRolId(rolProveedor);
		System.out.println("Entro!" + getRolId());
		em.persist(usuario);
		return usuario;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<?> consultarPersona(int identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> consultarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> buscarProveedor(int servicio) {
		// TODO Auto-generated method stub
		return null;
	}

}
