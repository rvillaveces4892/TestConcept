package co.com.uan.HogarApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import co.com.uan.HogarApp.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByUsuarioIdIn(List<Long> usuarioIds);
	
	@Procedure(procedureName = "prc_obtener_proveedores_cercanos")
	String prc_obtener_proveedores_cercanos(Integer id_cliente, Integer id_servicio, String ids);
	
	@Procedure
	String calcular(@Param("id_cliente") Integer id_cliente, @Param("id_servicio") Integer id_servicio);

}
