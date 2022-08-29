package com.stefanini.food.stefood.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesProdutoDto;
import com.stefanini.food.stefood.controller.dto.ProdutoDto;
import com.stefanini.food.stefood.controller.form.ProdutoForm;
import com.stefanini.food.stefood.modelo.Produto;
import com.stefanini.food.stefood.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<ProdutoDto> lista(){
		List<Produto> produtos = produtoRepository.findAll();
		
		return ProdutoDto.converter(produtos);
	}
	
	public ResponseEntity<ProdutoDto> cadastrar(ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter();
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
	
	public ResponseEntity<DetalhesProdutoDto> detalhar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesProdutoDto(produto.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<ProdutoDto> atualizar(Long id, ProdutoForm form){
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		
		return ResponseEntity.notFound().build();		
		
		
	}
	
	public ResponseEntity<?> remover(Long id){
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();

	}
}
