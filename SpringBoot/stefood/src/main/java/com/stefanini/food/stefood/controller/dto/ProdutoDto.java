package com.stefanini.food.stefood.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;

	
	public ProdutoDto(Produto produtos) {
		this.id = produtos.getId();
		this.nome = produtos.getNome();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	
	
	
}
