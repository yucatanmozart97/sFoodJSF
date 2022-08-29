package com.stefanini.food.stefood.controller.form;

import com.stefanini.food.stefood.modelo.Usuario;
import com.stefanini.food.stefood.repository.UsuarioRepository;
import com.stefanini.food.stefood.service.UsuarioService;

public class UsuarioForm {

	private String nome;
	private String userName;
	private String email;
	private String telefone;
	private String senha;
	private String confirmaSenha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	public Usuario converter() {
		return new Usuario(nome, userName, email, telefone, senha);
	}
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
      Usuario usuario = usuarioRepository.getOne(id);
      usuario.setNome(nome);
      usuario.setEmail(email);
      usuario.setTelefone(telefone);
		return usuario;
	}
	
}
