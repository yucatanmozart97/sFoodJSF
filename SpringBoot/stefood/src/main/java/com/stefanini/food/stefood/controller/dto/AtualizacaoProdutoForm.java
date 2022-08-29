package com.stefanini.food.stefood.controller.dto;

import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.repository.LojaProdutoRepository;

public class AtualizacaoProdutoForm {

	private Double preco;

	public AtualizacaoProdutoForm(Double preco) {
		this.preco = preco;
	}
	
	private Double getPreco() {
		return preco;
	}

	private void setPreco(Double preco) {
		this.preco = preco;
	}

	public LojaProduto atualizar(Long id, LojaProdutoRepository lojaProdutoRepository) {
		LojaProduto lojaProduto = lojaProdutoRepository.getOne(id);
		lojaProduto.setPreco(preco);
		return lojaProduto;
	}
	
	
	
}
