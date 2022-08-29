package com.stefanini.food.stefood.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.food.stefood.modelo.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;

	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	
	
}
