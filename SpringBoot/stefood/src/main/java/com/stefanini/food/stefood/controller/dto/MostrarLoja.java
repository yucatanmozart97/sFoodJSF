package com.stefanini.food.stefood.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Usuario;

public class MostrarLoja {

	private String nome;
	private List<ProdutoMostrarDto> produtos;
	
	public MostrarLoja() {}
	
	public MostrarLoja(String nome, List<ProdutoMostrarDto> produtos) {
		this.produtos = produtos;
		this.nome = nome;
	}
	
	
	public String getNome() {
	return nome;	
	}
	
	public List<ProdutoMostrarDto> getProdutos() {
		return produtos;
	}
	
	
}
