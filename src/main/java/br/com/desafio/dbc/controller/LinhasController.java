package br.com.desafio.dbc.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dbc.domain.Linhas;
import br.com.desafio.dbc.service.LinhasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/linhas")
public class LinhasController {
	
	private final LinhasService service;
	
	@Autowired
    public LinhasController(LinhasService service) {
        this.service = service;
    }
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ApiOperation(value = "Trás todas as linhas, fazendo a integração com a API externa")
    public Iterable<Linhas> getAll() {
        return service.getAllWithIntegration();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Encontra uma linha pelo ID")
    public Linhas find(@ApiParam(value = "Id da Linha", required = true) @PathVariable Long id) {
        Linhas linhas = service.getById(id);
        if (linhas == null) {
            throw new EntityNotFoundException("linha.nao.existe");
        } else {
            return linhas;
        }
    }
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca linhas pelo nome")
    public List<Linhas> searchByNome(
            @ApiParam(value = "Nome da linha", required = true)
            @PathVariable(name = "nome") @NotNull(message = "Nao pode ser nulo")  String nome) {
        return service.searchByNomeIgnoreCase(nome);
    }

}
