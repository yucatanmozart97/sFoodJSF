package com.stefanini.food.stefood.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LojaProdutoNaoExiste extends RuntimeException{
 public LojaProdutoNaoExiste(long lojaProdutoId) {
	 super("LojaProduto " + lojaProdutoId + " Não Existe");
 }
	
}
