package br.com.desafio.dbc.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LINHAS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Linhas {
    
	@Id
	private Long id;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "nome")
	private String nome;
	
}
