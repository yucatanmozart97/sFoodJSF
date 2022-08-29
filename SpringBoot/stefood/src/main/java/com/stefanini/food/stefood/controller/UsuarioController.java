package com.stefanini.food.stefood.controller;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.stefanini.food.stefood.controller.dto.DetalhesUsuarioDto;
import com.stefanini.food.stefood.controller.dto.UsuarioDto;
import com.stefanini.food.stefood.controller.form.UsuarioForm;
import com.stefanini.food.stefood.modelo.Usuario;
import com.stefanini.food.stefood.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	
	private UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioDto> lista(){
		return usuarioService.lista();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
		return usuarioService.cadastrar(form, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesUsuarioDto> detalhar(@PathVariable Long id) {
			return usuarioService.detalhar(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody UsuarioForm form){
			return usuarioService.atualizar(id, form);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		return usuarioService.remover(id);
	}
 	
}
