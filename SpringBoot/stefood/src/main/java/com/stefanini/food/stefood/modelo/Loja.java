package com.stefanini.food.stefood.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Loja {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String cnpj;
	private String endereco;
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
	private List<LojaProduto> registros; 
	
	
	public Loja() {}
	
	public Loja(Long id) {
		this.id = id;
	}
	
	public Loja(String nome, String descricao, String cnpj, String endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.registros = new ArrayList<>();		
	}
	

	public Loja(String nome, String descricao, String endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.endereco = endereco;	
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<LojaProduto> getRegistros(){
		return registros;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setRegistros(List<LojaProduto> registros) {
		this.registros = registros;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
