package com.stefanini.food.stefood.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Produto;

public class ProdutoMostrarDto {

	private String nome;
	private String descricao;
	private Double preco;
	
	public ProdutoMostrarDto() {}
	
	
	
	public ProdutoMostrarDto(LojaProduto lista) {
		this.nome = lista.getProduto().getNome();
		this.descricao = lista.getProduto().getDescricao();
		this.preco = lista.getPreco();
	}



	private String getNome() {
		return nome;
	}

	private String getDescricao() {
		return descricao;
	}

	private Double getPreco() {
		return preco;
	}
	
	public static List<ProdutoMostrarDto> converter(List<LojaProduto> registros) {
		return registros.stream().map(ProdutoMostrarDto::new).collect(Collectors.toList());
	}
	
}
