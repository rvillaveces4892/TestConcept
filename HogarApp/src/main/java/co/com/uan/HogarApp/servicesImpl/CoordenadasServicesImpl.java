package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.uan.HogarApp.entities.Coordenadas;
import co.com.uan.HogarApp.repositories.CoordenadaRepository;
import co.com.uan.HogarApp.services.CoordenadaServices;


@Component("coordenadaService")
@Transactional
public class CoordenadasServicesImpl implements CoordenadaServices{
	
	@Autowired
	private CoordenadaRepository coordenadaRepository;

	@Override
	public List<Coordenadas> getCoordenadas() {
		// TODO Auto-generated method stub
		return coordenadaRepository.findAll();
	}

	@Override
	public Coordenadas create(Coordenadas c) {
		// TODO Auto-generated method stub
		return coordenadaRepository.save(c);
	}

	@Override
	public List<Coordenadas> findByChriterias(String l, String e) {
		// TODO Auto-generated method stub
		return coordenadaRepository.findByLongitudAndEstado(l, e);
	}

}
