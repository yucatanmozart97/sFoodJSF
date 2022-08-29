package com.stefanini.food.stefood.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesLojaProdutoDto;
import com.stefanini.food.stefood.controller.dto.LojaProdutoDto;
import com.stefanini.food.stefood.controller.form.LojaProdutoForm;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.repository.LojaProdutoRepository;
import com.stefanini.food.stefood.repository.LojaRepository;
import com.stefanini.food.stefood.repository.ProdutoRepository;

@Service
public class LojaProdutoService {

	private final LojaProdutoRepository lojaProdutoRepository;
	private final LojaRepository lojaRepository;
	private final ProdutoRepository produtoRepository;
	
	public LojaProdutoService(LojaProdutoRepository lojaProdutoRepository, LojaRepository lojaRepository, ProdutoRepository produtoRepository) {
		this.lojaProdutoRepository = lojaProdutoRepository;
		this.produtoRepository = produtoRepository;
		this.lojaRepository = lojaRepository;
	}
	
	public List<LojaProdutoDto> findAll(){
List<LojaProduto> lojasProdutos = lojaProdutoRepository.findAll();
		
		return LojaProdutoDto.converter(lojasProdutos);
	}
	
	public ResponseEntity<LojaProdutoDto> cadastrar(LojaProdutoForm form, UriComponentsBuilder uriBuilder) {
		LojaProduto lojaProduto = form.converter(lojaRepository, produtoRepository);
		lojaProdutoRepository.save(lojaProduto);
		
		URI uri = uriBuilder.path("lojasprodutos/{id}").buildAndExpand(lojaProduto.getId()).toUri();
		return ResponseEntity.created(uri).body(new LojaProdutoDto(lojaProduto));
	}
	
	public ResponseEntity<DetalhesLojaProdutoDto> detalhar(Long id) {
		 Optional<LojaProduto> lojaProduto = lojaProdutoRepository.findById(id);
		if(lojaProduto.isPresent()) {
			return ResponseEntity.ok(new DetalhesLojaProdutoDto(lojaProduto.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	public ResponseEntity<LojaProdutoDto> atualizar(Long id, LojaProdutoForm form){
		Optional<LojaProduto> optional = lojaProdutoRepository.findById(id);
		if (optional.isPresent()) {
			LojaProduto produto = form.atualizar(id, lojaProdutoRepository, produtoRepository);
			return ResponseEntity.ok(new LojaProdutoDto(produto));
		}
		return ResponseEntity.notFound().build();
	}
	
	public List<?> mostrarProdutos(Long id) {
		List<?> lista =  lojaProdutoRepository.findByLojaId(id);
	    
	    
		return lista;
	}
	
	public ResponseEntity<?> remover(Long id){
		Optional<LojaProduto> optional = lojaProdutoRepository.findById(id);
		if(optional.isPresent()) {
			lojaProdutoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
