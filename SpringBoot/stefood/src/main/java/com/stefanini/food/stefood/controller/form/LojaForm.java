package com.stefanini.food.stefood.controller.form;

import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.repository.LojaRepository;
import com.stefanini.food.stefood.service.LojaService;

public class LojaForm {

	private String nome;
	private String descricao;
	private String cnpj;
	private String endereco;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public Loja converter() {
		return new Loja(nome, descricao, cnpj, endereco);
	}
	public Loja atualizar(Long id, LojaRepository lojaRepository) {
	   Loja loja = lojaRepository.getOne(id);
	   loja.setNome(nome);
	   loja.setDescricao(descricao);
	   loja.setEndereco(endereco);
		return loja;
	}
	
	
	
}
