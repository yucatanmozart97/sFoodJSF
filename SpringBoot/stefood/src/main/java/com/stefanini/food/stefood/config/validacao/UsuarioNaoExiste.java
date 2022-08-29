package com.stefanini.food.stefood.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioNaoExiste extends RuntimeException{
	public UsuarioNaoExiste(Long usuarioId) {
		super("Usuario " + usuarioId + " não existe.");
	}
	
}
