
package co.com.uan.HogarApp.servicesImpl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Cliente extends Persona{

    public static final Long idrol=1L;

    public Cliente(){
        super(idrol);
    }

}
