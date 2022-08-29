package com.stefanini.food.stefood.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesUsuarioDto;
import com.stefanini.food.stefood.controller.dto.UsuarioDto;
import com.stefanini.food.stefood.controller.form.UsuarioForm;
import com.stefanini.food.stefood.modelo.Usuario;
import com.stefanini.food.stefood.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioDto> lista(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return UsuarioDto.converter(usuarios);
	}
	
	public ResponseEntity<UsuarioDto> cadastrar(UsuarioForm form, UriComponentsBuilder uriBuilder) {
		if (form.getConfirmaSenha().equals(form.getSenha()) && form.getSenha().length() >= 8) {
			form.setSenha(new BCryptPasswordEncoder().encode(form.getSenha()));
			Usuario usuario = form.converter();
			List<Usuario> user = usuarioRepository.findByUserName(usuario.getUserName());
			List<Usuario> email = usuarioRepository.findByEmail(usuario.getEmail());
			List<Usuario> telefone = usuarioRepository.findByTelefone(usuario.getTelefone());
			if (user.size() != 0 || usuario.getUserName().length() <= 5) {
				return new ResponseEntity("Username já cadastrado ou caracteres abaixo de 5", HttpStatus.CONFLICT);
			} else if (email.size() != 0 || usuario.getEmail().indexOf("@") < 3 || usuario.getEmail().indexOf(".com") < 9 ) {
				return new ResponseEntity("Email já existente ou inválido(Verifique @ e .com)", HttpStatus.CONFLICT);
			} else if (telefone.size() != 0 || usuario.getTelefone().length() < 8) {
				return new ResponseEntity("Telefone já existente ou inválido", HttpStatus.CONFLICT);
			} 
			else {
			usuarioRepository.save(usuario);
			
			URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
			return ResponseEntity.created(uri).body(new UsuarioDto(usuario));	
			}
			}
		
		return new ResponseEntity("Senha e confirmação não estão compativeis e precisam ter no minimo 8 caracteres", HttpStatus.CONFLICT);
	}
	
	public ResponseEntity<DetalhesUsuarioDto> detalhar(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(new DetalhesUsuarioDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<UsuarioDto> atualizar(Long id, UsuarioForm form){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	public ResponseEntity<?> remover(Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);			
			return ResponseEntity.ok().build();	
		}
		
	 return ResponseEntity.notFound().build();
	}
	
}
