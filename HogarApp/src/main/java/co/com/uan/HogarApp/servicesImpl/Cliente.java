
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Usuario;

@Component
@Configuration
public class Cliente extends Persona{

    public static final Long idrol=1L;

    public Cliente(){
        super(idrol);
    }

	


}
