package br.com.desafio.dbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.dbc.domain.Itinerarios;

public interface ItinerariosRepository extends JpaRepository<Itinerarios, Long>{
	
	List<Itinerarios> findByLineId(Long LineId);
	
	List<Itinerarios> findByLatAndLng(String Lat,String Lng);

}
