package com.stefanini.food.stefood.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;


@Entity
public class LojaProduto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "loja_fk")
	private Loja loja;
	
	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;
	
	private Double preco;
	
	@OneToMany(mappedBy = "lojaProduto")
	private List<UsuarioLojaProduto> registros;
	
	public LojaProduto() {}
	
	public LojaProduto(Loja loja, Produto produto, Double preco) {
		this.loja = loja;
		this.produto = produto;
		this.preco = preco;
	}

	
	
	public LojaProduto(Long id, Loja loja, Produto produto, Double preco) {
		this.id = id;
		this.loja = loja;
		this.produto = produto;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<UsuarioLojaProduto> getRegistros(){
		return registros;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
