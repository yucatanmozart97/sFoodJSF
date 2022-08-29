package com.stefanini.food.stefood.controller.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.stefanini.food.stefood.config.validacao.LojaNaoExiste;
import com.stefanini.food.stefood.config.validacao.ProdutoNaoExiste;
import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Produto;
import com.stefanini.food.stefood.repository.LojaProdutoRepository;
import com.stefanini.food.stefood.repository.LojaRepository;
import com.stefanini.food.stefood.repository.ProdutoRepository;

public class LojaProdutoForm {

	private Long lojaId;
	private Long produtoId;
	private Double preco;
	
	public Long getLojaId() {
		return lojaId;
	}
	public void setLojaId(Long lojaId) {
		this.lojaId = lojaId;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public LojaProduto converter(LojaRepository lojaRepository, ProdutoRepository produtoRepository) {
		Loja loja = lojaRepository.findById(lojaId).orElseThrow(() -> new LojaNaoExiste(lojaId));
		Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new ProdutoNaoExiste(produtoId));
		
		return new LojaProduto(loja, produto, preco);
	}
	public LojaProduto atualizar(Long id, LojaProdutoRepository lojaProdutoRepository, ProdutoRepository produtoRepository) {
	 LojaProduto lojaProduto = lojaProdutoRepository.getOne(id);
	 lojaProduto.setProduto(produtoRepository.getOne(produtoId));
	 lojaProduto.setPreco(preco);
	 return lojaProduto;
	}
	
}
