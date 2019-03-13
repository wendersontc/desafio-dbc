package br.com.desafio.dbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dbc.domain.Itinerarios;
import br.com.desafio.dbc.service.ItinerariosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/itinerarios")
public class ItinerariosController {
	
	private final ItinerariosService service;
	
	@Autowired
    public ItinerariosController(ItinerariosService service) {
        this.service = service;
    }
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Encontra uma linha pelo ID")
    public List<Itinerarios> find(@ApiParam(value = "Id da Linha", required = true) @PathVariable Long id) {
        return service.getAllWithIntegration(id);
        
    }
	
	@RequestMapping(value = "/{unit}/{lat}/{lng}/{rate}", method = RequestMethod.GET)
    @ApiOperation(value = "Encontra uma linha pelo ID")
    public List<Itinerarios> filterDataByRate(@ApiParam(value = "Id da Linha", required = true) 
    @PathVariable String unit,
    @PathVariable String lat,
    @PathVariable String lng,
    @PathVariable String rate
    ) {
        return service.filterDataByRate(lat,lng);
        
    }
}
