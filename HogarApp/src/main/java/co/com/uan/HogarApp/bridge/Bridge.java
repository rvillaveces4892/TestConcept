
package co.com.uan.HogarApp.bridge;

import java.util.List;

import co.com.uan.HogarApp.facade.Fachada;


public abstract class Bridge implements Fachada {

    // Servicios
    
    @Override
    public abstract List obtenerServiciobyID(int idServicio);

    @Override
    public abstract List obtenerServicios();

    @Override
    public abstract void solicitarServicio(int identificador);
    
    //Personas (Cliente y Proveedor)

    @Override
    public abstract List obtenerPersonaByID(int idPersona);

    @Override
    public abstract List obtenerPersonas();

    @Override
    public abstract List buscarProveedor(int servicio);

    @Override
    public abstract void registrarPersona(List persona);
    
    
    //Categorías

    @Override
    public abstract List obtenerCategoriaByID(int idCategoria);

    @Override
    public abstract List obtenerCategorias();
    
    //Notificaciones

    @Override
    public abstract void notificarProveedor(int servicio);

    @Override
    public abstract List obtenerNotificacionByEstado(String estado);
    
    
    //Cotizaciones

    @Override
    public abstract List obtenerCotizacion(int idProveedor);

    @Override
    public abstract void enviarCotizacion(int idCliente);
      
}
