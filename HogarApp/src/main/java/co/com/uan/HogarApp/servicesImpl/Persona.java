
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;
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

    @Transactional
    @Override
    public Usuario registrarPersona(Usuario usuario) throws NotFoundException, Exception{
    	Usuario existUsuario = new Usuario();
        try {
        	existUsuario = this.buscarPersona(usuario.getUsuarioId());
        	if(existUsuario != null && existUsuario.getUsuarioId()!=null) {
        		throw new NotFoundException("El usuario ya existe");
        	}
			Rol rolProveedor=em.find(Rol.class,getRolId());
			usuario.setRolId(rolProveedor);
			System.out.println("Entro!"+getRolId());
			em.persist(usuario);
			return usuario;
		}catch (NotFoundException e) {
			throw new NotFoundException("El usuario ya existe");
		} 
        catch (Exception e) {
			throw e;
		}
    }

    @Override
    public Usuario obtenerUsusarioPorCorreo(String correo){
        Usuario usuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class)
                .setParameter("correo", correo).setParameter("estado", "ACTIVO").getSingleResult();
        return usuario;
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
