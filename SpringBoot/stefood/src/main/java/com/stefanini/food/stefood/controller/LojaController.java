package com.stefanini.food.stefood.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.stefanini.food.stefood.controller.dto.DetalhesDaLojaDto;
import com.stefanini.food.stefood.controller.dto.LojaDto;
import com.stefanini.food.stefood.controller.form.LojaForm;
import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.service.LojaService;


@RestController
@RequestMapping("/lojas")
public class LojaController {

	private final LojaService lojaService;
	
	@Autowired
	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}
	
	
	@GetMapping
	public List<LojaDto> lista(String nomeLoja){
		return lojaService.lista(nomeLoja);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LojaDto> cadastrar(@RequestBody LojaForm form, UriComponentsBuilder uriBuilder) {
		return lojaService.cadastrar(form, uriBuilder);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaLojaDto> detalhar(@PathVariable Long id) {
		return lojaService.detalhar(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LojaDto> atualizar(@PathVariable Long id, @RequestBody LojaForm form){
			return lojaService.atualizar(id, form);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		return lojaService.remover(id);	
	}
	
}
