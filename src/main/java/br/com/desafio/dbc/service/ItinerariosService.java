package br.com.desafio.dbc.service;

import java.util.List;

import br.com.desafio.dbc.domain.Itinerarios;

public interface ItinerariosService extends GenericService<Itinerarios, Long>{
   
	List<Itinerarios> getAllWithIntegration(Long id);
	
	List<Itinerarios> filterDataByRate(String lat,String lgn);
}
