package com.stefanini.food.stefood.controller;

import java.net.URI;

import com.stefanini.food.stefood.controller.dto.AtualizacaoProdutoForm;
import com.stefanini.food.stefood.controller.dto.DetalhesLojaProdutoDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.LojaProdutoDto;
import com.stefanini.food.stefood.controller.dto.MostrarLoja;
import com.stefanini.food.stefood.controller.dto.ProdutoMostrarDto;
import com.stefanini.food.stefood.controller.form.LojaProdutoForm;
import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Produto;
import com.stefanini.food.stefood.service.LojaProdutoService;


@RestController
@RequestMapping("/lojasprodutos")
public class LojaProdutoController {

	private final LojaProdutoService lojaProdutoService;
	
	@Autowired
	public LojaProdutoController(LojaProdutoService lojaProdutoService) {
		this.lojaProdutoService = lojaProdutoService;
	}
	
	
	@GetMapping
	public List<LojaProdutoDto> listar(){
		return lojaProdutoService.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LojaProdutoDto> cadastrar(@RequestBody LojaProdutoForm form, UriComponentsBuilder uriBuilder) {
		return lojaProdutoService.cadastrar(form, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLojaProdutoDto> converter(@PathVariable Long id) {
		 return lojaProdutoService.detalhar(id);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LojaProdutoDto> atualizar(@PathVariable Long id, @RequestBody LojaProdutoForm form){
		return lojaProdutoService.atualizar(id, form); 
	}
	
	@GetMapping("/loja/{id}")
	public List<?> mostrarProdutos(@PathVariable Long id) {
			return lojaProdutoService.mostrarProdutos(id);
	}
	

	
//	@PutMapping("/{id}")
//	@Transactional
//	public ResponseEntity<LojaProdutoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoProdutoForm form){
//		Optional<LojaProduto> optional = lojaProdutoRepository.findById(id);
//		if(optional.isPresent()) {
//			LojaProduto lojaProduto = form.atualizar(id, lojaProdutoRepository);
//			return ResponseEntity.ok(new LojaProdutoDto(lojaProduto));
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
//	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		return lojaProdutoService.remover(id);
	}
	
	
}
