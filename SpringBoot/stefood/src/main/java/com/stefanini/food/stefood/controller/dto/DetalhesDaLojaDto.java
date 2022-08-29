package com.stefanini.food.stefood.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Produto;

public class DetalhesDaLojaDto {

	private Long id;
	private String nome;
	private String descricao;
	private String cnpj;
	private String endereco;
	
	
	
	public DetalhesDaLojaDto(Loja loja) {
		this.id = loja.getId();
		this.nome = loja.getNome();
		this.descricao = loja.getDescricao();
		this.cnpj = loja.getCnpj();
		this.endereco = loja.getEndereco();
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

	public String getCnpj() {
		return cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

}
