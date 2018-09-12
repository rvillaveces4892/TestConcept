
package co.com.uan.HogarApp.bridge;

import java.util.List;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.facade.Fachada;


public abstract class Bridge implements Fachada {

    // Servicios
	public abstract List<Servicio> obtenerServicios();
    public abstract Servicio obtenerServiciobyID(Long servicioId);
    public abstract List<Servicio> obtenerServicioPorCategoria(Long categoriaId);
    
    //Personas (Cliente y Proveedor)

    @Override
    public abstract List obtenerPersonaByID(int idPersona);

    


    @Override
    public abstract Usuario registrarPersona(Usuario usuario);
    
    
    //Categorías
    @Override
    public abstract Categoria obtenerCategoriaByID(Long idCategoria);

    @Override
    public abstract List<Categoria> obtenerCategorias();
    
    //Notificaciones
    @Override
    public abstract List<NotificacionProveedor> obtenerNotificacionByEstado(String estado);
    
    @Override
    public abstract List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud);
    
    //Cotizaciones
    @Override
    public abstract List obtenerCotizacion(int idProveedor);

    @Override
    public abstract void enviarCotizacion(int idCliente);
    
    //solicitud
    public abstract Solicitud buscarSolicitud(Long solicitudId);
    
    public abstract Solicitud crearSolicitud(Solicitud solicitud); 
    
    
      
}
