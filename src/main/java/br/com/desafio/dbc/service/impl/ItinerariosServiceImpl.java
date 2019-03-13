package br.com.desafio.dbc.service.impl;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.desafio.dbc.api.WsPoatransporte;
import br.com.desafio.dbc.domain.Itinerarios;
import br.com.desafio.dbc.dto.GeoDTO;
import br.com.desafio.dbc.repository.ItinerariosRepository;
import br.com.desafio.dbc.service.ItinerariosService;

@Service
public class ItinerariosServiceImpl extends GenericServiceImpl<Itinerarios, Long> implements ItinerariosService{
    
	@Autowired
	private ItinerariosRepository repository;
	
	@Autowired
	private WsPoatransporte integracao_api;
	
	ModelMapper mapper = new ModelMapper();
	
    @Override
	public List<Itinerarios> getAllWithIntegration(Long id) {
		List<Itinerarios> ret = null;
		if(repository.findByLineId(id).size() > 1) {
			ret = repository.findByLineId(id);
		}else {
			this.getArrayConvert(id);
			ret = repository.findByLineId(id);
		}
		return ret;
	}
    
    public void getArrayConvert(Long code){
		String geolocalizacoes = integracao_api.getItinetatByCodeLine("il", code.toString());
		if(!geolocalizacoes.contains("encontrada")) {
			String array[] = geolocalizacoes.split("\\{");
			List<String> list = Arrays.asList(array);
			
			for(int i = 2; i < list.size(); i++) {
				String bitArray[] = list.get(i).split(",");
				String objectGeo = "{"+bitArray[0]+","+bitArray[1];
				if( (list.size()-1) == i) {
					objectGeo = objectGeo.substring(0, objectGeo.length()-1);
					
				}
				Type listType = new TypeToken<GeoDTO>(){}.getType();
				GeoDTO geoData = new Gson().fromJson(objectGeo, listType);
				
				Itinerarios insert = mapper.map(geoData, Itinerarios.class);
				
				insert.setLineId(code);
				repository.save(insert);
				
			}
		}
    }

	@Override
	public List<Itinerarios> filterDataByRate(String lat, String lgn) {
		return repository.findByLatAndLng(lat, lgn);
		 
	}	
    
}
