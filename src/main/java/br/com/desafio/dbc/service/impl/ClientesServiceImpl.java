package br.com.desafio.dbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.dbc.domain.Clientes;
import br.com.desafio.dbc.repository.ClientesRepository;
import br.com.desafio.dbc.service.ClientesService;

@Service
public class ClientesServiceImpl extends GenericServiceImpl<Clientes, Long> implements ClientesService{
    @Autowired
    private ClientesRepository repository;
    
	@Override
	public Clientes saveCliente(Clientes cliente) {
		return repository.save(cliente);
	}

	@Override
	public Clientes getClientebyId(Long id) {
		return repository.getOne(id);
	}

}
