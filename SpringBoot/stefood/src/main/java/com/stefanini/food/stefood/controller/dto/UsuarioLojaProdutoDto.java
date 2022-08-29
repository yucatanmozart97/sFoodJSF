package com.stefanini.food.stefood.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.stefanini.food.stefood.modelo.UsuarioLojaProduto;

public class UsuarioLojaProdutoDto {

	private Long id;
	private String nomeLoja;
	private String nomeProduto;
	private String nomeUsuario;
	private Integer quantidade;
	private LocalDateTime dataPedido;
	private Double preco;
	private Double valorTotal;
	
	public UsuarioLojaProdutoDto(UsuarioLojaProduto registros) {
		this.id = registros.getId();
		this.nomeLoja = registros.getLojaProduto().getLoja().getNome();
		this.nomeProduto = registros.getLojaProduto().getProduto().getNome();
		this.nomeUsuario = registros.getUsuario().getNome();
		this.dataPedido = registros.getDataVenda();
		this.preco = registros.getLojaProduto().getPreco();
		this.quantidade = registros.getQuantidade();
		this.valorTotal = registros.getQuantidade() * registros.getLojaProduto().getPreco();
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
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public LocalDateTime getDataPedido() {
		return dataPedido;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}

	public static Page<UsuarioLojaProdutoDto> converter(Page<UsuarioLojaProduto> pedidos) {
		return pedidos.map(UsuarioLojaProdutoDto::new);
	}
	
	
	
}
