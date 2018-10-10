
package co.com.uan.HogarApp.servicesImpl;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Proveedor extends Persona{

    public static final Long idrol=2L;

    public Proveedor(){
        super(idrol);
    }

}
