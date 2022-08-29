package com.stefanini.food.stefood.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesUsuarioLojaProdutoDto;
import com.stefanini.food.stefood.controller.dto.UsuarioLojaProdutoDto;
import com.stefanini.food.stefood.controller.form.UsuarioLojaProdutoForm;
import com.stefanini.food.stefood.modelo.LojaProduto;
import com.stefanini.food.stefood.modelo.Usuario;
import com.stefanini.food.stefood.modelo.UsuarioLojaProduto;
import com.stefanini.food.stefood.service.UsuarioLojaProdutoService;

@RestController
@RequestMapping("/usuarioslojasprodutos")
public class UsuarioLojaProdutoController {
	
     private final UsuarioLojaProdutoService pedidosService;
     
     @Autowired
     public UsuarioLojaProdutoController(UsuarioLojaProdutoService pedidosService) {
    	 this.pedidosService = pedidosService;
     }
 	

	@GetMapping
	public Page<UsuarioLojaProdutoDto> listar(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)
	Pageable paginacao){
		return pedidosService.listar(paginacao);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioLojaProdutoDto> cadastrar(@RequestBody UsuarioLojaProdutoForm form, UriComponentsBuilder uriBuilder){
		return pedidosService.cadastrar(form, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesUsuarioLojaProdutoDto> detalhar(@PathVariable Long id) {
		return pedidosService.detalhar(id);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		return pedidosService.remover(id);
	}
	
}
