package com.stefanini.food.stefood.controller.dto;

import com.stefanini.food.stefood.modelo.Produto;

public class DetalhesProdutoDto {

	private Long id;
	private String nome;
	private String descricao;
	
	public DetalhesProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
