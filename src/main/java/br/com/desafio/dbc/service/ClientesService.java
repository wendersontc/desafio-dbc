package br.com.desafio.dbc.service;

import br.com.desafio.dbc.domain.Clientes;

public interface ClientesService extends GenericService<Clientes, Long>{
     Clientes saveCliente(Clientes cliente);
     
     Clientes getClientebyId(Long id);
}
