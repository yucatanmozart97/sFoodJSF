package com.stefanini.food.stefood.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Produto;
import com.stefanini.food.stefood.controller.dto.LojaDto;

public class LojaProdutoDto {

	private Long id;
	private String nomeLoja;
	private String nomeProduto;
	private Double preco;
	
	
	public LojaProdutoDto(LojaProduto registros) {
		this.id = registros.getId();
		this.nomeLoja = registros.getLoja().getNome();
		this.nomeProduto = registros.getProduto().getNome();
		this.preco = registros.getPreco();
	}
	
	public Long getId() {
		return id;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public Double getPreco() {
		return preco;
	}
	
	
	public static List<LojaProdutoDto> converter(List<LojaProduto> registros) {
		return registros.stream().map(LojaProdutoDto::new).collect(Collectors.toList());
	}
	
	
	
	
}
