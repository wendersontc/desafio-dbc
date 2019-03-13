package br.com.desafio.dbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.dbc.domain.Linhas;

public interface LinhasRepository extends JpaRepository<Linhas, Long>{
	
	@Query(value = "SELECT l FROM Linhas l WHERE LOWER(l.nome) LIKE %?1%")
    List<Linhas> searchByNomeIgnoreCase(String nome);
}
