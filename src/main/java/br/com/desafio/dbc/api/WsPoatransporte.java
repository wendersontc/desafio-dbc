package br.com.desafio.dbc.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.desafio.dbc.util.Constants;

@FeignClient(name = "poaTransportesService", url = Constants.URL_WS_POATRANSPORTS)
public interface WsPoatransporte {
	
	@RequestMapping(value="lines", method = RequestMethod.GET,
			consumes = "application/json",
			produces = "application/json")
	String getLinesAll(
			@RequestParam(value="a") String a,
			@RequestParam(value="p") String p,
			@RequestParam(value="t") String t
    		);
	
	@RequestMapping(value="itinerat", method = RequestMethod.GET,
			consumes = "application/json",
			produces = "application/json")
	String getItinetatByCodeLine(
			@RequestParam(value="a") String a,
			@RequestParam(value="p") String p
    		);

}
