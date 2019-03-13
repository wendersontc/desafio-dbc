package br.com.desafio.dbc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dbc.api.WsPoatransporte;
import br.com.desafio.dbc.dto.GeoDTO;
import br.com.desafio.dbc.dto.LinhasDTO;
import io.swagger.annotations.ApiOperation;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/transportes")
public class TransportesController {
    
	@Autowired
	private WsPoatransporte api;
	
	@RequestMapping(value = "/getLinesAll", method = RequestMethod.GET)
    @ApiOperation(value = "lista todas as linhas da API")
    public List<LinhasDTO> getAll() {
		Type listType = new TypeToken<ArrayList<LinhasDTO>>(){}.getType();
		List<LinhasDTO> listLines = new Gson().fromJson(api.getLinesAll("nc", "%", "o"), listType);
        return listLines;
    }
	
	@RequestMapping(value = "/getItinetatByCodeLine/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "lista itinerário de uma linha de transporte da API")
    public HashMap<String, GeoDTO> getByCodeLine(
    		@PathVariable(value = "code") String code
    		) {
		HashMap<String, GeoDTO> geo = null;
		String geolocalizacoes = api.getItinetatByCodeLine("il", code);
		if(!geolocalizacoes.contains("encontrada")) {
			String array[] = geolocalizacoes.split("\\{");
			List<String> list = Arrays.asList(array);
			String objectString = "";
			
			for(int i = 2; i < list.size(); i++) {
				System.out.println(list.get(i));
				objectString = objectString + list.get(i)+"{";
			}
			
			Type amountCurrencyType =  
				    new TypeToken<HashMap<String, GeoDTO>>(){}.getType();
			geo =  
					new Gson().fromJson("{\r\n" +"\"0\": {" + objectString.substring(0, objectString.length() -1), amountCurrencyType);
		}
		
		return geo;
		
    }
}
