package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.repositories.RolRepository;
import co.com.uan.HogarApp.services.RolServices;


@Component("rolService")
@Transactional
public class RolServicesImpl implements RolServices{
	
	@Autowired
	private RolRepository rolRepository;
	
//	@Autowired
//    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;
//    private SimpleJdbcCall simpleJdbcCall;
//    
//    @PostConstruct
//    private void postConstruct() {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withProcedureName("collect_roles")
//                .returningResultSet("role_list_o",
//                        BeanPropertyRowMapper.newInstance(Rol.class));
//    }

	@Override
	public List<Rol> getRoles() {
		
//		Map<String, Object> result =
//                simpleJdbcCall.execute(new HashMap<String, Object>(0));
//        System.out.println("result: " + result);
//        return (List) result.get("role_list_o");
		return rolRepository.collect_roles();
	}

}
