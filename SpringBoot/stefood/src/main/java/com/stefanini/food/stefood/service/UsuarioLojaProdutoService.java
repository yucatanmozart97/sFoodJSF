package com.stefanini.food.stefood.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesUsuarioLojaProdutoDto;
import com.stefanini.food.stefood.controller.dto.UsuarioLojaProdutoDto;
import com.stefanini.food.stefood.controller.form.UsuarioLojaProdutoForm;
import com.stefanini.food.stefood.modelo.UsuarioLojaProduto;
import com.stefanini.food.stefood.repository.LojaProdutoRepository;
import com.stefanini.food.stefood.repository.UsuarioLojaProdutoRepository;
import com.stefanini.food.stefood.repository.UsuarioRepository;

@Service
public class UsuarioLojaProdutoService {

	private final UsuarioLojaProdutoRepository usuarioLojaProdutoRepository;
	private final UsuarioRepository usuarioRepository;
	private final LojaProdutoRepository lojaProdutoRepository;
	
	public UsuarioLojaProdutoService(UsuarioLojaProdutoRepository usuarioLojaProdutoRepository, UsuarioRepository usuarioRepository, LojaProdutoRepository lojaProdutoRepository) {
		this.usuarioLojaProdutoRepository = usuarioLojaProdutoRepository;
		this.lojaProdutoRepository = lojaProdutoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public Page<UsuarioLojaProdutoDto> listar(Pageable paginacao){
        Page<UsuarioLojaProduto> pedidos = usuarioLojaProdutoRepository.findAll(paginacao);
		
		return UsuarioLojaProdutoDto.converter(pedidos);
	}
	
	public ResponseEntity<UsuarioLojaProdutoDto> cadastrar(UsuarioLojaProdutoForm form, UriComponentsBuilder uriBuilder){
		UsuarioLojaProduto usuarioLojaProduto = form.converter(lojaProdutoRepository, usuarioRepository);
		usuarioLojaProdutoRepository.save(usuarioLojaProduto);
		
		URI uri = uriBuilder.path("pedidos/{id}").buildAndExpand(usuarioLojaProduto.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioLojaProdutoDto(usuarioLojaProduto));
	}
	
	public ResponseEntity<DetalhesUsuarioLojaProdutoDto> detalhar(Long id) {
		Optional<UsuarioLojaProduto> usuarioLojaProduto = usuarioLojaProdutoRepository.findById(id);	
		if(usuarioLojaProduto.isPresent()) {
			return ResponseEntity.ok(new DetalhesUsuarioLojaProdutoDto(usuarioLojaProduto.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> remover(Long id){
		Optional<UsuarioLojaProduto> optional = usuarioLojaProdutoRepository.findById(id);	
		if(optional.isPresent()) {
			usuarioLojaProdutoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
