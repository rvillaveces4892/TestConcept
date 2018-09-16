
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Rol;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.ICotizacion;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.interfaces.ISolicitud;

@Component
@Configuration
public class CotizacionImpl implements ICotizacion {

	@Autowired
	private EntityManager em;

	public CotizacionImpl() {
	}

	@Override
	public List<Cotizacion> listarCotizacion(int idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enviarCotizacion(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	

}
