package com.stefanini.food.stefood.controller.form;

import com.stefanini.food.stefood.modelo.Produto;
import com.stefanini.food.stefood.repository.ProdutoRepository;
import com.stefanini.food.stefood.service.ProdutoService;

public class ProdutoForm {

	private String nome;
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Produto converter() {
		return new Produto(nome, descricao);
	}
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
	Produto produto = produtoRepository.getOne(id);
	produto.setNome(nome);
	produto.setDescricao(descricao);
		return produto;
	}
	
	
}
