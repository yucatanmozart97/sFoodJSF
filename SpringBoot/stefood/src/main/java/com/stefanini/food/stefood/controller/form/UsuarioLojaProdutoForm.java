package com.stefanini.food.stefood.controller.form;


import com.stefanini.food.stefood.config.validacao.LojaProdutoNaoExiste;
import com.stefanini.food.stefood.config.validacao.UsuarioNaoExiste;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Usuario;
import com.stefanini.food.stefood.modelo.UsuarioLojaProduto;
import com.stefanini.food.stefood.repository.LojaProdutoRepository;
import com.stefanini.food.stefood.repository.UsuarioRepository;

public class UsuarioLojaProdutoForm {

	private Long lojaProdutoId;
	private Long usuarioId;
	private Integer quantidade;
		
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Long getLojaProdutoId() {
		return lojaProdutoId;
	}
	public void setLojaProdutoId(Long lojaProdutoId) {
		this.lojaProdutoId = lojaProdutoId;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public UsuarioLojaProduto converter(LojaProdutoRepository lojaProdutoRepository, UsuarioRepository usuarioRepository) {
		LojaProduto lojaProduto = lojaProdutoRepository.findById(lojaProdutoId).orElseThrow(() -> new LojaProdutoNaoExiste(lojaProdutoId));
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new UsuarioNaoExiste(usuarioId));
		
		return new UsuarioLojaProduto(lojaProduto, usuario, quantidade);
		
	}
	
	
}
