package com.stefanini.food.stefood.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;

public class LojaDto {

	private Long id;
	private String nome;
	
	
	public LojaDto(Loja loja) {
		this.id = loja.getId();
		this.nome = loja.getNome();
	
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	

	public static List<LojaDto> converter(List<Loja> lojas) {
		return lojas.stream().map(LojaDto::new).collect(Collectors.toList());
	}
	
	
	
	
	
}
