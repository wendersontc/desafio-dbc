package br.com.desafio.dbc.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dbc.domain.Clientes;
import br.com.desafio.dbc.domain.Linhas;
import br.com.desafio.dbc.service.ClientesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesController {

	private final ClientesService service;

	public ClientesController(ClientesService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Cria um cliente com suas linhas")
	public Clientes create(@ApiParam(value = "Cliente", required = true) @RequestBody @Valid Clientes cliente) {
		return service.saveCliente(cliente);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Trás todas os clientes")
	public Iterable<Clientes> getAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Encontra um cliente pelo ID")
	public Clientes find(@ApiParam(value = "Id do cliente", required = true) @PathVariable Long id) {
		return service.getClientebyId(id);

	}

	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Atualiza cliente")
	public Clientes update(@ApiParam(value = "Cliente", required = true) @RequestBody @Valid Clientes cliente) {
		return service.update(cliente);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Deletar um cliente pelo ID")
	public HttpEntity<Clientes> delete(@ApiParam(value = "Id do cliente", required = true) @PathVariable Long id) {
		service.removeById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
