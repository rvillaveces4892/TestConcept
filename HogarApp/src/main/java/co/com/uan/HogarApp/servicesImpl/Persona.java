
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.IPersona;

public abstract class Persona implements IPersona{

    @Autowired
    private EntityManager em;

    private Long rolId;

    public Persona(Long idRol){
        this.rolId=idRol;
    }

    public Long getRolId(){
        return rolId;
    }

    public void setRolId(Long rolId){
        this.rolId=rolId;
    }

    
    public Usuario buscarPersona(Long id) throws NotFoundException,Exception{
        Usuario persona=new Usuario();
        try{
            persona=em.find(Usuario.class,id);
            return persona;
        }
        catch(Exception e){
            throw new NotFoundException();
        }
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


    @Transactional
    @Override
    public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception{
    	Usuario existUsuario = new Usuario();
        try {
        	existUsuario = this.obtenerUsusarioPorCorreo(usuario.getCorreo());
        	if(existUsuario!=null&&existUsuario.getUsuarioId()!=null) {
        		throw new NoResultException();
        	}
			Rol rolProveedor=em.find(Rol.class,getRolId());
			usuario.setRolId(rolProveedor);
			System.out.println("Entro!"+getRolId());
			em.persist(usuario);
			return usuario;
		}catch (NoResultException e) {
			throw new NoResultException("El usuario ya existe con ese correo");
		} 
        catch (Exception e) {
        	e.printStackTrace();
			throw e;
		}
    }

    @Override
    public Usuario obtenerUsusarioPorCorreo(String correo){
    	Usuario usuario = new Usuario();
        try {
			usuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class)
			        .setParameter("correo", correo.trim()).setParameter("estado", "ACTIVO").getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return usuario;
		}
    }
    
    @Override
    public List<Usuario> consultarPersona(int identificador){
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<Usuario> consultarPersonas(){
        // TODO Auto-generated method stub
        return null;
    }

    public EntityManager getEm(){
        return em;
    }

    public void setEm(EntityManager em){
        this.em=em;
    }
}
