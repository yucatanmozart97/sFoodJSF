package com.stefanini.food.stefood.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LojaNaoExiste extends RuntimeException{
	public LojaNaoExiste(long lojaId) {
		super("Loja " + lojaId + " não existe");
	}
		
	
}
