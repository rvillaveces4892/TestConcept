
package co.com.uan.HogarApp.bridge;

import java.util.List;

import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.ICategoria;
import co.com.uan.HogarApp.interfaces.ICotizacion;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.interfaces.IPersona;
import co.com.uan.HogarApp.interfaces.IServicio;

public class BridgeImpl extends Bridge {
    
    private IServicio servicio;
    private IPersona persona;
    private ICategoria categoria;
    private ICotizacion cotizacion;
    private INotificacion notificacion;
    
    
    public BridgeImpl(IServicio servicio){
        this.servicio = servicio;
    }
    
    /*
    public BridgeImpl(IServicio servicio, IPersona persona, ICategoria categoria, ICotizacion cotizacion, INotificacion notificacion){
        this.servicio = servicio;
        this.persona = persona;
        this.categoria = categoria;
        this.cotizacion = cotizacion;
        this.notificacion = notificacion;
    }
    */
    
    public BridgeImpl(IPersona persona){
        this.persona = persona;
    }
    
    public BridgeImpl(ICategoria categoria){
        this.categoria = categoria;
    }
    
    public BridgeImpl(ICotizacion cotizacion){
        this.cotizacion = cotizacion;
    }
    
    public BridgeImpl(INotificacion notificacion){
        this.notificacion = notificacion;
    }
    

    @Override
    public List obtenerServiciobyID(int idServicio) {
        return servicio.listarServicio(idServicio);
    }

    @Override
    public List obtenerServicios() {
        return servicio.listarServicios();
    }

    @Override
    public void solicitarServicio(int identificador) {
        servicio.solicitarServicio(identificador);
    } 

    @Override
    public List obtenerPersonaByID(int idPersona) {
        return persona.consultarPersona(idPersona);
    }

    @Override
    public List obtenerPersonas() {
        return persona.consultarPersonas();
    }

    @Override
    public List buscarProveedor(int servicio) {
        return persona.buscarProveedor(4578);
    }

    @Override
    public void registrarPersona(List persona) {
        
    }

    @Override
    public List obtenerCategoriaByID(int idCategoria) {
        return categoria.listarCategoriaByID(idCategoria);
    }

    @Override
    public List obtenerCategorias() {
        return categoria.listarCategorias();
    }

    @Override
    public void notificarProveedor(int servicio) {
        
    }

    @Override
    public List obtenerNotificacionByEstado(String estado) {
        return notificacion.listarNotificacionByEstado(estado);
    }

    @Override
    public List obtenerCotizacion(int idProveedor) {
        return cotizacion.listarCotizacion(idProveedor);
    }

    @Override
    public void enviarCotizacion(int idCliente) {
        System.out.println("El proveedor se ha notificado");
    }

	@Override
	public List<Usuario> buscarProveedoresCercanos(Long usuarioIdCliente, Long servicioId) {
		return persona.getProveedoresCercanos(usuarioIdCliente, servicioId);
	}
    
}
