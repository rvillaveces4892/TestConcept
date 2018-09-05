package co.com.uan.HogarApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import co.com.uan.HogarApp.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
	
	@Procedure(name = "Rol.findRolesViaProcedure")
	List<Rol> collect_roles();

}
