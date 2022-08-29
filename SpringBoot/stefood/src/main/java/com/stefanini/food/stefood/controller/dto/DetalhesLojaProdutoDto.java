package com.stefanini.food.stefood.controller.dto;

import com.stefanini.food.stefood.modelo.LojaProduto;

public class DetalhesLojaProdutoDto {

	private String nomeLoja;
	private String enderecoLoja;
	private String nomeProduto;
	private String descricaoProduto;
	private Double preco;
	
	public DetalhesLojaProdutoDto(LojaProduto lojaProduto) {
		this.nomeLoja = lojaProduto.getLoja().getNome();
		this.enderecoLoja = lojaProduto.getLoja().getEndereco();
		this.nomeProduto = lojaProduto.getProduto().getNome();
		this.descricaoProduto = lojaProduto.getProduto().getDescricao();
		this.preco = lojaProduto.getPreco();
	}
	
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getEnderecoLoja() {
		return enderecoLoja;
	}
	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
