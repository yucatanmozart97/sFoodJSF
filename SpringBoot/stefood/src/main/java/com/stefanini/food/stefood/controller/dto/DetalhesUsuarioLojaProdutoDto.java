package com.stefanini.food.stefood.controller.dto;

import java.time.LocalDateTime;

import com.stefanini.food.stefood.modelo.UsuarioLojaProduto;

public class DetalhesUsuarioLojaProdutoDto {

	private String nomeLoja;
	private String nomeProduto;
	private String nomeUsuario;
	private Double preco;
	private Integer quantidade;
	private LocalDateTime dataVenda;
	
	public DetalhesUsuarioLojaProdutoDto(UsuarioLojaProduto usuarioLojaProduto) {
		this.nomeLoja = usuarioLojaProduto.getLojaProduto().getLoja().getNome();
		this.nomeProduto = usuarioLojaProduto.getLojaProduto().getProduto().getNome();
		this.nomeUsuario = usuarioLojaProduto.getUsuario().getNome();
		this.preco = usuarioLojaProduto.getLojaProduto().getPreco();
		this.quantidade = usuarioLojaProduto.getQuantidade();
		this.dataVenda = usuarioLojaProduto.getDataVenda();
	}
	
	
	
	public LocalDateTime getData() {
		return dataVenda;
	}



	public void setData(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}



	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
