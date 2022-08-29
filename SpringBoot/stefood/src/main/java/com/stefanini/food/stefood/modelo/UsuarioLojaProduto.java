package com.stefanini.food.stefood.modelo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UsuarioLojaProduto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "lp_fk")
	private LojaProduto lojaProduto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_fk")
	private Usuario usuario;
	
	private Integer quantidade;
	
	private LocalDateTime dataVenda = LocalDateTime.now();
	
	public UsuarioLojaProduto() {}
	
	public UsuarioLojaProduto(LojaProduto lojaProduto, Usuario usuario, Integer quantidade) {
		this.lojaProduto = lojaProduto;
		this.usuario = usuario;
		this.quantidade = quantidade;
	}
	
	public UsuarioLojaProduto(Long id, LojaProduto lojaProduto, Usuario usuario, Integer quantidade, LocalDateTime dataVenda) {
		this.id = id;
		this.lojaProduto = lojaProduto;
		this.usuario = usuario;
		this.quantidade = quantidade;
        this.dataVenda = dataVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LojaProduto getLojaProduto() {
		return lojaProduto;
	}

	public void setLojaProduto(LojaProduto lojaProduto) {
		this.lojaProduto = lojaProduto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
