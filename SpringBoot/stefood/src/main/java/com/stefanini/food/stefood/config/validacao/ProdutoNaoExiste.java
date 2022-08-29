package com.stefanini.food.stefood.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProdutoNaoExiste extends RuntimeException{
	public ProdutoNaoExiste(long produtoId) {
		super("Produto " + produtoId + " não existe");
	}
	
}
