
package co.com.uan.HogarApp.bridge;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import co.com.uan.HogarApp.ApplicationContextHolder;
import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.NotificacionProveedor;
import co.com.uan.HogarApp.entities.NotificacionProveedorPK;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.entities.Usuario;
import co.com.uan.HogarApp.interfaces.ICategoria;
import co.com.uan.HogarApp.interfaces.ICotizacion;
import co.com.uan.HogarApp.interfaces.INotificacion;
import co.com.uan.HogarApp.interfaces.IPersona;
import co.com.uan.HogarApp.interfaces.IServicio;
import co.com.uan.HogarApp.interfaces.ISolicitud;
import co.com.uan.HogarApp.servicesImpl.CategoriaImpl;
import co.com.uan.HogarApp.servicesImpl.Cliente;
import co.com.uan.HogarApp.servicesImpl.CotizacionImpl;
import co.com.uan.HogarApp.servicesImpl.NotificacionImpl;
import co.com.uan.HogarApp.servicesImpl.Proveedor;
import co.com.uan.HogarApp.servicesImpl.ServicioImpl;
import co.com.uan.HogarApp.servicesImpl.SolicitudImpl;
import co.com.uan.HogarApp.utils.s.Encriptor;

public class BridgeImpl extends Bridge{

    private IServicio servicio;
    private IPersona persona;
    private ICategoria categoria;
    private ICotizacion cotizacion;
    private INotificacion notificacion;
    private ISolicitud solicitudImpl;

    public BridgeImpl(){

    }

    public BridgeImpl(IServicio servicio){
        this.servicio=ApplicationContextHolder.getContext().getBean(servicio.getClass());
    }

    public BridgeImpl(IPersona persona){
        this.persona=ApplicationContextHolder.getContext().getBean(persona.getClass());
    }

    public BridgeImpl(ISolicitud solicitud){
        this.solicitudImpl=ApplicationContextHolder.getContext().getBean(SolicitudImpl.class);
    }

    public BridgeImpl(ICategoria categoria){
        this.categoria=ApplicationContextHolder.getContext().getBean(CategoriaImpl.class);
    }

    public BridgeImpl(ICotizacion cotizacion){
        this.cotizacion=ApplicationContextHolder.getContext().getBean(CotizacionImpl.class);
    }

    public BridgeImpl(INotificacion notificacion){
        this.notificacion=ApplicationContextHolder.getContext().getBean(NotificacionImpl.class);
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long idCategoria){
        return this.categoria.obtenerCategoriaPorId(idCategoria);
    }

    @Override
    public List<Categoria> obtenerCategorias(){
        return this.categoria.obtenerCategorias();
    }

    @Override
    public Servicio obtenerServicioPorId(Long servicioId){
        Servicio servicio=this.servicio.obtenerServicioPorId(servicioId);
        return servicio;
    }

    @Override
    public List<Servicio> obtenerServicios(){
        List<Servicio> servicios=this.servicio.obtenerServicios();
        return servicios;
    }

    @Override
    public List<Servicio> obtenerServicioPorCategoria(Long categoriaId){
        List<Servicio> servicios=this.servicio.obtenerServicioPorCategoria(categoriaId);
        return servicios;
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long usuario_id) throws Exception{
        Usuario usuario=this.persona.obtenerPersona(usuario_id);
        return usuario;
    }

    @Override
    public Usuario obtenerUsusarioPorCorreo(String correo){
        Usuario usuario=this.persona.obtenerUsusarioPorCorreo(correo);
        return usuario;
    }

    @Override
    public Usuario registrarPersona(Usuario usuario) throws NotFoundException,Exception{
        Usuario usuarioCreated = persona.registrarPersona(usuario);
        usuarioCreated.setPassword(Encriptor.decrypt(usuarioCreated.getPassword()));
        return usuarioCreated;
    }

    @Override
    public List<Usuario> obtenerProveedoresCercanos(String longitud,String latitud,Long servicioId){
        return persona.obtenerProveedoresCercanos(longitud,latitud,servicioId);
    }

    @Override
    public Solicitud obtenerSolicitudPorId(Long solicitudId){
        return solicitudImpl.obtenerSolicitud(solicitudId);
    }

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) throws Exception{
        this.servicio=ApplicationContextHolder.getContext().getBean(ServicioImpl.class);
        this.notificacion=ApplicationContextHolder.getContext().getBean(INotificacion.class);
        Servicio servicio=this.servicio.obtenerServicioPorId(solicitud.getServicioId().getServicioId());
        solicitud.setServicioId(servicio);
        Solicitud solicitudCreated=solicitudImpl.crearSolicitud(solicitud);
        List<NotificacionProveedor> notificaciones=crearNotificaciones(solicitud);
        solicitudCreated.setNotificacionProveedorList(notificaciones);
        return solicitudCreated;
    }

    @Override
    public List<Solicitud> obtenerSolicitudesDelCliente(Long usuario_id){
        return solicitudImpl.obtenerSolicitudesDelCliente(usuario_id);
    }

    @Override
    public List<NotificacionProveedor> obtenerNotificacionesPorEstado(String estado){
        return notificacion.obtenerNotificacionesPorEstado(estado);
    }
    
    @Override
    public List<NotificacionProveedor> obtenerNotificacionesPorEstadoYIdProveedor(String estado, Long idProveedor){
        return notificacion.obtenerNotificacionesPorEstadoYIdProveedor(estado, idProveedor);
    }
    
    @Override
    public void cambioEstadoNotificacion(NotificacionProveedorPK notificacionProveedorPK) throws Exception{
        notificacion.cambioEstadoNotificacion(notificacionProveedorPK);
    }

    @Override
    public List<NotificacionProveedor> crearNotificaciones(Solicitud solicitud) throws Exception{
        this.persona=ApplicationContextHolder.getContext().getBean(Proveedor.class);
        List<Usuario> proveedores=new ArrayList<>();
        if(solicitud.getUsuarioIdProveedor()!=null&&solicitud.getUsuarioIdProveedor().getUsuarioId()!=null){
            proveedores.add(this.persona.obtenerPersona(solicitud.getUsuarioIdProveedor().getUsuarioId()));
        }
        else{
            proveedores=this.persona.obtenerProveedoresCercanos(solicitud.getLongitud(),solicitud.getLatitud(),solicitud.getServicioId().getServicioId());
        }
        List<NotificacionProveedor> notificaciones=this.notificacion.crearNotificaciones(proveedores,solicitud);
        return notificaciones;
    }

    @Override
    public Cotizacion crearCotizacion(Cotizacion cotizacion) throws Exception,IllegalArgumentException{
        Cotizacion cotizacionCreated=this.cotizacion.crearCotizacion(cotizacion);
        return cotizacionCreated;
    }

    @Override
    public boolean aceptarCotizacion(Long solicitud_id,Long cotizacion_id){
    	
        return this.cotizacion.aceptarCotizacion(solicitud_id,cotizacion_id);
    }

    @Override
    public boolean rechazarCotizacion(Long cotizacion_id){
        return this.cotizacion.rechazarCotizacion(cotizacion_id);
    }

    @Override
    public List<Cotizacion> obtenerCotizacionesPorSolicitud(Long solicitud_id){
        List<Cotizacion> list=this.cotizacion.obtenerCotizacionPorSolicitud(solicitud_id);
        return list;
    }

}
