package br.com.desafio.dbc.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.desafio.dbc.api.WsPoatransporte;
import br.com.desafio.dbc.domain.Linhas;
import br.com.desafio.dbc.dto.LinhasDTO;
import br.com.desafio.dbc.repository.LinhasRepository;
import br.com.desafio.dbc.service.LinhasService;

@Service
public class LinhasServiceImpl extends GenericServiceImpl<Linhas, Long> implements LinhasService{
    
	@Autowired
	private LinhasRepository repository;
	
	@Autowired
	private WsPoatransporte integracao_api;
	
	ModelMapper mapper = new ModelMapper();
	
	
	@Override
	public List<Linhas> getAllWithIntegration() {
		List<Linhas> ret = null;
		if(repository.findAll().size() > 1) {
			ret = repository.findAll();
			List<Linhas> newList = this.getArrayConvert();
			if(ret.equals(newList)) {
				ret = repository.saveAll(newList);
			}
		}else {
			ret = this.getArrayConvert();
			repository.saveAll(ret);
		}
		return ret;
	}

	@Override
	public Linhas getById(Long id) {
		return repository.getOne(id);
	}
	
	public List<Linhas> getArrayConvert(){
		Type listType = new TypeToken<ArrayList<LinhasDTO>>(){}.getType();
		List<LinhasDTO> listLines = new Gson().fromJson(integracao_api.getLinesAll("nc", "%", "o"), listType);
        
		Type listTypeConv = new TypeToken<List<Linhas>>() {}.getType();
		return mapper.map(listLines, listTypeConv);
	}

	@Override
	public List<Linhas> searchByNomeIgnoreCase(String nome) {
		return repository.searchByNomeIgnoreCase(nome);
	}

}
