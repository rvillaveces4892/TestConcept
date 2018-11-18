
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Cotizacion;
import co.com.uan.HogarApp.entities.Solicitud;
import co.com.uan.HogarApp.interfaces.ISolicitud;

@Component
@Configuration
public class SolicitudImpl implements ISolicitud{

    @Autowired
    private EntityManager em;

    public SolicitudImpl(){
    }

    @Transactional
    @Override
    public Solicitud crearSolicitud(Solicitud solicitud){
        em.persist(solicitud);
        return solicitud;
    }

    @Override
    public Solicitud obtenerSolicitud(Long solicitudId){
        Solicitud solicitud=em.find(Solicitud.class, solicitudId);
        return solicitud;

    }

    @Override
    public List<Solicitud> obtenerSolicitudesDelCliente(Long usuario_id){
        Query solicitudes=em.createNamedQuery("Solicitud.findByCliente");
        solicitudes.setParameter("usuarioIdCliente",usuario_id);
        return (List<Solicitud>)solicitudes.getResultList();
    }
}
