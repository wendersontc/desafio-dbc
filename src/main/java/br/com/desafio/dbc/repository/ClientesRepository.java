package br.com.desafio.dbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.dbc.domain.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
