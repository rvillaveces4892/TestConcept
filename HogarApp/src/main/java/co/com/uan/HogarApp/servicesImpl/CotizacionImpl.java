
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.interfaces.ICotizacion;

@Component
@Configuration
public class CotizacionImpl implements ICotizacion{

    @Autowired
    private EntityManager em;

    public CotizacionImpl(){
    }

    @Override
    public Cotizacion crearCotizacion(Cotizacion cotizacion){
        em.persist(cotizacion);
        return cotizacion;
    }

    @Override
    public boolean aceptarCotizacion(Long solicitud_id,Long cotizacion_id){
        try{
            em.createNativeQuery("UPDATE COTIZACION SET ESTADO = 'RECHAZADA' WHERE SOLICITUD_ID = ? AND COTIZACION_ID != ?").setParameter(0,solicitud_id).setParameter(1,cotizacion_id);
            em.createNativeQuery("UPDATE COTIZACION SET ESTADO = 'ACEPTADA' WHERE COTIZACION_ID = ?").setParameter(0,cotizacion_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Cotizacion> obtenerCotizacionPorSolicitud(Long solicitud_id){
        Query findCotizacionBySolicitud=em.createNamedQuery("Cotizacion.findCotizacionsBySolicitud");
        findCotizacionBySolicitud.setParameter("solicitudId",solicitud_id);
        return (List<Cotizacion>)findCotizacionBySolicitud.getResultList();
    }

    @Override
    public boolean rechazarCotizacion(Long cotizacion_id){
        try{
            em.createNativeQuery("UPDATE COTIZACION SET ESTADO = 'RECHAZADA' WHERE COTIZACION_ID = ?").setParameter(0,cotizacion_id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
