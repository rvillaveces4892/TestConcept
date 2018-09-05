package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.uan.HogarApp.entities.Coordenadas;
import co.com.uan.HogarApp.entities.Servicio;
import co.com.uan.HogarApp.repositories.ServicioRepository;
import co.com.uan.HogarApp.services.ServicioServices;


@Component("servicioService")
@Transactional
public class ServicioServicesImpl implements ServicioServices{
	
	@Autowired
	private ServicioRepository servicioRepository;

	@Override
	public List<Servicio> getServicios() {
		// TODO Auto-generated method stub
		return servicioRepository.findAll();
	}

//	@Override
//	public Coordenadas create(Coordenadas c) {
//		// TODO Auto-generated method stub
//		return coordenadaRepository.save(c);
//	}
//
//	@Override
//	public List<Coordenadas> findByChriterias(String l, String e) {
//		// TODO Auto-generated method stub
//		return coordenadaRepository.findByLongitudAndEstado(l, e);
//	}

}
