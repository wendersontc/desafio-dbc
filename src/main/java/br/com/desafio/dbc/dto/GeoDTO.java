package br.com.desafio.dbc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonSerialize
@ToString
public class GeoDTO implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lat;
	private String lng;
}
