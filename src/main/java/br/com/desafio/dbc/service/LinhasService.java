package br.com.desafio.dbc.service;

import java.util.List;

import br.com.desafio.dbc.domain.Linhas;

public interface LinhasService extends GenericService<Linhas, Long>{
	
	List<Linhas> getAllWithIntegration();
    Linhas getById(Long id);
    List<Linhas> searchByNomeIgnoreCase(String nome);
}
