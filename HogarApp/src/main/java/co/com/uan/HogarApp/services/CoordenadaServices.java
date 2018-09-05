package co.com.uan.HogarApp.services;

import java.util.List;

import co.com.uan.HogarApp.entities.Coordenadas;

public interface CoordenadaServices {
	
	List<Coordenadas> getCoordenadas();
	
	Coordenadas create(Coordenadas c);
	
	List<Coordenadas> findByChriterias(String d, String e);

}
