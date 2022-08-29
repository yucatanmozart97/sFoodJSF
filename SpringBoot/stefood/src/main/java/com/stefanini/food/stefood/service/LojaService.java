package com.stefanini.food.stefood.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.food.stefood.controller.dto.DetalhesDaLojaDto;
import com.stefanini.food.stefood.controller.dto.LojaDto;
import com.stefanini.food.stefood.controller.form.LojaForm;
import com.stefanini.food.stefood.modelo.Loja;
import com.stefanini.food.stefood.repository.LojaRepository;

@Service
public class LojaService {

	private final LojaRepository lojaRepository;
	
	public LojaService (LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;
	}
	
	
	
	public List<LojaDto> lista(String nomeLoja){
		if(nomeLoja == null) {
			List<Loja> lojas = lojaRepository.findAll();
			return LojaDto.converter(lojas);	
		}
		List<Loja> lojas = lojaRepository.findByNome(nomeLoja);
		return LojaDto.converter(lojas);
	}
	
	
	public ResponseEntity<LojaDto> cadastrar(LojaForm form, UriComponentsBuilder uriBuilder) {
		Loja loja = form.converter();
		List<Loja> cnpj = lojaRepository.findByCnpj(loja.getCnpj());
		
		if(cnpj.size() == 0 && form.getCnpj().length() == 14) {
			lojaRepository.save(loja);
			URI uri = uriBuilder.path("/lojas/{id}").buildAndExpand(loja.getId()).toUri();
			return ResponseEntity.created(uri).body(new LojaDto(loja));
		} else {
			return new ResponseEntity("Cnpj já existente ou inválido.", HttpStatus.CONFLICT);
			
		}

	}
	
	public ResponseEntity<DetalhesDaLojaDto> detalhar(Long id) {
		Optional<Loja> loja = lojaRepository.findById(id);
		if (loja.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaLojaDto(loja.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<LojaDto> atualizar(Long id, LojaForm form){
		Optional<Loja> optional = lojaRepository.findById(id);
		if (optional.isPresent()) {
			Loja loja = form.atualizar(id, lojaRepository);
			return ResponseEntity.ok(new LojaDto(loja));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> remover(Long id){
		Optional<Loja> optional = lojaRepository.findById(id);
		if (optional.isPresent()) {
			lojaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();		
	}	
	
}
